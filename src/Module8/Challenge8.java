package Module8;

/**
 * Created by Angel on 18/5/2017.
 */
public class Challenge8 {

    //Create 3 threads and print from 1 to  100.
    //The numbers must not duplicate
    static int number;

    public static void main(String[] arg) {

        //Many ways to do the same thing.
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                doIncrementTillHundred("A");
            }
        });
        Thread b = new Thread(()->doIncrementTillHundred("B")) ;
        Thread c = new IncrementThread("C");

        a.start();
        b.start();
        c.start();
    }

    //synchronized //...other thread may not have opportunity to run
    private static void doIncrementTillHundred(String name) {
        boolean isInterrupted = false;
        while (number < 100 && !isInterrupted) {

            synchronized ("refKey") {
                //need another number check here...
                number++;
                print(name + ") " + number);
            }

            try {
                Thread.sleep(100); //add delay to increase likely hood of race condition.
            } catch (InterruptedException e) {
                isInterrupted = true;
            }
        }
    }

    private static void print(String s) {
        System.out.println(s);
    }


    private static class IncrementThread extends Thread {
        private final String threadName;

        public IncrementThread(String name) {
            this.threadName = name;
        }

        @Override
        public void run() {
            doIncrementTillHundred(threadName);
        }
    }
}
