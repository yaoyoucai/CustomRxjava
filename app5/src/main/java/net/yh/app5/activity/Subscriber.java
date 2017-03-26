package net.yh.app5.activity;

/**
 * Created by 25110 on 2017/3/25.
 */

public interface Subscriber<T> {
    void onNext(T t);
}
