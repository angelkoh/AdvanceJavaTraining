package Module3;

/**
 * Created by Angel on 17/5/2017.
 */
public class ParentClass {

    public ParentClass() {
        System.out.println();
        System.out.println(getClass().getSimpleName());
        System.out.println(getClass().getName());
        System.out.println("my parent is " + getClass().getSuperclass().getSimpleName());
    }
}
