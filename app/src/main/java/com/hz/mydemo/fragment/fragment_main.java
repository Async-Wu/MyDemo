package com.hz.mydemo.fragment;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hz.mydemo.R;
import com.hz.mydemo.RefreshActivity;
import com.hz.mydemo.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/25.
 */
public class fragment_main extends BaseFragment implements View.OnClickListener {
    private FloatingActionButton fab_main;
    private TextInputLayout til_main;
    private TabLayout tab_main;
    private ViewPager vp_main_tab;
    private Button button;
    @Override
    protected int getViewResid() {
        return R.layout.fragment_main;
    }

    @Override
    protected void init(View view) {
        super.init(view);
        /**
         * FAb
         */
        fab_main = (FloatingActionButton) getActivity().findViewById(R.id.fab_main);
        fab_main.setOnClickListener(this);
        til_main = (TextInputLayout) getActivity().findViewById(R.id.til_username);
        til_main.setHint("请输入用户名");

        EditText editText = til_main.getEditText();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 6) {
                    til_main.setError("文本长度不能超过6'");
                    til_main.setErrorEnabled(true);
                } else {
                    til_main.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        /**
         * tablelayout
         */
        tab_main = (TabLayout) getActivity().findViewById(R.id.tab_main);
//        tab_main.addTab(tab_main.newTab().setText("新闻"));
//        tab_main.addTab(tab_main.newTab().setText("热点"));
//        tab_main.addTab(tab_main.newTab().setText("娱乐"));
//        tab_main.addTab(tab_main.newTab().setText("体育"));
//        tab_main.addTab(tab_main.newTab().setText("直播间"));

        List<String> data = new ArrayList<>();
        data.add("新闻页面");
        data.add("热点页面");
        data.add("娱乐页面");
        data.add("体育页面");
        data.add("直播间页面");
        vp_main_tab = (ViewPager) getActivity().findViewById(R.id.vp_main_tab);
        ViewPagerAdapter vpa = new ViewPagerAdapter(getChildFragmentManager(),data);
        vp_main_tab.setAdapter(vpa);
        //viewpager与tablyout级联
        tab_main.setupWithViewPager(vp_main_tab);
        tab_main.setTabsFromPagerAdapter(vpa);


        button = (Button) getActivity().findViewById(R.id.bt_main);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RefreshActivity.class);
                startActivity(intent);
            }
        });



    }

    @Override
    public void onClick(View v) {
        final Snackbar snackbar = Snackbar.make(v, "点击弹出了snackbar", Snackbar.LENGTH_LONG);
        snackbar.setAction("知道了", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        });
        snackbar.show();
    }

    class ViewPagerAdapter extends FragmentPagerAdapter{
        private List<String> datas;
        public ViewPagerAdapter(FragmentManager fm,List<String> datas)  {
            super(fm);
            this.datas = datas;
        }

        @Override
        public Fragment getItem(int position) {
            return ViewPager_Fragment.getInstance(datas.get(position));
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        /**
         * 返回item所对应的标题名称
         * @param position
         * @return
         */
        @Override
        public CharSequence getPageTitle(int position) {
            return datas.get(position);
        }
    }
}
