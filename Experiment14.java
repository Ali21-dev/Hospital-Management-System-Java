// Experiment 14: File processing with streams, readers, writers,
// and buffered streams.
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class HospitalFileProcessingDemo {
    public static void main(String[] args) {
        String fileName = "patient.txt";
        String backupName = "patient_backup.txt";

        // Write human-readable patient data using a buffered character writer.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Patient ID: 401");
            writer.newLine();
            writer.write("Patient Name: Kiran");
            writer.newLine();
            writer.write("Department: Orthopedics");
            writer.newLine();
            writer.write("Appointment: 10:30 AM");
        } catch (IOException e) {
            System.out.println("Unable to write patient file: " + e.getMessage());
            return;
        }

        // Read the text file line by line with a buffered character reader.
        System.out.println("--- Saved Patient File ---");
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Unable to read patient file: " + e.getMessage());
            return;
        }

        // Make a byte-for-byte backup using buffered byte streams.
        try (BufferedInputStream input =
                 new BufferedInputStream(new FileInputStream(fileName));
             BufferedOutputStream output =
                 new BufferedOutputStream(new FileOutputStream(backupName))) {
            int data;
            while ((data = input.read()) != -1) {
                output.write(data);
            }
            System.out.println("Backup created: " + backupName);
        } catch (IOException e) {
            System.out.println("Unable to create backup: " + e.getMessage());
        }
    }
}
