package org.example.undoredo;

import org.example.controller.action.MyAction;

import java.util.LinkedList;

public class StateDisableUndoEnableRedo extends UndoRedoState{
    public StateDisableUndoEnableRedo(LinkedList<MyAction> actionLinkedList, LinkedList<MyAction> redoActivityList) {
        super(UndoRedoStateEnum.DUndoDRedo,
                actionLinkedList,
                redoActivityList);
    }

    @Override
    public UndoRedoState undo() {
        return null;
    }

    @Override
    public UndoRedoState redo() {
        return null;
    }

    @Override
    public boolean isEnableRedoButton() {
        return true;
    }

    @Override
    public boolean isEnableUndoButton() {
        return false;
    }
}
