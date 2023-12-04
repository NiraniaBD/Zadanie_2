package org.example.controller.menu;

import org.example.model.MyShape;
import org.example.model.shape.factory.ShapeType;
import org.example.model.shape.factory.fill.Fill;
import org.example.model.shape.factory.fill.FillBehavior;
import org.example.model.shape.factory.fill.NoFill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class MenuController {

    JMenuBar menu;

    private ShapeType selectedShape;
    private Color selectedColor;
    private  FillBehavior selectedFill;

    private MenuObserver menuObserver;

    @PostConstruct
    public void init() {
        menu = new JMenuBar();
        JMenu shapeMenu = createShapeMenu();
        JMenu colorMenu = createColorMenu();
        JMenu fillMenu = createFillMenu();
        menu.add(shapeMenu);
        menu.add(colorMenu);
        menu.add(fillMenu);

        defaultState();
    }

    private void defaultState() {
        selectedShape = ShapeType.ELLIPSE;
        selectedColor = Color.BLACK;
        selectedFill = new NoFill();
    }

    private JMenu createShapeMenu() {
        JMenu shapeMenu = new JMenu("Фигура");
        ButtonGroup group = new ButtonGroup();
        JRadioButtonMenuItem square = new JRadioButtonMenuItem("Прямоугольник");
        square.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                selectedShape = ShapeType.RECTANGULAR;
                selectedShape.createShape(selectedColor,selectedFill);
                MyShape shape = selectedShape.createShape(selectedColor, selectedFill);
                selectedFill.serShape(shape.getShape());
                menuObserver.notifyAllSubscribers();
            }
        });
        shapeMenu.add(square);
        group.add(square);
        JRadioButtonMenuItem ellipse = new JRadioButtonMenuItem("Эллипс");
        ellipse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                selectedShape = ShapeType.ELLIPSE;
                selectedShape.createShape(selectedColor,selectedFill);
                MyShape shape = selectedShape.createShape(selectedColor, selectedFill);
                selectedFill.serShape(shape.getShape());
                menuObserver.notifyAllSubscribers();
            }
        });
        shapeMenu.add(ellipse);
        group.add(ellipse);
        JRadioButtonMenuItem roundRectangular = new
                JRadioButtonMenuItem("Закругленный прямоугольник");
        roundRectangular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                selectedShape = ShapeType.ROUND_RECTANGULAR;
                selectedShape.createShape(selectedColor,selectedFill);
                MyShape shape = selectedShape.createShape(selectedColor, selectedFill);
                selectedFill.serShape(shape.getShape());
                menuObserver.notifyAllSubscribers();
            }
        });
        shapeMenu.add(roundRectangular);
        group.add(roundRectangular);

        return shapeMenu;
    }

    private JMenu createColorMenu(){
        JMenu shapeMenu = new JMenu("Заливка");
        ButtonGroup group = new ButtonGroup();
        JRadioButtonMenuItem zalivka = new JRadioButtonMenuItem("Есть заливка");
        zalivka.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedFill = new Fill();
                selectedFill.setColor(selectedColor);
                MyShape shape = selectedShape.createShape(selectedColor, selectedFill);
                selectedFill.serShape(shape.getShape());
                menuObserver.notifyAllSubscribers();
            }
        });

        shapeMenu.add(zalivka);
        group.add(zalivka);
        JRadioButtonMenuItem netZalivki = new JRadioButtonMenuItem("Нет заливки");
        netZalivki.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                selectedFill = new NoFill();
                selectedFill.setColor(selectedColor);
                MyShape shape = selectedShape.createShape(selectedColor, selectedFill);
                selectedFill.serShape(shape.getShape());
                menuObserver.notifyAllSubscribers();
            }
        });
        shapeMenu.add(netZalivki);
        group.add(netZalivki);

        return shapeMenu;
    }

    private JMenu createFillMenu() {
        JMenu shapeMenu = new JMenu("Цвет");
        ButtonGroup group = new ButtonGroup();
        JRadioButtonMenuItem black = new JRadioButtonMenuItem("Черный");
        black.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                selectedColor = Color.BLACK;
                selectedFill.setColor(selectedColor);
                MyShape shape = selectedShape.createShape(selectedColor, selectedFill);
                selectedFill.serShape(shape.getShape());
                menuObserver.notifyAllSubscribers();
            }
        });
        shapeMenu.add(black);
        group.add(black);
        JRadioButtonMenuItem red = new JRadioButtonMenuItem("Красный");
        red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                selectedColor = Color.RED;
                selectedFill.setColor(selectedColor);
                MyShape shape = selectedShape.createShape(selectedColor, selectedFill);
                selectedFill.serShape(shape.getShape());
                menuObserver.notifyAllSubscribers();
            }
        });
        shapeMenu.add(red);
        group.add(red);
        JRadioButtonMenuItem blue = new JRadioButtonMenuItem("Синий");
        blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                selectedColor = Color.BLUE;
                selectedFill.setColor(selectedColor);
                MyShape shape = selectedShape.createShape(selectedColor, selectedFill);
                selectedFill.serShape(shape.getShape());
                menuObserver.notifyAllSubscribers();
            }
        });
        shapeMenu.add(blue);
        group.add(blue);
        JRadioButtonMenuItem green = new JRadioButtonMenuItem("Зеленый");
        green.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                selectedColor = Color.GREEN;
                selectedFill.setColor(selectedColor);
                MyShape shape = selectedShape.createShape(selectedColor, selectedFill);
                selectedFill.serShape(shape.getShape());
                menuObserver.notifyAllSubscribers();
            }
        });
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

    public ShapeType getSelectedShape() {
        return selectedShape;
    }

    public Color getSelectedColor() {
        return selectedColor;
    }

    public FillBehavior getSelectedFill() {
        return selectedFill;
    }

    @Autowired
    public void setMenuObserver(MenuObserver menuObserver) {
        this.menuObserver = menuObserver;
    }
}
