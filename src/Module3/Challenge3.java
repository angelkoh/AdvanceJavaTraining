package Module3;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by Angel on 17/5/2017.
 */
public class Challenge3 {
    //Inspect and print out the methods and fields of the String Class

    public static void main(String[] arg) {
        String s ="";

        //you can either call
        Class c1 = s.getClass();
        //or
        Class c2 = String.class;

        Method[] methods = c1.getMethods();
        Field[] fields = c2.getFields();

        StringBuilder methodsSb = new StringBuilder("Methods: ");
        StringBuilder fieldsSb = new StringBuilder("Fields: ");

        //loop through
        Arrays.stream(methods).forEach(r-> methodsSb.append(r.toString()).append("\n"));
        Arrays.stream(fields).forEach(r-> fieldsSb.append(r.toString()).append(" "));

        print("-- String METHODS --");
        print(methodsSb.toString());
        print("-- String FIELDS --");
        print(fieldsSb.toString());
    }

    private static void print(String s) {
        System.out.println(s);
    }

}
