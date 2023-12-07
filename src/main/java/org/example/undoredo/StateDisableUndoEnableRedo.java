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
        LinkedList<MyAction> activityList = getActivityList();
        LinkedList<MyAction> redoActivityList = getRedoActivityList();
        MyAction action = redoActivityList.pollLast();
        if (action != null) {
            activityList.add(action);
        }
        return redoActivityList.size() > 0
                ? this
                : new StateEnableUndoDisableRedo(getActivityList(), getRedoActivityList());
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
