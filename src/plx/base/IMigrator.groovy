package plx.base

interface IMigrator extends Serializable{

    def setup()
    def up()
    def down()

}