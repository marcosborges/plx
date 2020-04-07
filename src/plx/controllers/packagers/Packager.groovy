package plx.controllers.packagers

import plx.base.Controller

trait Packager extends Controller {

    def name
    def domain

    void gitClone(url, branch) {
        Plx.exec.git(url: url, branch: branch, credentialsId: "PLX_GITKEY")
    }

    String gitCurrentCommit() {
        Plx.exec.sh(returnStdout: true, script: 'git rev-parse --short HEAD').trim()
    }

    String gitCheckout(commit) {
        Plx.exec.sh( returnStdout: true, script: "git reset --hard ${commit}" ).trim()
    }



    void restore() {}

    void test() {}

    void review() {}

    void build() {}

    void publish() {}

}