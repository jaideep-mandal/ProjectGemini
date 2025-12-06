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
        
        System.out.print("Fingerprint Verified? (true/false): ");
        boolean fingerprintVerified = input.nextBoolean();

        boolean isAuthenticated = (pin == 1234) || fingerprintVerified;

        if (!isAuthenticated) {
            System.out.println("\n[ERROR]: AUTHENTICATION FAILED. TERMINATING SESSION.");
            input.close();
            return;                                                                             // Stop the program here
        }

        System.out.println("\n--- ACCESS GRANTED ---");
        System.out.println("Welcome, " + userName + "!");

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

        // NEW: STRICT MODULE CHECK (Knowledge from Video 19 - Question 2)
        // Just like a student needs 33% in EVERY Subject, our system needs > 30 in every module.
        boolean modulesInitialized = (energy > 30) && (logic > 30) && (memory > 30) && (network > 30) && (security > 30);

        System.out.println("\nDiagnostic Complete.");
        System.out.println("Overall System Health: " + healthPercentage + "%");
        System.out.println("Individual Modules Initialized: " + modulesInitialized);

        // --- SECTION 4: OPERATION STATUS ---
        // System is stable ONLY if Average > 70 AND no single module failed.
        boolean isStable = (healthPercentage > 70) && modulesInitialized;

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
        System.out.println("4. [SCAN]    - Network Security Scanner");                  // New Module
        System.out.println("\n==========================================");
        System.out.println("ENTER COMMAND MODULE NAME: ");

        String commandRaw = input.nextLine();
        String command = commandRaw.toUpperCase();

        // THE SWITCH STATEMENT
        switch (command) {
            case "PHYSICS":
                System.out.println("\n>> ACCESSING PHYSICS ENGINE...");
                System.out.print("Enter Mass (kg): ");
                double mass = input.nextDouble();
                System.out.print("Enter Velocity (m/s): ");
                double velocity = input.nextDouble();

                double kineticEnergy = 0.5 * mass * (velocity * velocity);
                System.out.printf("Kinetic Energy: %.2f Joules" + kineticEnergy);
                break;
            
            case "ENCRYPT":
                System.out.println("\n>> ACCESSING ENCRYPTION CHANNEL...");
                char originalRank = 'A';
                System.out.println("Original Mission Rank: " + originalRank);
                char encryptedRank = (char)(originalRank + 8);
                System.out.println("Encrypting data... Key: " + encryptedRank);
                char decryptedRank = (char)(originalRank - 8);
                System.out.println("Decrypting verification... " + decryptedRank);
                break;

            case "UPLINK":
                if (!isSecure) {
                    System.out.println("\n[ERROR]: SECURITY LOCKDOWN. UPLINK DENIED.");
                    System.out.println("Reason: System instability detected.");
                } else {
                    System.out.println("\n>> ACCESSING TRANSMISSION UPLINK...");
                    System.out.print("Enter Mission Log Notes: ");
                    String missionLog = input.nextLine();
                    String cleanLog = missionLog.trim();
                    String safeLog = cleanLog.replace("danger", "[REDACTED]");

                    // Simple console output for now
                    System.out.println("Log Processed: " + safeLog);
                    System.out.println("[UPLINK ESTABLISHED]");
                }
                break;

            case "SCAN":
                // NEW MODULE: Knowledge from video 19 - Question 6
                System.out.println("\n>> NETWORK SECURITY SCANNER INITIALIZED...");
                System.out.print("Enter Target URL to scan: ");
                String url = input.nextLine();

                System.out.println("Analyzing: " + url);

                // 1. Check Security Protocol (startsWith)
                if (url.startsWith("https")) {
                    System.out.println("Protocol: SECURE (Hypertext transfer Protocol Secure)");
                } else if (url.startsWith("http")) {
                    System.out.println("Protocol: UNSECURE (Standard HTTP)");
                    System.out.println("[WARNING]: Connection is not encrypted.");
                } else {
                    System.out.println("Protocol: UNKNOWN");
                }

                // 2. Check Domain Type (endsWith)
                if (url.endsWith(".com")) {
                    System.out.println("Entity Type: Commercial");
                } else if (url.endsWith(".org")) {
                    System.out.println("Entity Type: Organization");
                } else if (url.endsWith(".gov")) {
                    System.out.println("Entity Type: Government (High Priority)");
                } else if (url.endsWith(".in")) {
                    System.out.println("Entity Type: Regional (India)");
                } else {
                    System.out.println("Entity Type: Standard Network Node");
                }
                break;

            default:
                System.out.println("\n[ERROR]: UNKNOWN COMMAND. SYSTEM STANDBY.");
                break;
        }

        input.close();
    }
}