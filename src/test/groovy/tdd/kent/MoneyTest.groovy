package tdd.kent

import spock.lang.Specification

class MoneyTest extends Specification {

    def "should be able to equal"() {

        expect:
            new Dollar(5) == new Dollar(5)
            new Dollar(5) != new Dollar(6)
            new Franc(5) == new Franc(5)
            new Franc(5) != new Franc(6)
            !new Franc(5).equals(new Dollar(5))
    }
}
