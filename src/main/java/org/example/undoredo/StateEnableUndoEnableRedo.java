package org.example.undoredo;

import org.example.controller.action.MyAction;

import java.util.LinkedList;

public class StateEnableUndoEnableRedo extends UndoRedoState{
    public StateEnableUndoEnableRedo(LinkedList<MyAction> actionLinkedList, LinkedList<MyAction> redoActivityList) {
        super(UndoRedoStateEnum.EUndoERedo,
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
                ? new StateEnableUndoEnableRedo(getActivityList(),getRedoActivityList())
                : new StateDisableUndoEnableRedo(getActivityList(), getRedoActivityList());
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
        return true;
    }
}
