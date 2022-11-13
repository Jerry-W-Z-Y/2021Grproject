package hk.edu.polyu.comp.comp2021.simple.model;

public class Simple {

    private String lab, type, varName;
    private boolean bool;
    private int integer;
    
    private String expName,bop,uop,expref1,expref2;

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
        public Simple binexpr(String a1,String a2 ,String a3,String a4, Simple test) {
            //code here
            Simple b = new Simple();
            int result;
            boolean bolresult;
            b.expName = a1;
            if (test.varName.equals("test123")) {
                System.out.println("the test is success");
                return test;
            }
            b.expref1 = a2;
            b.bop = a3;
            b.expref2 = a4;
            //check a[2], a[4] whether is variables
            //if expref1 and expref2 are int {
            if (a1.matches("-?\\d+")&& a4.matches("-?\\d+")) {  //a2 a4 are integers
                switch (bop) {
                    case "+": result =Integer.parseInt(a2) + Integer.parseInt(a4);
                    case "-": result =Integer.parseInt(a2) - Integer.parseInt(a4);
                    case "*": result =Integer.parseInt(a2) * Integer.parseInt(a4);
                    case "/": result =Integer.parseInt(a2) / Integer.parseInt(a4);
                    case ">": bolresult= Integer.parseInt(a2) > Integer.parseInt(a4);
                    case ">=": bolresult= Integer.parseInt(a2) >= Integer.parseInt(a4);
                    case "<": bolresult= Integer.parseInt(a2) < Integer.parseInt(a4);
                    case "<=": bolresult= Integer.parseInt(a2) <= Integer.parseInt(a4);
                    case "==": bolresult= Integer.parseInt(a2) == Integer.parseInt(a4);
                    case "!=": bolresult= Integer.parseInt(a2) != Integer.parseInt(a4);
                }
            }

            else {
                switch (bop) {
                    case "&&": bolresult = Boolean.parseBoolean(a2) && Boolean.parseBoolean(a4);

                    case "||": bolresult = Boolean.parseBoolean(a2) || Boolean.parseBoolean(a4);

                    case "==": bolresult = Boolean.parseBoolean(a2) == Boolean.parseBoolean(a4);

                    case "!=": bolresult = Boolean.parseBoolean(a2) != Boolean.parseBoolean(a4);

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
