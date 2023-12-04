package org.example.undoredo;

import org.example.controller.action.MyAction;

import java.util.LinkedList;

public abstract class UndoRedoState {
    private UndoRedoStateEnum undoRedoStateEnum;
    private final LinkedList<MyAction> activityList;

    private final LinkedList<MyAction> redoActivityList;

    public UndoRedoState(UndoRedoStateEnum undoRedoStateEnum, LinkedList<MyAction> activityList, LinkedList<MyAction> redoActivityList) {
        this.undoRedoStateEnum = undoRedoStateEnum;
        this.activityList = activityList;
        this.redoActivityList = redoActivityList;
    }

    public abstract UndoRedoState undo();

    public abstract UndoRedoState redo();

    public LinkedList<MyAction> getActivityList() {
        return activityList;
    }

    public LinkedList<MyAction> getRedoActivityList() {
        return redoActivityList;
    }

    public void addAction(MyAction action) {

    }

    public void clearHistory() {
        redoActivityList.clear();
    }

    public abstract boolean isEnableRedoButton();
    public abstract boolean isEnableUndoButton();
}


