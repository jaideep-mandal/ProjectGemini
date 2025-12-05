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
        
        // New: Simulate a biometric scan
        System.out.print("Fingerprint Verified? (true/false): ");
        boolean fingerprintVerified = input.nextBoolean();

        // LOGICAL OR (||): Access granted if PIN is correct OR Fingerprint is verified
        boolean isAuthenticated = (pin == 1234) || fingerprintVerified;

        if (!isAuthenticated) {
            System.out.println("\n[ERROR]: AUTHENTICATION FAILED. TERMINATING SESSION.");
            input.close();
            return;                                                                             // Stop the program here
        }

        // Output Personalized Report
        System.out.println("\n--- ACCESS GRANTED ---");
        System.out.println("Welcome, " + userName + "!");
        System.out.println("Auth Method: " + ((pin == 1234) ? "PIN" : "BIOMETRIC"));    // Ternary hint for later!

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
        
        boolean isStable = healthPercentage > 70;

        // LOGICAL AND (&&): Strict requirement for Uplink
        // Must be Authenticated AND System must be Stable
        boolean isSecure = isAuthenticated && isStable;

        System.out.println("System Stable: " + isStable);
        System.out.println("System Secure for Uplink: " + isSecure);

        // --- SECTION 11: COMMAND INTERFACE (Conditionals) ---
        
        input.nextLine();   // CONSUME THE LEFTOVER NEWLINE

        System.out.println("\n==========================================");
        System.out.println("AVAILABLE MODULES:");
        System.out.println("1. [PHYSICS] - Kinetic Energy & Displacement Calculator");
        System.out.println("2. [ENCRYPT] - Secure Community Encoder");
        System.out.println("3. [UPLINK]  - Mission Report Generator");
        System.out.println("\n==========================================");
        System.out.println("ENTER COMMAND MODULE NAME: ");

        String command = input.nextLine();

        if (command.equalsIgnoreCase("PHYSICS")) {
            
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

            System.out.println("\n>> ACCESSING ENCRYPTION CHANNEL...");
            char originalRank = 'A';
            System.out.println("Original Mission Rank: " + originalRank);
            char encryptedRank = (char)(originalRank + 8);
            System.out.println("Encrypting data... Key: " + encryptedRank);
            char decryptedRank = (char)(originalRank - 8);
            System.out.println("Decrypting verification... " + decryptedRank);

        } else if (command.equalsIgnoreCase("UPLINK")) {

            // LOGICAL NOT (!): Block access if NOT secure
            if (!isSecure) {
                System.out.println("\n[ERROR]: SECURITY LOCKDOWN. UPLINK DENIED.");
                System.out.println("Reason: System instability detected.");
            } else {
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
            }

        } else {
            System.out.println("\n[ERROR]: UNKNOWN COMMAND. SYSTEM STANDBY.");
        }

        input.close();
    }
}