package hk.edu.polyu.comp.comp2021.simple;

import hk.edu.polyu.comp.comp2021.simple.model.Simple;


import java.util.Scanner;


public class Application {

    public static class lab{
        String labcmd,labname;
        String []para;
        public lab(String lc,String ln,String []pa){
            this.labcmd= lc;
            this.labname= ln;
            this.para =pa;
        }
    }
    public static void exec(String lb,lab[] tt,Simple[] test,Simple s){
        int labid =-1;
        for (int i = 0 ; i< tt.length; i++){
            if (tt[i]!=null) {
                if (lb.equals(tt[i].labname)) {
                    labid = i;
                    break;
                }
            }
        }

        if(labid >= 0) {
            switch (tt[labid].labcmd) {
                case "vardef":
                    int i = 0;
                    while (test[i] != null)
                        i++;
                    test[i] = s.vardef(tt[labid].para);
                    break;
                case "assign":
                    s.assign(tt[labid].para[2], tt[labid].para[3], test);
                    break;
                case "block":
                    for (int p =2;p < tt[labid].para.length ;p++) {
                        String bk = tt[labid].para[p];
                        exec(bk, tt, test, s);
                    }
                    break;
                case"if":
                    boolean p = s.getbool(tt[labid].para[2],test);
                    System.out.println(p);
                    if (p){
                        exec(tt[labid].para[3],tt,test,s);
                    }else
                        exec(tt[labid].para[4],tt,test,s);
                    break;
                case"while":
                    boolean q = s.getbool(tt[labid].para[2],test);
                    System.out.println(tt[labid].para[2]+" pass "+ q);
                    while (q){
                        exec(tt[labid].para[3],tt,test,s);
                        q = s.getbool(tt[labid].para[2],test);
                        System.out.println(q);
                    }
                    break;
                case"skip ":
                    break;
                case "print":
                    break;
            }
        }
        else System.out.println("wrong labname");


    }




    public static void main(String[] args){

        Simple simple = new Simple();
        // Initialize and utilize the system
        String input;
        Simple[] data = new Simple[100];//used to store vardef
        lab[] labs = new lab[100];


        do {
            System.out.println("Command: ");
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
            String[] strs = input.split(" ");

            switch (strs[0]) {

                case "binexpr":
                    simple.binexpr(strs[1],strs[2],strs[3],strs[4], data);
                    break;
                case "unexpr":
                    simple.unexpr(strs[1],strs[2],strs[3], data);
                    break;

                case "vardef":
                case "assign":
                case "block":
                case "if":
                case "print":
                case "skip":
                case "while":
                    int p = 0;
                    while (labs[p]!=null)
                        p++;
                    lab temp = new lab(strs[0],strs[1],strs);
                    labs[p]= temp;
                    System.out.println(labs[p].labname+" "+labs[p].para[0]);
                    break;
                case "execute":
                    exec(strs[1],labs,data,simple);
                    break;
            }
        } while (! input.equals("quit"));
    }

}
