// BASE CLASS (The Parent)
public class ShipComponent {
    String name;
    boolean status; // true = online, false = offline

    public void checkStatus() {
        if (status) {
            System.out.println(name + " is ONLINE.");
        } else {
            System.out.println(name + " is OFFLINE.");
        }
    }
}
