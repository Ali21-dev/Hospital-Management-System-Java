import hospital.PatientRecord;
import java.util.ArrayList;

public class HospitalPackageDemo {
    public static void main(String[] args) {
        PatientRecord patient =
            new PatientRecord(201, "Sita", "Cardiology");
        patient.display();

        // ArrayList belongs to the built-in java.util package.
        ArrayList<String> departments = new ArrayList<>();
        departments.add("Cardiology");
        departments.add("Neurology");
        departments.add("Orthopedics");

        System.out.println("Available Departments:");
        for (String department : departments) {
            System.out.println("- " + department);
        }
    }
}
