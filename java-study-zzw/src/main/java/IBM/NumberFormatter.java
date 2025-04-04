package IBM;

/**
 * Created by zunzunwang
 * Date: 03/01/2020
 */

import com.ibm.icu.text.NumberFormat;
import com.ibm.icu.text.RuleBasedNumberFormat;

import java.math.BigDecimal;

/**
 * we presume the number contains just two decimal.
 */
public class NumberFormatter {

    public static String numberToString(String numString) {
        //check init condition

        return null;


    }

    public static void main(String[] args) {
        BigDecimal num = new BigDecimal(2700000005.28);
        NumberFormat formatter = new RuleBasedNumberFormat(RuleBasedNumberFormat.SPELLOUT);
        String result = formatter.format(num);
        System.out.println(result);
    }
}
