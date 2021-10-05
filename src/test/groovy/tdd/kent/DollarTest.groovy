package tdd.kent

import spock.lang.Specification

class DollarTest extends Specification {

    def "should be multiplicative"() {

        given:
            def five = Money.dollar(5)
        expect:
            Money.dollar(10) == five.times(2)
            Money.dollar(15) == five.times(3)
    }
}
