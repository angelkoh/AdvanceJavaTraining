package Module4;

import java.util.*;

/**
 * Created by Angel on 17/5/2017.
 */
public class CollectionsExample {

    static Set<String> stringSet1;
    static Set<String> stringSet2;

    static List<String> list;
    static Deque<String> deque;

    public static void main(String[] arg) {

        stringSet1 = new HashSet<>(); //this is unordered (class needs to implement equals)
        stringSet2 = new TreeSet<>(); //this is ordered. (class needs to implement comparable to know the order)

        populate(stringSet1);
        print("Hash Set:");
        print(stringSet1);
        stringSet1.remove("A");
        print(stringSet1);

        populate(stringSet2);
        print("Tree Set:");
        print(stringSet1);

        list = new ArrayList<>();
        populate(list);
        print("Array list:");
        print(list);
        list.remove("A");
        print(list);
        //to remove all
        while (list.remove("A")) ;
        print(list);

        //LinkedList implements the DEQUE (double-ended queue)
        //gives access to
        deque = new LinkedList<>();
        print("\nArray deque :");
        populate(deque);
        print(deque);

        String value;
        value = deque.pop();
        print("popped: " + value);
        print(deque);
        value = deque.peek();
        print("peeked: " + value);
        print(deque);

        value = deque.poll();
        print("polled: " + value);
        print(deque);

        deque.add("ADD") ;
        print(deque);
        deque.push("PUSH") ;
        print(deque);

    }

    private static void populate(Collection<String> collection) {

        collection.add("Z");
        collection.add("B");
        collection.add("D");
        collection.add("E");
        collection.add("Z");
        collection.add("G");
        collection.add("A");
        collection.add("A");
        collection.add("A");
    }

    public static void print(Collection collection) {
        StringBuilder sb = new StringBuilder();
        collection.stream().forEach(r -> sb.append(r).append(" "));
        print(sb.toString());
    }

    private static void print(Object r) {
        System.out.println(r);
    }
}
