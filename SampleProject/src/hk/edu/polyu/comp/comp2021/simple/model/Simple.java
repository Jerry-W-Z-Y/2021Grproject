package hk.edu.polyu.comp.comp2021.simple.model;

public class Simple {

    private String lab, type, varName;
    private boolean bool;
    private int integer;
    
    private String expName,bop,uop,expref1,expref2;

    public Simple() {
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
    public Simple binexpr(String[] a) {
        //code here
         Simple b = new Simple();
         b.expName = a[1];
         b.expref1 = a[2];
         b.expref2 = a[4];
         b.bop = a[3];
        //if expref1 and expref2 is int {
            switch(bop){
                case "+": ;
                case "-": ;
                case "*": ;
                case "/": ;
                case ">": ;
                case ">=": ;
                case "<": ;
                case "<=": ;
                case "==": ;
                case "!=": ;
            }
         //if expref1 and expref2 is bool {
            switch(bop){
                case "&&": ;
                case "||": ;
                case "==": ;
                case "!=": ;
            }
        
            System.out.println("binexpr variable");
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
