package org.example.controller;

import org.example.model.shape.factory.ShapeType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.HashSet;
import java.util.Set;


public class MenuObserver {
    Set<ActionListener> listenerSet = new HashSet<>();

    void subscribe(ActionListener listener){
            listenerSet.add(listener);
    }
    void unsubscribe(ActionListener listener){
            listenerSet.remove(listener);
    }

    void notifyAllObservers(String data){
            for (ActionListener event: listenerSet) {
                event.notify();
            }

    }


}
