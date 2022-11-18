package hk.edu.polyu.comp.comp2021.simple.model;



public class Simple {

    private String  type, varName;

    private boolean bool, boolexp;
    private int integer, intexp;

    private String expName,bop,uop;


    public  String getexpName(){
        return  this.expName;
    }
    public  String getexptype(){
        return  this.type;
    };

    public  int getexpint(){
        return  this.intexp;
    };
    public  boolean getexpbool(){
        return this.boolexp;
    }

    public int checkexpname(String epn, Simple[] test){

        for(int x = 0 ; x<test.length;x++){
        if(test[x]!=null){
            if (epn.equals(test[x].expName)) {
                return x;
                }
            }
        }
        return -1;
    }

    public static boolean isNumeric(String string) {
        int intValue;

        if(string == null || string.equals("")) {
            return false;
        }
        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("");
        }
        return false;
    }

    public Simple() {
    }
    public Simple(String[] a) {

        this.type = a[2];//only "bool", "int" allowed
        this.varName = a[3];
        if (this.type.equals("bool"))
            this.bool = Boolean.parseBoolean(a[4]);
        else if (this.type.equals("int")) {
            int n = Integer.parseInt(a[4]);
            this.integer = n > 99999 ? 99999 : n < -99999 ? -99999 : n;
        }
    }

    public Simple vardef(String[] a) {
        //code here
        Simple k = new Simple();

        k.type = a[2];//only "bool", "int" allowed
        k.varName = a[3];
        if (k.type.equals("bool"))
            k.bool = Boolean.parseBoolean(a[4]);
        else if (k.type.equals("int")) {
            int n = Integer.parseInt(a[4]);
            k.integer = n > 99999 ? 99999 : n < -99999 ? -99999 : n;
        }
        //System.out.println(k.integer+" "+k.varName+" " +k.bool);

        return k;
    }
    public void binexpr(String a1,String a2 ,String a3,String a4, Simple[] test) {
        //code here

        Simple b = new Simple();

        int i2,i4;
        boolean b2,b4;
        b.boolexp = false;
        b.expName = a1;
        int i ;
        int j;

        for(i = 0 ; i<test.length;i++){

            if(test[i]!=null){
                if ((a2.equals(test[i].varName))&&(test[i].type.equals("int"))){
                    i2 = test[i].integer;
                    a2 = String.valueOf(i2);

                }
                System.out.println(a2+" "+test[i].type);
                if ((a2.equals(test[i].varName))&&(test[i].type.equals("bool"))){
                    b2=  test[i].bool;
                    System.out.println(b2+"b2");
                    a2 = String.valueOf(b2);

                }
            }
        }
        for(j = 0 ; j<test.length;j++){
            if(test[j]!=null){
            if ((a4.equals(test[j].varName))&&(test[j].type.equals("int"))){
                i4 = test[j].integer;
                a4 = String.valueOf(i4);

            }
                if ((a4.equals(test[j].varName))&&(test[j].type.equals("bool"))){
                b4=  test[j].bool;
                a4= String.valueOf(b4);

            }
            }
        }





        b.bop = a3;

        //System.out.println(a2+" "+a3+" "+a4);
        //System.out.println(isNumeric(a2)+"2numeric");
        //System.out.println(isNumeric(a4)+"4numeric");
        //check a[2], a[4] whether is variables
        //if expref1 and expref2 are int {
        if (((isNumeric(a2))) && (isNumeric(a4))) {  //a2 a4 are integers


            switch (a3) {
                case "+":

                    b.intexp = Integer.parseInt(a2) + Integer.parseInt(a4);
                    b.type= "int";
                    break;
                case "-":
                    b.intexp = Integer.parseInt(a2) - Integer.parseInt(a4);
                    b.type= "int";
                    break;
                case "*":
                    b.intexp = Integer.parseInt(a2) * Integer.parseInt(a4);
                    b.type= "int";
                    break;
                case "/":
                    b.intexp = Integer.parseInt(a2) / Integer.parseInt(a4);
                    b.type= "int";
                    break;
                case "%" :
                    b.intexp =  Integer.parseInt(a2) % Integer.parseInt(a4);
                    b.type= "int";
                        break;
                case ">":
                    b.boolexp = Integer.parseInt(a2) > Integer.parseInt(a4);
                    b.type= "bool";
                    break;
                case ">=":
                    b.boolexp = Integer.parseInt(a2) >= Integer.parseInt(a4);
                    b.type= "bool";
                    break;
                case "<":
                    b.boolexp = Integer.parseInt(a2) < Integer.parseInt(a4);
                    b.type= "bool";
                    break;
                case "<=":
                    b.boolexp = Integer.parseInt(a2) <= Integer.parseInt(a4);
                    b.type= "bool";
                    break;
                case "==":
                    b.boolexp = Integer.parseInt(a2) == Integer.parseInt(a4);
                    b.type= "bool";
                    break;
                case "!=":
                    b.boolexp = Integer.parseInt(a2) != Integer.parseInt(a4);
                    b.type= "bool";
                    break;
            }
        }

        else{
            //System.out.println(Boolean.parseBoolean(a2)+" "+Boolean.parseBoolean(a4));
                switch (a3) {
                    case ("&&"):
                        b.boolexp = Boolean.parseBoolean(a2) && Boolean.parseBoolean(a4);
                        b.type= "bool";
                        break;

                    case "||":
                        b.boolexp = Boolean.parseBoolean(a2) || Boolean.parseBoolean(a4);
                        b.type= "bool";
                        break;

                    case "==":
                        b.boolexp = Boolean.parseBoolean(a2) == Boolean.parseBoolean(a4);
                        b.type= "bool";
                        break;

                    case "!=":
                        b.boolexp = Boolean.parseBoolean(a2) != Boolean.parseBoolean(a4);
                        b.type= "bool";
                        break;

                }
            }




        int check = checkexpname(a1,test);
        int m= 0;

        if (check >=  0){
            test[check]= b;
        }else {
            while (test[m] != null) {
                m++;
            }
            test[m] = b;
        }

    }
    public void unexpr(String a1, String a2 , String a3, Simple[] test) {
        //code here
        Simple c = new Simple();
        int i;
        boolean b;
        c.expName = a1;
        c.uop = a2;


        //System.out.println(a1+" "+a3);
        for(int j = 0 ; j<test.length;j++){

            if(test[j]!=null){
                if ((a3.equals(test[j].expName))&&(test[j].type.equals("int"))){
                    i = test[j].intexp;
                    a3 = String.valueOf(i);

                }
                if ((a3.equals(test[j].expName))&&(test[j].type.equals("bool"))){
                    b =  test[j].boolexp;
                    a3 = String.valueOf(b);

                }
            }
        }
        //System.out.println(a1+" "+a3);

        if (isNumeric(a3)) {
            c.type = "int";
            switch (a2) {
                case "#":
                    c.intexp = Integer.parseInt(a3);
                    break;
                case "~":
                    c.intexp = - (Integer.parseInt(a3));
            }
        }

        else{
            c.type = "bool";
            if (a2.equals("!")){ c.boolexp = !(Boolean.parseBoolean(a3));}

        }
        //System.out.println(c.boolexp+" int "+ c.intexp);
        int check = checkexpname(a1, test);
        int m= 0;
        if (check >=  0){
            test[check]= c;
        }else {
            while (test[m] != null) {
                m++;
            }
            test[m] = c;
        }
    }
    public void assign(String a2 , String a3, Simple[] test){
        int x=0;
        boolean  bo = false;
        if (isNumeric(a3)){
            x= Integer.parseInt(a3);
        }
        else{
            if (a3.equals("true") || a3.equals("false")) {
                bo = Boolean.parseBoolean(a3);
            }
        }

        for (int a = 0 ; a < test.length; a++){
            if  (test[a]!=null) {
                if (a3.equals(test[a].expName) && test[a].type.equals("int")) {
                     x = test[a].intexp;
                }
                if (a3.equals(test[a].expName) && test[a].type.equals("bool")){
                    bo = test[a].bool;
                }
            }
        }
        for (int i = 0 ; i< test.length;i++){
            if  (test[i]!=null){
                if (a2.equals(test[i].varName) && test[i].type.equals("int") ){
                    test[i].integer  = x;
                    //System.out.println(x);
                }
                if (a2.equals(test[i].varName) && test[i].type.equals("bool") ){
                    test[i].bool= bo;
                    //System.out.println(bo);
                }
            }
        }
    }

    public boolean getbool(String expn,Simple[] test) {
        for (int x = 0; x < test.length; x++) {
            if (test[x] != null) {
                if(test[x].varName!= null) {
                    if (test[x].varName.equals(expn)) {
                        return test[x].bool;
                    }
                }
                if( test[x].expName!=null) {
                    if (test[x].expName.equals(expn)) {
                        return test[x].boolexp;
                    }
                }
            }
        }
        return false;
    }

    public void getname(String expn,Simple[] test) {
        for (int x = 0; x < test.length; x++) {
            if (test[x] != null) {
                if (test[x].varName != null) {
                    if ((test[x].varName.equals(expn)) && (test[x].type.equals("int"))) {
                        String output = "["+test[x].integer+"] ";
                        System.out.println(output);
                    }
                    if ((test[x].varName.equals(expn)) && (test[x].type.equals("bool"))) {
                        String output =  "["+ test[x].bool+"] ";
                        System.out.println(output);
                    }
                }
            }

        }
    }
}

