package org.example.controller.menu;

import org.example.model.MyShape;
import org.example.model.shape.factory.ShapeType;
import org.example.model.shape.factory.fill.Fill;
import org.example.model.shape.factory.fill.FillBehavior;
import org.example.model.shape.factory.fill.NoFill;
import org.example.undoredo.UndoMachine;
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
    private Color selectedColorFill;
    private  FillBehavior selectedFill;
    private MenuObserver menuObserver;
    private UndoMachine undoMachine;

    @PostConstruct
    public void init() {
        menu = new JMenuBar();
        JMenu shapeMenu = createShapeMenu();
        JMenu colorMenu = createColorMenu();
        JMenu fillMenu = createFillMenu();
        JMenu fillBezZalivki = createFrameBezZalivkiMenu();
        JMenu undoRedoMenu = createUndoRedoMenu();
        menu.add(shapeMenu);
        menu.add(colorMenu);
        menu.add(fillMenu);
        menu.add(fillBezZalivki);
        menu.add(undoRedoMenu);
        defaultState();
    }

    private void defaultState() {
        selectedShape = ShapeType.RECTANGULAR;
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

        return shapeMenu;
    }

    private JMenu createFillMenu(){
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

    private JMenu createColorMenu() {
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

    private JMenu createFrameBezZalivkiMenu(){
        JMenu shapeMenu = new JMenu("Цвет рамки");
        ButtonGroup group = new ButtonGroup();
        JRadioButtonMenuItem blue = new JRadioButtonMenuItem("Синий");
        blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                selectedColor = Color.BLUE;
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
                MyShape shape = selectedShape.createShape(selectedColor, selectedFill);
                selectedFill.serShape(shape.getShape());
                menuObserver.notifyAllSubscribers();
            }
        });
        shapeMenu.add(green);
        group.add(green);

        JRadioButtonMenuItem red = new JRadioButtonMenuItem("Красный");
        red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                selectedColor = Color.RED;
                MyShape shape = selectedShape.createShape(selectedColor, selectedFill);
                selectedFill.serShape(shape.getShape());
                menuObserver.notifyAllSubscribers();
            }
        });
        shapeMenu.add(red);
        group.add(red);

        JRadioButtonMenuItem black = new JRadioButtonMenuItem("Черный");
        black.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                selectedColor = Color.BLACK;
                MyShape shape = selectedShape.createShape(selectedColor, selectedFill);
                selectedFill.serShape(shape.getShape());
                menuObserver.notifyAllSubscribers();
            }
        });
        shapeMenu.add(black);
        group.add(black);

        JRadioButtonMenuItem yellow = new JRadioButtonMenuItem("Желтый");
        yellow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                selectedColor = Color.YELLOW;
                MyShape shape = selectedShape.createShape(selectedColor, selectedFill);
                selectedFill.serShape(shape.getShape());
                menuObserver.notifyAllSubscribers();
            }
        });
        shapeMenu.add(yellow);
        group.add(yellow);

        return shapeMenu;
    }


    private JMenu createUndoRedoMenu() {
        JMenu shapeMenu = new JMenu("Undo|Redo");
        ButtonGroup group = new ButtonGroup();
        JButton undoButton = new JButton("Undo");

        shapeMenu.add(undoButton);
        group.add(undoButton);
        JButton redoButton = new JButton("Redo");
        shapeMenu.add(redoButton);
        group.add(redoButton);

        undoButton.addActionListener(e -> {
            undoMachine.executeUndo();
            undoButton.setEnabled(undoMachine.isEnableUndo());
            redoButton.setEnabled(undoMachine.isEnableRedo());
        });

        redoButton.addActionListener(e -> {
            undoMachine.executeRedo();
            undoButton.setEnabled(undoMachine.isEnableUndo());
            redoButton.setEnabled(undoMachine.isEnableRedo());
        });

        return shapeMenu;
    }


    @Autowired
    public MenuController(UndoMachine undoMachine) {
        this.undoMachine = undoMachine;
    }

    public JMenuBar getMenu() {
        return menu;
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
