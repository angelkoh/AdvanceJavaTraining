package Module2;

/**
 * Created by Angel on 17/5/2017.
 */
public class EnumExample {

    public static void main(String[] arg) {

        EnumColor ec = EnumColor.E_Color_1;

        System.out.println("color = " + ec);

        switch (ec) {
            //press ALT+ENTER here.
        }

        String a = "Hello";
        switch (a) {
            case "Hello":
                print("Hello called");
                break;
            case "hello":
                print("hello called");
                break;
            default:
                break;
        }
    }

    private static void print(String s) {
        System.out.println(s);
    }
}
