// Experiment 6: Abstract classes, interfaces, and dynamic dispatch.
interface Billable {
    // Every billable hospital service must return its charge.
    double calculateCharge();
}

abstract class HospitalService {
    protected String serviceName;

    HospitalService(String name) {
        serviceName = name;
    }

    // Abstract method implemented by specific services.
    abstract void showServiceDetails();
}

class Consultation extends HospitalService implements Billable {
    private String doctorName;
    private double consultationFee;

    Consultation(String doctorName, double fee) {
        super("Doctor Consultation");
        this.doctorName = doctorName;
        consultationFee = fee;
    }

    @Override
    void showServiceDetails() {
        System.out.println("Service: " + serviceName);
        System.out.println("Doctor: " + doctorName);
    }

    @Override
    public double calculateCharge() {
        return consultationFee;
    }
}

class LaboratoryTest extends HospitalService implements Billable {
    private String testName;
    private double testFee;

    LaboratoryTest(String testName, double fee) {
        super("Laboratory Test");
        this.testName = testName;
        testFee = fee;
    }

    @Override
    void showServiceDetails() {
        System.out.println("Service: " + serviceName);
        System.out.println("Test: " + testName);
    }

    @Override
    public double calculateCharge() {
        return testFee;
    }
}

class HospitalServiceDemo {
    public static void main(String[] args) {
        // Parent references demonstrate dynamic method dispatch.
        HospitalService[] services = {
            new Consultation("Dr. Rao", 600.0),
            new LaboratoryTest("Blood Test", 350.0)
        };

        for (HospitalService service : services) {
            service.showServiceDetails();
            Billable bill = (Billable) service;
            System.out.println("Charge: Rs. " + bill.calculateCharge());
            System.out.println();
        }
    }
}
