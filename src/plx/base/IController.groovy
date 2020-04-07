package plx.base

interface IController extends Serializable {

    void init()
    void beforeAction()
    void afterAction()
    void end()

}