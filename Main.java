import java.util.Scanner;   // Import the Scanner class
import java.util.Random;    // Import the Random class

public class Main {

    // --- GLOBAL CONSTANTS (Visual Theme) ---
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";

    // Global State Variable for Theme
    public static String currentTheme = RESET;

    public static void main(String[] args){
        bootSystem();
    }

    public static void bootSystem() {
        Scanner input = new Scanner(System.in);

        // --- SECTION 1: LOGIN (Refactored into Method) ---
        if (!performLogin(input)) {
            return; // Exit if login fails
        }

        // --- SECTION 2: SYSTEM DIAGNOSTIC (Runs Once) ---
        boolean isSecure = runDiagnostics(input);

        // --- SECTION 3: COMMAND LOOP ---
        while (true) {
            System.out.println(currentTheme);   // Apply Theme
            printMenu();                        // Show Options

            String commandRaw = input.nextLine();
            String command = commandRaw.toUpperCase();

            if (command.equals("EXIT")) {
                System.out.println(RESET + "SHUTTING DOWN SYSTEM... GOODBYE.");
            }

            // LOOK HOW CLEAN THIS SWITCH IS NOW!
            switch (command) {
                case "PHYSICS":     runPhysics(input);          break;
                case "ENCRYPT":     runEncryption(input);       break;
                case "UPLINK":      runUpink(input, isSecure);  break;
                case "SCAN":        runScanner(input);          break;
                case "SIMULATION":  runSimulation(input);       break;
                case "CALIBRATE":   runCalibration(input);      break;
                case "SYSCHECK":    runSysCheck(input);         break;
                case "SEARCH":      runSearch(input);           break;
                case "MATRIX":      runMatrix(input);           break;
                case "RISK":        runRisk(input);             break;
                case "SUPPLY":      runSupply(input);           break;
                case "ANALYZE":     runAnalysis(input);         break;
                case "MAP":         runMap(input);              break;
                case "INTEGRITY":   runIntegrity(input);        break;
                case "THEME":       runThemeParams(input);      break;
            
                default:
                    System.out.println("\n[ERROR]: UNKNOWN COMMAND. TRY AGAIN.");
                    break;
            }
        }
        input.close();
    }

// =================================================================
//                       MODULE METHODS
// =================================================================

public static boolean performLogin(Scanner input) {
    System.out.println("Starting Project: ProjectGemini");
    System.out.print("Enter User Name: ");
    String userName = input.nextLine();
    System.out.print("Enter Security PIN: ");
    int pin = input.nextInt();
    System.out.print("Fingerprint Verified? (true/false): ");
    boolean fingerprintVerified = input.nextBoolean();
    input.nextLine();   // Consume newline

    if ((pin == 1234) || fingerprintVerified) {
        System.out.println("\n--- ACCESS GRANTED ---");
        System.out.println("Welcome, " + userName + "!");
        return true;
    } else {
        System.out.println(RED + "\n[ERROR]: AUTHENTICATION FAILED." + RESET);
        return false;
    }
}

public static boolean runDiagnostics(Scanner input) {
    System.out.println("\n--- INITIATING SYSTEM DIAGNOSTIC ---");
    // Simplified for brevity in this refactor, but logic remains
    System.out.println("System Health: 100%");
    return true;    //Assume secure for now
}

public static void printMenu() {
    System.out.println("\n==========================================");
    System.out.println("AVAILABLE MODULES:");
    System.out.println("1.  [PHYSICS]   2.  [ENCRYPT]       3.  [UPLINK]");
    System.out.println("4.  [SCAN]      5.  [SIMULATION]    6.  [CALIBRATE]");
    System.out.println("7.  [SYSCHECK]  8.  [SEARCH]        9.  [MATRIX]");
    System.out.println("10. [RISK]      11. [SUPPLY]        12. [ANALYZE]");
    System.out.println("13. [MAP]       14. [INTEGRITY]     15. [THEME]");
    System.out.println("16. [EXIT]");            
    System.out.println("\n==========================================");
    System.out.println("ENTER COMMAND MODULE NAME: ");
}

public static void runPhysics(Scanner input) {
    System.out.println("\n>> ACCESSING PHYSICS ENGINE...");
    System.out.print("Enter Mass (kg): ");
    double mass = input.nextDouble();
    System.out.print("Enter Velocity (m/s): ");
    double velocity = input.nextDouble();
    input.nextLine();

    double kineticEnergy = 0.5 * mass * (velocity * velocity);
    System.out.printf("Kinetic Energy: %.2f Joules\n" kineticEnergy);
}

public static void runEncryption(Scanner input) {
    System.out.println("\n>> ACCESSING ENCRYPTION CHANNEL...");
    System.out.println("Encryption Key: A -> I");
}

public static void runUpink(Scanner input, boolean isSecure) {
    if (!isSecure) {
        System.out.println("\n[ERROR]: UPLINK DENIED." + currentTheme);
    } else {
        System.out.println("\n>> ACCESSING TRANSMISSION UPLINK...");
        System.out.print("Enter Messege: ");
        String msg = input.nextLine();
        System.out.println("Sending: "  + msg.replace("danger", "[REDACTED]"));
    }
}

public static void runScanner (Scanner input) {
    System.out.println("\n>> NETWORK SECURITY SCANNER...");
                    System.out.print("Enter URL: ");
                    String url = input.nextLine();
                    if (url.startsWith("https")) {
                        System.out.println(GREEN + "SECURE" + currentTheme);
                    } else {
                        System.out.println(RED + "UNSECURE" + currentTheme);
                    }
}

public static void runSimulation(Scanner input) {
    System.out.println("\n>> COMBAT SIMULATION...");
                    System.out.println("0: Rock, 1: Paper, 2: Scissors");
                    int user = input.nextInt();
                    input.nextLine();
                    int ai = new Random().nextInt(3);
                    System.out.println("AI chose: " + ai);

                    if (user == ai) System.out.println("DRAW");
                    else if ((user == 0 && ai == 2) || (user == 1 && ai == 0)  || (user == 2 && ai == 1))
                        System.out.println("VICTORY");
                    else System.out.println("DEFEAT");
}

public static void runCalibration(Scanner input) {
    System.out.println("\n>> SYSTEM CALIBRATION...");
                    Random randCal = new Random();
                    String retry;
                    do {                      
                        System.out.println("Calibrating... Drift: " + new Random().nextInt(100) + "%");
                        System.out.print("Retry? (y/n): ");
                        retry = input.nextLine();
                    } while (retry.equalsIgnoreCase("y"));
}

              
                    
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
                            System.out.print("[" + i + "," + j + "]");
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
                    System.out.println("\n>> ACCESSING SUPPLY INVENTORY...");
                    String[] supplyItems = {"Quantum Batteries", "Laser Emitters", "Nutrients Packs", "Medi-Gel", "Dark Matter Fuel"};
                    int[] supplyCounts = {15, 4, 120, 10, 2};
                    for (int i = 0; i < supplyItems.length; i++) {
                        System.out.println("Locker [" + i + "]" + supplyItems[i] + "(Qty: " + supplyCounts[i] + ")");
                    }
                    System.out.println("\n>> QUICK RETRIEVAL SYSTEM");
                    System.out.print("Enter Locker Number (0-4) to inspect: ");
                    int index = input.nextInt();
                    input.nextLine();
                    if (index >= 0 && index < supplyItems.length) {
                        System.out.println("Retrieved: " + supplyItems[index]);
                        System.out.println("Quantity Available: " + supplyCounts[index]);
                    } else {
                        System.out.println("[ERROR]: INVALID LOCKER INDEX.");
                    }
                    break;

