// Experiment 2: Static/non-static members, access modifiers,
// abstraction, and encapsulation.
abstract class HospitalUnit {
    // A static field is shared by all objects of this class.
    static String hospitalName = "City Care Hospital";

    // Every concrete hospital unit must define this operation.
    abstract void showDepartment();

    static void showHospitalName() {
        System.out.println("Hospital: " + hospitalName);
    }
}

class PatientRecord extends HospitalUnit {
    // private fields protect the data from direct outside access.
    private int patientId;
    private String patientName;
    private static int recordCount = 0;

    PatientRecord(int id, String name) {
        patientId = id;
        patientName = name;
        recordCount++; // Shared count increases for each new record.
    }

    // Public getters provide controlled access to private fields.
    public int getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    @Override
    void showDepartment() {
        System.out.println("Department: General Medicine");
    }

    static void showRecordCount() {
        System.out.println("Total records created: " + recordCount);
    }

    public static void main(String[] args) {
        // Static methods can be called using the class name.
        HospitalUnit.showHospitalName();
        PatientRecord p1 = new PatientRecord(102, "Meena");
        PatientRecord p2 = new PatientRecord(103, "Ravi");

        // Non-static methods work on a particular object.
        System.out.println("Patient ID: " + p1.getPatientId());
        System.out.println("Patient Name: " + p1.getPatientName());
        p1.showDepartment();
        PatientRecord.showRecordCount();
    }
}
