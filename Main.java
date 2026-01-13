import java.util.Scanner;
import java.util.Random;

public class Main {

    public static final String RESET    = "\u001B[0m";
    public static final String RED      = "\u001B[31m";
    public static final String GREEN    = "\u001B[32m";
    public static final String BLUE     = "\u001B[34m";
    public static final String YELLOW   = "\u001B[33m";
    public static final String PURPLE   = "\u001B[35m";
    public static final String CYAN     = "\u001B[36m";

    public static String currentTheme = RESET;

    public static void main(String[] args){
        bootSystem();
    }

    public static void bootSystem() {
        Scanner input = new Scanner(System.in);

        User activeUser = new User();
        activeUser.name = "Commander";
        activeUser.pin = 1234;
        activeUser.hasFingerprint = true;
        activeUser.clearanceLevel = 5;

        if (!performLogin(input, activeUser)) {
            return;
        }

        activeUser.printUserInfo();
        boolean isSecure = runDiagnostics(input);

        while (true) {
            System.out.println(currentTheme);
            printMenu();

            String commandRaw = input.nextLine();
            String command = commandRaw.toUpperCase();

            if (command.equals("EXIT")) {
                System.out.println(RESET + "SHUTTING DOWN SYSTEM... GOODBYE.");
                break;
            }

            switch (command) {
                case "PHYSICS":     runPhysics(input);                      break;
                case "ENCRYPT":     runEncryption(input);                   break;
                case "UPLINK":      runUpink(input, isSecure, activeUser);  break;
                case "SCAN":        runScanner(input);                      break;
                case "SIMULATION":  runSimulation(input);                   break;
                case "CALIBRATE":   runCalibration(input);                  break;
                case "SYSCHECK":    runSysCheck();                          break;
                case "SEARCH":      runSearch(input);                       break;
                case "MATRIX":      runMatrix(input);                       break;
                case "RISK":        runRisk(input);                         break;
                case "SUPPLY":      runSupply(input);                       break;
                case "ANALYZE":     runAnalysis(input);                     break;
                case "MAP":         runMap(input);                          break;
                case "INTEGRITY":   runIntegrity();                         break;
                case "THEME":       runThemeParams(input);                  break;
                case "TARGET":      runTargeting(input);                    break;
                case "REACTOR":     runReactor(input);                      break;
                case "ENVIRONMENT": runEnvironment(input);                  break;
                case "COMPONENT":   runComponentSystems();                  break;
                case "DROID":       runDroidSquad(input);                   break;
                case "ROBOT":       runRobotController(input);              break;  // NEW MODULE
                default:
                    System.out.println("\n[ERROR]: UNKNOWN COMMAND. TRY AGAIN.");
                    break;
            }
        }
        input.close();
    }

    // --- NEW: ROBOT CONTROL (ENCAPSULATION DEMO) ---
    public static void runRobotController(Scanner input) {
        System.out.println("\n>> ROBOT CONTROL INTERFACE...");

        // Create Object
        Robot bot = new Robot();

        // 1. Set Data using SETTER (Safe)
        bot.setId("XJ-9");
        bot.setBattery(100);
        bot.setMode("Idle");    // Valid mode

        // 2. Read Data using GETTER
        System.out.println("Connected to: " + bot.getId());
        System.out.println("Current Mode: " + bot.getMode());

        // 3. Try to break it (Validation Test)
        System.out.println("\n[TEST]: Attempting to set Invalid Mode...");
        bot.setMode("DanceParty");  // Should trigger error

        System.out.println("\n[TEST]: Attempting to set Invalid Battery...");
        bot.setBattery(5000);   // Should trigger error

        System.out.println("\n[STATUS]: " + bot.getId() + " remains in " + bot.getMode() + " mode.");
    }
    // ------------------------------------------------

    public static void runDroidSquad(Scanner input) {
        System.out.println("\n>> DROID SQUAD MANAGEMENT...");
        Droid[] squad = new Droid[3];
        squad[0] = new Droid(); squad[0].name = "R2-Unit";      squad[0].activate();
        squad[1] = new Droid(); squad[1].name = "BB-Unit";      squad[0].activate();
        squad[2] = new Droid(); squad[2].name = "C3-Protocol";  squad[0].activate();

        while(true) {
            System.out.println("\n--- SQUAD STATUS ---");
            for(Droid d : squad) d.displayStatus();
            System.out.println("\nActions: 1.Assign Task 2.Recharge All 3.Exit");
            int choice = input.nextInt();
            input.nextLine();
            if (choice == 1) {
                System.out.print("Select Droid ID (0-2): ");
                int id = input.nextInt();
                input.nextLine();
                if (id >= 0 && id < 3) {
                    System.out.print("Enter Task: ");
                    String task = input.nextLine();
                    squad[id].performTask(task);
                }
            } else if (choice == 2) {
                for(Droid d : squad) d.recharge();
            } else {
                break;
            }
        }
    }

