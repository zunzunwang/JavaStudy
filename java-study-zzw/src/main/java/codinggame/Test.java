package codinggame;

import java.util.ArrayList;

public class Test {
    public static void main(String args[]){
        ArrayList l = new ArrayList(2);
        l.add(l);
        l.add(l);
        l.add(l);
        System.out.println(l.size());
    }
}
