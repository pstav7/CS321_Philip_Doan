package org.openjfx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class MainLauncher extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Open both the Data Entry and Approver login screens side by side
        Platform.runLater(() -> {
            DataEntryLoginScreen dataEntryLogScreen = new DataEntryLoginScreen();
            dataEntryLogScreen.start(new Stage()); // Launch Data Entry Login screen in a new stage
        });

        Platform.runLater(() -> {
            ApproverLogScreen approverLogScreen = new ApproverLogScreen();
            approverLogScreen.start(new Stage()); // Launch Approver Login screen in a new stage
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
