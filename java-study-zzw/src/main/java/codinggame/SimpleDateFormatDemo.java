package codinggame;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * http://tutorials.jenkov.com/java-internationalization/simpledateformat.html
 */
public class SimpleDateFormatDemo {

    public static void main(String[] args){
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String date = simpleDateFormat.format(new Date());
        System.out.println(date);

        try {
            Date date2 = simpleDateFormat.parse("2018-09-09");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
