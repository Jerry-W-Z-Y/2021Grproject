package hk.edu.polyu.comp.comp2021.simple.model;

public class Simple {
    
    private String lab, type, varName;
    private boolean bool,boolexp;
    private int integer, intexp;
    
    private String expName,bop,uop,expref1,expref2;
    
    
   public static boolean isNumeric(String string) {
        int intValue;

        if(string == null || string.equals("")) {
            return false;
        }
        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
        }
        return false;
    }
    

    public Simple() {
    }
    public Simple(String[] a) {
        this.lab = a[1];
        this.type = a[2];//only "bool", "int" allowed
        this.varName = a[3];
        if (this.type.equals("bool"))
            this.bool = Boolean.parseBoolean(a[4]);
        else if (this.type.equals("int")) {
            int n = Integer.parseInt(a[4]);
            this.integer = n > 99999 ? 99999 : n < -99999 ? -99999 : n;
        }
    }

    public Simple binexpr(String a1,String a2 ,String a3,String a4, Simple test[]) {
        //code here

        Simple b = new Simple();
        int i2,i4;
        boolean b2,b4;
        b.boolexp = false;

        b.expName = a1;

        for(int i = 0 ; i<test.length;i++){

            if(test[i]!=null){
                if ((a2.equals(test[i].varName))&&(test[i].type.equals("int"))){
                    i2 = test[i].integer;
                    a2 = String.valueOf(i2);

                }
                if ((a4.equals(test[i].varName))&&(test[i].type.equals("bool"))){
                    b2=  test[i].bool;
                    a2 = String.valueOf(b2);

                }
            }
        }
        for(int i = 0 ; i<test.length;i++){
            if(test[i]!=null){
            if ((a4.equals(test[i].varName))&&(test[i].type.equals("int"))){
                i4 = test[i].integer;
                a4 = String.valueOf(i4);

            }
                if ((a4.equals(test[i].varName))&&(test[i].type.equals("bool"))){
                b4=  test[i].bool;
                a4= String.valueOf(b4);

            }
            }
        }





        b.bop = a3;
        System.out.println(a2+" "+a3+" "+a4);
        System.out.println(isNumeric(a2));
        System.out.println(isNumeric(a4));
        //check a[2], a[4] whether is variables
        //if expref1 and expref2 are int {
        if (((isNumeric(a2))) && (isNumeric(a4))) {  //a2 a4 are integers


            switch (a3) {
                case "+":
                    b.intexp = Integer.parseInt(a2) + Integer.parseInt(a4);
                    break;
                case "-":
                    b.intexp = Integer.parseInt(a2) - Integer.parseInt(a4);
                    break;
                case "*":
                    b.intexp = Integer.parseInt(a2) * Integer.parseInt(a4);
                    break;
                case "/":
                    b.intexp = Integer.parseInt(a2) / Integer.parseInt(a4);
                    break;
                case "%" :
                    b.intexp =  Integer.parseInt(a2) % Integer.parseInt(a4);
                        break;
                case ">":
                    b.boolexp = Integer.parseInt(a2) > Integer.parseInt(a4);
                    break;
                case ">=":
                    b.boolexp = Integer.parseInt(a2) >= Integer.parseInt(a4);
                    break;
                case "<":
                    b.boolexp = Integer.parseInt(a2) < Integer.parseInt(a4);
                    break;
                case "<=":
                    b.boolexp = Integer.parseInt(a2) <= Integer.parseInt(a4);
                    break;
                case "==":
                    b.boolexp = Integer.parseInt(a2) == Integer.parseInt(a4);
                    break;
                case "!=":
                    b.boolexp = Integer.parseInt(a2) != Integer.parseInt(a4);
                    break;
            }
        }

        else{
            System.out.println(Boolean.parseBoolean(a2)+" "+Boolean.parseBoolean(a4));
                switch (a3) {
                    case ("&&"):
                        b.boolexp = Boolean.parseBoolean(a2) && Boolean.parseBoolean(a4);
                        break;

                    case "||":
                        b.boolexp = Boolean.parseBoolean(a2) || Boolean.parseBoolean(a4);
                        break;

                    case "==":
                        b.boolexp = Boolean.parseBoolean(a2) == Boolean.parseBoolean(a4);
                        break;

                    case "!=":
                        b.boolexp = Boolean.parseBoolean(a2) != Boolean.parseBoolean(a4);
                        break;

                }
            }


        System.out.println(b.boolexp+" int "+ b.intexp);
        return b;

    }
    public Simple unexpr(String a1, String a2 , String a3, Simple[] test) {
        //code here
        Simple c = new Simple();
        int i;
        boolean b;
        c.expName = a1;
        c.uop = a2;
        c.expref1 = a3;

        for(int j = 0 ; j<test.length;j++){

            if(test[j]!=null){
                if ((a2.equals(test[j].varName))&&(test[j].type.equals("int"))){
                    i = test[i].integer;
                    a2 = String.valueOf(i);

                }
                if ((a2.equals(test[j].varName))&&(test[j].type.equals("bool"))){
                    b =  test[i].bool;
                    a2 = String.valueOf(b);

                }
            }
        }

        if (isNumeric(a2)) {
            switch (a3) {
                case "#":
                    c.intexp = Integer.parseInt(a2);
                    break;
                case "~":
                    c.intexp = - (Integer.parseInt(a2));
            }
        }

        else{
            switch (a3) {
                case "!":
                    c.boolexp = !(Boolean.parseBoolean(a2));
            }
        }
        return c;
    }

}

}
