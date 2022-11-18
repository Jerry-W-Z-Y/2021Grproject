package hk.edu.polyu.comp.comp2021.simple;

import hk.edu.polyu.comp.comp2021.simple.model.Simple;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


import java.util.Scanner;


public class Application {

    public  static void store1(String [] Str ,String location ){
        //create file object to store all string in Str
        try{
            File file = new File(location);
            FileWriter writer = new FileWriter(file);
            //if file exists , overwrite it
            //suppose each String in Str ==> 1 line
            for (String s : Str){
                if(s!=null) writer.write(s+"\n");
            }
            writer.close();
        }catch(IOException e){
            System.out.print("Error occur : " + e.getMessage());
        }

    }


    public  static  String[] load1(String location){
        //load function , open a file at String `location
        // return array of String , where each String is 1 line of the file
        String result[] ;
        try{
            String str="" ;
            File file = new File(location);
            Scanner scan = new Scanner(file);
            //keep reading until reach EOF
            while(scan.hasNextLine()){
                str += scan.nextLine() +"\n"; //need to add "\n" since scan.nextLine() consume "\n"
            }
            result = str.split("\n");//get final array with split funciton
            return (result);

        }catch(IOException e){
            System.out.println("Error occur : " + e.getMessage());
        }
        return null;
    }

    public static void print(String rf, Simple[]test,Simple s,exptable[]E){
        s.getname(rf,test);
        for(int i = 0; i<E.length;i++){
            if(E[i]!=null){
                if ((rf.equals(E[i].expname))&&(E[i].type.equals("bi"))){
                    System.out.println(E[i].expref[1]+" "+E[i].expref[2]+" "+E[i].expref[3]+" "+E[i].expref[4]);
                }
                if ((rf.equals(E[i].expname))&&(E[i].type.equals("un"))){
                    System.out.println(E[i].expref[1]+" "+E[i].expref[2]+" "+E[i].expref[3]);
                }
            }
        }

    }

    public static void brep(String en, exptable [] E, Simple[] test , Simple s){
        for(int j = 0 ; j<E.length;j++){
            if(E[j]!=null) {
                //System.out.println(E[j].expname);
                if ((en.equals(E[j].expname))&& (E[j].type.equals("bi")) ){
                    s.binexpr(E[j].expref[1], E[j].expref[2], E[j].expref[3], E[j].expref[4], test);
                }
                //System.out.println(en+ " "+ E[j].type);
                if ((en.equals(E[j].expname))&&(E[j].type.equals("un"))) {
                    //execute binexpr
                    System.out.println(E[j].expref[3]);
                    brep(E[j].expref[3],E,test,s);
                    s.unexpr(E[j].expref[1],E[j].expref[2],E[j].expref[3],test);
                }
            }
        }

    }

