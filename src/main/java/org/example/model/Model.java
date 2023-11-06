package org.example.model;

import org.springframework.stereotype.Component;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.Observable;

@Component
public class Model extends Observable {
    private MyShape currentShape;

    public void setMyShape(MyShape myShape) {
        this.currentShape = myShape;
    }

    public void changeShape(Point2D[] pd) {
        currentShape.setFrame(pd);
        this.setChanged();
        this.notifyObservers();
    }

    public void draw(Graphics2D g) {
        currentShape.draw(g);
    }
}
