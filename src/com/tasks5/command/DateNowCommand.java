package com.tasks5.command;

public class DateNowCommand implements Command{
    @Override
    public void execute() {
        System.out.println(System.currentTimeMillis());
    }
}
