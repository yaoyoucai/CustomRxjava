package shbd.customrxjava.activity;

/**
 * Created by 25110 on 2017/3/22.
 */

public class ConcreteSubject extends Subject {
    public void change(String state) {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }
}
