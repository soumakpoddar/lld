package org.example;

import java.util.Stack;

public class RemoteInvoker {
    private ICommand command;
    Stack<ICommand> commandHistory;

    public RemoteInvoker() {
        this.commandHistory = new Stack<>();
    }

    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
        commandHistory.push(command);
    }

    public void pressBackButton() {
        if (!commandHistory.isEmpty()) {
            ICommand lastCommand = commandHistory.pop();
            lastCommand.undo();
        } else {
            System.out.println("No command to undo");
        }
    }
}
