// Experiment 9: Create threads using Thread and Runnable.
class EmergencyRoomTask extends Thread {
    EmergencyRoomTask(String name) {
        super(name); // Set a meaningful thread name.
    }

    @Override
    public void run() {
        System.out.println(getName() + ": preparing emergency room.");
        System.out.println(getName() + ": equipment check completed.");
    }
}

class AppointmentTask implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()
            + ": updating appointment list.");
        System.out.println(Thread.currentThread().getName()
            + ": confirmation messages prepared.");
    }
}

class HospitalMultithreadingDemo {
    public static void main(String[] args) {
        // One thread is created by extending Thread.
        EmergencyRoomTask emergency = new EmergencyRoomTask("Emergency Team");

        // Another thread is created by passing a Runnable object.
        Thread appointments = new Thread(new AppointmentTask(), "Appointment Desk");

        System.out.println("Starting hospital service tasks...");
        emergency.start();
        appointments.start();

        try {
            // Wait until both tasks finish before ending main().
            emergency.join();
            appointments.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread was interrupted.");
        }
        System.out.println("All hospital tasks completed.");
    }
}
