public class Robot {
    // Private attributes for Encapsulation
    private String id;
    private int battery;
    private String mode;    // e.g., "Idle", "Combat", "Repair"

    // --- CONSTRUCTOR ---
    // Initializes a new Robot in a ready state immediately.
    public Robot(String id) {
        this.id = id;
        this.battery = 100;
        this.mode = "Idle";
    }

    // --- GETTERS AND SETTERS ---

    public void setId(String newId) {
        id = newId;
    }

    public String getId() {
        return id;
    }

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
