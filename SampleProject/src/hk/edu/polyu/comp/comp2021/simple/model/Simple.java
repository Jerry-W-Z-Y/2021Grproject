package hk.edu.polyu.comp.comp2021.simple.model;

public class Simple {

    private String lab, type, varName;
    private boolean bool;
    private int integer;

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
    public void binexpr(String[] a) {
        //code here
        System.out.println("binexpr variable");
    }
    public void unexpr(String[] a) {
        //code here
        System.out.println("unexpr variable");
    }

}
