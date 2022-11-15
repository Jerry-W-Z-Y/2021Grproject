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
            Simple test = new Simple(strs);
            switch (strs[0]) {
                case "vardef":
                    int i = 0;
                    while (data[i] != null)
                        i++;
                    data[i] = test.vardef(strs);
                    break;
                case "binexpr":

                     i = 0;
                    while (data[i] != null)
                        i++;
                    data[i] = simple.binexpr(strs[1],strs[2],strs[3],strs[4], data);
                    break;
                case "unexpr":
                    i = 0;
                    while (data[i] != null)
                        i++;
                    simple.unexpr(strs[1],strs[2],strs[3], data);
                    break;
            }
        } while (! input.equals("quit"));
    }

}
