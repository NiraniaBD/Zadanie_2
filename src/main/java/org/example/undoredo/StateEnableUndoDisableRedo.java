package org.example.undoredo;

import org.example.controller.action.MyAction;

import java.util.LinkedList;

public class StateEnableUndoDisableRedo extends UndoRedoState{
    public StateEnableUndoDisableRedo(LinkedList<MyAction> actionLinkedList, LinkedList<MyAction> redoActivityList) {
        super(UndoRedoStateEnum.DUndoDRedo,
                actionLinkedList,
                redoActivityList);
    }

    @Override
    public UndoRedoState undo() {

    }

    @Override
    public UndoRedoState redo() {

    }
}
