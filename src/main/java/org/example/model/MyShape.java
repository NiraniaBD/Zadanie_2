package org.example.model;

import org.example.model.shape.factory.fill.Fill;
import org.example.model.shape.factory.fill.FillBehavior;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

public class MyShape implements Cloneable {
    private Color color;
    private RectangularShape shape;
    private FillBehavior fb;

    public void setShape(RectangularShape shape) {
        this.shape = shape;
    }


    public void setFrame(Point2D[] pd) {
        shape.setFrameFromDiagonal(pd[0], pd[1]);
    }

//    public MyShape(RectangularShape shape) {
//        this.shape = shape;
//        color = Color.GRAY;
//        fb = new Fill();
//        fb.setColor(color);
//        fb.serShape(shape);
//    }

    public MyShape() {
        color = Color.BLUE;
        shape = new Rectangle2D.Double();
        fb = new Fill();
        fb.setColor(color);
        fb.serShape(shape);
    }

    public MyShape(Color color, RectangularShape shape, FillBehavior fb) {
        this.color = color;
        this.shape = shape;
        this.fb = fb;
        this.fb.serShape(shape);
        this.fb.setColor(color);
    }

//    public void setFb(FillBehavior fb) {
//        this.fb = fb;
//        fb.serShape(shape);
//        fb.setColor(color);
//    }

    void draw(Graphics2D g) {
        fb.draw(g);
    }

    @Override
    public MyShape clone() {
        MyShape clone = new MyShape();
        clone.color = color;
        clone.fb = fb.clone();
        RectangularShape anotherShape = (RectangularShape) shape.clone();
        clone.setShape(anotherShape);
        clone.fb.serShape(anotherShape);
        return clone;
    }


    public RectangularShape getShape() {
        return shape;
    }
}
