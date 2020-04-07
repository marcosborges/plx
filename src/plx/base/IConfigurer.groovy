package plx.base

interface IConfigurer  extends Serializable{

    Map base
    Map available
    Map unknown

    Map init()
    Map loadBase()
    Map loadAvailable()
    Map loadUnknown()
}