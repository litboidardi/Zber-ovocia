package com.example.zber_ovocia;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 800, Color.LIGHTBLUE);

        Kyblik kybel = new Kyblik(150,20,scene.getWidth()/3,scene.getHeight()-20, scene);
        root.getChildren().add(kybel);
        new Counter(root, scene,0);

        Timeline t = new Timeline(new KeyFrame(Duration.seconds(1), event -> vajicko(scene,root,kybel)));
        t.setCycleCount(60);
        t.play();

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public void vajicko(Scene scene, Group root, Kyblik kybel) {
        Vajicko vajicko = new Vajicko(30,40,(0+Math.random()*scene.getWidth()),0, root, scene, kybel);
        root.getChildren().add(vajicko);
    }

    public static void main(String[] args) {
        launch();
    }
}