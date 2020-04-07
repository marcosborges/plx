package plx.base

import org.jenkinsci.plugins.workflow.cps.CpsScript

interface IApplication extends Serializable {

    IController controller = null
    CpsScript workflowScript = null

    String controllerName = ""
    String action = ""

    Map config = [:]
    Map args = [:]

    void run()
}