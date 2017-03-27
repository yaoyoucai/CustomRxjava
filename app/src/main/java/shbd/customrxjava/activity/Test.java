package shbd.customrxjava.activity;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 25110 on 2017/3/22.
 */

public class Test {
    public static void main(String[] args) {
        testLinkedList();
//        testObserver();
    }

    private static void testLinkedList() {
        List<String> list = new LinkedList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");

        list.add(4, "hhhhhh");

        System.out.println(list.toString());

        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }

        HashMap

    }

    private static void testObserver() {
        Observer observer = new ConcreteObserver();

        ConcreteSubject subject = new ConcreteSubject();

        subject.attach(observer);

        subject.change("jjjjjjj");
    }
}
