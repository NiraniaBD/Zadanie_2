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
    // я не уверена насчет этого
    public UndoRedoState undo() {
//        LinkedList<MyAction> activityList = getActivityList();
////        LinkedList<MyAction> redoActivityList = getRedoActivityList();
////        MyAction action = activityList.pollLast();
////        if (action != null) {
////            redoActivityList.add(action);
////            action.unExecuteCommand();
////        }
////        return activityList.size() > 0
////                ? new StateEnableUndoEnableRedo(getActivityList(),getRedoActivityList())
////                : new StateDisableUndoEnableRedo(getActivityList(), getRedoActivityList());
        MakeAShiftUndo ();
        if (getActivityList().isEmpty()) { //если конец списка слева
            System.out.println("REDO - из ED переход в DE");
            return (new StateDisableUndoEnableRedo(getActivityList(),getRedoActivityList()));
        } else { //если слева не конец, то сейчас центр undo/redo
            System.out.println("REDO - из ED переход в EE");
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
