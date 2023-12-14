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
        MakeAShiftUndo ();
        System.out.println("getActivityList().isEmpty(): " + getActivityList().isEmpty() );
        if (getActivityList().isEmpty() ) {
            return (new StateDisableUndoEnableRedo(getActivityList(),getRedoActivityList()));
        } else {
            return (this);
        }
    }

    @Override
    public UndoRedoState redo() {
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
