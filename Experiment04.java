// Experiment 4: Hierarchical and multilevel inheritance.
class Person {
    // Common data inherited by patients and hospital employees.
    protected String name;

    Person(String name) {
        this.name = name;
    }

    void showName() {
        System.out.println("Name: " + name);
    }
}

// Patient and Staff both directly inherit Person (hierarchical).
class Patient extends Person {
    private int patientId;

    Patient(int patientId, String name) {
        super(name); // Initialize the Person part of this object.
        this.patientId = patientId;
    }

    void displayPatient() {
        System.out.println("Patient ID: " + patientId);
        showName();
    }
}

class Staff extends Person {
    protected String shift;

    Staff(String name, String shift) {
        super(name);
        this.shift = shift;
    }

    void displayStaff() {
        System.out.println("Staff Name: " + name);
        System.out.println("Shift: " + shift);
    }
}

// Doctor extends Staff, which extends Person (multilevel inheritance).
class Doctor extends Staff {
    private String specialization;

    Doctor(String name, String shift, String specialization) {
        super(name, shift);
        this.specialization = specialization;
    }

    void displayDoctor() {
        displayStaff(); // Reuse the inherited staff information.
        System.out.println("Specialization: " + specialization);
    }
}

class HospitalInheritanceDemo {
    public static void main(String[] args) {
        Patient p = new Patient(104, "Anita");
        Staff s = new Staff("Kumar", "Morning");
        Doctor d = new Doctor("Dr. Priya", "Evening", "Cardiology");

        System.out.println("PATIENT DETAILS");
        p.displayPatient();
        System.out.println("\nSTAFF DETAILS");
        s.displayStaff();
        System.out.println("\nDOCTOR DETAILS");
        d.displayDoctor();
    }
}
