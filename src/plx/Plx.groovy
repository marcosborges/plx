package plx

import jenkins.model.Jenkins
import org.jenkinsci.plugins.workflow.cps.CpsScript
import plx.base.Logger

import plx.utils.IHttpClient

/**
 * @author Marcos Borges
 */
class Plx implements Serializable{

    static Application app
    static CpsScript exec
    static Jenkins jks
    static Logger log
    static Object cache
    static IHttpClient http

}
