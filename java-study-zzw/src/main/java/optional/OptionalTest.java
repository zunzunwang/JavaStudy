package optional;

import java.util.Optional;

/**
 * Created by zunzunwang
 * Date: 24/06/2022
 */
public class OptionalTest {
    public Integer count;

    public OptionalTest(){
        this.count = 0;
    }

    private Integer m(String name) {
        System.out.println("methode is called: " + name);
        System.out.println(this.count);
        return this.count++;
    }

    private Integer m2() {
        return count++;
    }

    public static void main(String[] args){
        OptionalTest opt = new OptionalTest();
        Integer integerNull = null;
        Integer i1 = 1;
        Optional<Integer> optNull;

        //Constructor: of() ofNullable()
        Optional<Integer> optI1 = Optional.ofNullable(i1);
        //optNull = Optional.of(integerNull); //exception NullPointerException
        optNull = Optional.ofNullable(integerNull);

        //Check ifPresent
        optNull.isPresent();
        System.out.println(optI1.isPresent());

        //ifPresent
        optI1.ifPresent((value) -> {System.out.println(value);});//not accept return});

        //getValue throw exception if null;
        Integer i = optI1.get();

        //System.out.println(optNull.get()); if null No value present.

        /**
         * Difference between orElse() and orElseGet()
         * orElse doesn't support the lambda. always run.
         * orElseGet support supplier lambda. only empty run.
         */
        System.out.println(optNull.orElse(new Integer(0)));
        System.out.println("orElse return: " + optI1.orElse(opt.m("orElse")));//show I1 value;
        System.out.println("count: " + opt.count);//the m function is always run

        //orElseGet()
        System.out.println( "orElseGet return: " + optNull.orElseGet(() -> opt.m("orElseGet")));
        System.out.println("count: " + opt.count);

        //orElseThrow();
        try {
            optNull.orElseThrow(() -> new Exception("hehe"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //map
        System.out.println( "map return: " + optI1.map((value) -> value*2));

        //flatMap will not encapsule of the result
        System.out.println( "map return: " + optI1.flatMap((value) -> Optional.ofNullable(value*2)));

        //filter
        System.out.println( "map return: " + optI1.filter((value) -> value > 5));

        /**
         * public String getCity(User user) throws Exception{
         *     return Optional.ofNullable(user)
         *                    .map(u-> u.getAddress())
         *                    .map(a->a.getCity())
         *                    .orElseThrow(()->new Exception("取指错误"));
         * }
         */
    }
}
