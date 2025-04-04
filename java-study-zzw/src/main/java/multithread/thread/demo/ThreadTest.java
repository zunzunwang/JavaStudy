package multithread.thread.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zunzunwang
 * Date: 19/06/2022
 */

public class ThreadTest {
    private static final Logger logger = LoggerFactory.getLogger(ThreadTest.class);

    public static void main(String[] args){


        logger.trace("test_trace");
        logger.debug("test_debug");
        logger.info("test_info");
        logger.warn("test_warn");
        logger.error("test_error");
        System.out.println("hello");


    }
}
