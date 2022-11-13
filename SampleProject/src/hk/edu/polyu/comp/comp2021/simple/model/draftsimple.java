    public class Simple {

        private String lab, type, varName;

        private boolean bool;

        private int integer;
        private String expName,bop,expref1,expref2;



        public Simple() {
        }
        public String getvarname(){
            return this.varName;
        }
        public String gettype(){
            return this.type;
        };
        public int getint(){
            return this.integer;
        };
        public boolean getbool(){
            return this.bool;
        };


        public Simple vardef(String a1,String a2,String a3,String a4) {
            //code here
            Simple k = new Simple();
            k.lab = a1;
            k.type = a2;//only "bool", "int" allowed
            k.varName = a3;
            //check a[3] whether violate rules
            //check a[4] whether variables
            //if yes convert a[4] varName to data

            if (k.type.equals("bool"))
                k.bool = Boolean.parseBoolean(a4);
            else if (k.type.equals("int")) {
                int n = Integer.parseInt(a4);
                k.integer = n > 99999 ? 99999 : n < -99999 ? -99999 : n;
            }
            return k;
        }

        public Simple binexpr(String a1,String a2 ,String a3,String a4) {
            //code here
            Simple b = new Simple();
            int result;
            boolean bolresult;
            b.expName = a1;'

            b.expref1 = a2;
            b.bop = a3;
            b.expref2 = a4;
            //check a[2], a[4] whether is variables
            //if expref1 and expref2 are int {
            if (a1.matches("-?\\d+")&& a4.matches("-?\\d+")) {  //a2 a4 are integers
                switch (bop) {
                    case "+":result =Integer.parseInt(a2) + Integer.parseInt(a4);
                    case "-":result =Integer.parseInt(a2) - Integer.parseInt(a4);;
                    case "*":result =Integer.parseInt(a2) * Integer.parseInt(a4);;
                    case "/":result =Integer.parseInt(a2) / Integer.parseInt(a4);;
                    case ">": bolresult= Integer.parseInt(a2)>Integer.parseInt(a4);
                    case ">=": bolresult= Integer.parseInt(a2)>=Integer.parseInt(a4);
                    case "<": bolresult= Integer.parseInt(a2)<Integer.parseInt(a4);
                    case "<=": bolresult= Integer.parseInt(a2)<= Integer.parseInt(a4);
                    case "==": bolresult= Integer.parseInt(a2)== Integer.parseInt(a4);
                    case "!=": bolresult= Integer.parseInt(a2)!= Integer.parseInt(a4);
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
