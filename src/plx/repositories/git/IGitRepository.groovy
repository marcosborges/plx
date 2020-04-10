package plx.repositories.git

interface IGitRepository extends IGitApi {

    IGitGroupObject group = null
    IGitRepositoryObject create(IGitRepositoryObject repository)
    IGitRepositoryObject update(IGitRepositoryObject repository)
    IGitRepositoryObject getById(String id)
    IGitRepositoryObject getByName(String name)
    List<IGitRepositoryObject> getAll()
    Boolean delete(String id)
    Boolean exists(String id)
    List<IGitRepositoryBranchObject> branches = null
    List<IGitRepositoryWebHookObject> webHooks = null

}