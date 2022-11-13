package hk.edu.polyu.comp.comp2021.simple;

import hk.edu.polyu.comp.comp2021.simple.model.Simple;

import java.util.Scanner;

/**
    public static int checkvar(String a, Simple sim[]){
        for (int i = 0 ; i< 100; i++){
            if(a.equals(sim[i].getvarname())){
                return i; // index of variable
            }
        }
        return -1; // not exist
    }

    public static  String getvar(int dataindex,Simple data[]){
        String s="";
        if (dataindex>0){
            if (data[dataindex].gettype().equals("int")){
            int i = data[dataindex].getint();
          s = Integer.toString(i);
        } else if (data[dataindex].gettype().equals("bool")) {
            boolean p= data[dataindex].getbool();
           s = Boolean.toString(p);
        }
    }
    return s;
}
 **/

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
                    simple.unexpr(strs);
                    break;
            }
        } while (! input.equals("quit"));
    }

}
