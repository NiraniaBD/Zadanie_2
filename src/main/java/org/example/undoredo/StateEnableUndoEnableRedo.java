package org.example.undoredo;

import org.example.controller.action.MyAction;

import java.util.LinkedList;

public class StateEnableUndoEnableRedo extends UndoRedoState{
    public StateEnableUndoEnableRedo(LinkedList<MyAction> actionLinkedList, LinkedList<MyAction> redoActivityList) {
        super(UndoRedoStateEnum.DUndoDRedo,
                actionLinkedList,
                redoActivityList);
    }

    @Override
    public UndoRedoState undo() {
        LinkedList<MyAction> activityList = getActivityList();
        LinkedList<MyAction> redoActivityList = getRedoActivityList();
        MyAction action = activityList.pollLast();
        if (action != null) {
            redoActivityList.add(action);
        }
        return activityList.size() > 0
                ? this
                : new StateDisableUndoEnableRedo(getActivityList(), getRedoActivityList());
    }

    @Override
    public UndoRedoState redo() {
        return null;
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
