// Experiment 1: Classes, objects, constructors, and methods
class Patient {
    // Instance variables store details for one patient object.
    int patientId;
    String name;
    int age;
    String illness;

    // Parameterized constructor initializes the new patient.
    Patient(int id, String patientName, int patientAge, String patientIllness) {
        patientId = id;
        name = patientName;
        age = patientAge;
        illness = patientIllness;
    }

    // A method displays the details stored in this object.
    void displayDetails() {
        System.out.println("Patient ID   : " + patientId);
        System.out.println("Patient Name : " + name);
        System.out.println("Age          : " + age);
        System.out.println("Illness      : " + illness);
    }

    public static void main(String[] args) {
        // Create an object; the constructor runs automatically.
        Patient patient1 = new Patient(101, "Arun", 35, "Fever");

        System.out.println("HOSPITAL MANAGEMENT SYSTEM");
        System.out.println("--------------------------");
        patient1.displayDetails();
    }
}
