package exception;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by zunzunwang
 * Date: 27/06/2022
 */
public class ExceptionTest {
    /**
     * Throwable
     * -Exception
     *
     * -Error
     *
     * 除了RuntimeException + (sous class) 和 Error + (sous class) 其余都是 checkedException.
     * 两种都应该捕获
     *
     *
     *
     */

    public static void main(String[] args) {
        //public class Exception extends Throwable
        Exception exception = new Exception();

        //CheckedException
        IOException ioException = new IOException();
        SQLException sqlException = new SQLException();


        /**
         * RuntimeException
         */
        //空指针
        NullPointerException nullPointerException = new NullPointerException();

        //数组越界
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();

        //非法参数异常
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();

        //数组长度为负异常
        NegativeArraySizeException negativeArraySizeException = new NegativeArraySizeException();

        //非法状态异常
        IllegalStateException illegalStateException = new IllegalStateException();

        //类型转换异常
        ClassCastException classCastException = new ClassCastException();

        /**
         * CheckedException
         */
        //该类没有指定名称
        NoSuchFieldException noSuchFieldException = new NoSuchFieldException();

        //没有指定方法
        NoSuchMethodException noSuchMethodException = new NoSuchMethodException();

        //不允许访问某个类
        IllegalAccessException illegalAccessException = new IllegalAccessException();

        //类没有找到抛出异常
        ClassNotFoundException classNotFoundException = new ClassNotFoundException();











        //public class Error extends Throwable
        Error error = new Error();



    }

}
