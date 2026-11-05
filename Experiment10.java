// Experiment 10: Synchronization and inter-thread communication.
class HospitalNoticeBoard {
    private String notice;
    private boolean noticeAvailable = false;

    // The reader waits until the staff publishes a notice.
    synchronized void readNotice() {
        while (!noticeAvailable) {
            try {
                wait(); // Releases the monitor while waiting.
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Reader thread interrupted.");
                return;
            }
        }
        System.out.println("Notice received: " + notice);
        noticeAvailable = false;
    }

    // Synchronized publication prevents inconsistent shared access.
    synchronized void publishNotice(String newNotice) {
        notice = newNotice;
        noticeAvailable = true;
        System.out.println("Staff published a hospital notice.");
        notifyAll(); // Wake waiting reader threads.
    }
}

class HospitalCommunicationDemo {
    public static void main(String[] args) {
        HospitalNoticeBoard board = new HospitalNoticeBoard();

        Thread reader = new Thread(() -> board.readNotice(), "Notice Reader");
        Thread staff = new Thread(() -> {
            try {
                Thread.sleep(300); // Simulate preparing the notice.
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            board.publishNotice("Free health camp starts at 10 AM.");
        }, "Hospital Staff");

        reader.start();
        staff.start();

        try {
            reader.join();
            staff.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
