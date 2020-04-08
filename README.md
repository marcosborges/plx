# PLX - Ready Jenkins Pipelines

The main objective of PLX is to provide an uncomplicated way to package and delivery micro-services without sacrificing quality.

1. [How it works](#how-it-works)
    - [Git repository setup](#git-repository-setup)
    - [Initializes the application](#initializes-the-application-based-on-the-archetype)
    - [Jenkins Pipeline setup](#jenkins-pipeline-setup)
2. [How to install](#how-to-install)
3. [How to Configure](#how-to-configure)
4. [How to create a new project](#how-to-create-a-new-project)
5. [How to import existing projects](#how-to-import-existing-projects)

---

## How it works

CI / CD pipelines are automatically generated based on application archetypes.

As soon as a new project is created, the following actions are performed automatically.

* Git repository setup;

* Initializes the application based on the archetype;

* Jenkins Pipeline setup;

---

### Git repository setup

The setup of the GIT Repository consists of 3 parts:

* **Creating the repository** - *Creates a repository with the application name.*

* **Protect the branches** - *It protects the direct push into the branch of development, approval and production linked to the environments. This action must be done by pull / merge request.*

* **Configure webhooks** - *Create a webhook for each branch linked to an environment to trigger the pipeline responsible for packaging and delivery.*


*Today we support 3 Git providers: Github, GitLab and Bitbucket.*

---

### Initializes the application based on the archetype

During the process of creating or importing applications, it is necessary to provide an archetype.

It is based on archetypes that PLX automatically configures CI / CD pipelines.

*Today we make available 8 archetypes:*

* PHP
    - API Rest.
    - Service (Consumer/Producer).
    - Schedule worker.
    - Library.
* NodeJs
    - API Rest.
    - Service (Consumer/Producer).
    - Schedule worker.
    - Library.
* React
    - Static WEB (frontend web).

You can create and register your own archetypes.

---

### Jenkins Pipeline setup

**[NAMESPACE]/[APPLICATION]/[ENVIRONMENT]/** 

    - setup-secrets
    - packing-and-deploying
    
---

## How to install

### Install by "console script"
Copy, paste and run the follow code on Jenkins > Manager > Script Console.

```groovy 
import jenkins.model.Jenkins
import jenkins.plugins.git.GitSCMSource
import jenkins.plugins.git.traits.BranchDiscoveryTrait
import org.jenkinsci.plugins.workflow.libs.GlobalLibraries
import org.jenkinsci.plugins.workflow.libs.LibraryConfiguration
import org.jenkinsci.plugins.workflow.libs.SCMSourceRetriever

if (! Jenkins.instance.getDescriptor(GlobalLibraries).getLibraries().findAll{ it.getName() == "plx" }) {
    def libraries = Jenkins.instance.getDescriptor(GlobalLibraries).getLibraries()
    def scm = new GitSCMSource("git@github.com:marcosborges/plx.git")
    scm.traits = [new BranchDiscoveryTrait()]
    def library = new LibraryConfiguration("plx", new SCMSourceRetriever(scm))    
    library.defaultVersion = "master"
    library.implicit = true
    library.allowVersionOverride = true
    library.includeInChangesets = false
    libraries << library
    def gSettings = Jenkins.instance.getExtensionList(GlobalLibraries.class)[0]
    gSettings.libraries = libraries
    gSettings.save()
    // TODO - CREATE SETUP JOB
    println 'PLX Global Shared Libraries configured succefully'
}
```
---
<!--
### Install by "pipeline job"

1. Create one Pipeline Job called "install";
2. Copy, paste and run the follow code on script editor";
```groovy
@GrabResolver(name='plx', root='https://maven.pkg.github.com/marcosborges/')
@Grab('com.marcosborges.plx:0.0.1')
import plus.plx.Install
new Install().start() 
```
3. Save end run the "install" job;
---
-->




# How to configure

## Run setup Pipeline Job

---

## fsdfdsfsdfsdfsdfs

---

## Model
```groovy
@Library('plx')
import plx.Application
new Application(
    [
        packageName : "plx.controllers",
        controllerName: "CiCdController",
        action: "start",
        args : [
            name: "demo",
            namespace: "innovation",
            archetype : [
                name : "php.microservice.api",
                type : "service",
                /* type : "job", */
                language : [
                    class : "Php",
                    container : [
                        builder : [
                            name : "", 
                            /*dockerfile : [
                                "name" : "",
                                "args : []
                            ],  
                            */
                            env : [:]
                        ],
                        runner : [
                             name : "", 
                             /*dockerfile : [
                                 "name" : "",
                                 "args : []
                             ],  
                             */
                             env : [:],
                             ports : [ 80, 8080 ]
                        ],
                    ]
                ],
                configures : [
                    class : "EnvVars",
                    files : [
                        "config/gcp-project-key.json"
                    ]
                ]                    
            ],
            git : [
                url : "${env.gitlabSourceRepoSshUrl}",
                branch : "${env.gitlabBranch}"
            ],
            environment : [
                name : "${env.environment}",
                destination : [
                    class : "Gcp.K8s",
                    type : "blue-green",  
                    nodeSelector : "main",
                    /* schedule : "10 * * * *", */
                    expose : [
                        [
                            host : null,
                            paths : [
                                '/' : 80
                            ],
                            tls : "tlsSecret"
                        ]
                    ],
                    health : [
                        path : "/healthz",
                        port : 80,
                        /* headers: [
                            [
                                name: "Custom-Header",
                                value: "Awesome"
                            ]
                        ], */
                        /* exec : [ 
                            'cat /tmp/healthy'
                        ], */
                        delay: [
                            initial : 30,    
                            interval : 60,
                            timeout : 60
                        ],
                        hertz : [
                            successAt : 2,        
                            failureAt : 4
                        ],
                    ],
                    size : [
                        requests : [
                            memory : "200Mi",
                            cpu : "750m"
                        ],
                        requests : [
                            memory : "200Mi",
                            cpu : "750m"
                        ],    
                    ],
                    env : [
                        TZ : "America/Sao_Paulo"
                    ]
                ]
            ],
            tests : [
                smoke : [ 
                    class : "Newman",
                ],
            ]
        ]        
    ], 
    this, 
    Jenkins.instance
).run()
```

### Modelo de JOBs

  

#### AAAA


##### AAAAA


###### AAAAAA
