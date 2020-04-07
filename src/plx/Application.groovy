package plx

import com.cloudbees.groovy.cps.NonCPS
import jenkins.model.Jenkins
import org.jenkinsci.plugins.workflow.cps.CpsScript
import plx.base.IApplication
import plx.base.IController

class Application implements IApplication{

    IController controller
    String controllerName
    String action
    Map config
    Map args

    Application (Map options, CpsScript workflowScript, Jenkins jks) {
        Plx.app = this
        Plx.exec = workflowScript
        Plx.jks = jks
        for (o in options) { this[o.key as String] = o.value }
    }

    void run() {
        Plx.exec.println("Application.run()")
        verifyRequirements()
        controller = new GroovyClassLoader().loadClass(controllerName as String,true,false).getDeclaredConstructor().newInstance() as IController
        controller?.init()
        controller?.beforeAction()
        controller?."${action}"(args)
        controller?.afterAction()
        controller?.end()
    }

    @NonCPS
    void verifyRequirements() {
        Collection _installedPlugins = getInstalledPlugins()
        Collection _requiredPlugins = ['subversion','workflow-job'] as Collection
        Collection _missing = _requiredPlugins - _installedPlugins
        if ( _missing.size() > 0 ) {
            throw new Exception("Mandatory plugins were not found, to continue install the following plugins: ${_missing.join(', ')};")
        }
    }

    @NonCPS
    Collection getInstalledPlugins () {
        Plx.jks.pluginManager.plugins.collect({it -> it.getShortName()})
    }
}