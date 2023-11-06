package org.example.view;

import org.example.controller.Controller;
import org.example.model.MyShape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Observable;
import java.util.Observer;
import javax.annotation.PostConstruct;
import javax.swing.JPanel;

@Component
public class MyPanel extends JPanel implements Observer {
    private Controller controller;

    @Autowired
    public void setController(Controller controller) {
        this.controller = controller;
    }
    @PostConstruct
    private void init() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent arg0) {
                controller.getPointOne(arg0.getPoint());
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent arg0) {
                controller.getPointTwo(arg0.getPoint());
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        controller.draw(g2);


    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }

}
