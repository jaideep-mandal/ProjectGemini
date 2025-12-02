import java.util.Scanner;   // Import the Scanner class

public class Main {
    public static void main(String[] args){
        bootSystem();
    }

    public static void bootSystem() {
        // 1. Setup Input Scanner
        Scanner input = new Scanner(System.in);

        System.out.println("Starting Project: ProjectGemini");

        // --- SECTION 1: USER LOGIN ---
        System.out.print("Enter User Name: ");
        String userName = input.nextLine();         

        System.out.print("Enter Security PIN: ");
        int pin = input.nextInt();                      
        
        // System Variables
        long systemChipId = 987654321000L;
        float cpuTemperature = 45.5f;
        boolean isSystemActive = true;

        // Output Personalized Report
        System.out.println("\n--- ACCESS GRANTED ---");
        System.out.println("Welcome, " + userName + "!");
        System.out.println("Security PIN Verified: " + pin);
        System.out.println("Chip ID: " + systemChipId);                     // Prints the Long
        System.out.println("CPU Temp: " + cpuTemperature + "C");               // Prints the Char
        System.out .println("Active: " + isSystemActive);

        // --- SECTION 2: SYSTEM DIAGNOSTIC (Percentage Calculation) ---
        System.out.println("\n--- INITIATING SYSTEM DIAGNOSTIC ---");
        System.out.println("Please enter status (0-100) for the following modules:");

        // Get Input for 5 "Subsystems"
        System.out.print("1. Energy Core: ");
        int energy = input.nextInt();

        System.out.print("2. Logic Matrix: ");
        int logic = input.nextInt();

        System.out.print("3. Memory Bank: ");
        int memory = input.nextInt();

        System.out.print("4. Network Module: ");
        int network = input.nextInt();

        System.out.print("5. Security Shield: ");
        int security = input.nextInt();

        // Calculate Percentage
        float totalScore = energy + logic + memory + network + security;
        float healthPercentage = (totalScore / 500.0f) * 100;

        System.out.println("\nDiagnostic Complete.");
        System.out.println("Overall System Health: " + healthPercentage + "%");

        // --- SECTION 3: NAVIGATION MODULE (Unit Converter) ---
        System.out.println("\n--- NAVIGATION SUBSYSTEM ---");
        System.out.print("Enter target distance (in Kilometers): ");

        double kilometers = input.nextDouble();
        double conversionFactor = 0.621371;
        double miles = kilometers * conversionFactor;

        System.out.println("Calculating trajectory...");
        System.out.println(kilometers + " km is equivalent to " + miles + " miles.");

        // --- SECTION 4: OPERATION STATUS (Operators Demo) ---
        System.out.println("\n--- OPERATION STATUS ---");

        boolean isStable = healthPercentage > 70;
        boolean isSecure = (pin == 1234) && isStable;
        double maintenanceRemainder = kilometers % 1000;

        System.out.println("System Stable (Health > 70%): " + isStable);
        System.out.println("Master Access (PIN is 1234): " + (pin == 1234));
        System.out.println("System Secure (Stable + Master): " + isSecure);
        System.out.println("Distance since last maintenance: " + maintenanceRemainder);

        // --- SECTION 5: PHYSICS ENGINE (Precedence & Associativity) ---
        System.out.println("\n--- PHYSICS ENGINE ---");
        System.out.println("Calculating Kinetic Energy of the System Ship...");

        System.out.print("Enter Mass (kg): ");
        double mass = input.nextDouble();

        System.out.print("Enter Velocity (m/s): ");
        double velocity = input.nextDouble();

        double kineticEnergy = 0.5 * mass * (velocity * velocity);
        System.out.println("Kinetic Energy: " + kineticEnergy + " Joules");

        double u = 0;
        double a = 9.8;
        double displacement = ((velocity * velocity) - (u * u)) / (2 * a);
        System.out.println("Theoretical Displacement to reach this velocity: " + displacement + " meters");

        // --- SECTION 6: POWER CALIBRATION & ENCRYPTION (Increment/Decrement) ---
        System.out.println("\n--- POWER CALIBRATION MODULE ---");
        int calibrationStart = 50;

        System.out.println("Initial Calibration Value: " + calibrationStart);
        // Postfix: Uses 50, THEN becomes 51
        System.out.println("Reading with Postfix (i++): " + calibrationStart++);
        System.out.println("Current Value after Postfix: " + calibrationStart);

        // Prefix: Becomes 52, THEN Uses 52
        System.out.println("Reading with Prefix (i++): " + ++calibrationStart);

        System.out.println("\n--- ENCRYPTION KEY GENERATOR ---");
        char keyBase = 'A';
        System.out.println("Base Key: " + keyBase);

        keyBase++;                                          // Incrementing a char! 'A' becomes 'B'
        System.out.print("Generated Sequence: " + keyBase);

        keyBase++;
        System.out.print(" -> " + keyBase);

        keyBase++;
        System.out.print(" -> " + keyBase);
        System.out.println("\n(Key generation complete using Character Increment");

        // Close the scanner
        input.close();
    }
}