package Module7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

/**
 * Created by Angel on 18/5/2017.
 */
public class FileReadWriteExample {

    public static final String LORUM_IPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";


    public static void main(String[] arg) {

        Path path = Paths.get("files");
        Path source = Paths.get(path.toString(), "source.txt");
        Path destination = Paths.get(path.toString(), "destination.txt");

        //to write a single time, you can use FileWriter
        try (
                FileWriter fw = new FileWriter(source.toFile());
                BufferedWriter bw = new BufferedWriter(new FileWriter(source.toFile(), true))
        ) {

            fw.write(LORUM_IPSUM);
            fw.flush(); // what happens if we don't flush the buffer ?
            IntStream.range(1, 6).forEach(r -> {
                try {
                    String s = r+") "+LORUM_IPSUM;
                    print(s);
                    bw.append("\n\n" + s);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void print(String s) {
        System.out.println(s);
    }


}
