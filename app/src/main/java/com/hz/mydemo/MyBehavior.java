package com.hz.mydemo;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/6/27.
 */
public class MyBehavior extends CoordinatorLayout.Behavior {
    public MyBehavior(Context context,AttributeSet attributeSet){
        super(context,attributeSet);
    }

    /**
     * 确定依赖关系
     * @param parent
     * @param child 表示从属对象 也就是指定app:layout_Behavior这个属性对象
     * @param dependency 希望依赖的对象
     * @return
     */
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
//        return dependency.getId() == R.id.v_main_rfa ;
        return false;
    }

    /**
     * 依赖对象发生改变会回调该方法
     * @param parent
     * @param child 从属对象
     * @param dependency 主动对象
     * @return
     */
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        child.setY(dependency.getY()+dependency.getHeight());
        return true;
    }
}
