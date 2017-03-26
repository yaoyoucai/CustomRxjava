package net.yh.app5.activity;

/**
 * Created by 25110 on 2017/3/25.
 */

public interface IFun<T, R> {
    R call(T t);
}
