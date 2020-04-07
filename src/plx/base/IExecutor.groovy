package plx.base

interface IExecutor extends Serializable {

    void echo (msg)
    def sh (Map config)
    def sh (String command)
    def stage(name, Closure closure)
    def build (Map map)
    def getEnv ()
    def getCurrentBuild ()
    def withCredentials (List list, Closure closure)
    def configFileProvider (List list, Closure closure)
    def configFile(Map map)
    def sshagent (List list, Closure closure)
    def timeout (Map map, Closure closure)
    def properties (List list)
    def getParams ()
    def getDocker ()
    def parameters (List list)
    def error (String msg)
    def string (Map map)
    def text (Map map)
    def choice (Map map)
    def git (Map map)
    void deleteDir ()
    def booleanParam (Map map)
    def stringParam(Map map)
    def textParam(Map map)
    def load (String filename)
    def readYaml(Map map)
    def writeYaml(Map map)
    def readJSON(Map map)
    def allure(Map map)
    def junit(Map map)
    def perfReport(Map map)
    def dir(String path, Closure closure)
    def tool(String name)
    def readProperties(Map map)
    def pwd()
    def waitForQualityGate()
    def libraryResource(String resource)
    def readMavenPom(String pom)
    def writeMavenPom(Map map)
    def findFiles(Map map)
    def withSonarQubeEnv(Map map, Closure closure)
    def archiveArtifacts(String path)
    def httpRequest(Map map)
    def sshPut(Map map)
    def sshCommand(Map map)
}