package edu.gmu.cs321;

import java.util.HashMap;
import java.util.Map;

public class WorkflowIntegration {

    // Simulated storage for forms (in place of a database)
    private Map<String, Map<String, String>> formStorage;

    public WorkflowIntegration() {
        formStorage = new HashMap<>();
    }

    /**
     * Submits a form with the given details.
     *
     * @param immigrantANumber The immigrant's A-Number (String for flexibility).
     * @param relativeANumber  The relative's A-Number.
     * @param relativeName     The relative's name.
     * @throws IllegalArgumentException If any input is invalid.
     */
    public void submitForm(String immigrantANumber, String relativeANumber, String relativeName) {
        validateInput(immigrantANumber, "Immigrant A-Number");
        validateInput(relativeANumber, "Relative A-Number");
        validateInput(relativeName, "Relative Name");

        if (formStorage.containsKey(immigrantANumber)) {
            throw new IllegalArgumentException("Form with this Immigrant A-Number already exists.");
        }

        // Save form details in storage
        Map<String, String> formDetails = new HashMap<>();
        formDetails.put("Relative A-Number", relativeANumber);
        formDetails.put("Relative Name", relativeName);
        formStorage.put(immigrantANumber, formDetails);

        System.out.println("Form submitted successfully.");
        System.out.println("Immigrant A-Number: " + immigrantANumber);
        System.out.println("Relative A-Number: " + relativeANumber);
        System.out.println("Relative Name: " + relativeName);
    }

    /**
     * Fetches the next form in the storage (for demonstration, retrieves any form).
     *
     * @return Details of the next form to be processed.
     */
    public String fetchNextForm() {
        if (formStorage.isEmpty()) {
            return "No forms available for processing.";
        }

        // Fetch the first entry in the form storage
        Map.Entry<String, Map<String, String>> entry = formStorage.entrySet().iterator().next();
        String immigrantANumber = entry.getKey();
        Map<String, String> formDetails = entry.getValue();

        return "Immigrant A-Number: " + immigrantANumber + "\n"
                + "Relative A-Number: " + formDetails.get("Relative A-Number") + "\n"
                + "Relative Name: " + formDetails.get("Relative Name");
    }

    /**
     * Updates the status of a form (e.g., approving or rejecting).
     *
     * @param immigrantANumber The immigrant's A-Number.
     * @param status           The new status of the form.
     * @throws IllegalArgumentException If the form does not exist.
     */
    public void updateFormStatus(String immigrantANumber, String status) {
        if (!formStorage.containsKey(immigrantANumber)) {
            throw new IllegalArgumentException("No form found with this Immigrant A-Number.");
        }

        // Update status logic (e.g., logging for now)
        System.out.println("Status of Immigrant A-Number " + immigrantANumber + " updated to: " + status);
    }

    /**
     * Validates input to ensure it is not null or empty.
     *
     * @param input The input to validate.
     * @param fieldName The name of the field for error messages.
     * @throws IllegalArgumentException If the input is invalid.
     */
    private void validateInput(String input, String fieldName) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be empty.");
        }
    }
}
