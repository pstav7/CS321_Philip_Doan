package org.openjfx;

import edu.gmu.cs321.WorkflowIntegration;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WorkFlowScreen extends Application {
    private WorkflowIntegration workFlowIntegration = new WorkflowIntegration();

    @Override
    public void start(Stage stage) {
        // Create UI components
        TextField formIdField = new TextField();
        formIdField.setPromptText("Form ID");

        // ComboBox for selecting the next step in the workflow
        ComboBox<String> nextStepDropdown = new ComboBox<>();
        nextStepDropdown.getItems().addAll("Review", "Approve", "Reject");
        nextStepDropdown.setPromptText("Select Next Step");

        Button submitButton = new Button("Submit Form");
        submitButton.setOnAction(e -> {
            String formId = formIdField.getText();
            String nextStep = nextStepDropdown.getValue(); // Get selected next step

            // Validate formId and nextStep inputs
            if (formId.isEmpty() || !formId.matches("\\d+")) {
                System.err.println("Invalid Form ID. Please enter a valid number.");
                return;
            }
            if (nextStep == null) {
                System.err.println("Please select a valid next step.");
                return;
            }

            try {
                workFlowIntegration.submitForm(formId, nextStep);
                System.out.println("Form submitted successfully.");
            } catch (Exception ex) {
                System.err.println("Error submitting form: " + ex.getMessage());
                ex.printStackTrace();
            }
        });

        Button fetchButton = new Button("Fetch Next Form");
        fetchButton.setOnAction(e -> {
            try {
                String nextFormId = workFlowIntegration.reviewNextForm();
                if (nextFormId != null) {
                    formIdField.setText(nextFormId);
                    System.out.println("Next form to process: " + nextFormId);

                    // Update the status of the form to 'Reviewing' when fetched
                    workFlowIntegration.updateFormStatus(nextFormId, "Reviewing");

                } else {
                    System.out.println("No forms to process.");
                }
            } catch (Exception ex) {
                System.err.println("Error fetching next form: " + ex.getMessage());
                ex.printStackTrace();
            }
        });

        // Layout adjustments
        VBox layout = new VBox(10, formIdField, nextStepDropdown, submitButton, fetchButton);
        layout.setStyle("-fx-background-color: #f0f0f0; -fx-padding: 20px;");
        layout.setPrefWidth(300);
        layout.setPrefHeight(200);

        // Set scene and stage
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.setTitle("Workflow Manager");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args); // Launch JavaFX application
    }
}
