package Module3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Angel on 17/5/2017.
 */
public class ReflectionExample {

    String s;

    public ReflectionExample(String s) {
        this.s = s;
        System.out.println(getClass().getName() + " is called (" + s + ")");
        System.out.println(getClass().getSimpleName());
    }

    class InnerClass {
        void print() {
            System.out.println(getClass().getName());
            System.out.println(getClass().getSimpleName());
        }
    }

    public static void main(String[] arg) {

        ParentClass c1 = new ParentClass();
        ParentClass c2 = new ChildClass();
        ParentClass c3 = new GrandChildClass();

        if (c3 instanceof ParentClass) {
            System.out.println("\n" + c3.getClass().getSimpleName() + " is instanceof " + ParentClass.class.getSimpleName());
        }
        if (ParentClass.class.isInstance(c3.getClass())) {
            System.out.println(   ParentClass.class.getSimpleName() + " is instanceof " + c3.getClass().getSimpleName());
        }else {
            System.out.println( "but" + ParentClass.class.getSimpleName() + " is NOT instanceof " + c3.getClass().getSimpleName());
        }
        if (ParentClass.class.equals(c3)) {
            System.out.println(  c3.getClass().getSimpleName() + " is class" + ParentClass.class.getSimpleName());
        } else {
            System.out.println(  c3.getClass().getSimpleName() + " is NOT class" + ParentClass.class.getSimpleName());
        }
            //
        Constructor<?>[] constructors = ReflectionExample.class.getConstructors();
        System.out.println();
        System.out.println(constructors.length + " constructors found");
        Constructor<?> constructor = constructors[0];
        try {
            Object obj = constructor.newInstance("Hello");
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println(ReflectionExample.class.getPackage().getName());
    }
}
