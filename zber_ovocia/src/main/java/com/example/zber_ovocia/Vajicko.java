package com.example.zber_ovocia;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Vajicko extends Canvas {
    GraphicsContext gc;
    int w, h, hscene;
    Group root;
    Scene scene;
    Kyblik kybel;


    public Vajicko(int w,int h, double x, double y, Group root, Scene scene, Kyblik kybel) {
       super(w,h);
       this.w=w;this.h=h;
        this.scene=scene;this.root=root; this.kybel=kybel;
       hscene = (int) scene.getHeight();
       gc = getGraphicsContext2D();
       setLayoutX(x);
       setLayoutY(y);
       int cisla = (int) ((Math.random()*16)+15);
       Timeline t = new Timeline(new KeyFrame(Duration.millis(cisla), event -> pohyb()));
       t.setCycleCount(Animation.INDEFINITE);
       t.play();
       vykresli();
    }

    private void pohyb() {
    setLayoutY(getLayoutY()+5);
    //detekcia kolízie
    if(getLayoutY()+(kybel.h*2) == (kybel.getLayoutY()) &&
            (getLayoutX() >= kybel.getLayoutX())
            && (getLayoutX() <= kybel.getLayoutX() + (kybel.w-2))) {
        root.getChildren().remove(this);
        //counter pri kolízii
        Counter.winScore++;
        int i = Counter.winScore;
        Counter.removeText();
        new Counter(root,scene,i);
    } if(getLayoutY()>scene.getHeight()-20) {
        root.getChildren().remove(this);
        }
    }

    public void vykresli(){
        gc.setFill(Color.BLACK);
        gc.fillOval(0,0,w,h);
        gc.setFill(Color.WHITE);
        gc.fillOval(1,1,w-2,h-2);
    }

}
