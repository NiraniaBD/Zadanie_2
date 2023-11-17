package org.example.controller;

import javax.swing.*;

public class MenuController {

    private JMenu createShapeMenu() {
        JMenu shapeMenu = new JMenu("Фигура");
        ButtonGroup group = new ButtonGroup();
        JRadioButtonMenuItem square = new JRadioButtonMenuItem("Прямоугольник");
        //square.addActionListener(e -> selectedShape = ShapeType.RECTANGULAR);
        shapeMenu.add(square);
        group.add(square);
        JRadioButtonMenuItem ellipse = new JRadioButtonMenuItem("Эллипс");
        //ellipse.addActionListener(e -> selectedShape = ShapeType.ELLIPSE);
        shapeMenu.add(ellipse);
        group.add(ellipse);
        JRadioButtonMenuItem roundRectangular = new
                JRadioButtonMenuItem("Закругленный прямоугольник");
        //roundRectangular.addActionListener(e -> selectedShape = ShapeType.ROUND_RECTANGULAR);
        shapeMenu.add(roundRectangular);
        group.add(roundRectangular);
        return shapeMenu;
    }
}
