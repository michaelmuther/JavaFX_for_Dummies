package com.example.javafx_for_dummies;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class ClickMe extends Application{

    public static void main(String[] args) {
        System.out.println("Launching JavaFX");
        launch(args);
        System.out.println("Finished!");
    }

    Button btn;

    @Override public void start(Stage primaryStage) {
        // Create the button
        btn = new Button();
        btn.setText("Click me please!");
        btn.setOnAction(e-> buttonClick());

        // Add the button to a layout pane
        BorderPane pane = new BorderPane();
        pane.setCenter(btn);

        // Add the layout pane to a scene
        Scene scene = new Scene(pane,250,250);

        // Finalize and show the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("The Click Me App");
        primaryStage.show();
    }

    public void buttonClick() {
        if(btn.getText() == "Click me please!") {
            btn.setText("You clicked me!");
        } else {
            btn.setText("Click em please!");
        }
    }
}