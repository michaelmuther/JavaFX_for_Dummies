package com.example.javafx_for_dummies;

import javafx.application.Application; // core class on which all JavaFX applications depend.
import javafx.scene.Scene;
import javafx.scene.control.Button; // button
import javafx.scene.control.Label; // for label
import javafx.scene.layout.HBox;
import javafx.stage.Stage; // Stage is the class of the top-level container; this is the highest level window.
import javafx.event.*; // provides the ActionEvent class and the EventHandler interface.

/* 4 ways to handle events in Java FX:
1: Implement the EventHandler interface
2: Create an inner class that implements EventHandler -- HERE
3: Create an anonymous class that implements EventHandler
4: Use a lambda expression to implement the handle method
 */

public class AddSubtract2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Button btnAdd;
    Button btnSubtract;
    Label lbl;
    int iCounter = 0;

    @Override public void start (Stage primaryStage) {

        // Create a ClickHandler instance
        ClickHandler ch = new ClickHandler();

        // Create the Add button
        btnAdd = new Button();
        btnAdd.setText("Add");
        btnAdd.setOnAction(ch);

        // Create the Subtract button
        btnSubtract = new Button();
        btnSubtract.setText("Subtract");
        btnSubtract.setOnAction(ch);

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

    // ClickHandler is declared as an inner class by placing its declaratin completely within the AddSubtract2 class.
    // ClickHandler implements the EventHandler interface
    private class ClickHandler implements EventHandler <ActionEvent> {

        @Override public void handle(ActionEvent e) {
            if(e.getSource() == btnAdd) {
                iCounter++;
            } else if (e.getSource() == btnSubtract) {
                iCounter--;
            }
            lbl.setText(Integer.toString(iCounter));
        }
    }
}
