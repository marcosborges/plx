package plx.controllers.packagers.php

import plx.Plx
import plx.base.IController

class PhpController implements IController {

    def container

    void start(Map args) {

        Plx.exec.node () {

            Plx.exec.println("PhpController.start()")

            loadConfigures()

            loadCredentials()

            Plx.exec.stage ('downloading') {
                Plx.exec.println("checkout")
                Plx.exec.docker.image('composer').inside (""" --net=host --entrypoint='' """) {
                    Plx.exec.sh """ composer --version """
                }
            }

            Plx.exec.stage ('restoring') {
                Plx.exec.println("restore")
            }

            Plx.exec.stage ('testing') {
                Plx.exec.println("test")
            }

            Plx.exec.stage ('reviewing') {
                Plx.exec.println("review")
            }

            Plx.exec.stage ('building') {
                Plx.exec.println("build")
            }

            Plx.exec.stage ('registering') {
                Plx.exec.println("registering")
            }

            Plx.exec.stage ('publishing') {
                Plx.exec.println("publish")
            }

            Plx.exec.stage ('validating') {
                Plx.exec.println("validating")
            }

            Plx.exec.stage ('finishing') {
                Plx.exec.println("validating")
            }
        }
    }

    void loadConfigures() {
        //Plx.exec.echo "PhpController.loadConfigures()"
        /*
        Plx.pl.configFileProvider([
            Plx.pl.configFile(fileId: 'builder.dockerfile', variable: 'BUILDER_DOCKERFILE')
        ]) {
            Plx.pl.sh(""" cp ${dockerfileConfigFile} ${Plx.app.workspace}/Dockerfile """)
        }
        */
    }

    void loadCredentials() {
        //Plx.exec.echo "PhpController.loadCredentials()"
        /*
        Plx.pl.withCredentials([
                Plx.pl.string(credentialsId: 'REGISTRY_KEY', variable: "NEXUS_API_KEY")
        ]) {
            nexusAPIKey = "${Plx.pl.env.NEXUS_API_KEY}"
        }
        */
    }


    void restore() {
        //Plx.exec.sh "ls"
        //Plx.exec.echo "PhpController.restore()"

        /*
        try{
            Plx.pl.docker.image('composer').inside (""" --net=host -v ${workspace}:/app --entrypoint='' """) {
                Plx.pl.sh """ composer install """
            }
        } finally {
            Plx.pl.sh """sudo chown ${userId}:${groupId} * -R """
        }

         */
    }

    void test() {
        //Plx.exec.echo "PhpController.test()"
        /*
        try{
            Plx.pl.docker.image('composer').inside (""" --net=host -v ${workspace}:/app --entrypoint='' """) {
                Plx.pl.sh """ composer test """
            }
        } finally {
            Plx.pl.sh """sudo chown ${userId}:${groupId} * -R """
        }

         */
    }

    void review() {
        //Plx.exec.echo "PhpController.review()"
        /*
        try{
            Plx.pl.docker.image('sonarsource/sonar-scanner-cli').inside (""" --net=host -v ${workspace}:/app --entrypoint='' """) {
                Plx.pl.withSonarQubeEnv(installationName: 'sonarqube') {
                    Plx.pl.sh '$SONAR_RUNNER_HOME/bin/sonar-scanner ' +
                    """  -Dsonar.sources=./ """ +
                    //"""  -Dsonar.tests=./tests """ +
                    """  -Dsonar.projectKey=${name}""" +
                    """  -Dsonar.projectDescription="" """ +
                    """  -Dsonar.projectVersion=${baseVersion} """ +
                    """  -Dsonar.exclusions=vendor/** """ +
                    """  -Dsonar.inclusions=**.php """ +
                    """  -Dsonar.scm.exclusions.disabled=true """ +
                    //"""  -Dsonar.typescript.tslint.reportPaths=lint-report.json """ +
                    //"""  -Dsonar.typescript.lcov.reportPaths=coverage/lcov.info """ +
                    //"""  -Dsonar.clover.reportPath=coverage/clover.xml """
                    //"""  -Dsonar.testExecutionReportPaths=test-report.xml """ +
                    """  -DsourceEncoding=UTF-8 """
                }
            }
        } finally {
            Plx.pl.sh """sudo chown ${userId}:${groupId} * -R """
        }
        */
    }

    void build() {
        //Plx.exec.echo "PhpController.build()"
        /*
        try{
            container = app.wfs.docker.build(
                    """${dockerPath}:${version}""",
                    """ -f ${workspace}/Dockerfile . """
            )
        } finally {
            Plx.pl.sh """sudo chown ${userId}:${groupId} * -R """
        }
        
         */
    }

    void publish() {
       // Plx.exec.echo "PhpController.publish()"
        /*
        try{
            Plx.pl.docker.image('composer').inside (""" --net=host -v ${workspace}:/app --entrypoint='' """) {
                Plx.pl.sh """ composer test """
            }
        } finally {
            Plx.pl.sh """sudo chown ${userId}:${groupId} * -R """
        }

         */
    }

    @Override
    void init() {
       // Plx.exec.echo "PhpController.init()"

    }

    @Override
    void beforeAction() {
        //Plx.exec.echo "PhpController.beforeAction()"

    }

    @Override
    void afterAction() {
        //Plx.exec.echo "PhpController.afterAction()"

    }

    @Override
    void end() {
        //Plx.exec.echo "PhpController.end()"

    }
}
