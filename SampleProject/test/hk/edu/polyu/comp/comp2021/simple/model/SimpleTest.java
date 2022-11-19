package hk.edu.polyu.comp.comp2021.simple.model;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleTest {
    final int MAX_INT = 99999;
    final int MIN_INT = 99999;


    String command1 = "vardef hh int x 3423";
    String command1_1 = "vardef hg int max 666666";
    String command2 = "vardef vardef2 int y 3";
    String command2_1 = "vardef vardef21 bool z true";
    String command2_2 = "vardef vardef22 bool k false";

    String command3 = "unexpr exp2 ~ 10269";
    String command4 = "binexpr bb x * y";
    String command4_1 = "binexpr cc z && k";
    String command4_2 = "binexpr dd z != k";

    String command5 = "binexpr exp1 3423 * 3 ";
    String command6 = "assign assign1 y uu";
    String command7 = "print print1 aa";
    String command8 = "skip skip1";
    String command9 = "block block1 hh vardef2 bb uu print1";
    String command10 = "if if1 exp5 block1 print1";
    String command11 = "while while1 vardef21 block1";
    String command12 = "program program1 while1";
    String command13 = "list program1";
    String command14 = "store program1 d:/prog1.simple";
    String command15 = "load d:/nprog1.simple program1";

    String command16 = "quit";

    String command17 = "execute program1";



    public Simple[] prepare() {
        Simple a = new Simple(command1.split(" "));
        Simple b = new Simple(command2.split(" "));

        Simple c = new Simple(command2_1.split(" "));
        Simple d = new Simple(command2_2.split(" "));

        Simple e = new Simple(command3.split(" "));
        Simple f = new Simple(command4.split(" "));

        Simple[] all = {a, b, c, d, e, f};
        return all;
    }

    @Test
    public void testSimpleConstructor(){
        Simple s = new Simple();
        assert true;
    }
    @Test
    public void testvardef() {
        String[] test = command1.split(" ");
        Simple t = new Simple(test);

        assertEquals(test[3], t.vardef(test).getVarName());
        assertEquals(test[2], t.vardef(test).getexptype());
        assertEquals(Integer.parseInt(test[4]), t.vardef(test).getInt());

        String[]test1 = command1_1.split(" ");
        assertEquals(MAX_INT, t.vardef(test1).getInt());
        assertEquals(MIN_INT, t.vardef(test1).getInt());
    }

    @Test
    public void testvardef2() {
        String[] test = command2.split(" ");
        Simple t = new Simple(test);
        assertEquals(test[3], t.vardef(test).getVarName());
        assertEquals(test[2], t.vardef(test).getexptype());
        assertEquals(Integer.parseInt(test[4]), t.vardef(test).getInt());

        String[]test1 = command2_1.split(" ");
        assertEquals(test1[3], t.vardef(test1).getVarName());
        test1 = command2_2.split(" ");
        assertFalse(t.vardef(test1).getboolean());
    }

    @Test
    public void testbinexpr() {
        String[] test = command5.split(" ");

        Simple t = new Simple();
        Simple[] all = new Simple[100];

        t.binexpr(test[1], test[2], test[3], test[4], all);
        assertEquals(10269, all[0].getexpint());
    }
    @Test
    public void testunexpr() {
        String[] test = command3.split(" ");
        Simple t = new Simple();
        Simple[] all1 = new Simple[100];
        t.unexpr(test[1], test[2], test[3], all1);
        assertEquals(-10269, all1[0].getexpint());
    }

}
