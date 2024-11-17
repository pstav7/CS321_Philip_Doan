package org.openjfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application { // Corrected class declaration

    @Override
    public void start(Stage stage) {
        try {
            if (DatabaseConnector.getConnection() != null) {
                Label label = new Label();
                StackPane root = new StackPane(label);
                Scene scene = new Scene(root, 640, 480);
                stage.setScene(scene);
                stage.setTitle("Database Connection");
                stage.show();
            } else {
                throw new RuntimeException("Database connection failed!");
            }
        } catch (Exception e) {
            // Show error in an alert dialog
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Database Error");
            alert.setHeaderText("Database Connection Failed");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args); // Correctly call launch() here
    }
}
