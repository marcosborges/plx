package plx.base

trait Executor implements IExecutor{

    Executor init(Map config) {
        config?.each { k, v -> Executor.instance[k] = v }
        Executor.instance
    }

}