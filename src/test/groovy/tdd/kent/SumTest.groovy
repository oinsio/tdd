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

    def "should add money"() {

        given:
            Expression fiveBucks = Money.dollar(5)
            Expression tenFrancs = Money.franc(10)
            def bank = new Bank()
            bank.addRate("CHF", "USD", 2)
        when:
            Expression sum = new Sum(fiveBucks, tenFrancs).plus(fiveBucks)
            def result = bank.reduce(sum, "USD")
        then:
            Money.dollar(15) == result
    }
}
