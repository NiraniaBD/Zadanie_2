package org.example.controller;

import org.example.controller.action.ActionDraw;
import org.example.model.Model;
import org.example.model.MyShape;
import org.example.model.fill.NoFill;
import org.example.view.MyFrame;
import org.example.view.MyPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

@Component
public class Controller {
    private Model model;
    private MyFrame frame;
    private MyPanel panel;
    private Point2D [] pd;
    private MyShape shape;

    private ActionDraw actionDraw;

    @PostConstruct
    public void init() {
        shape = new MyShape(Color.BLACK, new Rectangle2D.Double(), new NoFill());
        actionDraw.setSampleShape(shape);
        actionDraw.setShape(shape);
        model.addObserver(panel);
        frame.setPanel(panel);

        pd = new Point2D[2];
    }
    public void getPointOne(Point2D p){
        pd[0] = p;
    }
    public void getPointTwo(Point2D p){
        pd[1] = p;
        model.changeShape(pd);
    }

    public void draw(Graphics2D g2) {
        model.setMyShape(shape);
        model.draw(g2);
    }

    public void mousePressed(Point point){
        actionDraw.createShape(point);
    }

    public void mouseDragged(Point point){
        actionDraw.stretchShape(point);
    }


    @Autowired
    public void setModel(Model model) {
        this.model = model;
    }
    @Autowired
    public void setFrame(MyFrame frame) {
        this.frame = frame;
    }
    @Autowired
    public void setPanel(MyPanel panel) {
        this.panel = panel;
    }
    @Autowired
    public void setActionDraw(ActionDraw actionDraw) {
        this.actionDraw = actionDraw;
    }
}
