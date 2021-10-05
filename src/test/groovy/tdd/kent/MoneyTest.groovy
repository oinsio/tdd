package tdd.kent

import spock.lang.Specification

class MoneyTest extends Specification {

    def "should be able to equal"() {

        expect:
            Money.dollar(5) == Money.dollar(5)
            Money.dollar(5) != Money.dollar(6)
            Money.franc(5) == Money.franc(5)
            Money.franc(5) != Money.franc(6)
            !Money.franc(5).equals(Money.dollar(5))
    }

    def "should provide currency name"() {
        expect:
            "USD" == Money.dollar(1).currency()
            "CHF" == Money.franc(1).currency()
    }

    def "should equal different classes"() {
        expect:
            new Money(10, "CHF") == new Franc(10, "CHF")
    }
}
