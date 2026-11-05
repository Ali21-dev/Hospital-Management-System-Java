// Experiment 15: Serialization and deserialization of a patient object.
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// Serializable marks objects of this class as eligible for persistence.
class Patient implements Serializable {
    private static final long serialVersionUID = 1L;

    private int patientId;
    private String name;
    private String illness;
    private int daysAdmitted;
    private double billAmount;

    Patient(int id, String name, String illness, int days, double bill) {
        patientId = id;
        this.name = name;
        this.illness = illness;
        daysAdmitted = days;
        billAmount = bill;
    }

    void displayDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Patient Name: " + name);
        System.out.println("Illness: " + illness);
        System.out.println("Days Admitted: " + daysAdmitted);
        System.out.println("Bill Amount: Rs. " + billAmount);
    }
}

class HospitalSerializationDemo {
    public static void main(String[] args) {
        String fileName = "patient.dat";
        Patient original = new Patient(501, "Divya", "Migraine", 2, 1800.0);

        // Serialization converts the object state into a file representation.
        try (ObjectOutputStream output = new ObjectOutputStream(
                 new FileOutputStream(fileName))) {
            output.writeObject(original);
            System.out.println("Patient object saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving patient: " + e.getMessage());
            return;
        }

        // Deserialization reconstructs the object from the saved file.
        try (ObjectInputStream input = new ObjectInputStream(
                 new FileInputStream(fileName))) {
            Patient restored = (Patient) input.readObject();
            System.out.println("\nRestored Patient Details");
            restored.displayDetails();
        } catch (IOException e) {
            System.out.println("Error reading patient file: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Patient class could not be found: " + e.getMessage());
        }
    }
}
