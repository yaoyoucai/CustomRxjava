package com.app1.activity;

/**
 * 项目名称：CustomRxjava
 * 类描述：
 * 创建人：yh
 * 创建时间：2017/3/23 7:25
 * 修改人：yh
 * 修改时间：2017/3/23 7:25
 * 修改备注：
 */
public class MyCount {
    public int count;

    public MyCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "MyCount[count:" + count + "]";
    }

    @Override
    public int hashCode() {
        return count;
    }

    @Override
    public boolean equals(Object obj) {


        if (this == obj)
            return true;
        if (obj != null && obj.getClass() == MyCount.class) {
            MyCount myCount = (MyCount) obj;
            return myCount.count == this.count;
        }
        return false;
    }


}
