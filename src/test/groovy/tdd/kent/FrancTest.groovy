
import spock.lang.Specification
import tdd.kent.Franc

class FrancTest extends Specification {

    def "should be multiplicative"() {

        given:
            def five = new Franc(5)
        expect:
            new Franc(10) == five.times(2)
            new Franc(15) == five.times(3)
    }
}
