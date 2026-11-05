// Experiment 13: Comparable for natural order and Comparator for custom order.
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Patient implements Comparable<Patient> {
    private int patientId;
    private String name;
    private int age;

    Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Comparable defines the natural ordering: ascending patient ID.
    @Override
    public int compareTo(Patient other) {
        return Integer.compare(this.patientId, other.patientId);
    }

    String getName() {
        return name;
    }

    @Override
    public String toString() {
        return patientId + " - " + name + " (Age " + age + ")";
    }
}

class HospitalSortingDemo {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient(303, "Zara", 29));
        patients.add(new Patient(301, "Meena", 41));
        patients.add(new Patient(302, "Asha", 35));

        // Collections.sort() uses Patient.compareTo().
        Collections.sort(patients);
        System.out.println("Sorted by patient ID:");
        for (Patient p : patients) {
            System.out.println(p);
        }

        // Comparator supplies a different sorting rule: name order.
        Comparator<Patient> byName = Comparator.comparing(Patient::getName);
        patients.sort(byName);
        System.out.println("Sorted by patient name:");
        for (Patient p : patients) {
            System.out.println(p);
        }
    }
}
