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

        float totalScore = energy + logic + memory + network + security;
        float healthPercentage = (totalScore / 500.0f) * 100;

        System.out.println("\nDiagnostic Complete.");
        System.out.println("Overall System Health: " + healthPercentage + "%");

        // --- SECTION 4: OPERATION STATUS ---
        // (Moved up to be available for global checks)
        boolean isStable = healthPercentage > 70;
        boolean isSecure = (pin == 1234) && isStable;

        System.out.println("System Stable: " + isStable);
        System.out.println("System Secure: " + isSecure);

        // --- SECTION 11: COMMAND INTERFACE (Conditionals) ---
        // This replaces the linear execution. The users now CHOOSES what to do.

        input.nextLine();   // CONSUME THE LEFTOVER NEW LINE FROM nextInt() above!

        System.out.println("\n==========================================");
        System.out.println("AVAILABLE MODULES:");
        System.out.println("1. [PHYSICS] - Kinetic Energy & Displacement Calculator");
        System.out.println("2. [ENCRYPT] - Secure Community Encoder");
        System.out.println("3. [UPLINK]  - Mission Report Generator");
        System.out.println("\n==========================================");
        System.out.println("ENTER COMMAND MODULE NAME: ");

        String command = input.nextLine();

        // THE BRANCHING PATH (If-Else-If Ladder)
        if (command.equalsIgnoreCase("PHYSICS")) {
            
            // --- MOVED SECTION 5: PHYSICS ENGINE ---
            System.out.println("\n>> ACCESSING PHYSICS ENGINE...");

            System.out.print("Enter Mass (kg): ");
            double mass = input.nextDouble();
            System.out.print("Enter Velocity (m/s): ");
            double velocity = input.nextDouble();

            double kineticEnergy = 0.5 * mass * (velocity * velocity);
            System.out.printf("Kinetic Energy: %.2f Joules" + kineticEnergy);

            double u = 0;
            double a = 9.8;
            double displacement = ((velocity * velocity) - (u * u)) / (2 * a);
            System.out.printf("Theoretical Displacement to reach this velocity: %.2f meters\n" + displacement);

        } else if (command.equalsIgnoreCase("ENCRYPT")) {

            // --- MOVED SECTION 6: SECURE ENCRYPTION CHANNEL ---
            System.out.println("\n>> ACCESSING ENCRYPTION CHANNEL...");

            char originalRank = 'A';
            System.out.println("Original Mission Rank: " + originalRank);

            char encryptedRank = (char)(originalRank + 8);
            System.out.println("Encrypting data... Key: " + encryptedRank);

            char decryptedRank = (char)(originalRank - 8);
            System.out.println("Decrypting verification... " + decryptedRank);

        } else if (command.equalsIgnoreCase("UPLINK")) {

            // --- MOVED SECTION 10: TRANSMISSION UPLINK ---
            // Security Gate: Only allow Uplink if system is SECURE
            if (isSecure) {
                System.out.println("\n>> ACCESSING TRANSMISSION UPLINK...");

                System.out.print("Enter Mission Log Notes: ");
                String missionLog = input.nextLine();

                String cleanLog = missionLog.trim();
                String safeLog = cleanLog.replace("danger", "[REDACTED]");
                String filename = userName.toLowerCase().replace(" ", "_") + "_log.txt";

                System.out.println("Generating file: " + filename);

                String template = "To: HQ\nFrom: Commander <|name|>\nStatus: <|status|>\nMessege: <|log|>\nEnd Transmission.";
                String finalTransmission = template.replace("<|name|>", userName)
                                                    .replace("<|status|>", (isStable ? "STABLE" : "UNSTABLE"))
                                                    .replace("<|log|>", safeLog);

                System.out.println("\n[UPLINKING MESSEGE...]");
                System.out.println(finalTransmission);
            } else {
                // Nested Else for Security Failure
                System.out.println("\n[ERROR]: SECURITY LOCKDOWN. UPLINK DENIED.");
                System.out.println("Reason: System is unstable or PIN is invalid.");
            }

        } else {
            // Default Else
            System.out.println("\n[ERROR]: UNKNOWN COMMAND. SYSTEM STANDBY.");
        }

        // Close the scanner
        input.close();
    }
}