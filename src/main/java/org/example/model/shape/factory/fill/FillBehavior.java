package org.example.model.shape.factory.fill;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.RectangularShape;

public interface FillBehavior {
    void draw(Graphics2D g);

    void setColor(Color c);

    void serShape(RectangularShape s);

    FillBehavior clone();
}