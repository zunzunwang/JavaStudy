package wrapper;

import java.math.BigDecimal;

/**
 * Created by zunzunwang
 * Date: 09/06/2022
 */
public class DoubleTest {
    //Double Float are always new Object.
    public static void main(String[] args) {
        System.out.println("/****************************** Question 1 *********************************/");
        Double d1 = 100.00;
        Double d2 = 100.00;
        System.out.println(d1 == d2);//false autoboxing always new Double();

        System.out.println("/****************************** Question 6  *********************************/");
        //正确的计算小数
        /**
         * https://www.cnblogs.com/wunsiang/p/12811661.html
         */
        float price1 = 10.9f;
        double price2 = 5.8;
        int num1 = 2;
        int num2 = 4;
        double res2 = (price1 * num1 + price2 * num2);
        System.out.println("一共付给收银员" + res2 + "元");
        System.out.println(5.8 * 4 - 10.9 * 2);
        System.out.println(2.00 - 1.10);
        //Solution
        BigDecimal bigDecimal = new BigDecimal("0.2");
        BigDecimal bigDecimalDouble = new BigDecimal(0.2);//not correct
        bigDecimalDouble = BigDecimal.valueOf(0.2);//Double.toString(val)
    }

}
