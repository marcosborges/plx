import plx.Application
import org.jenkinsci.plugins.workflow.cps.CpsScript
import com.homeaway.devtools.jenkins.testing.JenkinsPipelineSpecification
import spock.lang.*
import plx.base.Controller
import plx.base.IApplication
import plx.base.IController
import jenkins.model.Jenkins

class ApplicationSpec extends Specification {

    def appMock
    def wfsMock
    def jksMock

    def setup () {

/*
        println Jenkins.getInstance()

        System.exit(0)
*/

        appMock = [
            controllerName: "plx.controllers.packagers.php.PhpController",
            action: "start",
            args : [
                    name: "Nome",
                    namespace: "Namespace"
            ]
        ]

        wfsMock = [
            'println': { arg -> println(arg[0]) },
            'echo': { arg -> println(arg[0]) },
            'stage' : { arg -> arg[1]()},
            'steps' : { arg -> arg[1]()}
        ] as CpsScript

        jksMock = [
            'pluginManager' : [
                'plugins' : [
                    [ 'getShortName' : { 'workflow-job' } ],
                    [ 'getShortName' : { 'subversion' } ]
                ] as Collection
            ]
        ]
    }

    def "Plx.Application_new" () {
        when:
            Application app = new Application(appMock, wfsMock, jksMock)
        then:
            app instanceof IApplication
            app.controllerName instanceof String
            app.action instanceof String
            app.args instanceof Map
            app.args.name instanceof String
            app.args.namespace instanceof String
    }


    def "Plx.Application_run" () {
        setup:
            Application app = new Application(appMock, wfsMock, jksMock)
        when:
            app.run()
        then:
            Exception exception = thrown()
            exception instanceof Exception
            println exception.message
            exception.message == "Mandatory plugins were not found, to continue install the following plugins: .*"
            //app.controller instanceof IController
    }

}