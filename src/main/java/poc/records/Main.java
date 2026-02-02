package poc.records;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Basic record usage
        Person.Address address = new Person.Address("221B Baker Street", "London", "NW1");
        Person sherlock = new Person("Sherlock Holmes", 40, address);

        System.out.println("Person record:");
        System.out.println("  " + sherlock); // toString auto-generated
        System.out.println("  name=" + sherlock.name());
        System.out.println("  isAdult=" + sherlock.isAdult());

        // Demonstrate immutability and with-style copy
        Person olderSherlock = sherlock.withAge(41);
        System.out.println("\nCopy with changed field:");
        System.out.println("  original=" + sherlock);
        System.out.println("  updated =" + olderSherlock);

        // Demonstrate equals/hashCode auto-generation
        Person sherlock2 = new Person("Sherlock Holmes", 40, address);
        System.out.println("\nEquality:");
        System.out.println("  sherlock.equals(sherlock2) = " + sherlock.equals(sherlock2));
        System.out.println("  sherlock.hashCode()==sherlock2.hashCode() = " + (sherlock.hashCode() == sherlock2.hashCode()));

        // Records as map keys
        Map<Person, String> roles = new HashMap<>();
        roles.put(sherlock, "detective");
        System.out.println("\nRecord as map key:");
        System.out.println("  lookup via equal instance: " + roles.get(sherlock2));

        // Domain record: Money
        Money m1 = new Money("USD", 10_00);
        Money m2 = new Money("USD", 2_50);
        Money sum = m1.plus(m2);
        System.out.println("\nMoney record:");
        System.out.println("  m1=" + m1 + ", m2=" + m2 + ", sum=" + sum);

        // Interop with a classic class
        LegacyUser legacy = new LegacyUser("john", "doe");
        Person fromLegacy = legacy.toPerson(address);
        System.out.println("\nInterop with class:");
        System.out.println("  legacy fullName=" + legacy.fullName());
        System.out.println("  converted to record=" + fromLegacy);

        // Simple pattern via instanceof (no preview features required)
        Object maybePerson = sherlock;
        System.out.println("\ninstanceof + record accessors:");
        if (maybePerson instanceof Person p) {
            System.out.println("  It is a Person named " + p.name() + " from " + p.address().city());
        }

        // Validation demo (uncomment to see exceptions)
        // new Person("", 10, address);
        // new Money("usd", -1);
    }
}
