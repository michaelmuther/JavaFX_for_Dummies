package com.example.javafx_for_dummies;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/* 4 ways to handle events in Java FX:
1: Implement the EventHandler interface
2: Create an inner class that implements EventHandler
3: Create an anonymous class that implements EventHandler
4: Use a lambda expression to implement the handle method -- HERE
 */

public class AddSubtract4 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Button btnAdd;
    Button btnSubtract;
    Label lbl;
    int iCounter = 0;

    @Override public void start (Stage primaryStage) {

        // Create the Add button
        btnAdd = new Button();
        btnAdd.setText("Add");
        btnAdd.setOnAction( e -> {
            iCounter++;
            lbl.setText(Integer.toString(iCounter));
        });

        // The EventHandler interface has just one abstract method: handle().  Therefore, it is a functional interface
        // and can be used with Lambda expressions.  You don't need to know the name of the method as the functional
        // interface has only one method.  You also do not need to know the name of the interface!  This is because
        // the interface is determined by the context.  The setOnAction() method takes a single parameter of type
        // EventHandler.
        // With an anonymous class set to an event handler, you must know and specify the name of the class
        // (EventHandler) and the name of the method to be called (handle).  Anonymous classes only don't need the name
        // of the variable that will reference the class.  With a lambda expression, you don't have to know the or
        // specify the name of the class, the method, or a variable used to reference it.  All you have to do is provide
        // the body of the handle() method.

        // Create the Subtract button
        btnSubtract = new Button();
        btnSubtract.setText("Subtract");
        btnSubtract.setOnAction(e -> {
            iCounter--;
            lbl.setText(Integer.toString(iCounter));
        });

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
}