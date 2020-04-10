package plx.controllers

import plx.Plx
import plx.base.IGit
import plx.base.archetypes.IArchetype
import plx.base.IController
import plx.base.environments.IEnvironments

class CiCdController implements IController  {

    String name
    String namespace
    IArchetype archetype
    IGit git
    IEnvironments environment

    @Override
    void init() { }

    void start(Map args) {
        Plx.exec.println(args)
        /*
        name = args.name
        namespace = args.namespace
        archetype = args.archetype as IArchetype
        git = args.git as IGit
        environment = args.environments as IEnvironments
        */

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
    void beforeAction() { }

    @Override
    void afterAction() { }

    @Override
    void end() { }
}