    public static void runComponentSystems() {
        System.out.println("\n>> SHIP COMPONENT MANAGEMENT SYSTEM...");
        Engine mainEngine = new Engine();
        mainEngine.name = "HyperDrive X1";
        mainEngine.status = true;
        mainEngine.powerOutput = 100;

        Weapon laserCannon = new Weapon();
        laserCannon.name = "Turbo Laser";
        laserCannon.status = true;
        laserCannon.damageType = "Thermal";

        System.out.println("[STATUS CHECK]");
        mainEngine.checkStatus();
        laserCannon.checkStatus();

        System.out.println("[SYSTEM TEST]");
        mainEngine.boost();
        laserCannon.fire();
    }

    public static boolean performLogin(Scanner input, User authorizedUser) {
        System.out.println("Starting Project: ProjectGemini");
        System.out.print("Enter User Name: ");
        String inputName = input.nextLine();
        if (!inputName.equalsIgnoreCase(authorizedUser.name)) {
            System.out.println(RED + "\n[ERROR]: USER NOT FOUND." + RESET);
            return false;
        }
        System.out.print("Enter Security PIN: ");
        int inputPin = input.nextInt();
        System.out.print("Fingerprint Verified? (true/false): ");
        boolean inputFingerprint = input.nextBoolean();
        input.nextLine();
        if ((inputPin == 1234) || (inputFingerprint && authorizedUser.hasFingerprint)) {
            System.out.println("\n--- ACCESS GRANTED ---");
            System.out.println("Welcome, " + authorizedUser.name + "!");
            return true;
        } else {
            System.out.println(RED + "\n[ERROR]: AUTHENTICATION FAILED." + RESET);
            return false;
        }
    }

    public static boolean runDiagnostics(Scanner input) {
        System.out.println("\n--- INITIATING SYSTEM DIAGNOSTIC ---");
        System.out.println("System Health: 100%");
        return true;
    }

    public static void printMenu() {
        System.out.println("\n==========================================");
        System.out.println("AVAILABLE MODULES:");
        System.out.println("1.  [PHYSICS]   2.  [ENCRYPT]       3.  [UPLINK]");
        System.out.println("4.  [SCAN]      5.  [SIMULATION]    6.  [CALIBRATE]");
        System.out.println("7.  [SYSCHECK]  8.  [SEARCH]        9.  [MATRIX]");
        System.out.println("10. [RISK]      11. [SUPPLY]        12. [ANALYZE]");
        System.out.println("13. [MAP]       14. [INTEGRITY]     15. [THEME]");
        System.out.println("16. [TARGET]    17. [REACTOR]       18. [ENVIRONMENT]");            
        System.out.println("19. [COMPONENT] 20. [DROID]         21. [EXIT]");
        System.out.println("\n==========================================");
        System.out.println("ENTER COMMAND MODULE NAME: ");
    }

    public static void runEnvironment(Scanner input) {
        System.out.println("\n>> ENVIRONMENT CONTROL...");
        System.out.println("1. Temperature Regulation");
        System.out.println("2. Holographic Pattern Test");
        int choice = input.nextInt();
        input.nextLine();
        if (choice == 1) {
            System.out.print("Enter Ambient Temp (Celsius): ");
            double c = input.nextDouble();
            input.nextLine();
            double f = celsiusToFahrenheit(c);
            System.out.printf("Converted Temp: %.1f°F\n", f);
            if (f > 100) System.out.println(RED + "[WARNING]: HEAT HAZARD" + currentTheme);
            else System.out.println(GREEN + "Temp Nominal" + currentTheme);
        } else if (choice == 2) {
            System.out.println("Enter Pattern Size (Rows): ");
            int rows = input.nextInt();
            input.nextLine();
            printHoloPattern(rows);
        }
    }

    public static double celsiusToFahrenheit(double c) { return (c * 9/5) + 32; }

    public static void printHoloPattern(int rows) {
        System.out.println("Generating Holo-Emitter Pattern:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) System.out.print("* ");
            System.out.println();
        }
    }

