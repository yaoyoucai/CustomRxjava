package com.app1.activity;

/**
 * Created by 25110 on 2017/3/22.
 */

public class Subject<T> {
    private OnAttach attach;

    private Subject(OnAttach<T> attach) {
        this.attach = attach;
    }

    public static <T> Subject<T> create(OnAttach<T> attach) {
        return new Subject(attach);
    }

    public void attach(Observer<T> observer) {
        attach.call(observer);
    }

    public interface OnAttach<T> {
        void call(Observer<T> observer);
    }
}
