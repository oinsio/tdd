package tdd.kent

import spock.lang.Specification

class MoneyTest extends Specification {

    def "should be multiplicative"() {

        given:
            def five = Money.dollar(5)
        expect:
            Money.dollar(10) == five.times(2)
            Money.dollar(15) == five.times(3)
    }

    def "should be able to equal"() {

        expect:
            Money.dollar(5) == Money.dollar(5)
            Money.dollar(5) != Money.dollar(6)
            !Money.franc(5).equals(Money.dollar(5))
    }

    def "should provide currency name"() {

        expect:
            "USD" == Money.dollar(1).currency()
            "CHF" == Money.franc(1).currency()
    }

    def "should do simple addition"() {

        given:
            def five = Money.dollar(5)
            Expression result = five.plus(five)
            Sum sum = (Sum) result
        expect:
            five == sum.augend
            five == sum.addend
    }

    def "should test reduce Sum"() {

        given:
            def sum = new Sum(Money.dollar(3), Money.dollar(4))
            def bank = new Bank()
        when:
            def result = bank.reduce(sum, "USD")
        then:
            Money.dollar(7) == result
    }

    def "should reduce"() {

        given:
            def bank = new Bank()
        when:
            def result = bank.reduce(Money.dollar(1), "USD")
        then:
            Money.dollar(1) == result
    }
}
