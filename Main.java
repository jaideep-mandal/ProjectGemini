import java.util.Scanner;   // Import the Scanner class
import java.util.Random;    // Import the Random class

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

        boolean modulesInitialized = (energy > 30) && (logic > 30) && (memory > 30) && (network > 30) && (security > 30);

        System.out.println("\nDiagnostic Complete.");
        System.out.println("Overall System Health: " + healthPercentage + "%");

        // --- SECTION 4: OPERATION STATUS ---
        boolean isStable = (healthPercentage > 70) && modulesInitialized;
        boolean isSecure = isAuthenticated && isStable;

        System.out.println("System Stable: " + isStable);
        System.out.println("System Secure for Uplink: " + isSecure);

        // --- SECTION 11: COMMAND INTERFACE (Conditionals) ---
        
        input.nextLine();   // CONSUME THE LEFTOVER NEWLINE

        while (true) {
            System.out.println("\n==========================================");
            System.out.println("AVAILABLE MODULES:");
            System.out.println("1.  [PHYSICS]       - Kinetic Energy Calculator");
            System.out.println("2.  [ENCRYPT]       - Secure Encoder");
            System.out.println("3.  [UPLINK]        - Mission Report");
            System.out.println("4.  [SCAN]          - Network Security Scanner");
            System.out.println("5.  [SIMULATION]    - Combat Tactics Drill");
            System.out.println("6.  [CALIBRATE]     - System Calibration");
            System.out.println("7.  [SYSCHECK]      - Power Cycle & Reboot");
            System.out.println("8.  [SEARCH]        - Deep Search Protocol");
            System.out.println("9.  [MATRIX]        - Quantum Matrix Visualization");
            System.out.println("10. [RISK]          - Risk Permutation Engine");
            System.out.println("11. [SUPPLY]        - Supply Inventory (New)");
            System.out.println("12. [EXIT]          - Shutdown System");            
            System.out.println("\n==========================================");
            System.out.println("ENTER COMMAND MODULE NAME: ");

            String commandRaw = input.nextLine();
            String command = commandRaw.toUpperCase();

            if (command.equals("EXIT")) {
                System.out.println("SHUTTING DOWN SYSTEM... GOODBYE.");
                break;                                                      // Breaks the loop and ends the program
            }

            switch (command) {
                case "PHYSICS":
                    System.out.println("\n>> ACCESSING PHYSICS ENGINE...");
                    System.out.print("Enter Mass (kg): ");
                    double mass = input.nextDouble();
                    System.out.print("Enter Velocity (m/s): ");
                    double velocity = input.nextDouble();
                    input.nextLine();   // Fix Scanner Trap

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

                        System.out.println("Log Processed: " + safeLog);
                        System.out.println("[UPLINK ESTABLISHED]");
                    }
                    break;

                case "SCAN":
                    System.out.println("\n>> NETWORK SECURITY SCANNER INITIALIZED...");
                    System.out.print("Enter Target URL to scan: ");
                    String url = input.nextLine();

                    System.out.println("Analyzing: " + url);

                    if (url.startsWith("https")) {
                        System.out.println("Protocol: SECURE");
                    } else {
                        System.out.println("Protocol: UNSECURE");
                    }
                    break;

                case "SIMULATION":
                    System.out.println("\n>> TACTICAL COMBAT SIMULATION INITIATED...");
                    System.out.println("Select Maneuver: 0 (Rock), 1 (Paper), 2 (Scissors)");
                    int userMove = input.nextInt();
                    input.nextLine();   // Fix Scanner Trap

                    if (userMove < 0 || userMove > 2) {
                        System.out.println("[ERROR]: INVALID MANEUVER.");
                    } else {
                        Random rand = new Random();
                        int computerMove = rand.nextInt(3);
                        System.out.println("System Maneuver: " + computerMove);

                        if (userMove == computerMove) {
                            System.out.println("RESULT: STALEMATE");
                        } else if (userMove == 0 && computerMove == 2 ||
                                    userMove == 1 && computerMove == 0 ||
                                    userMove == 2 && computerMove == 1 ) {
                            System.out.println("RESULT: VICTORY");
                        } else {
                            System.out.println("RESULT: DEFEAT");
                        }
                    }
                    break;

                case "CALIBRATE":
                    System.out.println("\n>> SYSTEM CALIBRATION MODULE LOADED...");
                    Random randCal = new Random();
                    String retryChoice;

                    do {
                        System.out.println("[RUNNING DIAGNOSTICS...");
                        int drift = randCal.nextInt(100);                       
                        System.out.println("Current System Drift: " + drift + "%");
                        System.out.print("Run Calibration sequence again? (y/n): ");
                        retryChoice = input.nextLine();
                    } while (retryChoice.equalsIgnoreCase("y"));

                    System.out.println("Calibration Sequence Ended.");
                    break;

                case "SYSCHECK":
                    System.out.println("\n>> INITIATING POWER CYCLE...");
                    for (int i = 1; i <= 5; i++) {
                        System.out.println("Powering up Sector " + i + "...");
                        try { Thread.sleep(500); } catch(InterruptedException e) { }
                    }
                    System.out.println("All Sectors ONLINE.");
                    System.out.println("\n>> INITIATING REBOOT COUNTDOWN...");
                    for (int i = 10; i > 0; i--) {
                        System.out.println("Reboot in " + i + "...");
                        try { Thread.sleep(500); } catch (InterruptedException e) { }
                    }
                    System.out.println("REBOOT COMPLETE. SYSTEM FRESH.");
                    break;

                case "SEARCH":
                    System.out.println("\n>> DEEP SEARCH PROTOCOL INITIATED...");
                    System.out.print("Enter total checks to perform (e.g. 10): ");
                    int totalChecks = input.nextInt();
                    System.out.print("Enter ID to SKIP: ");
                    int skipId = input.nextInt();
                    System.out.print("Enter ID to STOP: ");
                    int stopId = input.nextInt();
                    input.nextLine();

                    for (int i = 1; i <= totalChecks; i++) {
                        if (i == skipId) {
                            System.out.println("-> ID " + i + ": [CORRUPTED] - SKIPPING (Continue)");
                            continue;
                        }
                        if (i == stopId) {
                            System.out.println("-> ID " + i + ": [TARGET FOUND] - STOPPING (Break)");
                            break;
                        }
                        System.out.println("-> ID " + i + ": Analyzed.");
                    }
                    break;

                case "MATRIX":
                    System.out.println("\n>> GENERATING QUANTUM MATRIX VISUALIZATION...");
                    System.out.print("Enter Matrix Size (e.g. 5): ");
                    int size = input.nextInt();
                    input.nextLine();

                    for (int i = 0; i < size; i++) {    
                        for (int j = 0; j <= i; j++) {  
                            System.out.println("[" + i + "," + j + "]");
                        }
                        System.out.println();           
                    }
                    System.out.println("Matrix Generation Complete.");
                    break;

                case "RISK":
                    System.out.println("\n>> CALCULATING RISK PERMUTATIONS...");
                    System.out.print("Enter Risk Complexity Level (e.g. 5): ");
                    int n = input.nextInt();
                    input.nextLine();

                    long permutations = 1;  
                    int factorialCounter = 1;

                    while (factorialCounter <= n) {
                        permutations = permutations * factorialCounter;
                        factorialCounter++;
                    }
                    System.out.println("Total Possible Failure Senarious: " + permutations);
                    break;

                case "SUPPLY":
                    // NEW MODULE: ARRAYS
                    System.out.println("\n>> ACCESSING SUPPLY INVENTORY...");

                    // 1. Declare and Initialize Arrays (Parallel Arrays)
                    String[] supplyItems = {"Quantum Batteries", "Laser Emitters", "Nutrients Packs", "Medi-Gel", "Dark Matter Fuel"};
                    int[] supplyCounts = {15, 4, 120, 10, 2};

                    // 2. Display Full Inventory using a loop
                    System.out.println("--- CURRENT STOCK ---");
                    // We use supplyItems.length so we don't have to hardcode "5"
                    for (int i = 0; i < supplyItems.length; i++) {
                        System.out.println("Locker [" + i + "]" + supplyItems[i] + "(Qty: " + supplyCounts[i] + ")");
                    }

                    // 3. Access Specific Element by Index
                    System.out.println("\n>> QUICK RETRIEVAL SYSTEM");
                    System.out.print("Enter Locker Number (0-4) to inspect: ");
                    int index = input.nextInt();
                    input.nextLine();   //Fix Scanner Trap

                    if (index >= 0 && index < supplyItems.length) {
                        System.out.println("Retrieved: " + supplyItems[index]);
                        System.out.println("Quantity Available: " + supplyCounts[index]);
                    } else {
                        System.out.println("[ERROR]: INVALID LOCKER INDEX.");
                    }
                    break;

                default:
                    System.out.println("\n[ERROR]: UNKNOWN COMMAND. TRY AGAIN.");
                    break;
            }
        }   // End of While Loop

        input.close();
    }
}