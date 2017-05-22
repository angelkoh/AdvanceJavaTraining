package Module7;

import com.sun.org.apache.bcel.internal.generic.LOR;

import java.io.*;
import java.util.stream.IntStream;

/**
 * Created by Angel on 18/5/2017.
 */
public class InputOutputStreamExample {

    public static final String LORUM_IPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public static void main(String[] arg) {

        //writing a file in binary
        try (
                FileOutputStream fos = new FileOutputStream("files/text1.txt");
                FileInputStream fis = new FileInputStream("files/flower.jpg");
                FileOutputStream fos2 = new FileOutputStream("files/flower2.jpg");
        ) {

            fos.write(LORUM_IPSUM.getBytes()); // writes a stream into text1

            byte[] byte1000 = new byte[1000];

            int len = 0;
            while (fis.available() > 0) {
                int l = fis.read(byte1000, 0, byte1000.length);
                IntStream.range(0, l).forEach(r -> print("" + (char) byte1000[r]));
                len += l;

                fos2.write(byte1000, 0, l);
            }
            print("\nRead: len=" + len);
            print("\n" + byte1000);

            fos2.write("\n\nsome secret text".getBytes());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void print(String s) {
        System.out.print(s);
    }
}
