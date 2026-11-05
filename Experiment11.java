// Experiment 11: Thread lifecycle and deadlock prevention.
class SharedHospitalRecords {
    // All tasks acquire these locks in the same order to prevent deadlock.
    private final Object patientLock = new Object();
    private final Object billingLock = new Object();

    void updateRecord(String workerName) {
        synchronized (patientLock) {
            System.out.println(workerName + " locked patient record.");
            synchronized (billingLock) {
                System.out.println(workerName + " updated billing record.");
            }
        }
    }
}

class RecordWorker extends Thread {
    private SharedHospitalRecords records;

    RecordWorker(String name, SharedHospitalRecords records) {
        super(name);
        this.records = records;
    }

    @Override
    public void run() {
        records.updateRecord(getName());
    }
}

class HospitalThreadLifecycleDemo {
    public static void main(String[] args) throws InterruptedException {
        SharedHospitalRecords records = new SharedHospitalRecords();
        RecordWorker reception = new RecordWorker("Reception", records);
        RecordWorker billing = new RecordWorker("Billing Desk", records);

        System.out.println("Reception state before start: " + reception.getState());
        reception.start();
        billing.start();

        // join() makes main wait until both workers terminate.
        reception.join();
        billing.join();

        System.out.println("Reception state after completion: " + reception.getState());
        System.out.println("Deadlock prevention: locks are always acquired in a fixed order.");
    }
}
