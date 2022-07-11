package com.example.javafx_for_dummies;

import javafx.application.Application; // core class on which all JavaFX applications depend.
import javafx.scene.Scene; // holds user interface elements
import javafx.scene.control.Button; // button
import javafx.scene.control.Label; // for label
import javafx.scene.layout.*; // layout manager determines the position of each control displayed in the gui
import javafx.stage.Stage; // Stage is the class of the top-level container; this is the highest level window.
import javafx.event.*; // provides the ActionEvent class and the EventHandler interface.

/* 4 ways to handle events in Java FX:
1: Implement the EventHandler interface -- HERE
2: Create an inner class that implements EventHandler
3: Create an anonymous class that implements EventHandler
4: Use a lambda expression to implement the handle method
 */

// This version will implement the EventHandler interface to the program's Application class
// and provide an implementation of the handle method; this is the first way to handle events.

public class AddSubtract1 extends Application implements EventHandler <ActionEvent> {

    public static void main(String[] args) {
        launch(args);
    }

    Button btnAdd;
    Button btnSubtract;
    Label lbl;
    int iCounter = 0;

    @Override public void start(Stage primaryStage) {

        // Create the Add button
        btnAdd = new Button();
        btnAdd.setText("Add");
        btnAdd.setOnAction(this);

        // Create the Subtract button
        btnSubtract = new Button();
        btnSubtract.setText("Subtract");
        btnSubtract.setOnAction(this);

        // Create the label
        lbl = new Label();
        lbl.setText(Integer.toString(iCounter));

        // Add the buttons and the label to an HBox pane
        HBox pane = new HBox(10);
        pane.getChildren().addAll(lbl, btnAdd, btnSubtract);

        // Add the layout pane to the scene
        Scene scene = new Scene(pane, 200, 75);

        // Add the scene to the stage, set the title, show the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Add/Sub");
        primaryStage.show();
    }

    @Override public void handle(ActionEvent e) { // must define this method as EventHandler interface is implemented.
        if(e.getSource() == btnAdd) {
            iCounter++;
        } else if (e.getSource() == btnSubtract) {
            iCounter--;
        }
        lbl.setText(Integer.toString(iCounter));
    }
}
