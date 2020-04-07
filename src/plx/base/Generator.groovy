package plx.base

trait Generator implements IGenerator {

    Generator init(Map config) {
        config?.each { k, v -> Generator.instance[k] = v }
        Generator.instance
    }
}