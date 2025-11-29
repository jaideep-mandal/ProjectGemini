import java.util.Scanner;   // Import the Scanner class

public class Main {
    public static void main(String[] args){
        bootSystem();
    }

    public static void bootSystem() {
        // 1. Setup Input Scanner
        Scanner input = new Scanner(System.in);

        System.out.println("Starting Project: ProjectGemini");

        // 2. Ask for User Input (The Login Simulator)
        System.out.print("Enter User Name: ");
        String userName = input.nextLine();         // Reads the whole line (e.g. "Jhon Doe")

        System.out.print("Enter Security PIN: ");
        int pin = input.nextInt();                      // Reads an integer
        
        // 3. System Variables (Our "Database")
        long systemChipId = 987654321000L;
        float cpuTemperature = 45.5f;
        boolean isSystemActive = true;

        // 4. Output Personalized Report
        System.out.println("\n--- ACCESS GRANTED ---");
        System.out.println("Welcome, " + userName + "!");
        System.out.println("Security PIN Verified: " + pin);
        System.out.println("Chip ID: " + systemChipId);                     // Prints the Long
        System.out.println("CPU Temp: " + cpuTemperature + "C");               // Prints the Char
        System.out .println("Active: " + isSystemActive);

        // 5. Close the scanner (Good practice)
        input.close();
    }
}