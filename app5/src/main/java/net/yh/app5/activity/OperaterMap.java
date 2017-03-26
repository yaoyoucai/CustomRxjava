package net.yh.app5.activity;

/**
 * Created by 25110 on 2017/3/25.
 */

public class OperaterMap<T, R> implements Observable.Operator<R, T> {
    private IFun<T, R> convert;

    public OperaterMap(IFun<T, R> convert) {
        this.convert = convert;
    }

    @Override
    public Subscriber<T> call(final Subscriber<R> subscriber) {
        return new Subscriber<T>() {
            @Override
            public void onNext(T t) {
                R r = convert.call(t);
                subscriber.onNext(r);
            }
        };
    }
}
