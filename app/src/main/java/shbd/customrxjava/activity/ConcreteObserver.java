package shbd.customrxjava.activity;

/**
 * Created by 25110 on 2017/3/22.
 */

public class ConcreteObserver implements Observer {
    @Override
    public void update(String state) {
        System.out.println("状态改变了" + state);
    }
}
