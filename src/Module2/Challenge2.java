package Module2;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Angel on 17/5/2017.
 */
public class Challenge2 {
//    Initialize a static int array with the square value of 1 to 10.
//    Create a member class. Initialize an int array with the square value of 11 to 20.

    static int[] staticIntArray;
    int[] instanceIntArray;

    static {
        staticIntArray = new int[10];
        for (int i = 1; i <= 10; i++) {
            staticIntArray[i - 1] = i * i;
        }
        print("Static array");
        print(staticIntArray);
    }

    {
        instanceIntArray = new int[10];
        IntStream.range(1, 11).forEach(i -> instanceIntArray[i - 1] = (i + 10) * (i + 10));
        print("Instance ARRAY");
        print(instanceIntArray);
    }

    public static void main(String[] arg) {


        new Challenge2();
    }

    public static void print(int[] array) {

        IntStream.range(0, array.length).forEach(i-> print(i+")"+array[i]));



        //position information is lost
        //use this if position is not impt
       //Arrays.stream(array).forEach(r -> print("value: " + r));

        //example to show various features of streams.
//        Arrays.stream(array).filter(r-> r>50).forEach(r -> print("value: " + r));
//
//        print("total of the array is " + Arrays.stream(array).sum());
//        IntStream.range(0, array.length).parallel() .forEach(i-> print(i+")"+array[i]));

    }


    public static void print(String s) {
        System.out.println(s);
    }

}


