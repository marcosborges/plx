package plx.controllers

import plx.Plx
import plx.base.IGit
import plx.base.IController
import plx.base.environments.IEnvironments
import plx.base.archetypes.IArchetype

class CiCdController implements IController  {

    String name
    String namespace
    IArchetype archetype
    IGit git
    IEnvironments environment

    @Override
    void init() { }

    void start(Map args) {

        name = args.name

        namespace = args.namespace

        archetype = [
            name : args.archetype.name,
            type : args.archetype.type,
            language : new GroovyClassLoader()
                .loadClass("${args.archetype.language.class}",true,false)
                .getDeclaredConstructor()
                .newInstance(container : args.archetype.language.container),
            configures : new GroovyClassLoader()
                .loadClass("${args.archetype.configures.class}",true,false)
                .getDeclaredConstructor()
                .newInstance(files : args.archetype.configures.files),
        ] as IArchetype

        git = args.git as IGit

        environment = [
            name : args.environment.name,
            destination : new GroovyClassLoader()
                .loadClass("${args.environment.destination.class}",true,false)
                .getDeclaredConstructor()
                .newInstance(
                    options : args.archetype.destination.options
                )
        ] as IEnvironments

        Plx.exec.node () {

            Plx.exec.stage ('downloading') {
                Plx.exec.git(git)
            }

            Plx.exec.stage ('restoring') {
                archetype.language.restore()
            }

            Plx.exec.stage ('testing') {
                archetype.language.unitTest()
            }

            Plx.exec.stage ('reviewing') {
                Plx.exec.wfs.withCredentials([
                    Plx.exec.wfs.string(credentialsId: 'PLX_SONAR_ENABLED', variable: "PLX_SONAR_ENABLED"),
                    Plx.exec.wfs.string(credentialsId: 'PLX_SONAR_API_HOST', variable: "PLX_SONAR_API_HOST"),
                    Plx.exec.wfs.string(credentialsId: 'PLX_SONAR_API_KEY', variable: "PLX_SONAR_API_KEY"),
                    Plx.exec.wfs.string(credentialsId: 'PLX_SONAR_WEBHOOK_KEY', variable: "PLX_SONAR_WEBHOOK_KEY")
                ]) {
                    archetype.language.review()
                }
            }

            Plx.exec.stage ('building') {
                archetype.language.build()
            }

            Plx.exec.stage ('registering') {
                Plx.exec.wfs.withCredentials([
                    Plx.exec.wfs.string(credentialsId: "PLX_NEXUS_ENABLED", variable: "PLX_NEXUS_ENABLED"),
                    Plx.exec.wfs.string(credentialsId: "PLX_NEXUS_API_HOST", variable: "PLX_NEXUS_API_HOST"),
                    Plx.exec.wfs.string(credentialsId: "PLX_NEXUS_API_KEY", variable: "PLX_NEXUS_API_KEY"),
                    Plx.exec.wfs.string(credentialsId: "PLX_NEXUS_COMPONENT_REGISTRY_${environment.name.toUpperCase()}", variable: "PLX_NEXUS_COMPONENT_REGISTRY"),

                    Plx.exec.wfs.string(credentialsId: "PLX_DOCKER_REGISTRY_HOST", variable: "PLX_NEXUS_DOCKER_HOST"),
                    Plx.exec.wfs.string(credentialsId: "PLX_DOCKER_REGISTRY_KEY", variable: "PLX_NEXUS_DOCKER_KEY"),
                    Plx.exec.wfs.string(credentialsId: "PLX_DOCKER_REGISTRY_NAME_${environment.name.toUpperCase()}", variable: "PLX_NEXUS_DOCKER_REGISTRY"),




                ]) {
                    archetype.language.registry()
                }
            }

            Plx.exec.stage ('configuring') {
                archetype.configures.verify()
            }

            Plx.exec.stage ('publishing') {

                environment.destination.publish()

            }

            Plx.exec.stage ('validating') {
                environment.destination.validate()
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