    public static void runReactor(Scanner input) {
        System.out.println("\n>> REACTOR CONTROL SUBSYSTEM...");
        System.out.println("1. Calculate Chain Reaction Yeild (Factorial)");
        System.out.println("2. Generate Sheild Harmonics (Fabonacci)");
        int choice = input.nextInt();
        input.nextLine();
        if (choice == 1) {
            System.out.print("Enter Reaction Depth (1-20): ");
            int depth = input.nextInt();
            input.nextLine();
            long energy = calculateReaction(depth);
            System.out.println("Theoretical Energy Output: " + energy + " Gigajoules");
        } else if (choice == 2) {
            System.out.print("Enter Harmonic Layer Count (1-15): ");
            int layers = input.nextInt();
            input.nextLine();
            System.out.print("Harmonic Sequence: ");
            for (int i = 0; i < layers; i++) System.out.print(calculateShieldHarmonics(i) + " ");
            System.out.println("\nShield Modulation Complete.");
        }
    }

    public static long calculateReaction(int n) {
        if (n == 0 || n == 1) return 1;
        return n * calculateReaction(n - 1);
    }

    public static int calculateShieldHarmonics(int n) {
        if (n <= 1) return n;
        return calculateShieldHarmonics(n - 1) + calculateShieldHarmonics(n - 2);
    }

    public static void runTargeting(Scanner input) {
        System.out.println("\n>> DEFENSE SYSTEMS ONLINE...");
        System.out.println("Simulating Multi-Target Engagements:");
        System.out.println("\n[SCENARIO 1: Lone Asteroid]");
        fireSalvo("Plasma Bolt", 120);
        System.out.println("\n[SCENARIO 2: Twin Debris]");
        fireSalvo("Railgun", 45, 90);
        System.out.println("\n[SCENARIO 3: Asteroid Field]");
        fireSalvo("Photon Torpedo", 10, 20, 30, 40, 50);
    }

    public static void fireSalvo(String weapon, int... coordinates) {
        System.out.println("Weapon System: " + weapon);
        System.out.println("Target Lock Count: " + coordinates.length);
        for (int sector : coordinates) {
            System.out.println(" -> Firing at Sector " + sector + " [HIT]");
            try { Thread.sleep(200); } catch(Exception e){}
        }
        System.out.println("Salvo Complete.");
    }

    public static void runPhysics(Scanner input) {
        System.out.println("\n>> ACCESSING PHYSICS ENGINE...");
        System.out.print("Enter Mass (kg): ");
        double mass = input.nextDouble();
        System.out.print("Enter Velocity (m/s): ");
        double velocity = input.nextDouble();
        input.nextLine();
        double kineticEnergy = 0.5 * mass * (velocity * velocity);
        System.out.printf("Kinetic Energy: %.2f Joules\n", kineticEnergy);
    }

    public static void runEncryption(Scanner input) {
        System.out.println("\n>> ACCESSING ADAPTIVE ENCRYPTION SUITE...");
        System.out.println("Enter Data to Encrypt: ");
        String data = input.nextLine();
        System.out.println("Select Security Level: 1. Standard 2. Custom 3. Quantum");
        int choice = input.nextInt();
        input.nextLine();
        String result = "";
        if (choice == 1) result = encrypt(data);
        else if (choice == 2) {
            System.out.print("Enter Shift Key (Int): ");
            int key = input.nextInt();
            input.nextLine();
            result = encrypt(data, key);
        } else if (choice == 3) result = encrypt(data, true);
        System.out.println(GREEN + "Encrypted Output: " + result + currentTheme);
    }

    public static String encrypt(String msg) {
        char[] chars = msg.toCharArray();
        for (int i = 0; i < chars.length; i++) chars[i] = (char) (chars[i] + 1);
        return new String(chars);
    }

    public static String encrypt(String msg, int key) {
        char[] chars = msg.toCharArray();
        for (int i = 0; i < chars.length; i++) chars[i] = (char) (chars[i] + key);
        return new String(chars);
    }

