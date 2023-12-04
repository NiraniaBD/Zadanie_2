package org.example.undoredo;

import org.example.controller.action.MyAction;

import java.util.LinkedList;

public class StateDisableUndoDisableRedo extends UndoRedoState{
    public StateDisableUndoDisableRedo(LinkedList<MyAction> actionLinkedList, LinkedList<MyAction> redoActivityList) {
        super(UndoRedoStateEnum.DUndoDRedo,
                actionLinkedList,
                redoActivityList);
    }

    @Override
    public UndoRedoState undo() {
        return this;
    }

    @Override
    public UndoRedoState redo() {
        return this;
    }

    @Override
    public boolean isEnableRedoButton() {
        return false;
    }

    @Override
    public boolean isEnableUndoButton() {
        return false;
    }
}
