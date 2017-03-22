package com.app1.activity;

/**
 * Created by 25110 on 2017/3/22.
 */

public interface Observer<T> {
    void update(T state);
}
