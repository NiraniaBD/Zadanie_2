package org.example.undoredo;

import org.example.controller.action.MyAction;

import java.util.LinkedList;

public class StateEnableUndoDisableRedo extends UndoRedoState{
    public StateEnableUndoDisableRedo(LinkedList<MyAction> actionLinkedList, LinkedList<MyAction> redoActivityList) {
        super(UndoRedoStateEnum.EUndoDRedo,
                actionLinkedList,
                redoActivityList);
    }

    @Override
    public UndoRedoState undo() {
        MakeAShiftUndo ();
        if (getActivityList().isEmpty()) {
            return (new StateDisableUndoEnableRedo(getActivityList(),getRedoActivityList()));
        } else {
            return (new StateEnableUndoEnableRedo(getActivityList(),getRedoActivityList()));
        }
    }

    @Override
    public UndoRedoState redo() {
        return this;
    }
    @Override
    public boolean isEnableUndoButton() {
        return true;
    }
    @Override
    public boolean isEnableRedoButton() {
        return false;
    }


}
