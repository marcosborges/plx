package plx.controllers

import plx.Plx
import plx.base.IController

class CiCdController implements IController  {

    def technology
    def destinationClass

    void start() {

        Plx.exec.node () {
            Plx.exec.println("CiCd.start()")

            Plx.exec.stage ('downloading') {
                Plx.exec.println("downloading")
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

    @Override
    void init() {

    }

    @Override
    void beforeAction() {

    }

    @Override
    void afterAction() {

    }

    @Override
    void end() {

    }
}
