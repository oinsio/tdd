package tdd.kent

import spock.lang.Specification

class DollarTest extends Specification {

    def "should be multiplicative"() {
        given:
            def five = new Dollar(5)
        when:
            five.times(2)
        then:
            five.amount == 10
    }

}
