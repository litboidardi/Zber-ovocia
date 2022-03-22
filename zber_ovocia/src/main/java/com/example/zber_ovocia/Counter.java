package com.example.zber_ovocia;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Counter extends Canvas {
  static int winScore = 0;
  static Text txt = new Text();
  static Group root;
  Scene scene;

    public Counter(Group root, Scene scene, int i) {
        Counter.root = root;
        this.scene = scene;
        txt.setText(Integer.toString(i));
        txt.setFont(Font.font("Comic Sans", FontWeight.EXTRA_BOLD, 150));
        txt.setFill(Color.web("#3b4dd4"));
        if(winScore<10) {
            txt.setLayoutX((scene.getWidth()/2)-60);
        } else {
            txt.setLayoutX((scene.getWidth()/2)-120);
        }
        txt.setLayoutY((scene.getHeight()/2)+30);
        root.getChildren().add(0,txt);
    }
    public static void removeText(){
        root.getChildren().remove(txt);
    }
}
