package com.tasks3.fibonacci;

public class Fibonacci {
    //Повертає число Фібоначчі за номером, нумерація почнеться з одиниці
    //якщо число не можливо вирахувати поверніть -1
    public long getNumber(int position){
        if(position < 1)
            return -1L;
        if(position==1)
            return 1L;
        if(position==2)
            return 1L;
        return getNumber(position-1) + getNumber(position-2);
    }

    public static void main(String[] args){
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.getNumber(3));
    }
}