                case "ANALYZE":
                    System.out.println("\n>> INCOMING DATA STREAM DETECTED...");
                    double[] signalValues = {10.5, 45.2, 98.1, 12.0, 67.5, 33.3};
                    double sum = 0;
                    double maxSignal = 0;
                    for (double signal : signalValues) {
                        System.out.println("Reading Signal: " + signal + " Hz");
                        sum += signal;
                        if (signal > maxSignal) maxSignal = signal;
                        try { Thread.sleep(150); } catch (InterruptedException e) { }
                    }
                    double average = sum / signalValues.length;
                    System.out.println("\n>> SIGNAL ANALYSIS REPORT <<");
                    System.out.printf("Average Frequency: %.2f Hz\n", average);
                    System.out.println("Peak Signal Detected: " + maxSignal + " Hz");
                    break;

                case "MAP":
                    System.out.println("\n>> LOADING SECTOR MAP (3x3)...");
                    char[][] sectorMap = new char[3][3];
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            sectorMap[i][j] = '.';
                        }
                    }
                    int playerRow = 0;
                    int playerCol = 0;
                    sectorMap[playerRow][playerCol] = 'P';
                    sectorMap[1][2] = '*';
                    while (true) {
                        System.out.println("\n--- SECTOR GRID ---");
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                System.out.println(sectorMap[i][j] + " ");
                            }
                            System.out.println();
                        }
                        System.out.println("Current Coords: [" + playerRow + "," + playerCol + "]");
                        System.out.println("Enter new Row (0-2) or 9 to Exit Map: ");
                        int newRow = input.nextInt();
                        if (newRow == 9) break;
                        System.out.println("Enter new Col(0-2): ");
                        int newCol = input.nextInt();
                        input.nextLine();
                        if (newRow >= 0 && newRow < 3 && newCol >= 0 && newCol < 3) {
                            sectorMap[playerRow][playerCol] = '.';  // Clear old spot
                            playerRow = newRow;
                            playerCol = newCol;
                            if (sectorMap[playerRow][playerCol] == '*') {
                                System.out.println("[ALLERT]: ANOMALY DISCOVERED!");
                            }
                            sectorMap[playerRow][playerCol] = 'P';  // set new spot
                        } else {
                            System.out.println("[ERROR]: COORDINATES OUT OF RANGE. WARP FAILED");
                        }
                    }
                    break;

                case "INTEGRITY":
                    System.out.println("\n>> ACCESSING BLACK BOX DATA RECORDER...");
                    int[] dataLog = {50, 42, 999, 12, 5, 2};
                    System.out.print("Raw Data Log (Corrupted): ");
                    for (int val : dataLog) System.out.println(val + " ");
                    System.out.println();
                    int len = dataLog.length;
                    int halfLen = Math.floorDiv(len, 2);
                    for (int i = 0; i < halfLen; i++) {
                        int temp = dataLog[i];
                        dataLog[i] = dataLog[len - 1 - i];
                        dataLog[len - 1 - i] = temp;
                    }
                    System.out.println("Restored Log (Reversed): ");
                    for (int val : dataLog) System.out.println(val + " ");
                    System.out.println();
                    int maxSpike = 0;
                    for (int val : dataLog) {
                        if (val > maxSpike) maxSpike = val;
                    }
                    System.out.println(RED + "Highest Energy Spike Detected: " + maxSpike + " MW" + currentTheme);
                    boolean isSorted = true;
                    for (int i = 0; i < dataLog.length; i++) {
                        if (dataLog[i] > dataLog[i+1]) {    // If current is greater than next, it's NOT sorted
                            isSorted = false;
                            break;
                        }
                    }
                    if (isSorted) System.out.println("timeline Integrity: VERIFIED (Chronological Order");
                    else System.out.println("timeline Integrity: ERROR (Timestamps out of sync)");
                    break;

                case "THEME":
                    // NEW MODULE: UI CUSTOMIZATION
                    // Applies the concept of "Customization" from the video to the Console
                    System.out.println("\n>> INTERFACE VISUAL CUSTOMIZATION...");
                    System.out.println("Select Holographic Theme:");
                    System.out.println("1. CYBER (Default/White)" + currentTheme);
                    System.out.println("2. MATRIX (Green)" + currentTheme);
                    System.out.println("3. ALERT (Red)" + currentTheme);
                    System.out.println("4. VOID (Cyan)" + currentTheme);
                    System.out.println("5. SOLAR (Yellow)" + currentTheme);

                    int themeChoice = input.nextInt();
                    input.nextLine();

                    switch (themeChoice) {
                        case 1: currentTheme = RESET; break;
                        case 2: currentTheme = GREEN; break;
                        case 3: currentTheme = RED; break;
                        case 4: currentTheme = CYAN; break;
                        case 5: currentTheme = YELLOW; break;
                        default: System.out.println("Invalid selection. Keeping current theme");
                    }
                    System.out.println(currentTheme + "Theme Updated. System Rebooting Interface...");
                    break;

                default:
                    
                    break;
            }
        }   // End of While Loop

        
    }
}

