import net.yh.app5.activity.IFun;
import net.yh.app5.activity.Observable;
import net.yh.app5.activity.Subscriber;

/**
 * Created by 25110 on 2017/3/25.
 */

public class Test {
    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test2() {
        final Subscriber<String> subscriber1 = new Subscriber<String>() {
            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        };

        final Observable.OnSubscribe<String> onSubscribe1 = new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<String> subscriber) {
                subscriber.onNext("dddddd,");
            }
        };

        Observable<String> observable1 = Observable.create(onSubscribe1);

        final Subscriber<String> subscriber2 = new Subscriber<String>() {
            @Override
            public void onNext(String s) {
                s = s + "ffffff";
                subscriber1.onNext(s);
            }
        };
        Observable.OnSubscribe<String> onSubscribe2 = new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<String> subscriber) {
                onSubscribe1.call(subscriber);
            }
        };
        Observable observable2 = new Observable(onSubscribe2);

        observable2.subscribe(subscriber1);

    }

    private static void test1() {
        Observable.OnSubscribe<String> onSubscribe1 = new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<String> subscriber) {
                subscriber.onNext("dddddd,");
            }
        };

        Observable<String> observable1 = Observable.create(onSubscribe1);

        Observable observable2 = observable1.map(new IFun<String, String>() {
            @Override
            public String call(String s) {
                return s + "fffff";
            }
        });

        Subscriber<String> subscriber1 = new Subscriber<String>() {
            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        };
        observable2.subscribe(subscriber1);
    }
}
