public class Robot {
    // PRIVATE: Direct access is forbidden
    private String id;
    private int battery;
    private String mode;    // e.g., "Idle", "Combat", "Repair"

    // SETTER: Allows setting ID securely
    public void setId(String newId) {
        id = newId;
    }

    // GETTER: Allows setting ID securely
    public String getId() {
        return id;
    }

    // SETTER with VALIDATION logic
    public void setMode(String newMode) {
        if (newMode.equals("Combat") || newMode.equals("Repair") || newMode.equals("Idle")) {
            mode = newMode;
            System.out.println(">> Mode updated to: " + mode);
        } else {
            System.out.println(">> [ERROR]: Invalid Mode. Protocol Rejected.");
        }
    }

    public String getMode() {
        return mode;
    }

    // SETTER with Logic
    public void setBattery(int level) {
        if (level >= 0 && level <= 100) {
            battery = level;
        } else {
            System.out.println(">> [ERROR]: Invalid Battery Level.");
        }
    }

    public int getBattery() {
        return battery;
    }
}
