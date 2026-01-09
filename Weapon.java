// SUBCLASS (The Child) - Inherits from ShipComponent
public class Weapon extends ShipComponent {
    String damageType; // Specific to Weapons

    public void fire() {
        System.out.println(">> " + name + " fires a " + damageType + " blast! PEW PEW!");
    }
}