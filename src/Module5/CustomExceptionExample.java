package Module5;

/**
 * Created by Angel on 17/5/2017.
 */
public class CustomExceptionExample {


    public static void main(String[] arg) throws CustomException {


        try {
            //some processing

            //somehow an error occurs
            throw (new CustomException("Hello World"));
        } catch (CustomException e) {
            //perform system logging
            print (e.getMessage());
        }

        //without catching the error
        throw (new CustomException("Let Application Crash"));
    }

    static  public void print(String s) {
        System.out.println(s);
    }


    static class CustomException extends Exception {
        public CustomException(String message) {
            super("CustomException: " + message);
        }
    }
}
