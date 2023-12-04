package org.example.controller.action;

public interface MyAction {
    void executeCommand();
    void unExecuteCommand();
    MyAction cloneAction();
}
