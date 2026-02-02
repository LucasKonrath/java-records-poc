java-records-poc

Goal
- Minimal Java POC demonstrating Java records: immutability, generated methods, compact constructors, validation, nested records, pattern matching (if available), and interoperability with classes.

Requirements
- JDK 17+ (records are final since Java 16; this project targets 17 LTS)

Run (no build tool)
1) Compile:
   javac -d out src/main/java/poc/records/*.java
2) Run:
   java -cp out poc.records.Main

Optional: enable preview (only needed if you change code to use preview language features)
- javac --release 21 --enable-preview -d out ...
- java --enable-preview -cp out ...

What to look for
- Person record: compact constructor validation, custom method.
- Money record: normalization and domain logic.
- Address record nested in Person.
- Equality/hashCode/toString behavior.
- Using a record in a HashMap key.
- Simple "with"-style method (returns a new record instance).
- Interop with a classic class (LegacyUser).
