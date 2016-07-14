 package com.hz.mydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.RadioGroup;

import com.hz.mydemo.fragment.fragment_main;
import com.hz.mydemo.fragment.fragment_map;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    //页面底部的radiogroup
    private RadioGroup rg_main;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    /**
     * 初始化方法
     */
    private void init() {
        rg_main = (RadioGroup) findViewById(R.id.rg_main);
        rg_main.setOnCheckedChangeListener(this);//对点击事件进行监听
        rg_main.getChildAt(0).performClick();//模拟点击

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);//隐藏标题名字
    }

    /**
     * 对于radiogroup点击事件进行处理
     * @param group
     * @param checkedId
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rb_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_main,new fragment_main()).commit();
                break;
            case R.id.rb_map:
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_main,new fragment_map()).commit();
                break;
            case R.id.rb_mine:
                break;
        }
    }
}
