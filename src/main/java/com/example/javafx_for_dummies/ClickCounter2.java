package com.example.javafx_for_dummies;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ClickCounter2 extends Application{

    public static void main(String[] args) {
        launch(args); // creates instance of ClickCounter class and calls the start() method.
    }

    Button btn;
    int iClickCount = 0;

    @Override public void start(Stage primaryStage) {
        // Create the button
        btn = new Button();
        btn.setText("Click me please!");
        btn.setOnAction(e-> buttonClick());

        // Add the label and the button to a layout pane
        BorderPane pane = new BorderPane();
        pane.setCenter(btn);

        // Add the layout pane to a scene
        Scene scene = new Scene(pane, 250, 150);


        // Add the scene to the stage, set the title and show the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Click Counter!"); // just sets the title
        primaryStage.show();
    }

    public void buttonClick() {
        iClickCount++;
        if (iClickCount == 1) {
            MessageBox.show("You have clicked once.", "Click!");
        } else {
            MessageBox.show("You have clicked " + iClickCount + " times.", "Click!");
        }
    }
}
