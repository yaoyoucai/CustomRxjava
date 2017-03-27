package net.yh.app5.activity;

/**
 * Created by 25110 on 2017/3/25.
 */

public class Observable<T> {
    public OnSubscribe onSubscribe;

    public Observable(OnSubscribe onSubscribe) {
        this.onSubscribe = onSubscribe;
    }

    public static <T> Observable<T> create(OnSubscribe<T> onSubscribe) {
        return new Observable(onSubscribe);
    }

    public void subscribe(Subscriber<T> subscriber) {
        onSubscribe.call(subscriber);
    }

    public interface OnSubscribe<T> {
        void call(Subscriber<T> subscriber);
    }

    public <T, R> Observable map(IFun<T, R> convert) {
        OperaterMap operaterMap = new OperaterMap(convert);
        Observable lift = lift(operaterMap);
        return lift;
    }

    private <T, R> Observable lift(final Operator<T, R> operator) {
        return new Observable(new OnSubscribe() {
            @Override
            public void call(Subscriber subscriber) {
                Subscriber newSubscriber = operator.call(subscriber);
                Observable.this.onSubscribe.call(newSubscriber);
            }
        });
    }

    public interface Operator<R, T> extends IFun<Subscriber<R>, Subscriber<T>> {
    }
}
