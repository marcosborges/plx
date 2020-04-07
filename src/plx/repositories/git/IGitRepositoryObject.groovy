package plx.repositories.git

interface IGitRepositoryObject {

    String id = null
    String name = null
    String url = null
    String cloneUrlSsh = null
    String cloneUrlHttp = null
    IGitGroupObject group = null

}

