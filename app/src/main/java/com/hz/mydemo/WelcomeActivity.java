package com.hz.mydemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/22.
 * 欢迎页面
 */
public class WelcomeActivity extends AppCompatActivity {
    /**
     * 欢迎页的viewpager
     */
    private ViewPager vp_welcome;
    /**
     * 欢迎页的Viewpager
     */
    private List welcome_ListVew = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        init();
    }

    /**
     * 初始化方法
     */
    private void init() {
        vp_welcome = (ViewPager) findViewById(R.id.vp_welcome);
        ImageView iv_welcome01 = new ImageView(WelcomeActivity.this);
        ImageView iv_welcome02 = new ImageView(WelcomeActivity.this);
        ImageView iv_welcome03 = new ImageView(WelcomeActivity.this);
        ImageView iv_welcome04 = new ImageView(WelcomeActivity.this);
        iv_welcome01.setImageResource(R.drawable.introduct_1);
        iv_welcome02.setImageResource(R.drawable.introduct_2);
        iv_welcome03.setImageResource(R.drawable.introduct_3);
        iv_welcome04.setImageResource(R.drawable.introduct_4);
        welcome_ListVew.add(iv_welcome01);
        welcome_ListVew.add(iv_welcome02);
        welcome_ListVew.add(iv_welcome03);
        welcome_ListVew.add(iv_welcome04);
        WelcomeAdapter welcomeAdapter = new WelcomeAdapter(welcome_ListVew);
        vp_welcome.setAdapter(welcomeAdapter);
        /**
         * 对viewpager设置监听
         */
        vp_welcome.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            private Boolean flag = false;
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state) {
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        flag = false;
                        break;
                    case ViewPager.SCROLL_STATE_SETTLING:
                        flag = true;
                        break;
                    case ViewPager.SCROLL_STATE_IDLE:
                        if (vp_welcome.getCurrentItem() == vp_welcome.getAdapter().getCount() - 1 && !flag) {

                            Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                            startActivity(intent);
                            WelcomeActivity.this.finish();
                        }
                        flag = true;
                        break;
                }
            }
        });

    }

    /**
     * Viewpager的适配器
     */
    class WelcomeAdapter extends PagerAdapter {
        private List welcome_ListVew1;

        WelcomeAdapter(List welcome_ListVew) {
            this.welcome_ListVew1 = welcome_ListVew;
        }

        @Override
        public int getCount() {
            return welcome_ListVew1.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) welcome_ListVew1.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView((View) welcome_ListVew1.get(position));
            return welcome_ListVew1.get(position);
        }

    }

}
