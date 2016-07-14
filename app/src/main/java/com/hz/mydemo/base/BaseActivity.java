package com.hz.mydemo.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/2/25.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getViewResid());
        ButterKnife.bind(this);
        init();
        loadDatas();
    }

    protected  void init(){}

    protected  void loadDatas(){}

    protected abstract int getViewResid();
}
