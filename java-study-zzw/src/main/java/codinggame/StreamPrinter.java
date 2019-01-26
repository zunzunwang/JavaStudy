package codinggame;


import java.io.IOException;
import java.io.Reader;

/**
 * StreamPrinter.print(Reader reader) is not rubust.
 * Improve StreamPrinter.print(Reader reader)
 */
public class StreamPrinter {

    /**
     * Reads from the given reader and print to stdout.
     * http://tutorials.jenkov.com/java-io/io-exception-handling.html
     * http://tutorials.jenkov.com/java-exception-handling/exception-handling-templates.html
     * https://stackoverflow.com/questions/12199142/closing-bufferedreader-and-inputstreamreader
     */
    void print(Reader reader) {
        if (reader != null) {
            try {
                try {
                    int code = reader.read();
                    while (code != -1) {
                        System.out.print((char) code);
                        code = reader.read();
                    }
                } finally {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
