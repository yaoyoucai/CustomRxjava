package shbd.app2.activity;

/**
 * 项目名称：CustomRxjava
 * 类描述：
 * 创建人：yh
 * 创建时间：2017/3/23 13:29
 * 修改人：yh
 * 修改时间：2017/3/23 13:29
 * 修改备注：
 */
public class Observable<T> {
    private OnAttach attach;

    private Observable(OnAttach attach) {
        this.attach = attach;
    }

    public static <T> Observable<T> create(OnAttach<T> attach) {
        return new Observable<T>(attach);
    }

    public void call(Observer<T> observer) {
        attach.call(observer);
    }

    public interface OnAttach<T> {
        void call(Observer observer);
    }

    public Observable<R> map(IFun<? super T, ? extends R> fun) {
        OperatorMap operatorMap = new OperatorMap(fun);

        Observable lift = lift(operatorMap);

        return lift;
    }


    public Observable<R> lift(final Operation<T, R> operation) {
        return new Observable<R>(new OnAttach() {
            @Override
            public void call(Observer observer) {
                Observer<T> newObserver = operation.call(observer);
                Observable.this.attach.call(newObserver);
            }
        });
    }

    public interface Operation<R, T> extends IFun<Observer<? super R>, Observer<? extends T>> {

    }

}
