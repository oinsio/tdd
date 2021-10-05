package tdd.kent

import spock.lang.Specification

class FrancTest extends Specification {

    def "should be multiplicative"() {

        given:
            def five = Money.franc(5)
        expect:
            Money.franc(10) == five.times(2)
            Money.franc(15) == five.times(3)
    }
}
