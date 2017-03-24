package shbd.app4.activity;

/**
 * 项目名称：CustomRxjava
 * 类描述：
 * 创建人：yh
 * 创建时间：2017/3/24 16:26
 * 修改人：yh
 * 修改时间：2017/3/24 16:26
 * 修改备注：
 */
public class ContextManager {
    static final ThreadLocal<Object> ctx = new ThreadLocal<>();

    private ContextManager() {
        throw new IllegalStateException();
    }

    public static Object get() {
        return ctx.get();
    }
    public static void set(Object context) {
        ctx.set(context);
    }
}
