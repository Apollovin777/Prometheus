package com.com.task6;

public class Decode {
    public static void main(String[] args){
        if(args.length == 0) {
            System.out.println("");
            return;
        }
        String input = args[0];

        StringBuilder builder = new StringBuilder();
        char symbol = input.charAt(0);
        for (int i = 1;i<input.length();i++){
            if(Character.isAlphabetic(input.charAt(i))){
                if(symbol == input.charAt(i)){
                    System.out.println("");
                    return;
                }
                else{
                    builder.append(symbol);
                    symbol = input.charAt(i);
                }
            }
            else if(Character.isDigit(input.charAt(i))){
                if(i+1<input.length() && Character.isDigit(input.charAt(i+1))){
                    System.out.println("");
                    return;
                }
                else{
                    int c = Character.getNumericValue(input.charAt(i));
                    for(int j = 0;j<c;j++)
                        builder.append(symbol);
                    if(i+1<input.length())
                        i++;
                    symbol= input.charAt(i);
                }

            }
        }
        System.out.println(builder.toString());
    }
}
