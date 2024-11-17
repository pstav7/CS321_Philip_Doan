package org.openjfx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DataEntryLoginScreen extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginButton = new Button("Login");

        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if ("dataentry".equals(username) && "password1".equals(password)) {
                primaryStage.close(); // Close login screen
                Platform.runLater(() -> {
                    WorkFlowScreen workFlowScreen = new WorkFlowScreen();
                    workFlowScreen.start(new Stage()); // Open Data Entry Screen
                });
            } else {
                showAlert("Invalid Login", "Incorrect username or password.");
            }
        });

        VBox layout = new VBox(10, usernameField, passwordField, loginButton);
        layout.setStyle("-fx-padding: 20;");
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Data Entry Login");
        primaryStage.show();
    }

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
