public class User {
    // 1. DATA HIDING: Private attributes
    private String name;
    private int pin;
    private boolean hasFingerprint;
    private int clearanceLevel;

    // --- 2. CONSTRUCTOR ---
    // This allows us to set all data INSTANTLY when creating the object.
    public User(String name, int pin, boolean hasFingerprint, int clearanceLevel) {
        this.name = name;   // Use setters inside constructor for validation!
        this.pin = pin;
        this.hasFingerprint = hasFingerprint;   // Direct set (no validation needed yet)
        this.clearanceLevel = clearanceLevel;
    }

    // Default Constructor (Optional, but good practice)
    public User() {
        this.name = "Guest";
        this.pin = 0000;
        this.hasFingerprint = false;
        this.clearanceLevel = 1;
    }

    // Getters and Setters remain the same...
    public String getName() {
        return name;
    }

    public void setName(String n) {
        if (n != null && !n.trim().isEmpty()) {
            this.name = n;
        } else {
            System.out.println(">> [ERROR]: Invalid Name. Keeping old value.");
        }
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int p) {
        if (p >= 1000 && p <= 9999) {
            this.pin = p;
        } else {
            System.out.println(">> [ERROR]: PIN must be 4 digits. Keeping old PIN.");
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
        if (level >= 1 && level <= 5) {
            this.clearanceLevel = level;
        } else {
            System.out.println(">> [ERROR]: Invalid Clearance Level (1-5).");
        }
    }

    public void printUserInfo() {
        System.out.println("User Profile: " + name);
        System.out.println("Clearance Level: " + clearanceLevel);
        System.out.println("Biometric Status: " + (hasFingerprint ? "REGISTERED" : "NONE"));
    }
}
