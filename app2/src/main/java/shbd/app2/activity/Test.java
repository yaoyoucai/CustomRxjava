package shbd.app2.activity;

/**
 * 项目名称：CustomRxjava
 * 类描述：
 * 创建人：yh
 * 创建时间：2017/3/23 13:33
 * 修改人：yh
 * 修改时间：2017/3/23 13:33
 * 修改备注：
 */
public class Test {
    public static void main(String[] args) {
        Observable.OnAttach<String> attach0 = new Observable.OnAttach<String>() {
            @Override
            public void call(Observer observer) {
                observer.update("hhhhhh");
            }
        };

        Observable observable0 = Observable.create(attach0);

        Observable observable1 = observable0.map(new IFun<String, String>() {
            @Override
            public String call(String s) {
                return s + "dddddd";
            }
        });

        Observable observable2 = observable1.map(new IFun<String, String>() {
            @Override
            public String call(String s) {
                return s + "gggggg";
            }
        });

        Observer<String> observer0 = new Observer<String>() {
            @Override
            public void update(String s) {
                System.out.println(s);
            }
        };

        observable2.call(observer0);

    }
}
