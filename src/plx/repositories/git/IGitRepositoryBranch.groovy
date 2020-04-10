package plx.repositories.git

interface IGitRepositoryBranch extends IGitApi {

    IGitRepositoryObject repository = null
    IGitRepositoryBranchObject create(IGitRepositoryBranchObject branch)
    IGitRepositoryBranchObject getByName(String name)
    List<IGitRepositoryBranchObject> getAll()
    Boolean delete(String name)
    Boolean exists(String name)
    Boolean isProtected(String Name)
    Boolean protect(Map map)
    Boolean unprotect(String name)

}