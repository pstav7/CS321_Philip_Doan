package org.openjfx;

import edu.gmu.cs321.WorkflowIntegration; // Ensure to import WorkflowIntegration
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WorkFlowScreen extends Application {
    private WorkflowIntegration workFlowIntegration = new WorkflowIntegration();

    @Override
    public void start(Stage stage) {
        // Immigrant Details section
        Label immigrantLabel = new Label("Immigrant Details");
        immigrantLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-padding: 10px;");

        // Immigrant fields
        TextField immigrantANumberField = new TextField();
        immigrantANumberField.setPromptText("Immigrant A-Number");
        TextField immigrantNameField = new TextField();
        immigrantNameField.setPromptText("Immigrant Name");
        TextField dobField = new TextField();
        dobField.setPromptText("Date of Birth (MM/DD/YYYY)");

        // Relative Details section
        Label relativeLabel = new Label("Relative Details");
        relativeLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-padding: 10px;");

        // Relative fields
        TextField relativeANumberField = new TextField();
        relativeANumberField.setPromptText("Relative A-Number");

        // Feedback Label
        Label feedbackLabel = new Label();
        feedbackLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        // Buttons
        Button submitButton = new Button("Submit Form");
        submitButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10px;");
        submitButton.setOnAction(e -> {
            String immigrantANumber = immigrantANumberField.getText();
            String relativeANumber = relativeANumberField.getText();

            // Validate the input fields
            if (immigrantANumber.isEmpty() || relativeANumber.isEmpty() || !dobField.getText().matches("\\d{2}/\\d{2}/\\d{4}")) {
                feedbackLabel.setText("Please provide valid details.");
                feedbackLabel.setStyle("-fx-text-fill: red;");
                return;
            }

            // Save data to SharedData for later use
            SharedData.getInstance().setImmigrantANumber(immigrantANumber);
            SharedData.getInstance().setRelativeANumber(relativeANumber);

            // Simulate form submission logic
            try {
                workFlowIntegration.submitForm(immigrantANumber, relativeANumber, immigrantNameField.getText());
                feedbackLabel.setText("Form submitted successfully.");
                feedbackLabel.setStyle("-fx-text-fill: green;");
            } catch (Exception ex) {
                feedbackLabel.setText("Error submitting form: " + ex.getMessage());
                feedbackLabel.setStyle("-fx-text-fill: red;");
            }
        });

        Button clearButton = new Button("Clear");
        clearButton.setStyle("-fx-background-color: #FF5722; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10px;");
        clearButton.setOnAction(e -> {
            immigrantANumberField.clear();
            immigrantNameField.clear();
            dobField.clear();
            relativeANumberField.clear();
            feedbackLabel.setText("");
        });

        // Layout for immigrant details
        GridPane immigrantDetailsGrid = new GridPane();
        immigrantDetailsGrid.setVgap(10);
        immigrantDetailsGrid.setHgap(10);
        immigrantDetailsGrid.add(new Label("Immigrant A-Number:"), 0, 0);
        immigrantDetailsGrid.add(immigrantANumberField, 1, 0);
        immigrantDetailsGrid.add(new Label("Immigrant Name:"), 0, 1);
        immigrantDetailsGrid.add(immigrantNameField, 1, 1);
        immigrantDetailsGrid.add(new Label("Date of Birth:"), 0, 2);
        immigrantDetailsGrid.add(dobField, 1, 2);

        // Layout for relative details
        GridPane relativeDetailsGrid = new GridPane();
        relativeDetailsGrid.setVgap(10);
        relativeDetailsGrid.setHgap(10);
        relativeDetailsGrid.add(new Label("Relative A-Number:"), 0, 0);
        relativeDetailsGrid.add(relativeANumberField, 1, 0);

        // Buttons layout
        HBox buttonsBox = new HBox(15, submitButton, clearButton);
        buttonsBox.setStyle("-fx-padding: 10px; -fx-alignment: center;");

        // Main layout
        VBox layout = new VBox(20, immigrantLabel, immigrantDetailsGrid, relativeLabel, relativeDetailsGrid, buttonsBox, feedbackLabel);
        layout.setStyle("-fx-padding: 20px; -fx-alignment: center; -fx-background-color: #f0f0f0;");

        Scene scene = new Scene(layout, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Workflow Manager");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args); // Launch JavaFX application
    }
}
