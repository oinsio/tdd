package tdd.kent

import spock.lang.Specification

class SumTest extends Specification {

    def "should reduce sum"() {

        given:
            def sum = new Sum(Money.dollar(3), Money.dollar(4))
            def bank = new Bank()
        when:
            def result = bank.reduce(sum, "USD")
        then:
            Money.dollar(7) == result
    }
}
