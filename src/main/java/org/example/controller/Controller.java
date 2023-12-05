package org.example.controller;

import org.example.controller.action.ActionDraw;
import org.example.controller.menu.MenuController;
import org.example.controller.menu.MenuObserver;
import org.example.controller.menu.MenuSubscriber;
import org.example.model.Model;
import org.example.model.MyShape;
import org.example.model.shape.factory.ShapeType;
import org.example.model.shape.factory.fill.FillBehavior;
import org.example.model.shape.factory.fill.NoFill;
import org.example.view.MyFrame;
import org.example.view.MyPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.awt.*;
import java.awt.geom.Point2D;

@Component
public class Controller implements MenuSubscriber {
    private Model model;
    private MyFrame frame;
    private MyPanel panel;
    private Point2D [] pd;
    private MyShape shape;
    private MyShape shape1;
    private ActionDraw actionDraw;
    private MenuController menuController;
    private MenuObserver menuObserver;


    @PostConstruct
    public void init() {
        actionDraw.setSampleShape(shape);
        actionDraw.setShape(shape);
        model.addObserver(panel);
        frame.setPanel(panel);
        frame.setJMenuBar(menuController.getMenu());
        frame.revalidate();
        menuObserver.subscribe(this);
        menuObserver.notifyAllSubscribers();
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

    @Autowired
    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    @Autowired
    public void setMenuObserver(MenuObserver menuObserver) {
        this.menuObserver = menuObserver;
    }

    @Override
    public void notifyUpdate() {
        ShapeType selectedShape = menuController.getSelectedShape();
        Color selectedColor = menuController.getSelectedColor();
        FillBehavior selectedFill = menuController.getSelectedFill();
        shape = selectedShape.createShape(selectedColor, selectedFill);
        actionDraw.setSampleShape(shape);

        model.updateShape();

//        ShapeType selectedShape1 = menuController.getSelectedShape1();
//        Color selectedColor1 = menuController.getSelectedColor1();
//        FillBehavior selectedFill1 = menuController.getSelectedFill1();
//        shape1 = selectedShape1.createShape(selectedColor1, selectedFill1);
//        actionDraw.setSampleShape(shape1);
//
//        model.updateShape();
    }
}
