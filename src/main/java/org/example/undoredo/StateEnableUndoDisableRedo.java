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
    public UndoRedoState undo() {
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
