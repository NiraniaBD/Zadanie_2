package org.example.model.shape.factory;

import org.example.model.MyShape;
import org.example.model.shape.factory.fill.FillBehavior;

import java.awt.*;
import java.awt.geom.*;

public enum ShapeType {
    RECTANGULAR {
        @Override
        public MyShape createShape(Color color, FillBehavior fillBehavior)  {
            return new MyShape(color, new Rectangle2D.Double(), fillBehavior);
        }

    }, ELLIPSE {
        @Override
        public MyShape createShape(Color color, FillBehavior fillBehavior)  {
        return new MyShape(color, new Ellipse2D.Double(), fillBehavior);
        }

    },ROUND_RECTANGULAR {
        @Override
        public MyShape createShape(Color color, FillBehavior fillBehavior)  {
        return new MyShape( color, new RoundRectangle2D.Double(), fillBehavior);
        }

    }, ARC2D {
        @Override
        public MyShape createShape(Color color, FillBehavior fillBehavior)  {
        return new MyShape(color, new Arc2D.Double(), fillBehavior);
        }

    };

    public abstract MyShape createShape(Color color, FillBehavior fillBehavior);

}
