public class User {
    // 1. DATA HIDING: Mark attributes as private
    private String name;
    private int pin;
    private boolean hasFingerprint;
    private int clearanceLevel;

    // 2. GETTERS AND SETTERS

    public String getName() {
        return name;
    }

    public void setName(String n) {
        // Validation: Name cannot be empty
        if (n != null && !n.trim().isEmpty()) {
            this.name = n;
        } else {
            System.out.println(">> [ERROR]: Invalid Name.");
        }
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int p) {
        // Validation: PIN must be 4 digits
        if (p >= 1000 && p <= 9999) {
            this.pin = p;
        } else {
            System.out.println(">> [ERROR]: Security Alert! PIN must be 4 digits.");
        }
    }

    public boolean isHasFingerprint() {
        return hasFingerprint;
    }

    public void setHasFingerprint(boolean b) {
        this.hasFingerprint = b;
    }

    public int getClearanceLevel() {
        return clearanceLevel;
    }

    public void setClearanceLevel(int level) {
        // Validation: Level 1-5 only
        if (level >= 1 && level <= 5) {
            this.clearanceLevel = level;
        } else {
            System.out.println(">> [ERROR]: Invalid Clearance Level.");
        }
    }

    public void printUserInfo() {
        System.out.println("User Profile: " + name);
        System.out.println("Clearance Level: " + clearanceLevel);
        System.out.println("Biometric Status: " + (hasFingerprint ? "REGISTERED" : "NONE"));
    }
}
