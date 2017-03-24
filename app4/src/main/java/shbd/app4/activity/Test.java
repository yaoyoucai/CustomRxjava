package shbd.app4.activity;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Scheduler;
import rx.functions.Action0;
import rx.functions.Action1;

import static shbd.app4.activity.ContextAwareScheduler.INSTANCE;

/**
 * 项目名称：CustomRxjava
 * 类描述：
 * 创建人：yh
 * 创建时间：2017/3/24 15:08
 * 修改人：yh
 * 修改时间：2017/3/24 15:08
 * 修改备注：
 */
public class Test {
    public static void main(String[] args) {
        Scheduler.Worker w = INSTANCE.createWorker();
        final CountDownLatch cdl = new CountDownLatch(1);
        ContextManager.set(1);

        w.schedule(new Action0() {
            @Override
            public void call() {
                System.out.println(Thread.currentThread());
                System.out.println(ContextManager.get());
            }
        });

        ContextManager.set(2);
        w.schedule(new Action0() {
            @Override
            public void call() {
                System.out.println(Thread.currentThread());
                System.out.println(ContextManager.get());
                cdl.countDown();
            }
        });

        try {
            cdl.await();


            ContextManager.set(3);

            Observable.timer(500, TimeUnit.MILLISECONDS, INSTANCE).doOnNext(new Action1<Long>() {
                @Override
                public void call(Long aLong) {
                    System.out.println(Thread.currentThread());
                    System.out.println(ContextManager.get());
                }
            }).toBlocking().first();

            w.unsubscribe();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
