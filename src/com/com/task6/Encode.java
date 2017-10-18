package com.com.task6;

public class Encode {
    public static void main(String[] args){
        if(args.length==0){
            System.out.println("");
            return;
        }
        String input = args[0];
        char symbol = input.charAt(0);
        int numberOfRepeats = 1;
        StringBuilder builder = new StringBuilder();

        for(int i = 1; i < input.length(); i++){
            if(input.charAt(i)==symbol){
                if(numberOfRepeats==9){
                    builder.append(symbol);
                    builder.append(numberOfRepeats);
                    numberOfRepeats=1;
                }
                else
                    numberOfRepeats++;
            }
            else {
                builder.append(symbol);
                if (numberOfRepeats > 1)
                    builder.append(numberOfRepeats);
                symbol = input.charAt(i);
                numberOfRepeats=1;
            }
        }
        builder.append(symbol);
        if (numberOfRepeats > 1)
            builder.append(numberOfRepeats);

        System.out.println(builder.toString());
    }
}
