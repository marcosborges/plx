import plx.Plx
import spock.lang.*
import com.homeaway.devtools.jenkins.testing.JenkinsPipelineSpecification

class PlxSpec extends Specification {

    def setup () {}

    def "Plx_new" () {
        when:
            Plx plx = new Plx()
        then:
            plx instanceof Plx
    }


}