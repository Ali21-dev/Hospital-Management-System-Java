// Experiment 3: Console input with Scanner and output with System.
import java.util.Scanner;

class PatientRegistration {
    public static void main(String[] args) {
        // Scanner reads values entered by the user at the keyboard.
        Scanner sc = new Scanner(System.in);

        System.out.println("HOSPITAL PATIENT REGISTRATION");
        System.out.print("Enter patient ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume the newline left by nextInt().

        System.out.print("Enter patient name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter illness: ");
        String illness = sc.nextLine();

        // System.out.println() prints the entered information.
        System.out.println("\n--- Patient Details ---");
        System.out.println("Patient ID : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Illness    : " + illness);

        sc.close(); // Release the Scanner resource.
    }
}
