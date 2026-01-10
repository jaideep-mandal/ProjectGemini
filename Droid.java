public class Droid {
    String name;
    int batteryLevel;
    String status;

    public void activate() {
        status = "Online";
        batteryLevel = 100;
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