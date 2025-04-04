package codinggame;

import java.util.Random;

/**
 * Created by zunzunwang
 * Date: 08/06/2022
 */
public class RandomTest {



    public static void main(String[] args) {
        //use Math.random(); 底层用的就是random类。
        int up = 20;
        int down = 10;
        //  0 <= r < 1
        Double r;
        // here range = 11
        int range = (up - down) + 1;
        int result;
        for (int i = 0; i < 10; i++) {
            r = Math.random();
            result = (int) (r * range) + down;
            System.out.println(result);
        }


        //use class Random
        Random rd = new Random();
        for (int i = 0; i< 10; i++) {
            System.out.println(rd.nextInt(10));
        }

    }
}
