package org.example.controller;

import org.example.model.shape.factory.ShapeType;
import org.example.model.shape.factory.fill.FillBehavior;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;

//import static jdk.nio.zipfs.ZipFileAttributeView.AttrID.group;

@Component
public class MenuController {

    JMenuBar menu;

    @PostConstruct
    public void init() {
        menu = new JMenuBar();
        JMenu shapeMenu = createShapeMenu();
        JMenu colorMenu = createColorMenu();
        JMenu fillMenu = createFillMenu();
        menu.add(shapeMenu);
        menu.add(colorMenu);
        menu.add(fillMenu);
    }

    private JMenu createShapeMenu() {
        JMenu shapeMenu = new JMenu("Фигура");
        ButtonGroup group = new ButtonGroup();
        JRadioButtonMenuItem square = new JRadioButtonMenuItem("Прямоугольник");
        square.addActionListener(new MenuObserver());
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

    private JMenu createColorMenu(){
        JMenu shapeMenu = new JMenu("Заливка");
        ButtonGroup group = new ButtonGroup();
        JRadioButtonMenuItem zalivka = new JRadioButtonMenuItem("Есть заливка");
        //zalivka.addActionListener(e -> selectedFill = ShapeFill.NoFill);
        shapeMenu.add(zalivka);
        group.add(zalivka);
        JRadioButtonMenuItem netZalivki = new JRadioButtonMenuItem("Нет заливки");
        //netZalivki.addActionListener(e -> selectedFill = ShapeFill.Fill);
        shapeMenu.add(netZalivki);
        group.add(netZalivki);

        return shapeMenu;
    }

    private JMenu createFillMenu() {
        JMenu shapeMenu = new JMenu("Цвет");
        ButtonGroup group = new ButtonGroup();
        JRadioButtonMenuItem black = new JRadioButtonMenuItem("Черный");
        //black.addActionListener(e -> selectedColor = ShapeColor.BLACK);
        shapeMenu.add(black);
        group.add(black);
        JRadioButtonMenuItem red = new JRadioButtonMenuItem("Красный");
        //red.addActionListener(e -> selectedColor = ShapeColor.RED);
        shapeMenu.add(red);
        group.add(red);
        JRadioButtonMenuItem blue = new JRadioButtonMenuItem("Синий");
        //blue.addActionListener(e -> selectedColor = ShapeColor.BLUE);
        shapeMenu.add(blue);
        group.add(blue);
        JRadioButtonMenuItem green = new JRadioButtonMenuItem("Зеленый");
        //green.addActionListener(e -> selectedColor = ShapeColor.GREEN);
        shapeMenu.add(green);
        group.add(green);

        return shapeMenu;
    }


    public JMenuBar getMenu() {
        return menu;
    }

    public Color selectedColor(){
        return null;
    }

    public FillBehavior selectedFill(){
        return null;
    }
}
