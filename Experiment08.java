// Experiment 8: Built-in and user-defined exception handling.
class InvalidPatientAgeException extends Exception {
    InvalidPatientAgeException(String message) {
        super(message);
    }
}

class HospitalExceptionDemo {
    // A custom exception prevents invalid ages from entering a record.
    static void validateAge(int age) throws InvalidPatientAgeException {
        if (age <= 0 || age > 120) {
            throw new InvalidPatientAgeException(
                "Age must be between 1 and 120."
            );
        }
        System.out.println("Patient age accepted: " + age);
    }

    static int calculateAverageBill(int total, int patients) {
        // A zero patient count would cause ArithmeticException.
        return total / patients;
    }

    public static void main(String[] args) {
        // First demonstrate a valid age and a built-in exception.
        try {
            validateAge(45);
            System.out.println("Average bill: Rs. " +
                calculateAverageBill(5000, 0));
        } catch (InvalidPatientAgeException e) {
            System.out.println("Validation error: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Billing error: patient count cannot be zero.");
        } finally {
            System.out.println("First validation operation completed.");
        }

        // Demonstrate the user-defined exception with invalid input.
        try {
            validateAge(150);
        } catch (InvalidPatientAgeException e) {
            System.out.println("Validation error: " + e.getMessage());
        }
    }
}
