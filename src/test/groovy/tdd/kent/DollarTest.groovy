package tdd.kent

import spock.lang.Specification

class DollarTest extends Specification {

    def "should be multiplicative"() {

        given:
            def five = new Dollar(5)
        expect:
            new Dollar(10) == five.times(2)
            new Dollar(15) == five.times(3)
    }

    def "should be able to equal"() {

        expect:
            new Dollar(5) == new Dollar(5)
        and:
            new Dollar(5) != new Dollar(6)
    }
}
