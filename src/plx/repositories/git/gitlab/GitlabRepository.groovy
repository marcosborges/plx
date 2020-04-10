package plx.repositories.git.gitlab


import plx.repositories.git.IGitRepository
import plx.repositories.git.IGitRepositoryObject

class GitlabRepository implements IGitRepository {


    @Override
    IGitRepositoryObject create(IGitRepositoryObject repository) {
        return null
    }

    @Override
    IGitRepositoryObject update(IGitRepositoryObject repository) {
        return null
    }

    @Override
    IGitRepositoryObject getById(String id) {
        return null
    }

    @Override
    IGitRepositoryObject getByName(String name) {
        return null
    }

    @Override
    List<IGitRepositoryObject> getAll() {
        return null
    }

    @Override
    Boolean delete(String id) {
        return null
    }

    @Override
    Boolean exists(String id) {
        return null
    }
}
