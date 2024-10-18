package edu.gmu.cs321;

public class ImmigrantValidation {
    private boolean validated;

    // Constructor
    public ImmigrantValidation(boolean validated) {
        this.validated = validated;
    }

    // Method to validate a new immigrant
    public boolean validateNewImm() {
        // Validation logic for a new immigrant
        return validated;
    }

    // Method to check if forms exist
    public boolean validateFormsExist() {
        // Logic to check if forms are present
        return validated;
    }

    // Getter and setter
    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }
}
