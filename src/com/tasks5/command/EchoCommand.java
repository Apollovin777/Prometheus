package com.tasks5.command;

public class EchoCommand implements Command {
    private String echoText;

    public EchoCommand(String echoText) {
        this.echoText = echoText;
    }

    @Override
    public void execute() {
        System.out.println(echoText);
    }
}
