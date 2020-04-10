package plx.services


class Executor implements IExecutor {

    IExecutor repository

    Executor(Map options) {
        Class clazz = new GroovyClassLoader().loadClass(
            "${options.repositoryName}".toString(),
           true,
           false
        )
        repository = clazz.getDeclaredConstructor().newInstance(options.workflowScript) as IExecutor
    }

    @Override
    void echo(Object msg) {
        repository.println msg
    }

    @Override
    def sh (Map config) {
        repository.sh config
    }

    @Override
    def sh (String command) {
        repository.sh command
    }

    @Override
    def stage(name, Closure closure) {
        repository.stage(name) {
            closure.call()
        }
    }

    @Override
    def build (Map map) {
        repository.build map
    }

    @Override
    def getEnv () {
        repository.env
    }

    @Override
    def getCurrentBuild () {
        repository.currentBuild
    }

    @Override
    def withCredentials (List list, Closure closure) {
        repository.withCredentials(list) {
            closure.call()
        }
    }

    @Override
    def configFileProvider (List list, Closure closure) {
        repository.configFileProvider(list) {
            closure.call()
        }
    }

    @Override
    def configFile(Map map) {
        repository.configFile(map)
    }

    @Override
    def sshagent (List list, Closure closure) {
        repository.sshagent(list) {
            closure.call()
        }
    }

    @Override
    def timeout (Map map, Closure closure) {
        repository.timeout(map) {
            closure.call()
        }
    }

    @Override
    def properties (List list) {
        repository.properties(list)
    }

    @Override
    def getParams () {
        repository.params
    }

    @Override
    def getDocker () {
        repository.docker
    }

    @Override
    def parameters (List list) {
        repository.parameters list
    }

    @Override
    def error (String msg) {
        repository.error msg
    }

    @Override
    def string (Map map) {
        repository.string map
    }

    @Override
    def text (Map map) {
        repository.text map
    }

    @Override
    def choice (Map map) {
        repository.choice map
    }

    @Override
    def git (Map map) {
        repository.git map
    }

    @Override
    void deleteDir () {
        repository.deleteDir()
    }

    @Override
    def booleanParam (Map map) {
        repository.booleanParam map
    }

    @Override
    def stringParam(Map map) {
        repository.stringParam map
    }

    @Override
    def textParam(Map map) {
        repository.textParam map
    }

    @Override
    def load (String filename) {
        repository.load(filename)
    }

    @Override
    def readYaml(Map map) {
        repository.readYaml(map)
    }

    @Override
    def writeYaml(Map map) {
        repository.writeYaml(map)
    }

    @Override
    def readJSON(Map map) {
        repository.readJSON(map)
    }

    @Override
    def allure(Map map) {
        repository.allure(map)
    }

    @Override
    def junit(Map map) {
        repository.junit(map)
    }

    @Override
    def perfReport(Map map) {
        repository.perfReport(map)
    }

    @Override
    def dir(String path, Closure closure) {
        repository.dir(path) {
            closure.call()
        }
    }

    @Override
    def tool(String name) {
        repository.tool(name)
    }

    @Override
    def readProperties(Map map) {
        repository.readProperties(map)
    }

    @Override
    def pwd() {
        repository.pwd()
    }

    @Override
    def waitForQualityGate() {
        repository.waitForQualityGate()
    }

    @Override
    def libraryResource(String resource) {
        repository.libraryResource(resource)
    }

    @Override
    def readMavenPom(String pom) {
        repository.readMavenPom(pom)
    }

    @Override
    def writeMavenPom(Map map) {
        repository.writeMavenPom(map)
    }

    @Override
    def findFiles(Map map) {
        repository.findFiles(map)
    }

    @Override
    def withSonarQubeEnv(Map map, Closure closure) {
        repository.withSonarQubeEnv(map) {
            closure.call()
        }
    }

    @Override
    def archiveArtifacts(String path) {
        repository.archiveArtifacts(path)
    }

    @Override
    def httpRequest(Map map) {
        repository.httpRequest(map)
    }

    @Override
    def sshPut(Map map) {
        repository.sshPut(map)
    }

    @Override
    def sshCommand(Map map) {
        repository.sshCommand(map)
    }

}
