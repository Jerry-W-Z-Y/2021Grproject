package hk.edu.polyu.comp.comp2021.simple;

import hk.edu.polyu.comp.comp2021.simple.model.Simple;

import java.util.Scanner;

public class Application {

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



    public static void main(String[] args){
        Simple simple = new Simple();
        // Initialize and utilize the system
        String input;
        Simple[] data = new Simple[100];//used to store vardef
        int dataindex;
        do {
            System.out.println("Command: ");
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
            String[] strs = input.split(" ");
            switch (strs[0]) {
                case "vardef":
                    int i = 0;

                    dataindex= checkvar(strs[4],data);                  // check ref whether is variable
                    if (dataindex>0){                                   // > 0 mean variable exist
                        strs[4]=getvar(dataindex, data);
                    }
                    dataindex= -1;
                    dataindex = checkvar(strs[2],data);

                    if (dataindex>0){                                   // > 0 mean variable exist
                        data[dataindex] = simple.vardef(strs[1],strs[2],strs[3],strs[4]);
                    }

                    else
                        while (data[i] != null){
                            i++;
                            data[i] = simple.vardef(strs[1],strs[2],strs[3],strs[4]);
                        }
                    break;
                case "binexpr":
                    int  bi2 = checkvar(strs[2],data);
                    if (bi2>0){
                        strs[2]= getvar(bi2, data);
                    };
                    int bi4 = checkvar(strs[4],data);
                    if (bi4>0){
                        strs[4] = getvar(bi4,data);
                    }
                    simple.binexpr(strs[1],strs[2],strs[3],strs[4]);

                    break;
                case "unexpr":
                    simple.unexpr(strs);
                    break;
            }
        } while (! input.equals("quit"));
    }

}
