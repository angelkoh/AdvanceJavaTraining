package Module5;

/**
 * Created by Angel on 17/5/2017.
 */
public class AssertExample {

    public static void main(String[] arg) {

        System.out.println("running doMethod()");
       // assert doMethod(); //not very descriptive.
        assert doMethod(): getError(55);

        //add -ea to configuration (VM Options:)

        //continue with the rest of the codes
        System.out.println("running other codes");

        // also look up "assertj" and "hamcrest" for a better (more descriptive assert)

        //assert is the basic, usually we use junit/jtest/mokito/etc for modular level testing
        //has more meaningful asserts and trace features assertNotNull, assertEqual

        //Do note that the error trace is not in sequence with the mainThread trace

    }

    private static String getError(int i) {
        System.out.println("Error received!!");
        return "Error " + i + " received";
    }


    public  static boolean doMethod(){
        boolean success = false;
        return success;
    }
}
