// Experiment 12: Generic collections using List, Set, Map, and Queue.
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class HospitalCollectionsDemo {
    public static void main(String[] args) {
        // List preserves insertion order and permits duplicates.
        List<String> patientNames = new ArrayList<>();
        patientNames.add("Asha");
        patientNames.add("Ravi");
        patientNames.add("Asha");

        // Set stores unique department names only.
        Set<String> departments = new LinkedHashSet<>();
        departments.add("Cardiology");
        departments.add("Neurology");
        departments.add("Cardiology"); // Duplicate is ignored.

        // Map associates each patient ID with a patient name.
        Map<Integer, String> patientRecords = new LinkedHashMap<>();
        patientRecords.put(301, "Asha");
        patientRecords.put(302, "Ravi");
        patientRecords.put(303, "Meena");

        // Queue represents patients waiting for consultation (FIFO).
        Queue<String> waitingQueue = new LinkedList<>();
        waitingQueue.offer("Asha");
        waitingQueue.offer("Ravi");
        waitingQueue.offer("Meena");

        System.out.println("Patient List: " + patientNames);
        System.out.println("Departments: " + departments);
        System.out.println("Patient Records: " + patientRecords);
        System.out.println("Next patient: " + waitingQueue.peek());
        System.out.println("Served patient: " + waitingQueue.poll());
        System.out.println("Waiting after service: " + waitingQueue);
    }
}
