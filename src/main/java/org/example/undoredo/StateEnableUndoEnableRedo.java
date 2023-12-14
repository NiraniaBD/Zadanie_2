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
//        LinkedList<MyAction> activityList = getActivityList();
//        LinkedList<MyAction> redoActivityList = getRedoActivityList();
//        MyAction action = activityList.pollLast();
//        if (action != null) {
//            redoActivityList.add(action);
//        }
//        return activityList.size() > 0
//                ? new StateEnableUndoEnableRedo(getActivityList(),getRedoActivityList())
//                : new StateDisableUndoEnableRedo(getActivityList(), getRedoActivityList());
        MakeAShiftUndo ();
        System.out.println("getActivityList().isEmpty(): " + getActivityList().isEmpty() );
        if (getActivityList().isEmpty() ) { //если конец списка
            System.out.println("REDO - из EE переход в DE");
            return (new StateDisableUndoEnableRedo(getActivityList(),getRedoActivityList()));
        } else {
            System.out.println("REDO - переход в себя EE");
            return (this);
        }
    }

    @Override
    public UndoRedoState redo() {
//        LinkedList<MyAction> activityList = getActivityList();
//        LinkedList<MyAction> redoActivityList = getRedoActivityList();
//        MyAction action = redoActivityList.pollLast();
//        if (action != null) {
//            activityList.add(action);
//        }
//        return redoActivityList.size() > 0
//                ? this
//                : new StateEnableUndoDisableRedo(getActivityList(), getRedoActivityList());
        MakeAShiftRedo ();
        System.out.println("getActivityList().isEmpty(): " + getActivityList().isEmpty() );
        if (getRedoActivityList().isEmpty()) {
            System.out.println("REDO - из EE переход ED");
            return (new StateEnableUndoDisableRedo(getActivityList(), getRedoActivityList()));
        } else{
            System.out.println("REDO - из EE переход в себя EE");
            return (this);
        }
    }
    @Override
    public boolean isEnableUndoButton() {
        return true;
    }
    @Override
    public boolean isEnableRedoButton() {
        return true;
    }


}
