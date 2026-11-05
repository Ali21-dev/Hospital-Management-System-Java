// Experiment 5: Compile-time polymorphism (overloading) and
// runtime polymorphism (overriding).
class HospitalBilling {
    // Same method name with one parameter.
    double calculateBill(double consultationFee) {
        return consultationFee;
    }

    // Overloaded method with two parameters.
    double calculateBill(double consultationFee, double medicineFee) {
        return consultationFee + medicineFee;
    }

    // Another overload includes a room charge.
    double calculateBill(double consultationFee, double medicineFee,
                         double roomCharge) {
        return consultationFee + medicineFee + roomCharge;
    }
}

class HospitalStaff {
    void performDuty() {
        System.out.println("Hospital staff performs assigned duties.");
    }
}

class Doctor extends HospitalStaff {
    @Override
    void performDuty() {
        System.out.println("Doctor examines patients and prescribes treatment.");
    }
}

class Nurse extends HospitalStaff {
    @Override
    void performDuty() {
        System.out.println("Nurse monitors patients and provides care.");
    }
}

class HospitalPolymorphismDemo {
    public static void main(String[] args) {
        HospitalBilling bill = new HospitalBilling();
        System.out.println("Consultation bill: Rs. " + bill.calculateBill(500));
        System.out.println("Consultation + medicine: Rs. " + bill.calculateBill(500, 250));
        System.out.println("Full bill: Rs. " + bill.calculateBill(500, 250, 1000));

        // The actual object decides which overridden method runs.
        HospitalStaff staff = new Doctor();
        staff.performDuty();
        staff = new Nurse();
        staff.performDuty();
    }
}
