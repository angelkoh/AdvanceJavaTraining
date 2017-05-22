package Module5;

import java.io.*;

/**
 * Created by Angel on 17/5/2017.
 */
public class FinallyExample {

    //Finally is used to clean up resources when an unrecoverable exception occurs
    // e.g. file streams & channels, databases, cursors, video streams

    public static void main(String[] arg) {

        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader("files/myFile.txt");
            br = new BufferedReader(fr);

            print("Opened filed myFile.txt");
        } catch (FileNotFoundException e) {
            print("Error opening file: " + e.getMessage());
        } finally {
            closeSilently(fr);
            closeSilently(br);
        }

        //we can also use the try with resource to let system close it for us.
        try (
                FileReader fr1 = new FileReader("files/myFile.txt");
                BufferedReader br1 = new BufferedReader(fr);
        ) {
            print("Opened filed myFile.txt");
        } catch (IOException e) {
            print("Error opening file: " + e.getMessage());
        }
    }

    private static void print(String s) {
        System.out.println(s);
    }

    private static void closeSilently(Reader fr) {
        if (fr != null) {
            try {
                fr.close();
                print("closed reader");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
