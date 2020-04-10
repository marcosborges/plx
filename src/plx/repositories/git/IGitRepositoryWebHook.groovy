package plx.repositories.git

interface IGitRepositoryWebHook extends IGitApi {

    IGitRepositoryObject repository = null
    IGitRepositoryWebHookObject create(IGitRepositoryWebHookObject webHook)
    IGitRepositoryWebHookObject update(IGitRepositoryWebHookObject webHook)
    IGitRepositoryWebHookObject getByName(String Name)
    IGitRepositoryWebHookObject getByUrl(String Url)
    List<IGitRepositoryWebHookObject> findAll()
    Boolean delete(String id)
    Boolean exists(String id)

}