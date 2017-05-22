package Module8;

/**
 * Created by Angel on 17/5/2017.
 */
public class ThreadExample {

    private static Integer counter = 0; //some shared resource

    public static void main(String[] args) throws InterruptedException {


        //Runnable Example
        Thread t1 = new Thread(new RunnableClass("a"));
        Thread t2 = new Thread(new RunnableClass("b"));
        t1.start();
        t2.start();

        ThreadClass t3 = new ThreadClass("c");
        ThreadClass t4 = new ThreadClass("d");
        t3.start();
        t4.start();

        Thread.sleep(2000);
        String s = "Interrupting...";
        print(s);

        t1.interrupt();
        t2.interrupt();
        t3.interrupt();
        t4.interrupt();

        //Increment example - anonnymous
        new Thread(new Runnable() {
            @Override
            public void run() {
                doMethod("A");
            }
        }).start();

        new Thread(() -> doMethod("B")).start();
        new Thread(() -> doMethod("C")).start();


    }

    //synchronized  // what happens with this uncommented?
    public static void doMethod(String id) {
        while (counter < 100) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // do nothing
            }
            if(counter <100) {
                //synchronized ("tag") { //what happens with this uncommented?
                    String s = id + ") " + counter++;
                //}
                print(s);
            }
        }
    }

    private static void print(String s) {
        System.out.println(s);
    }
}
