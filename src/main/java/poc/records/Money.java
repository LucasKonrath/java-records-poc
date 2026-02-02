package poc.records;

public record Money(String currency, long cents) {
    public Money {
        if (currency == null || currency.isBlank()) {
            throw new IllegalArgumentException("currency must not be blank");
        }
        currency = currency.trim().toUpperCase();
        if (currency.length() != 3) {
            throw new IllegalArgumentException("currency must be a 3-letter ISO-like code");
        }
        if (cents < 0) {
            throw new IllegalArgumentException("cents must be >= 0");
        }
    }

    public Money plus(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("currency mismatch: " + this.currency + " vs " + other.currency);
        }
        return new Money(this.currency, this.cents + other.cents);
    }

    @Override
    public String toString() {
        // Custom toString (records generate one by default; override to show formatting)
        long abs = Math.abs(cents);
        long dollars = abs / 100;
        long rem = abs % 100;
        return currency + " " + dollars + "." + String.format("%02d", rem);
    }
}
