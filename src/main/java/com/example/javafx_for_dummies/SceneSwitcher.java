package com.example.javafx_for_dummies;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SceneSwitcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    // class fields for Click-Counter scene
    int iClickCount = 0;
    Label lblClicks;
    Button btnClickMe;
    Button btnSwitchToScene2;
    Scene scene1;

    // class fields for Add-Subtract scene
    int iCounter = 0;
    Label lblCounter;
    Button btnAdd;
    Button btnSubtract;
    Button btnSwitchToScene1;
    Scene scene2;

    // class field for Stage
    Stage stage;

    @Override public void start (Stage primaryStage) {

        stage = primaryStage;

        // Build the click-counter scene **************************

        lblClicks = new Label();
        lblClicks.setText("You have not clicked the button.");

        btnClickMe = new Button();
        btnClickMe.setText("Click me please!");
        btnClickMe.setOnAction(e -> btnClickMe_Click());

        btnSwitchToScene2 = new Button();
        btnSwitchToScene2.setText("Switch!");
        btnSwitchToScene2.setOnAction(e -> btnSwitchToScene2_Click());

        // Add the buttons and the label to an HBox pane
        VBox pane1 = new VBox(10);
        pane1.getChildren().addAll(lblClicks, btnClickMe, btnSwitchToScene2);

        // Add the layout pane to the scene
        scene1 = new Scene(pane1, 250, 150);

        // End click-counter scene *******************************

        // Build the add-subtract scene **************************

        lblCounter = new Label();
        lblCounter.setText(Integer.toString(iCounter));

        btnAdd = new Button();
        btnAdd.setText("Add");
        btnAdd.setOnAction(e -> btnAdd_Click());

        btnSubtract = new Button();
        btnSubtract.setText("Subtract");
        btnSubtract.setOnAction(e -> btnSubtract_Click());

        btnSwitchToScene1 = new Button();
        btnSwitchToScene1.setText("Switch");
        btnSwitchToScene1.setOnAction(e -> btnSwitchToScene1_Click());

        HBox pane2 = new HBox(10);
        pane2.getChildren().addAll(lblCounter, btnAdd, btnSubtract, btnSwitchToScene1);

        scene2 = new Scene(pane2, 300, 75);

        // End add-subtract scene ********************************

        // Set the stage with scene 1 and show the stage
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Scene Switcher");
        primaryStage.show();

    }

    // Event Handlers for Scene 1
    private void btnClickMe_Click() {
        iClickCount++;
        if (iClickCount == 1) {
            lblClicks.setText("You have clicked once.");
        } else {
            lblClicks.setText("You have clicked " + iClickCount + " times.");
        }
    }

    private void btnSwitchToScene2_Click() {
        stage.setScene(scene2);
    }

    // Even Handlers for Scene 2

    private void btnAdd_Click() {
        iCounter++;
        lblCounter.setText(Integer.toString(iCounter));
    }

    private void btnSubtract_Click() {
        iCounter--;
        lblCounter.setText(Integer.toString(iCounter));
    }

    private void btnSwitchToScene1_Click() {
        stage.setScene(scene1);
    }

}
