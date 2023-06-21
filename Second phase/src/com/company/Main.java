package com.company;

import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

import static java.lang.System.exit;

public class Main {
    static class MyException extends Exception {
        public MyException(String message) {
            super(message);
        }
    }
    public static void main(String[] args){
        //Amirali Lotfi
        //Mohammad kazem Harandi -> mohammad._.hr

        Scanner input = new Scanner(System.in);
        while (true) {
            print("The language is : (a^2n)(b^3n)\n");
            print("1.create a new String.\n");
            print("2.Check a string.\n");
            print("'exit' for exit.\n");
            String select = input.next();
            switch (select) {
                case "1":
                    while (true) {
                        print("Enter a number for create a string or Enter 'back' for menu\n");
                        String n = input.next();
                        if (Objects.equals(n, "back"))
                            break;
                        else
                            numberOne(Integer.parseInt(n));
                    }
                    break;
                case "2":
                    while (true) {
                        print("Enter a string or Enter 'back' for menu\n");
                        String n = input.next();
                        if (Objects.equals(n, "back"))
                            break;
                        else
                            numberTwo(n);
                    }
                    break;
                case "exit":
                    printRed("good luck");
                    exit(0);
                    break;
            }
        }
    }

    public static void numberOne(int n){
        try{
            if (n<1)
                throw new MyException("The number should be more than 0! \n");
            else {
                for (int i = 0; i < 2*n; i++)
                    print("a");
                for (int i = 0; i < 3*n; i++)
                    print("b");

                print("\n");
            }
        }catch (Exception e){
            printRed(e.getMessage());
        }
    }

    public static void numberTwo(String n){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);

            if (c != 'a' && c != 'b') {
                print("Rejected\n");
                return;
            }

            if (c == 'a') {
                stack.push(c);
                stack.push(c);
                stack.push(c);
            }
            else {
                if ((!stack.isEmpty()) && stack.size() > 1) {
                    stack.pop();
                    stack.pop();
                } else {
                    print("Rejected\n");
                    return;
                }
            }
        }
        if (stack.isEmpty()) {
            print("Accepted\n");
        }
    }

    public static void print(Object obj){
        System.out.print(obj);
    }

    public static void printRed(Object obj){
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        System.out.println(ANSI_RED
                + obj
                + ANSI_RESET);
    }
}
