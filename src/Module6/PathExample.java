package Module6;

import Module3.ParentClass;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by Angel on 18/5/2017.
 */
public class PathExample {

    public static final String LORUM_IPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public static void main(String[] arg) {

        //Exploring path
        Path path = Paths.get("files/text file/file.txt");
        print(path.toString());
        print("absolute path=" + path.toAbsolutePath());
        print("path depth = " + path.getNameCount());
        print("filename = " + path.getFileName());

        try {
            if (!Files.exists(path)) {
                Files.createDirectories(path.getParent());
                Files.createFile(path);
            }

            //can write to file also
            FileWriter fw = new FileWriter(path.toFile());
            fw.write(LORUM_IPSUM);
            fw.close();

            //if you write to this file multiple times, use BufferedWriter
            BufferedWriter bw = new BufferedWriter(new FileWriter(path.toFile()));
            IntStream.range(0, 11).forEach(r -> {
                try {
                    bw.append((r + 1) + ") ").append(LORUM_IPSUM).append("\n\n");
                } catch (IOException e) {
                    print("write Error:" + e);
                }
            });
            bw.close();

            Path destination = Paths.get(path.getParent().toString(), "destination.txt");
            Files.copy(path, destination, StandardCopyOption.REPLACE_EXISTING);


            //read 5 sentences from console + write to file.
            print("Enter 5 sentences");
            BufferedWriter bw2 = new BufferedWriter(new FileWriter(path.toFile()));
            Scanner scanner = new Scanner(System.in);
            IntStream.range(0, 5).forEach(
                    r -> {
                        print("Enter line " + r);
                        try {
                            bw2.append((r + 1) + ") " + scanner.nextLine()+"\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
            );
            bw2.close();
            scanner.close();


        } catch (IOException e) {
            print("Error: " + e);
        }


    }

    private static void print(String s) {
        System.out.println(s);
    }
}
