package org.openjfx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ApproverUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Placeholder for any startup logic for the Approver UI (if needed)
    }

    // This method will open the approver dashboard screen
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
            approveButton.setOnAction(e -> statusLabel.setText("Form approved."));

            Button rejectButton = new Button("Reject");
            rejectButton.setStyle("-fx-background-color: red;");
            rejectButton.setOnAction(e -> statusLabel.setText("Form rejected."));

            VBox layout = new VBox(15, approverLabel, immigrantLabel, relativeLabel, approveButton, rejectButton, statusLabel);
            layout.setStyle("-fx-padding: 20px; -fx-alignment: center;");

            Scene scene = new Scene(layout, 400, 300);
            approverStage.setScene(scene);
            approverStage.setTitle("Approver UI");
            approverStage.show();
        });
    }

    public static void main(String[] args) {
        launch(args);  // Launch the JavaFX application
    }
}
