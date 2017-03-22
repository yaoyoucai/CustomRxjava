package shbd.customrxjava.activity;

/**
 * Created by 25110 on 2017/3/22.
 */

public class Test {
    public static void main(String[] args) {
        Observer observer = new ConcreteObserver();

        ConcreteSubject subject = new ConcreteSubject();

        subject.attach(observer);

        subject.change("jjjjjjj");
    }
}
