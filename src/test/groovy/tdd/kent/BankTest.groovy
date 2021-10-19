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

    def "should reduce money with different currency"() {

        given:
            def bank = new Bank()
            bank.addRate("CHF", "USD", 2)
        when:
            def result = bank.reduce(Money.franc(2), "USD")
        then:
            Money.dollar(1) == result
    }

    def "should use identity rate for the same currency"() {

        expect:
            new Bank().rate("USD", "USD") == 1
    }

    def "should add mixed currency"() {

        given:
            Money fiveBucks = Money.dollar(5)
            Money tenFrancs = Money.franc(10)
            def bank = new Bank()
            bank.addRate("CHF", "USD", 2)
        when:
            def result = bank.reduce(fiveBucks.plus(tenFrancs), "USD")
        then:
            result == Money.dollar(10)
    }
}
