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

    public Simple vardef(String[] a) {
        //code here
        Simple k = new Simple();
        k.lab = a[1];
        k.type = a[2];//only "bool", "int" allowed
        k.varName = a[3];
        if (k.type.equals("bool"))
            k.bool = Boolean.parseBoolean(a[4]);
        else if (k.type.equals("int")) {
            int n = Integer.parseInt(a[4]);
            k.integer = n > 99999 ? 99999 : n < -99999 ? -99999 : n;
        }
        return k;
    }
        public Simple binexpr(String a1,String a2 ,String a3,String a4, Simple test[]) {
        //code here

        Simple b = new Simple();
        int i2,i4;
        boolean b2,b4;
        b.boolexp = false;

        b.expName = a1;
        /*
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
        */




        b.bop = a3;
        System.out.println(a2+" "+a3+" "+a4);
        System.out.println(isNumeric(a2));
        System.out.println(isNumeric(a4));
        //check a[2], a[4] whether is variables
        //if expref1 and expref2 are int {
        if (((isNumeric(a2))) && (isNumeric(a4))) {  //a2 a4 are integers
            int x = (Integer.parseInt(a2));
            int y = Integer.parseInt(a4);

            switch (a3) {
                case "+":
                    b.intexp = x + y;
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
    public void unexpr(String[] a) {
        //code here
        Simple c = new Simple();
        c.expName = a[1];
        c.uop = a[2];
        //if expref1 is int{
        switch(bop){
            case "#": ;
            case "~": ;
        }

        //if expref1 is bool{
        switch (bop){
            case "!": ;
        }
        c.expref1 = a[3];
        System.out.println("unexpr variable");
    }

}




        b.bop = a3;

        //check a[2], a[4] whether is variables
        //if expref1 and expref2 are int {
        if ((isNumeric(a2))&&isNumeric(a4)) {  //a2 a4 are integers
            switch (b.bop) {
                case "+": b.intexp =Integer.parseInt(a2) + Integer.parseInt(a4);
                case "-": b.intexp =Integer.parseInt(a2) - Integer.parseInt(a4);
                case "*": b.intexp =Integer.parseInt(a2) * Integer.parseInt(a4);
                case "/": b.intexp =Integer.parseInt(a2) / Integer.parseInt(a4);
                case ">": b.boolexp = Integer.parseInt(a2) > Integer.parseInt(a4);
                case ">=": b.boolexp= Integer.parseInt(a2) >= Integer.parseInt(a4);
                case "<": b.boolexp= Integer.parseInt(a2) < Integer.parseInt(a4);
                case "<=": b.boolexp= Integer.parseInt(a2) <= Integer.parseInt(a4);
                case "==": b.boolexp= Integer.parseInt(a2) == Integer.parseInt(a4);
                case "!=": b.boolexp= Integer.parseInt(a2) != Integer.parseInt(a4);
            }
        }

        else {
            switch (b.bop) {
                case "&&": b.boolexp = Boolean.parseBoolean(a2) && Boolean.parseBoolean(a4);

                case "||": b.boolexp = Boolean.parseBoolean(a2) || Boolean.parseBoolean(a4);

                case "==": b.boolexp= Boolean.parseBoolean(a2) == Boolean.parseBoolean(a4);

                case "!=": b.boolexp = Boolean.parseBoolean(a2) != Boolean.parseBoolean(a4);

            }
        }


        return b;

    }

    
    public void unexpr(String[] a) {
        //code here
        Simple c = new Simple();
        c.expName = a[1];
        c.uop = a[2];
        //if expref1 is int{
            switch(bop){
                case "#": ;
                case "~": ;
            }

            //if expref1 is bool{
            switch(bop){
                case "!": ;
            }
        c.expref1 = a[3];
        System.out.println("unexpr variable");
    }

}
