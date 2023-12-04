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

    private static final Set<MenuSubscriber> listenerSet = new HashSet<>();

    void subscribe(MenuSubscriber listener){
            listenerSet.add(listener);
    }
    void unsubscribe(MenuSubscriber listener){
            listenerSet.remove(listener);
    }

    static void notifyAllSubscribers(){
            for (MenuSubscriber event : listenerSet) {
                event.notifyUpdate();
            }
    }


}
