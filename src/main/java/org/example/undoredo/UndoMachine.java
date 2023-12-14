package org.example.undoredo;

import org.example.controller.action.MyAction;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.LinkedList;

@Component
public class UndoMachine {

    private UndoRedoState state;

    @PostConstruct
    public void init() {
        state = new StateDisableUndoDisableRedo(new LinkedList<>(), new LinkedList<>());
    }

    public void add(MyAction action){
        state.addAction(action);
        state = new StateEnableUndoDisableRedo(
                state.getActivityList(), state.getRedoActivityList());
    }

    public void executeRedo(){
        state = state.redo();
    }
    public void executeUndo(){
        state = state.undo();
    }

    public boolean isEnableUndo(){
        return state.isEnableUndoButton();
    }

    public boolean isEnableRedo(){
        return state.isEnableRedoButton();
    }

}
