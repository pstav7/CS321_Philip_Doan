package org.openjfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginScreen extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Login Fields
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginButton = new Button("Login");

        // Handle login button action
        loginButton.setOnAction(e -> handleLogin(usernameField.getText(), passwordField.getText(), primaryStage));

        // Layout
        VBox layout = new VBox(10, usernameField, passwordField, loginButton);
        layout.setStyle("-fx-padding: 20;");

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Handle Login logic
    private void handleLogin(String username, String password, Stage primaryStage) {
        if ("dataentry".equals(username) && "password1".equals(password)) {
            System.out.println("Data Entry User Logged In");
            primaryStage.close(); // Close login screen

            // Open Data Entry UI
            WorkFlowScreen workflowScreen = new WorkFlowScreen();
            Stage dataEntryStage = new Stage();
            workflowScreen.start(dataEntryStage); // Launch the Data Entry screen
        } else if ("approver".equals(username) && "password2".equals(password)) {
            System.out.println("Approver User Logged In");
            primaryStage.close(); // Close login screen

            // Open Approver UI
            ApproverUI approverUI = new ApproverUI();
            Stage approverStage = new Stage();
            approverUI.start(approverStage); // Launch the Approver screen
        } else {
            showAlert("Invalid Login", "Incorrect username or password.");
        }
    }

    // Show alert for invalid login
    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
