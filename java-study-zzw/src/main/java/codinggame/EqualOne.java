package codinggame;

import java.util.HashMap;

public class EqualOne {
    static boolean a(int i, int j){
        if(i == 1 || j == 1 || (i + j ==1)){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String args[]){
        System.out.println(EqualOne.a(1, 5));
        System.out.println(EqualOne.a(2, 3));
        System.out.println(EqualOne.a(-3, 4));

        String s = "A";
        s.toLowerCase();
        System.out.println(s);

        HashMap m = new HashMap<>();
        Object o1 = new Object();
        Object o2 = o1;
        m.put(o1, 1);
        m.put(o2, 2);
        System.out.println(m.get(o1));
    }
}
