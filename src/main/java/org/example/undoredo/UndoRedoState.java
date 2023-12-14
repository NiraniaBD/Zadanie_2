package org.example.undoredo;

import org.example.controller.action.MyAction;

import java.util.LinkedList;

public abstract class UndoRedoState {
    private UndoRedoStateEnum undoRedoStateEnum;
    private final LinkedList<MyAction> activityList;
    private final LinkedList<MyAction> redoActivityList;
    private static final int MAX_UNDO = 50;

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
        if(activityList.size()>=MAX_UNDO){
            activityList.removeFirst();
        }
        activityList.add(action);
        redoActivityList.clear();
}
    public void MakeAShiftUndo(){
        MyAction action = activityList.pollLast();
        redoActivityList.add(action);
        action.unExecuteCommand();
    }

    public void MakeAShiftRedo(){
        MyAction action = redoActivityList.pollLast();
        activityList.add(action);
        action.executeCommand();
    }


    public void clearHistory() {
        redoActivityList.clear();
    }
    public abstract boolean isEnableRedoButton();
    public abstract boolean isEnableUndoButton();


}


