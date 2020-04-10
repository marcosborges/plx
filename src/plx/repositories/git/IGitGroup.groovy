package plx.repositories.git

interface IGitGroup extends IGitApi {

    IGitGroupObject create(IGitGroupObject group)
    IGitGroupObject update(IGitGroupObject group)
    IGitGroupObject getById(String id)
    IGitGroupObject getByName(String name)
    List<IGitGroupObject> getAll()
    Boolean exists(String id)
    Boolean delete(String id)

}