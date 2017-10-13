package com.tasks5.command;

public class Application {
    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println("Error");
            return;
        }
        Command command;
        if (args.length == 2) {
            if (args[0] == "echo") {
                command = new EchoCommand(args[1]);
                command.execute();
                return;
            }
            if (args[0].equals("date") && args[1].equals("now")) {
                command = new DateNowCommand();
                command.execute();
                return;
            }
        }

        if (args.length == 1) {
            switch (args[0]) {
                case "help":
                    command = new HelpCommand();
                    break;
                case "exit":
                    command = new ExitCommand();
                    break;
                default: {
                    System.out.println("Error");
                    return;
                }
            }
            command.execute();
            return;
        }
        System.out.println("Error");
    }


}

