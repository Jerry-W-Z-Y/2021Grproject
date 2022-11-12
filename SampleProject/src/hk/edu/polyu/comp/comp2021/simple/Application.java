package hk.edu.polyu.comp.comp2021.simple;

import hk.edu.polyu.comp.comp2021.simple.model.Simple;

import java.util.Scanner;

public class Application {

    public static void main(String[] args){
        Simple simple = new Simple();
        // Initialize and utilize the system
        String input;
        Simple[] data = new Simple[100];//used to store vardef
        do {
            System.out.println("Command: ");
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
            String[] strs = input.split(" ");
            switch (strs[0]) {
                case "vardef":
                    int i = 0;
                    while (data[i] != null)
                        i++;
                    data[i] = simple.vardef(strs);
                    break;
                case "binexpr":
                    simple.binexpr(strs);
                    break;
                case "unexpr":
                    simple.unexpr(strs);
                    break;
            }
        } while (! input.equals("quit"));
    }

}
