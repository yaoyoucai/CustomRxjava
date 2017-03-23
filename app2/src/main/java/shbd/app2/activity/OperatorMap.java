package shbd.app2.activity;

/**
 * 项目名称：CustomRxjava
 * 类描述：
 * 创建人：yh
 * 创建时间：2017/3/23 13:44
 * 修改人：yh
 * 修改时间：2017/3/23 13:44
 * 修改备注：
 */
public class OperatorMap<T, R> implements Observable.Operation<R, T> {
    private IFun<T, R> convert;

    public OperatorMap(IFun<T, R> convert) {
        this.convert = convert;
    }

    @Override
    public Observer<? extends T> call(final Observer<? super R> observer) {
        return new Observer<T>() {
            @Override
            public void update(T t) {
                R r = convert.call(t);
                observer.update(r);
            }
        };
    }
}
