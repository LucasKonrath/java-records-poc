package poc.records;

// Classic mutable-ish class to contrast with records.
public class LegacyUser {
    private final String firstName;
    private final String lastName;

    public LegacyUser(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String fullName() {
        return (firstName == null ? "" : firstName) + " " + (lastName == null ? "" : lastName);
    }

    public Person toPerson(Person.Address address) {
        String fn = firstName == null ? "" : firstName.trim();
        String ln = lastName == null ? "" : lastName.trim();
        String name = (fn + " " + ln).trim();
        if (name.isBlank()) {
            name = "Unknown";
        }
        return new Person(name, 0, address);
    }
}
