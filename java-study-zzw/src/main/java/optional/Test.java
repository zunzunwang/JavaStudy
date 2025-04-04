package optional;

import java.util.Optional;

/**
 * Created by zunzunwang
 * Date: 24/06/2022
 */
public class Test {
    public Integer count;

    public Test(){
        count = 0;
    }

    public Integer ag(){
        return count++;
    }

    public static void main(String[] args){
        Test t = new Test();
        Optional<Integer> op = Optional.ofNullable(null);
        System.out.println(op.orElse(t.ag()));
        System.out.println(t.count);
        System.out.println(op.orElse(t.ag()));
        System.out.println(t.count);


    }

}
