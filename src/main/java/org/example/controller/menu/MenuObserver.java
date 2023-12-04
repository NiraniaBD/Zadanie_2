package org.example.controller.menu;

import org.example.model.shape.factory.ShapeType;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.HashSet;
import java.util.Set;

@Component
public class MenuObserver {

    private final Set<MenuSubscriber> listenerSet = new HashSet<>();

    public void subscribe(MenuSubscriber listener){
            listenerSet.add(listener);
    }
    public void unsubscribe(MenuSubscriber listener){
            listenerSet.remove(listener);
    }

    public void notifyAllSubscribers(){
            for (MenuSubscriber event : listenerSet) {
                event.notifyUpdate();
            }
    }


}
