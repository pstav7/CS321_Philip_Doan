package org.openjfx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ApproverUI {

    public void openApproverScreen(String immigrantANumber, String relativeANumber) {
        System.out.println("Approver Screen opened for:");
        System.out.println("Immigrant A-Number: " + immigrantANumber);
        System.out.println("Relative A-Number: " + relativeANumber);

        Platform.runLater(() -> {
            Stage approverStage = new Stage();
            Label approverLabel = new Label("Approver Dashboard");
            approverLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

            Label immigrantLabel = new Label("Immigrant A-Number: " + immigrantANumber);
            Label relativeLabel = new Label("Relative A-Number: " + relativeANumber);

            Label statusLabel = new Label("No form selected");
            statusLabel.setStyle("-fx-font-size: 14px;");

            Button approveButton = new Button("Approve");
            approveButton.setStyle("-fx-background-color: green;");
            approveButton.setOnAction(e -> {
                statusLabel.setText("Form approved.");
                System.out.println("Form approved for Immigrant A-Number: " + immigrantANumber);
                updateDatabase(immigrantANumber, relativeANumber, "approved");
            });

            Button rejectButton = new Button("Reject");
            rejectButton.setStyle("-fx-background-color: red;");
            rejectButton.setOnAction(e -> {
                statusLabel.setText("Form rejected.");
                System.out.println("Form rejected for Immigrant A-Number: " + immigrantANumber);
                updateDatabase(immigrantANumber, relativeANumber, "rejected");
            });

            VBox layout = new VBox(15, approverLabel, immigrantLabel, relativeLabel, approveButton, rejectButton, statusLabel);
            layout.setStyle("-fx-padding: 20px; -fx-alignment: center;");

            Scene scene = new Scene(layout, 400, 300);
            approverStage.setScene(scene);
            approverStage.setTitle("Approver UI");
            approverStage.show();
        });
    }

    // Method to update the database based on approval or rejection
    private void updateDatabase(String immigrantANumber, String relativeANumber, String status) {
        // Database connection details (update with your actual database credentials)
        String url = "jdbc:sqlserver://localhost:1433;databaseName=cs321;encrypt=true;trustServerCertificate=true;";
        String user = "SA";
        String password = "MyStrongPass123";
    
        // Corrected SQL query to update the form status in the correct table
        String sql = "UPDATE workflow_items SET status = ? WHERE immigrant_a_number = ? AND relative_a_number = ?";
    
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = connection.prepareStatement(sql)) {
    
            stmt.setString(1, status);
            stmt.setString(2, immigrantANumber);
            stmt.setString(3, relativeANumber);
            int rowsUpdated = stmt.executeUpdate();
    
            if (rowsUpdated > 0) {
                System.out.println("Form status updated to " + status + " for Immigrant A-Number: " + immigrantANumber);
            } else {
                System.out.println("No form found with the provided A-numbers.");
            }
        } catch (SQLException e) {
            System.err.println("Error updating the database: " + e.getMessage());
            showAlert("Database Error", "Error updating the database: " + e.getMessage());
        }
    }
    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
