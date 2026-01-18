public class Droid {
    String name;
    int batteryLevel;
    String status;

    // --- CONSTRUCTOR ---
    // This simplifies droid creation. You give a name, it does the rest.
    public Droid(String name) {
        this.name = name;
        this.batteryLevel = 100;
        this.status = "Online";
    }

    public void performTask(String task) {
        if (batteryLevel > 10) {
            System.out.println(">> " + name + " is performing task: " + task);
            batteryLevel -= 20;
            System.out.println("   Battery at " + batteryLevel + "%");
        } else {
            System.out.println(">> " + name + " LOW BATTERY! Cannot perform task.");
            status = "Low Power Mode";
        }
    }

    public void recharge() {
        System.out.println(">> Charging " + name + "...");
        batteryLevel = 100;
        status = "Online";
    }

    public void displayStatus() {
        System.out.println("[" + name + "] Status: " + status + " | Battery: " + batteryLevel + "%");
    }
}