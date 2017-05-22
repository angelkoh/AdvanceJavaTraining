package Module2;

/**
 * Created by Angel on 17/5/2017.
 */
public class MemberClassExample {

    int a;//parent class a

    public class InnerClassExample {
        int a; //inner class a

        InnerClassExample(String parent) {
            print(parent + " -> " + this.getClass().getSimpleName() + " created");
        }
    }

    void methodWithInnerClass() {
        class NestedClassExample {
            int a; //method class a

            NestedClassExample(String parent) {
                print(parent + " -> " + this.getClass().getSimpleName() + " created");
            }
        }
        new NestedClassExample(getClass().getSimpleName());
    }

    public MemberClassExample(String parent) {
        print(parent + " -> " + this.getClass().getSimpleName() + " created");


        new InnerClassExample(this.getClass().getSimpleName()); //instantiating from inside the class
    }

    public static void main(String[] arg) {

        MemberClassExample mce = new MemberClassExample("Main");

        mce.methodWithInnerClass();
        mce.new InnerClassExample("Main"); //instantiating from outside the class

        IAnonymousExample anonymousExample = new IAnonymousExample() {
            @Override
            public void doMethod() {
                print("Example of anonymous class");
                //we will re-visit this at the threading example
            }
        };

        IAnonymousExample anonymousExample2 = () -> {
            //can do this if it's only one method.
            print("this is also anonymous class in Lambda");
        };

        IAnonymousExample anonymousExample3 = MemberClassExample::staticDoMethod;

        anonymousExample.doMethod();
        anonymousExample2.doMethod();
        anonymousExample3.doMethod();
    }

    static void staticDoMethod(){
        print("this is a static do method");
    }

    private static void print(String s) {
        System.out.println(s);
    }

    interface IAnonymousExample {
        void doMethod();
    }
}
