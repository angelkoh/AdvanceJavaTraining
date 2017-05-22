package Module6;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Angel on 18/5/2017.
 */
public class FileVisitorExample {

    public static void main(String[] arg) {

        //lets create some directories
        Path path1 = Paths.get("files/media");
        Path path2 = Paths.get("files/more media");

        try {
            Files.createDirectories(path1);
            Files.createDirectories(path2);

            //now we can walk through the directory from the root "files"
            MyFileVisitor fileVisitor = new MyFileVisitor();
            Files.walkFileTree(path1.getParent(), fileVisitor);

            //we can monitor file changes also.
            // Delete, Create, Modified
            FileSystem fs = FileSystems.getDefault();
            WatchService ws = fs.newWatchService();

            path1.register(ws,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_MODIFY);


            print("\n\nmonitoring " + path1);
            Thread thread = new Thread(() -> doMonitoring(ws));
            thread.start();

            Scanner scanner = new Scanner(System.in);
            print("Press any key to exit");
            scanner.next(); //blocking while waiting for input
            thread.interrupt();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void doMonitoring(WatchService ws) {
        boolean isInterrupted = false;
        do {
            WatchKey watchKey = null;
            try {
                watchKey = ws.take();
            } catch (InterruptedException e) {
                print("interrupted...");
                isInterrupted = true;
            }
            //get what kind of events
            if (!isInterrupted && watchKey != null){
                if(watchKey.isValid()) {
                    List<WatchEvent<?>> event = watchKey.pollEvents();

                    if (!event.isEmpty()) {
                        WatchEvent we = event.get(event.size() - 1);
                        Path path = (Path) we.context();
                        if (we.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                            print(path + " file is created");
                        } else if (we.kind() == StandardWatchEventKinds.ENTRY_DELETE) {
                            print(path + "  file is deleted");
                        } else if (we.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
                            print(path + "  file is modified");
                        }
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        isInterrupted = true;
                    }

                }
                //always reset the key
                watchKey.reset();
            }


        } while (!isInterrupted);

        print("exiting");

    }

    private static class MyFileVisitor extends SimpleFileVisitor<Path> {
        PathMatcher pattern;

        public MyFileVisitor() {

            //regular expressions and glob (simplified regex)
            FileSystem fs = FileSystems.getDefault();
            pattern = fs.getPathMatcher("glob:**.{txt}");
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            print("previsit dir: " + dir);

            if (pattern.matches(dir)) {
                print(dir + " contains a .txt file");
            }
            return super.preVisitDirectory(dir, attrs);
        }


        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

            // print("    -> file: " + file + " is a file");

            if (pattern.matches(file)) {
                print(file + " is a .txt file");
            } else {
                print(file + " is not a .txt file");
            }

            return super.visitFile(file, attrs);
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            print("postVisit dir: " + dir);
            return super.postVisitDirectory(dir, exc);
        }
    }

    public static void print(String s) {
        System.out.println(s);
    }
}
