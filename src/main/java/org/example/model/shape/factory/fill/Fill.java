package org.example.model.shape.factory.fill;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.RectangularShape;
public class Fill implements FillBehavior, Cloneable {
    private Color color;
    private RectangularShape shape;

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g) {
        Paint paint = g.getPaint();
        g.setPaint(color);
        g.fill(shape);
        g.setPaint(paint);
    }

    @Override
    public void serShape(RectangularShape s) {
        shape = s;
    }

    @Override
    public FillBehavior clone() {
        Fill fill = new Fill();
        fill.color = color;
        return fill;
    }
}
