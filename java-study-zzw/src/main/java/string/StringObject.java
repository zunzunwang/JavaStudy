package string;

/**
 * Created by zunzunwang
 * Date: 23/06/2022
 */
public class StringObject {
    public static void main(String[] args){
        String a1 = "a";
        String param1 = new String("param" + a1);
        //System.out.println(param1 == "parama");
        //param1.intern();
        System.out.println(param1 == "parama");

/*

        String a = "a";
        String param = new String("param") + a;
        System.out.println(param == "parama");
        param.intern();
        System.out.println(param == "parama");
        */






    }
}
