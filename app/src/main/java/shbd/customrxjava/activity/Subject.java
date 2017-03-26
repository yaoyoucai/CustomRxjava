package shbd.customrxjava.activity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 25110 on 2017/3/22.
 */

public abstract class Subject {
    protected List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String state) {
        for (Observer observer : observers) {
            observer.update(state);
            LinkedList
        }
    }

}
