package Module5;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Angel on 17/5/2017.
 */
public class Challenge5 {
//    Use Scanner to read 1st Integer
//    Implement exception in while loop until a positive integer is entered
//
//    Use Scanner to read 2nd Integer and divide 1st integer with 2nd integer
//    Catch arithmetic exception if divide by zero.
//    In the handling of the first exception, divide 2nd integer with 1st integer and throw a customized exception.
//    Finally print out the result

    public static void main(String[] arg) {

        boolean inputOk = true;
        int integer1 = 0;
        int integer2 = 0;

        do {
            try {
                integer1 = getIntegerFromSystem("Enter first Number:");
                inputOk =true;
            } catch (InputMismatchException e) {
                print("Not a number. Try again");
                inputOk =false;
            }
        } while (!inputOk);

        do {
            try {
                integer2 = getIntegerFromSystem("Enter Second Number:");
                inputOk =true;

                if (integer2 == 0) {
                    throw (new DividerIsZeroException("integer 2 is zero"));
                }
            } catch (InputMismatchException e) {
                print("Not a number. Try again: "+e.getMessage());
                inputOk =false;
            } catch (DividerIsZeroException e) {
                print("custom div0. Try again: "+e.getMessage());
                inputOk =false;
            }
        } while (!inputOk);

        int result = integer1 / integer2;
        print(integer1 + " / " + integer2 + " =(int) " + result);
    }


    static int getIntegerFromSystem(String prompt) {
        print(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static void print(String prompt) {
        System.out.println(prompt);
    }

    private static class DividerIsZeroException extends Throwable {
        public DividerIsZeroException(String s) {
            super(s);
        }
    }
}
