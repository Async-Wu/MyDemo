package com.hz.mydemo;

import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.hz.mydemo.Adapter.MyAdapter;
import com.hz.mydemo.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/25.
 */
public class RefreshActivity extends BaseActivity implements View.OnClickListener, View.OnLongClickListener {
    private List<String> data;
    private Toolbar tb_rfa;
//    private SwipeRefreshLayout srl_main;//官方的下拉刷新
    private RecyclerView recv_main;
    private MyAdapter myAdapter;
    private CollapsingToolbarLayout toolbarLayout;

    @Override
    protected int getViewResid() {
        return R.layout.activity_fresh;
    }

    @Override
    protected void init() {
        super.init();

        /**
         * 模拟数据源
         */
        data = new ArrayList<>();
        for(int i=0;i<30;i++){
            data.add("内容  "+i);
        }
        recv_main = (RecyclerView) findViewById(R.id.recV_main);
        recv_main.setLayoutManager(new LinearLayoutManager(this,1,false));
        myAdapter = new MyAdapter(this,data);
        myAdapter.setOnClickListener(this);
        myAdapter.setOnLongClickListener(this);
        recv_main.setAdapter(myAdapter);


//        srl_main = (SwipeRefreshLayout) findViewById(R.id.srl_main);
//        srl_main.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                Snackbar snackbar = Snackbar.make(srl_main, "正在刷新", Snackbar.LENGTH_LONG);
//                snackbar.setAction("知道", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        data.add(0, "刷添加的内容");
//                        myAdapter.notifyDataSetChanged();
//                        srl_main.setRefreshing(false);
//                    }
//                });
//                snackbar.show();
//            }
//        });

        tb_rfa = (Toolbar) findViewById(R.id.tb_fresh);
        setSupportActionBar(tb_rfa);
//        toolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.ctl_fresh);
//        toolbarLayout.setTitle("标题");
//        toolbarLayout.setCollapsedTitleGravity(Gravity.CENTER);
    }

    @Override
    public void onClick(View v) {
//        Toast.makeText(RefreshActivity.this,"当前点击了"+recv_main.getChildAdapterPosition(v),Toast.LENGTH_SHORT).show();;
//        int position = recv_main.getChildAdapterPosition(v);
//        data.add(position,"点击添加的内容");
//        myAdapter.notifyItemInserted(position);
    }

    @Override
    public boolean onLongClick(View v) {
//        Toast.makeText(RefreshActivity.this,"你长按了"+recv_main.getChildAdapterPosition(v),Toast.LENGTH_SHORT).show();;
//        data.remove(recv_main.getChildAdapterPosition(v));
//        myAdapter.notifyItemRemoved(recv_main.getChildAdapterPosition(v));
        return false;
    }
}
