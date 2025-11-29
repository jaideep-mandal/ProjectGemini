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
        String userName = input.nextLine();         // Reads the whole line (e.g. "Jhon Doe")

        System.out.print("Enter Security PIN: ");
        int pin = input.nextInt();                      // Reads an integer
        
        // System Variables (Our "Database")
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

        // --- SECTION 2: SYSTEM DIAGNOSTIC (Based on Percentage Calculation)
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
        // Total possible score is 500 (100 * 5)
        float totalScore = energy + logic + memory + network + security;
        float healthPercentage = (totalScore / 500.0f) * 100;

        // Display Result
        System.out.println("\nDiagnostic Complete.");
        System.out.println("Overall System Health: " + healthPercentage + "%");

        // 5. Close the scanner (Good practice)
        input.close();
    }
}