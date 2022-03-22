package com.example.zber_ovocia;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class Kyblik extends Canvas {
    GraphicsContext gc;
    double w, h;
    Scene scene;

    public Kyblik(double w, double h, double x, double y, Scene scene) {
    super(w,h);
    this.scene = scene;
    this.w = w;
    this.h = h;
   setLayoutX(x);
   setLayoutY(y);

    this.gc = getGraphicsContext2D();
    setOnKeyPressed(this::pohyb);
    setFocusTraversable(true);
    requestFocus();
    vykresli();
    }
    public void vykresli() {
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0,w,h);
        gc.setFill(Color.GRAY);
        gc.fillRect(1,1,w-2,h-2);
    }
    public void pohyb(KeyEvent e) {
        switch (e.getCode()) {
            case LEFT, A -> pohybLavy();
            case RIGHT, D -> pohybPravy();
            case UP, W -> pohybHore();
            case DOWN, S -> pohybDole();
        }
    }
    
    private void pohybHore() {
        if(getLayoutY()<0+h) {
            setLayoutY(0);
        } else {
            setLayoutY(getLayoutY()-15);
        }
    }
    private void pohybDole() {
        if(getLayoutY()>scene.getHeight()-h*2) {
            setLayoutY(scene.getHeight()-h);
        } else {
            setLayoutY(getLayoutY()+15);
        }
    }
    public void pohybPravy() {
        if(getLayoutX()>scene.getWidth()) {
            setLayoutX(0-w);
        } else {
            setLayoutX(getLayoutX()+15);
        }
    }
    public void pohybLavy() {
        if(getLayoutX()<(0-w)) {
            setLayoutX(scene.getWidth());
        } else {
            setLayoutX(getLayoutX()-15);
        }
    }
}