    public static String encrypt(String msg, boolean isQuantum) {
        if (!isQuantum) return msg;
        char[] chars = msg.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[n - i - 1];
            chars[n - i - 1] = temp;
        }
        for (int i = 0; i < chars.length; i++) chars[i] = (char) (chars[i] + 5);
        return "[Q-SECURE]: " + new String(chars);
    }

    public static void runUpink(Scanner input, boolean isSecure, User user) {
        if (!isSecure) {
            System.out.println(RED + "\n[ERROR]: UPLINK DENIED." + currentTheme);
        } else {
            System.out.println("\n>> ACCESSING TRANSMISSION UPLINK...");
            System.out.print("Enter Messege: ");
            String msg = input.nextLine();
            System.out.println("TRANSMISSION AUTHOR: " + user.name + " (Level " + user.clearanceLevel + ")");
            System.out.println("Sending: " + msg.replace("danger", "[REDACTED]"));
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
            System.out.println("VICTORY" + currentTheme);
        else System.out.println("DEFEAT" + currentTheme);
    }

    public static void runCalibration(Scanner input) {
        System.out.println("\n>> SYSTEM CALIBRATION...");
        String retry;
        do {                      
            System.out.println("Calibrating... Drift: " + new Random().nextInt(100) + "%");
            System.out.print("Retry? (y/n): ");
            retry = input.nextLine();
        } while (retry.equalsIgnoreCase("y"));
    }

    public static void runSysCheck() {
        System.out.println("\n>> POWER CYCLE...");
        for (int i = 1; i <= 3; i++) {
            System.out.println("Sector " + i + " OK");
            try { Thread.sleep(200); } catch(Exception e) {}
        }
    }

    public static void runSearch(Scanner input) {
        System.out.println("\n>> DEEP SEARCH...");
        System.out.print("Target ID: ");
        int target = input.nextInt();
        for (int i = 1; i < 10; i++) {
            if (i == target) {
                System.out.println(GREEN + "FOUND ID " + i + currentTheme);
                break;
            }
            System.out.println("Scanning " + i + "...");
        }
    }

    public static void runMatrix(Scanner input) {
        System.out.println("\n>> QUANTUM MATRIX...");
        System.out.print("Size: ");
        int size = input.nextInt();
        input.nextLine();
        for (int i = 0; i < size; i++) {    
            for (int j = 0; j <= i; j++) System.out.print("[" + i + "," + j + "]");
            System.out.println();
        }
    }

    public static void runRisk(Scanner input) {
        System.out.println("\n>>  RISK ENGINE...");
        System.out.print("Complexity: ");
        int n = input.nextInt();
        input.nextLine();
        long f = 1;
        for (int i = 1; i <= n; i++) f *= i;  
        System.out.println("Permutations: " + f);
    }

    public static void runSupply(Scanner input) {
        System.out.println("\n>> SUPPLY INVENTORY...");
        String[] items = {"Fuel", "Ammo", "Rations"};
        int[] qtys = {100, 500, 20};
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i] + ": " + qtys[i]);
        }
    }

    public static void runAnalysis(Scanner input) {
        System.out.println("\n>> SIGNAL ANALYSIS...");
        double[] sigs = {10.5, 99.9, 42.0};
        double max = 0;
        for (double s : sigs) if (s > max) max = s;
        System.out.println("Peak Signal: " + max);
    }

    public static void runMap(Scanner input) {
        System.out.println("\n>> SECTOR MAP...");
        char[][] map = new char[3][3];
        for (int i = 0; i < 3; i++) for (int j = 0; j < 3; j++) map[i][j] = '.';
        int r = 0, c = 0; map[r][c] = 'P';
        while (true) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) System.out.print(map[i][j] + " ");
                System.out.println();
            }
            System.out.println("Move Row (0-2) or 9 to exit: ");
            int nr = input.nextInt();
            if (nr == 9) break;
            System.out.println("Move Col(0-2): ");
            int nc = input.nextInt();
            input.nextLine();
                            
            if (nr >= 0 && nr < 3 && nc >= 0 && nc < 3) {
                map[r][c] = '.'; r = nr; c = nc; map[r][c] = 'P';
            }
        }
    }

    public static void runIntegrity() {
        System.out.println("\n>> DATA INTEGRITY...");
        int[] data = {5, 4, 3, 2, 1};
        System.out.print("Fixed Data: ");
        for (int i = data.length; i >= 0; i--) System.out.print(data[i] + " ");
        System.out.println();
    }

    public static void runThemeParams(Scanner input) {
        System.out.println("\n>> THEME SELECTOR...");
        System.out.println("1. RESET 2. GREEN 3. RED 4. CYAN");
        int choice = input.nextInt();
        input.nextLine();
        switch (choice) {
            case 2:     currentTheme = GREEN;   break;
            case 3:     currentTheme = RED;     break;
            case 4:     currentTheme = CYAN;    break;
            default:    currentTheme = RESET;   break;
        }
        System.out.println(currentTheme + "Theme Applied.");
    }
}