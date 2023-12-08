package org.example.controller.action;

import org.example.model.Model;
import org.example.model.MyShape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.awt.*;
import java.awt.geom.Point2D;

@Component
public class ActionDraw implements MyAction {
    private Model model;
    private MyShape sampleShape;
    private MyShape shape;
    private Point2D[] p;

    @PostConstruct
    public void init() {
        p = new Point2D[2];
    }

    public void stretchShape(Point point){
        p[1] = point;
        shape.setFrame(p);
    }
    public void createShape(Point point){
        p[0] = point;
        shape = sampleShape.clone();
        model.createCurrentShape(shape);
    }

    @Autowired
    public void setModel(Model model) {
        this.model = model;
    }

    public void setSampleShape(MyShape shape) {
        this.sampleShape = shape;
    }

    public void setShape(MyShape shape) {
        this.shape = shape;
    }

    @Override
    public void executeCommand() {
        model.createCurrentShape(shape);
        model.updateShape();
    }

    @Override
    public void unExecuteCommand() {
        model.removeShape();
        model.updateShape();
    }

    @Override
    public MyAction cloneAction() {
        ActionDraw cloneAction = new ActionDraw();
        cloneAction.shape=shape;
        cloneAction.model=model;
        cloneAction.sampleShape=sampleShape;
        cloneAction.p=p;
        return cloneAction;
    }
}
