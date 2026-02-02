package poc.records;

import java.util.Objects;

public record Person(String name, int age, Address address) {

    // Nested record
    public record Address(String street, String city, String postalCode) {
        public Address {
            street = requireNonBlank(street, "street");
            city = requireNonBlank(city, "city");
            postalCode = requireNonBlank(postalCode, "postalCode");
        }
    }

    // Compact constructor: validate/normalize inputs
    public Person {
        name = requireNonBlank(name, "name");
        if (age < 0) {
            throw new IllegalArgumentException("age must be >= 0");
        }
        address = Objects.requireNonNull(address, "address must not be null");
    }

    public boolean isAdult() {
        return age >= 18;
    }

    // With-style method
    public Person withAge(int newAge) {
        return new Person(this.name, newAge, this.address);
    }

    private static String requireNonBlank(String v, String field) {
        if (v == null || v.isBlank()) {
            throw new IllegalArgumentException(field + " must not be blank");
        }
        return v;
    }
}
