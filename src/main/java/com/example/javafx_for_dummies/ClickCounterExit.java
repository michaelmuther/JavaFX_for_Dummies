package com.example.javafx_for_dummies;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ClickCounterExit extends Application{

    public static void main(String[] args) {
        launch(args); // creates instance of ClickCounter class and calls the start() method.
    }

    Stage stage;
    int iClickCount = 0;

    @Override public void start(Stage primaryStage) {

        stage = primaryStage;

        // Create ClickMe button
        Button btnClickMe = new Button();
        btnClickMe.setText("Click me please!");
        btnClickMe.setOnAction(e-> btnClickMe_Click());

        // Create Close button
        Button btnClose = new Button();
        btnClose.setText("Close");
        btnClose.setOnAction(e-> btnClose_Click());

        // Add the buttons to a layout pane
        VBox pane = new VBox();
        pane.getChildren().addAll(btnClickMe, btnClose);
        pane.setAlignment(Pos.CENTER);

        // Add the layout pane to a scene
        Scene scene = new Scene(pane, 250, 150);

        // Add the scene to the stage, set the title and show the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Click Counter!"); // just sets the title
        primaryStage.setOnCloseRequest( e -> {
            e.consume();
            btnClose_Click();
        });
        primaryStage.show();
    }

    public void btnClickMe_Click() {
        iClickCount++;
        if (iClickCount == 1) {
            MessageBox.show("You have clicked once.", "Click!");
        } else {
            MessageBox.show("You have clicked " + iClickCount + " times.", "Click!");
        }
    }

    public void btnClose_Click() {
        boolean confirm = false;
        confirm = ConfirmationBox.show("Are you sure you want to quit?", "Confirmation",
                "Yes", "No");
        if (confirm) {
            // Place any code needed to save files or close resources here.
            stage.close();
        }
    }
}