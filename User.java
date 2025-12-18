// KNOWLEDGE POINT: This is a "Class" - A blueprint for creating Objects.
public class User {
    // Attributes (State)
    String name;
    int pin;
    boolean hasFingerprint;
    int clearanceLevel;

    // A method specific to this object (Behavior)
    public void printuserInfo() {
        System.out.println("User Profile: " + name);
        System.out.println("Clearance Level: " + clearanceLevel);
        System.out.println("Biometric Status: " + (hasFingerprint ? "REGISTERED" : "NONE"));
    }
}
