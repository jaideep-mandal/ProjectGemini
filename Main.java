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

        // --- SECTION 6: SECURE ENCRYPTION CHANNEL (Type Casting & Char Math) ---
        System.out.println("\n--- SECURE ENCRYPTION CHANNEL ---");

        char originalRank = 'A';
        System.out.println("Original Mission Rank: " + originalRank);

        char encryptedRank = (char)(originalRank + 8);
        System.out.println("Encrypting data...");
        System.out.println("Encrypted Rank sent to HQ: " + encryptedRank);

        char decryptedRank = (char)(originalRank - 8);
        System.out.println("Decrypting incoming data...");                                    
        System.out.println("Verified Mission Rank: " + decryptedRank);

        // --- SECTION 7: PRECISION CALIBRATION & LOGIC CHECK ---
        System.out.println("\n--- SYSTEM EFFICIENCY CALIBRATION ---");

        float roughRating = 7/4 * 9/2;
        System.out.println("Rough Efficiency Rating (Int Math): " + roughRating + " (INACCURATE)");

        float preciseRating = 7.0f/4.0f * 9.0f/2.0f;
        System.out.println("Precise Efficiency Rating (Float Math): " + preciseRating + " (ACCURATE)");

        System.out.print("Enter Minimum Efficiency Threshold to proceed: ");
        float userThreshold = input.nextFloat();

        boolean isEfficient = preciseRating > userThreshold;
        System.out.println("System Efficiency > Threshold? " + isEfficient);

        // --- SECTION 8: MISSION LOG & FORMATTED REPORT (String & printf) ---
        System.out.println("\n--- MISSION REPORT GENERATION ---");

        // FIXING THE SCANNER TRAP:
        // We just used input.nextFloat() above. This leaves a "newline" character.
        // We must consume it before reading a new String.
        input.nextLine();

        System.out.print("Enter Mission Log Notes: ");
        String missionLog = input.nextLine();               // Now this will work correctly!

        System.out.println("\nGenerating Final Formatted Report...");
        System.out.println("==========================================");
        // Using prinf for clean columns and 2 decimal places (%.2f)
        System.out.printf("%-20s : %s\n", "Commander", userName);
        System.out.printf("%-20s : %d\n", "Mission ID", pin);
        System.out.printf("%-20s : %.2f%%\n", "Health Status", healthPercentage);
        System.out.printf("%-20s : %.2f km\n", "Distance Target", kilometers);
        System.out.printf("%-20s : %.2f J\n", "Kinetic Energy", kineticEnergy);
        System.out.printf("%-20s : %s\n", "Log Entry", missionLog);
        System.out.println("==========================================");

        // Close the scanner
        input.close();
    }
}