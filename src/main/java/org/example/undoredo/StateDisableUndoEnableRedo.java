package org.example.undoredo;

import org.example.controller.action.MyAction;

import java.util.LinkedList;

public class StateDisableUndoEnableRedo extends UndoRedoState{
    public StateDisableUndoEnableRedo(LinkedList<MyAction> actionLinkedList, LinkedList<MyAction> redoActivityList) {
        super(UndoRedoStateEnum.DUndoERedo,
                actionLinkedList,
                redoActivityList);
    }

    @Override
    public UndoRedoState undo() {
        return this;
    }

    @Override
    public UndoRedoState redo() {
        MakeAShiftRedo();
        if (getRedoActivityList().isEmpty()) {
            return (new StateEnableUndoDisableRedo(getActivityList(), getRedoActivityList()));
        } else{
            return (new StateEnableUndoEnableRedo(getActivityList(), getRedoActivityList()));
        }
    }


    @Override
    public boolean isEnableUndoButton() {
        return false;
    }
    @Override
    public boolean isEnableRedoButton() {
        return true;
    }


}
