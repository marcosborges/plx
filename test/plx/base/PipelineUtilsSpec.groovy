import org.jenkinsci.plugins.workflow.cps.CpsScript
import plx.base.Logger

import com.homeaway.devtools.jenkins.testing.JenkinsPipelineSpecification

import spock.lang.*
class PipelineUtilsSpec extends Specification {

    def mock

    def setup() {
        mock = [
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
    }
/*
    def "Plx.PipelineUtils_init"() {
        when:
            Executor.instance.init(workflowScript : mock)
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_echo"() {
        when:
            Executor.instance.echo("Test")
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_sh"() {
        when:
            Executor.instance.sh("ls")
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_sh2"() {
        def result
        when:
            result = Executor.instance.sh(script: "ls", returnStout : true)
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_stage"() {
        when:
            Executor.instance.stage('name') {
                println "staged"
            }
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_build"() {
        when:
            Executor.instance.build([:])
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_getEnv"() {
        when:
            Executor.instance.getEnv()
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_getCurrentBuild"() {
        when:
            Executor.instance.getCurrentBuild()
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_withCredentials"(){
        when:
             Executor.instance.withCredentials([]){
                println ""
             }
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_configFileProvider"(){
        when:
            Executor.instance.configFileProvider([]){
                println ""
            }
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_configFile"() {
        when:
            Executor.instance.configFile([:])
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_sshagent"(){
        when:
            Executor.instance.sshagent([]){
                println "sshagent"
            }
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_timeout"(){
        when:
            Executor.instance.timeout(time: 180, unit: 'SECONDS'){
                println ""
            }
        then:
            true
        expect:
            true
    }


    def "Plx.PipelineUtils_properties"(){
        when:
            Executor.instance.properties([])
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_getParams"(){
        when:
            Executor.instance.getParams()
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_parameters"(){
        when:
            Executor.instance.parameters([])
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_error"(){
        when:
            Executor.instance.error("")
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_string"(){
        when:
            Executor.instance.string([:])
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_text"(){
        when:
            Executor.instance.text([:])
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_choice"(){
        when:
            Executor.instance.choice([:])
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_git"(){
        when:
            Executor.instance.git([:])
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_booleanParam"(){
        when:
            Executor.instance.booleanParam([:])
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_stringParam"(){
        when:
            Executor.instance.stringParam([:])
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_textParam"(){
        when:
            Executor.instance.textParam([:])
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_load"(){
        when:
            Executor.instance.load("")
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_readYaml"(){
        when:
            Executor.instance.readYaml([:])
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_writeYaml "(){
        when:
            Executor.instance.writeYaml ([:])
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_getDocker"(){
        when:
            Executor.instance.getDocker()
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_readJSON"() {
        when:
            Executor.instance.readJSON([:])
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_allure"() {
        when:
            Executor.instance.allure([:])
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_junit"() {
        when:
            Executor.instance.junit([:])
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_perfReport"() {
        when:
            Executor.instance.perfReport([:])
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_tool"() {
        when:
            Executor.instance.tool("")
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_readProperties"() {
        when:
            Executor.instance.readProperties([:])
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_pwd"() {
        when:
            Executor.instance.pwd()
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_waitForQualityGate"() {
        when:
        Executor.instance.waitForQualityGate()
        then:
        true
        expect:
        true
    }
    def "Plx.PipelineUtils_libraryResource"() {
        when:
            Executor.instance.libraryResource("")
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_readMavenPom"() {
        when:
            Executor.instance.readMavenPom("")
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_writeMavenPom"() {
        when:
            Executor.instance.writeMavenPom([:])
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_findFiles"() {
        when:
            Executor.instance.findFiles([:])
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_archiveArtifacts"() {
        when:
        Executor.instance.archiveArtifacts("")
        then:
        true
        expect:
        true
    }
    def "Plx.PipelineUtils_httpRequest"() {
        when:
            Executor.instance.httpRequest([:])
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_sshPut"() {
        when:
            Executor.instance.sshPut([:])
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_deleteDir"() {
        when:
        Executor.instance.deleteDir()
        then:
        true
        expect:
        true
    }
    def "Plx.PipelineUtils_withSonarQubeEnv"() {
        when:
            Executor.instance.withSonarQubeEnv([:]){
                println ""
            }
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_dir"() {
        when:
            Executor.instance.dir(""){
                println ""
            }
        then:
            true
        expect:
            true
    }
    def "Plx.PipelineUtils_sshCommand"() {
        when:
            Executor.instance.sshCommand([:])
        then:
            true
        expect:
            true
    }
*/
}