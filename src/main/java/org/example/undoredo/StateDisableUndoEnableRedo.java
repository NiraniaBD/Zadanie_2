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
        MakeAShiftRedo();
        if (getRedoActivityList().isEmpty()) { //если список вперёд пустой
            System.out.println("REDO - из DE переход в ED");
            return (new StateEnableUndoDisableRedo(getActivityList(), getRedoActivityList()));
        } else{
            System.out.println("REDO - из DE переход в EE");
            return (new StateEnableUndoEnableRedo(getActivityList(), getRedoActivityList()));
        }
    }


    @Override
    public boolean isEnableUndoButton() {
        return false;
    }
    @Override
    public boolean isEnableRedoButton() {
        return true;
    }


}
