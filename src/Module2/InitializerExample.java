package Module2;

import com.sun.org.apache.bcel.internal.generic.INEG;
import org.omg.PortableInterceptor.INACTIVE;

/**
 * Created by Angel on 17/5/2017.
 */
public class InitializerExample {

    static int staticVar1;

    static {
        String s = "static init called once when app starts";
        print(s);
        staticVar1 = 100;
    }

    int instanceVar1;

    {
        String s = "instance init called every time class in instantiated";
        print(s);
        instanceVar1 = 99;
        staticVar1--;
    }

    public InitializerExample() {
        print("static Var = " + staticVar1);
    }

    public static void main(String[] args) {

        new InitializerExample();
        new InitializerExample();
        new InitializerExample();

    }

    private static void print(String s) {
        System.out.println(s);
    }
}
