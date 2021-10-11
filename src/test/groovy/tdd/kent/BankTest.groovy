package tdd.kent

import spock.lang.Specification

class BankTest extends Specification {

    def "should reduce"() {

        given:
            def bank = new Bank()
        when:
            def result = bank.reduce(Money.dollar(1), "USD")
        then:
            Money.dollar(1) == result
    }
}
