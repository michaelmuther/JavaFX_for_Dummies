package com.example.javafx_for_dummies;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ClickCounter extends Application{

    public static void main(String[] args) {
        launch(args); // creates instance of ClickCounter class and calls the start() method.
    }

    Button btn;
    Label lbl;
    int iClickCount = 0;

    @Override public void start(Stage primaryStage) {
        // Create the button
        btn = new Button();
        btn.setText("Click me please!");
        btn.setOnAction(e-> buttonClick());

        // Create the Label
        lbl = new Label();
        lbl.setText("You have not clicked the button!");

        // First, the node elements are created.
        // Then, node elements are placed in the BorderPane.
        // Then, a scene with the size is created with the BorderPane passed in.
        //Then, the scene is passed to the Stage (the Stage is passed into the start method by the Application's
        // launch() method).  Then, the Stage class's show() method is called to open the window.


        // Add the label and the button to a layout pane
        BorderPane pane = new BorderPane();
        pane.setTop(lbl);
        pane.setCenter(btn);

        // Add the layout pane to a scene
        Scene scene = new Scene(pane, 250, 250);


        // Add the scene to the stage, set the title and show the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Click Counter!"); // just sets the title
        primaryStage.show();
    }

    public void buttonClick() {
        iClickCount++;
        if (iClickCount == 1) {
            lbl.setText("You have clicked once.");
        } else {
            lbl.setText("You have clicked " + iClickCount + " times.");
        }
    }
}
