package com.hz.mydemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Fragment基类.
 */
public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getViewResid(), container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        init(view);
        loadDatas();

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        getDatas(getArguments());
        super.onActivityCreated(savedInstanceState);
    }

    /**
     * 解析获得数据
     */
    protected void getDatas(Bundle arguments){

    }
    /**
     * 加载数据方法，由子类具体实现
     */
    protected  void loadDatas(){}

    /**
     * 初始化方法
     * @param view
     */
    protected  void init(View view){}

    /**
     * 获得布局id
     * @return
     */
    protected abstract int getViewResid();
}
