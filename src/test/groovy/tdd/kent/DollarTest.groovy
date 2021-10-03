package tdd.kent

import spock.lang.Specification

class DollarTest extends Specification {

    def "should be multiplicative"() {

        given:
            def five = new Dollar(5)
        when:
            Dollar product = five.times(2)
        then:
            product.amount == 10
        when:
            product = five.times(3)
        then:
            product.amount == 15
    }
}
