/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.JFrame;

@Component
public class MyFrame extends JFrame {
    private MyPanel panel;

    @Autowired
    public void setPanel(MyPanel panel) {
        this.panel = panel;
    }

    @PostConstruct
    public void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
        add(panel);
    }

} 
