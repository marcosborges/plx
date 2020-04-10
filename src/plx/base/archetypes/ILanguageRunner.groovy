package plx.base.archetypes

interface ILanguageRunner {
    String name = ""
    String dockerfile = null
    Map args = [:]
    Map env = [:]
    List ports = [ 80, 8080 ]
    interface IMigrator extends Serializable{

        def setup()
        def up()
        def down()

    }
}