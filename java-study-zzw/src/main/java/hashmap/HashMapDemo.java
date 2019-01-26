package hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HashMapDemo {


    /**
     * Hash new 的时候并没有在对内存里开辟空间，指定了DEFAULT_LOAD_FACTOR = 0.75。
     */
    public static void main(String args[]) throws Exception {

        final int max = Integer.MAX_VALUE >>> 4;
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 20; i++) {
            int hash = random.nextInt(max) << 4;
            int betterHash = hash ^ (hash >>> 16);
            System.out.print(toBinaryString(hash));
            System.out.println(" --> " + toBinaryString(betterHash));
        }
    }

    //将整数转换为二进制字符串，高位补0
    final static char[] digits = {'0', '1'};

    static String toBinaryString(int i) {
        char[] buf = new char[32];
        int pos = 32;
        int mask = 1;
        do {
            buf[--pos] = digits[i & mask];
            i >>>= 1;
        } while (pos > 0);
        return new String(buf, pos, 32);
    }
}
