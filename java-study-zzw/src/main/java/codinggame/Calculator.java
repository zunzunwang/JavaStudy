package codinggame;

import java.math.BigDecimal;

public class Calculator {

    static String sum(String... numbers){
        BigDecimal total = new BigDecimal(0);
        for(String number:numbers){
            total = total.add(new BigDecimal(number));
        }
        return String.valueOf(total.floatValue());
    }

    static String sum1(String... numbers){
        BigDecimal total = new BigDecimal(0);
        for (String number: numbers) {
            total = total.add(new BigDecimal(number));
        }

        return String.valueOf(total.floatValue());
    }

    public static void main(String[] args){

        System.out.println(Calculator.sum("99.35", "1.10"));
        System.out.println(Calculator.sum1("99.35", "1.10"));
    }
}
