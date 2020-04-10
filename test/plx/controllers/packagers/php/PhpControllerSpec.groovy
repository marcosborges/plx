import plx.Plx
import plx.Application

import plx.controllers.packagers.php.PhpController
import org.jenkinsci.plugins.workflow.cps.CpsScript

import com.homeaway.devtools.jenkins.testing.JenkinsPipelineSpecification

import spock.lang.*
class PhpControllerSpec extends Specification {

    def controller
    def setup () {

        Plx.pl =  Executor.instance.init(
             workflowScript : [
                'echo': { arg -> println(arg[0]) },
                'println': { arg -> println(arg[0]) },
                'sh': { arg ->
                    def script
                    def returnStdout
                    if (arg.length == 1 && arg[0] instanceof Map) {
                        script = arg[0]['script']
                        returnStdout = arg[0]['returnStdout']
                    } else {
                        script = arg[0]
                    }
                    println "Calling sh with script: ${script}"
                },
                'script' : { arg ->arg[0]()},
                'dir' : { arg -> arg[1]() },
                'stage' : { arg -> arg[1]()},
                'build': { arg -> println arg[0] },
                'withCredentials' : { arg -> arg[1]() },
                'configFileProvider': { arg -> arg[1]() },
                'sshagent': { arg -> arg[1]()},
                'configFile' : { arg -> println arg[0] },
                'timeout' : {arg -> arg[1]() },
                'properties' : {arg -> println "properties(${arg[0]})"},
                'getParams' : {arg -> println "getParams(${arg[0]})"},
                'getDocker' : {arg -> println "getDocker(${arg[0]})"},
                'parameters' : {arg -> println "parameters(${arg[0]})"},
                'error' : {arg -> println "error(${arg[0]})"},
                'string' : {arg -> println "string(${arg[0]})"},
                'text' : {arg -> println "text(${arg[0]})"},
                'choice' : {arg -> println "choice(${arg[0]})"},
                'git' : {arg -> println "git(${arg[0]})"},
                'booleanParam' : {arg -> println "booleanParam(${arg[0]})"},
                'stringParam' : {arg -> println "stringParam(${arg[0]})"},
                'textParam' : {arg -> println "textParam(${arg[0]})"},
                'load' : {arg -> println "load(${arg[0]})"},
                'readYaml' : {arg -> println "readYaml(${arg[0]})"},
                'writeYaml' : {arg -> println "writeYaml(${arg[0]})"},
                'withSonarQubeEnv' : {arg -> arg[1]()},
                'withSonarQubeEnv' : {arg -> arg[1]()},
                'readJSON' : {arg -> println "readJSON:${arg[0]}"},
                'allure' : {arg -> println "allure:${arg[0]}"},
                'junit' : {arg -> println "junit:${arg[0]}"},
                'perfReport' : {arg -> println "perfReport:${arg[0]}"},
                'tool' : {arg -> println "tool:${arg[0]}"},
                'readProperties' : {arg -> println "readProperties:${arg[0]}"},
                'pwd' : { println "pwd"},
                'deleteDir' : { println "deleteDir"},
                'waitForQualityGate' : { println "waitForQualityGate:"},
                'libraryResource' : {arg -> println "libraryResource:${arg[0]}"},
                'readMavenPom' : {arg -> println "readMavenPom:${arg[0]}"},
                'writeMavenPom' : {arg -> println "writeMavenPom:${arg[0]}"},
                'findFiles' : {arg -> println "findFiles:${arg[0]}"},
                'archiveArtifacts' : {arg -> println "archiveArtifacts:${arg[0]}"},
                'httpRequest' : {arg -> println "httpRequest:${arg[0]}"},
                'sshPut' : {arg -> println "sshPut:${arg[0]}"},
                'sshCommand' : {arg -> println "sshCommand:${arg[0]}"}
            ] as CpsScript
        )

        Plx.app = [
            controllerName: "plx.controllers.packagers.php.PhpController",
            action: "start",
            args : [
                    name: "Nome",
                    namespace: "Namespace"
            ]
        ] as Application

        controller = new PhpController()

    }

    /*
    def "Plx_startAction"(){
        when:
            controller.startAction()
        then:
            true
        expect:
            true
    }

    def "Plx_loadConfigures"(){
        when:
            controller.loadConfigures()
        then:
            true
        expect:
            true
    }

    def "Plx_loadCredentials"(){
        when:
            controller.loadCredentials()
        then:
            true
        expect:
            true
    }

    def "Plx_restore"(){
        when:
            controller.restore()
        then:
            true
        expect:
            true
    }*/


}