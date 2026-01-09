// SUBCLASS (The Child) - Inherits from ShipComponent
public class Engine extends ShipComponent {
    int powerOutput; // Specific to Engines

    public void boost() {
        System.out.println(">> " + name + " is boosting power to " + (powerOutput * 2) + "%!");
    }
}