package com.app1.activity;

/**
 * Created by 25110 on 2017/3/22.
 */

public class Test {
    public static void main(String[] args) {
        Subject.OnAttach<Integer> attach = new Subject.OnAttach<Integer>() {
            @Override
            public void call(Observer<Integer> observer) {
                observer.update(4545454);
            }
        };

        Subject<Integer> subject = Subject.create(attach);

        subject.attach(new Observer<Integer>() {
            @Override
            public void update(Integer state) {
                System.out.println("状态改变了" + state);
            }
        });
    }
}
