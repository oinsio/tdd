package tdd.kent;

import java.util.Hashtable;
import java.util.Objects;

public class Bank {

    private Hashtable<Pair, Integer> rates = new Hashtable();

    void addRate(String from, String to, int rate) {

        rates.put(new Pair(from, to), rate);
    }

    public Money reduce(Expression source, String to) {

        return source.reduce(this, to);
    }

    int rate(String from, String to) {

        if (from.equals(to)) return 1;
        return rates.get(new Pair(from, to));
    }

    private class Pair {

        private final String from;
        private final String to;

        public Pair(String from, String to) {

            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {

            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return Objects.equals(from, pair.from) && Objects.equals(to, pair.to);
        }

        @Override
        public int hashCode() {

            return 0;
        }
    }
}
