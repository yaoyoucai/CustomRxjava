package shbd.app2.activity;

/**
 * 项目名称：CustomRxjava
 * 类描述：
 * 创建人：yh
 * 创建时间：2017/3/23 13:28
 * 修改人：yh
 * 修改时间：2017/3/23 13:28
 * 修改备注：
 */
public interface Observer<T> {
    void update(T t);
}
