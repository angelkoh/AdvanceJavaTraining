package Module8;

/**
 * Created by Angel on 17/5/2017.
 */
public class ThreadClass extends Thread {

    String s;
    boolean isInterrupted = false;

    public ThreadClass(String s) {
        this.s = s;
    }

    @Override
    public void run() {

        print("Thread " + s + " is running");

        do {
            try {
                sleep(1000);
                print("doing process " + s);
            } catch (InterruptedException e) {
                print("Sleep Interrupted "+s);
                isInterrupted = true;
            }

        } while (!isInterrupted);
    }

    private void print(String s) {
        System.out.println(s);
    }

    @Override
    public void interrupt() {
        print("Interrupt called for "+s);
        isInterrupted = true;

        super.interrupt();
    }
}
