package plx.repositories.executors


import org.jenkinsci.plugins.workflow.cps.CpsScript

class Jenkins implements IExecutor {

    CpsScript wfs

    void echo (msg) {
        wfs.println msg
    }

    def sh (Map config) {
        wfs.sh config
    }

    def sh (String command) {
        wfs.sh command
    }

    def stage(name, Closure closure) {
        wfs.stage(name) {
            closure.call()
        }
    }

    def build (Map map) {
        wfs.build map
    }

    def getEnv () {
        wfs.env
    }

    def getCurrentBuild () {
        wfs.currentBuild
    }

    def withCredentials (List list, Closure closure) {
        wfs.withCredentials(list) {
            closure.call()
        }
    }

    def configFileProvider (List list, Closure closure) {
        wfs.configFileProvider(list) {
            closure.call()
        }
    }
    def configFile(Map map) {
        wfs.configFile(map)
    }

    def sshagent (List list, Closure closure) {
        wfs.sshagent(list) {
            closure.call()
        }
    }

    def timeout (Map map, Closure closure) {
        wfs.timeout(map) {
            closure.call()
        }
    }

    def properties (List list) {
        wfs.properties(list)
    }

    def getParams () {
        wfs.params
    }

    def getDocker () {
        wfs.docker
    }

    def parameters (List list) {
        wfs.parameters list
    }

    def error (String msg) {
        wfs.error msg
    }

    def string (Map map) {
        wfs.string map
    }

    def text (Map map) {
        wfs.text map
    }

    def choice (Map map) {
        wfs.choice map
    }

    def git (Map map) {
        wfs.git map
    }

    void deleteDir () {
        wfs.deleteDir()
    }

    def booleanParam (Map map) {
        wfs.booleanParam map
    }

    def stringParam(Map map) {
        wfs.stringParam map
    }

    def textParam(Map map) {
        wfs.textParam map
    }

    def load (String filename) {
        wfs.load(filename)
    }

    def readYaml(Map map) {
        wfs.readYaml(map)
    }

    def writeYaml(Map map) {
        wfs.writeYaml(map)
    }

    def readJSON(Map map) {
        wfs.readJSON(map)
    }

    def allure(Map map) {
        wfs.allure(map)
    }

    def junit(Map map) {
        wfs.junit(map)
    }

    def perfReport(Map map) {
        wfs.perfReport(map)
    }

    def dir(String path, Closure closure) {
        wfs.dir(path) {
            closure.call()
        }
    }

    def tool(String name) {
        wfs.tool(name)
    }

    def readProperties(Map map) {
        wfs.readProperties(map)
    }

    def pwd() {
        wfs.pwd()
    }

    def waitForQualityGate() {
        wfs.waitForQualityGate()
    }

    def libraryResource(String resource) {
        wfs.libraryResource(resource)
    }

    def readMavenPom(String pom) {
        wfs.readMavenPom(pom)
    }

    def writeMavenPom(Map map) {
        wfs.writeMavenPom(map)
    }

    def findFiles(Map map) {
        wfs.findFiles(map)
    }

    def withSonarQubeEnv(Map map, Closure closure) {
        wfs.withSonarQubeEnv(map) {
            closure.call()
        }
    }

    def archiveArtifacts(String path) {
        wfs.archiveArtifacts(path)
    }

    def httpRequest(Map map) {
        wfs.httpRequest(map)
    }

    def sshPut(Map map) {
        wfs.sshPut(map)
    }

    def sshCommand(Map map) {
        wfs.sshCommand(map)
    }
}