    public static void exec(String lb,lab[] tt,Simple[] test,Simple s, exptable[] E){
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
                    /*for(int j = 0 ; j<E.length;j++){
                        if(E[j]!=null) {
                            //System.out.println(E[j].expname);
                            if ((tt[labid].para[3].equals(E[j].expname))&&(E[j].type.equals("bi"))) {
                                //execute binexpr
                                s.binexpr(E[j].expref[1], E[j].expref[2], E[j].expref[3], E[j].expref[4], test);
                            }
                        }
                    }*/
                    brep(tt[labid].para[3],E,test,s);
                    s.assign(tt[labid].para[2], tt[labid].para[3], test);
                    break;
                case "block":

                    for (int p =2;p < tt[labid].para.length ;p++) {
                        String bk = tt[labid].para[p];
                        exec(bk, tt, test, s,E);
                    }
                    break;
                case"if":

                    /*for(int j = 0 ; j<E.length;j++){
                        if(E[j]!=null) {
                            //System.out.println(E[j].expname);
                            if (tt[labid].para[2].equals(E[j].expname)) {
                                //execute binexpr
                                s.binexpr(E[j].expref[1], E[j].expref[2], E[j].expref[3], E[j].expref[4], test);
                            }
                        }
                    }*/
                    brep(tt[labid].para[2],E,test,s);
                    boolean p = s.getbool(tt[labid].para[2],test);
                    System.out.println(p);
                    if (p){
                        exec(tt[labid].para[3],tt,test,s,E);
                    }else
                        exec(tt[labid].para[4],tt,test,s,E);
                    break;
                case"while":
                    /*for(int j = 0 ; j<E.length;j++){
                        if(E[j]!=null) {
                            //System.out.println(E[j].expname);
                            if ((tt[labid].para[2].equals(E[j].expname))&&E[j].type.equals("bi")) {
                                //execute binexpr
                                s.binexpr(E[j].expref[1], E[j].expref[2], E[j].expref[3], E[j].expref[4], test);
                            }
                        }
                    }*/
                    brep(tt[labid].para[2],E,test,s);
                    boolean q = s.getbool(tt[labid].para[2],test);
                    //System.out.println(tt[labid].para[2]+" pass "+ q);
                    while (q){
                        exec(tt[labid].para[3],tt,test,s,E);
                        /*for(int j = 0 ; j<E.length;j++){
                            if(E[j]!=null) {
                                System.out.println(E[j].expname);
                                if (tt[labid].para[2].equals(E[j].expname)) {
                                    //execute binexpr
                                    s.binexpr(E[j].expref[1], E[j].expref[2], E[j].expref[3], E[j].expref[4], test);
                                }
                            }
                        }*/
                        brep(tt[labid].para[2],E,test,s);
                        System.out.println("afterwhile" + q);
                        q = s.getbool(tt[labid].para[2],test);
                        //System.out.println(q);
                    }
                    break;
                case"skip ":
                    break;
                case "print":
                    print(tt[labid].para[2],test,s,E);
                    break;
            }
        }
        else System.out.println("wrong labname");


    }

    public static class lab{
        String labcmd,labname;
        String []para;
        public lab(String lc,String ln,String []pa){
            this.labcmd= lc;
            this.labname= ln;
            this.para =pa;
        }
    }

    public static class program{
        String programname;

        String labnamep;

        String [] commandlist = new String[1000];

        public  String cmdll(String k, lab[] lb){
            String cmd1 = "";

            for (int x = 0 ;x < lb.length ; x++){
                if ((lb[x]!= null) && (k.equals(lb[x].labname))) {
                    for (String s : lb[x].para ) {
                        cmd1 = cmd1+s+" ";
                    };
                }
            }
            return cmd1;
        }

        public  program(){};
        public program(String pg, String lp, lab[] lb){
            this.programname= pg;
            this.labnamep= lp;
            int count = 0;

            String cmd = "";
            for (int x = 0 ;x < lb.length ; x++){
                if ((lb[x]!= null) && (this.labnamep.equals(lb[x].labname))) {
                       if (lb[x].labcmd.equals("block")){
                           for(int y = 2; y< lb[x].para.length;y++){
                               cmd= cmdll(lb[x].para[y],lb);
                               commandlist[count]=cmd;
                               count++;
                           }
                       }
                       else{
                           cmd =cmdll(this.labnamep, lb);
                           commandlist[count]=cmd;
                           count++;
                        }
                    }
            }

            System.out.println(cmd);
        }
    }

    public static class exptable{
        String expname, type;
        String []expref;
        public exptable(String expn,String []ref, String tp){
            this.expname= expn;
            this.expref =ref;
            this.type = tp;
        }
    }

    public static void main(String[] args){

        Simple simple = new Simple();
        // Initialize and utilize the system
        String input;
        Simple[] data = new Simple[100];//used to store vardef
        lab[] labs = new lab[100];
        exptable[] expt = new exptable[100];
        program[] programlist = new program[100];


        do {
            System.out.println("Command: ");
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
            String[] strs = input.split(" ");

            switch (strs[0]) {

                case "binexpr":
                    String exptype = "bi";
                    int d=0;
                    while (expt[d]!=null)
                        d++;
                    exptable exptemp = new exptable(strs[1], strs, exptype);
                    expt[d] = exptemp;
                    //simple.binexpr(strs[1],strs[2],strs[3],strs[4], data);
                    break;
                case "unexpr":
                    exptype = "un";
                    d=0;
                    while (expt[d]!=null)
                        d++;
                    exptable exptemp1 = new exptable(strs[1], strs, exptype);
                    expt[d] = exptemp1;
                    //simple.unexpr(strs[1],strs[2],strs[3], data);
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
                case"program":
                    int l = 0;
                    while (programlist[1]!=null)
                        l++;
                    program temppro = new program(strs[1],strs[2],labs);
                    programlist[l] = temppro;
                    break;
                case "list":
                    for (program k : programlist){
                        if ((k!=null)&&(strs[1].equals(k.programname))) {
                            for (String w : k.commandlist) {
                                if (w!=null)System.out.println(w);
                            }
                        }
                    }
                    break;
                case "execute":
                    for (int h = 0; h< programlist.length;h++){
                        if (programlist[h]!=null){
                            if (strs[1].equals(programlist[h].programname)){
                                exec(programlist[h].labnamep,labs,data,simple, expt);
                            }
                        }
                    }
                    //exec(strs[1],labs,data,simple, expt);
                    break;
                case "store":
                    for(program y: programlist){
                        if(y!=null) {
                            if (strs[1].equals(y.programname)) {
                                store1(y.commandlist,strs[2]);
                            }
                        }
                    }
                    break;
                case "load":
                    l = 0;
                    while (programlist[1]!=null)
                        l++;
                    program tempprog = new program();
                    tempprog.programname = strs[2];

                    tempprog.commandlist =  load1(strs[1]);
                    programlist[l]= tempprog;
                    break;
            }
        } while (! input.equals("quit"));
    }

}

