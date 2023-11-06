package org.example.model;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

@Component
public class Model extends Observable {
    private MyShape currentShape;

    private List<MyShape> shapeList;
    @PostConstruct
    public void init() {
        shapeList = new ArrayList<>();
    }

    public void setMyShape(MyShape myShape) {
        this.currentShape = myShape;
    }

    public void changeShape(Point2D[] pd) {
        currentShape.setFrame(pd);
        this.setChanged();
        this.notifyObservers();
    }

    public void draw(Graphics2D g) {
        for (MyShape shape : shapeList) {
            shape.draw(g);
        }
    }

    public void createCurrentShape(MyShape shape) {
        currentShape = shape;
        shapeList.add(currentShape);
        setChanged();
        notifyObservers();
    }
}
