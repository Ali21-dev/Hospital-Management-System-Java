// Experiment 7: User-defined package and built-in java.util package.
// Save this first class in hospital/PatientRecord.java.
package hospital;

public class PatientRecord {
    private int patientId;
    private String patientName;
    private String department;

    public PatientRecord(int id, String name, String department) {
        patientId = id;
        patientName = name;
        this.department = department;
    }

    // Public method makes the record accessible outside the package.
    public void display() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Patient Name: " + patientName);
        System.out.println("Department: " + department);
    }
}
