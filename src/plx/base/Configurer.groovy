package plx.base

trait Configurer implements IConfigurer {

    Map loadUnknown() {
        unknown = base.collectEntries{k,v -> [k, (v - (available[k]?:0))]}
    }

}