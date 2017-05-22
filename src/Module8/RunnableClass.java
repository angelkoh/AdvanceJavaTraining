package Module8;

/**
 * Created by Angel on 17/5/2017.
 */
public class RunnableClass implements Runnable {

    String s;
    boolean isInterrupted=false;


    public RunnableClass(String s) {
        this.s = s;
    }

    @Override
    public void run() {
        do {
            try {
                String str = "Runnable " + s + " is running";
                print(str);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                isInterrupted = true;
                print("thread " + s + " is interrupted");
            }


        }while(!isInterrupted);
    }

    private void print(String str) {
        System.out.println(str);
    }


}
