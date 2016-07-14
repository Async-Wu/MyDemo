package com.hz.mydemo;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;

import com.hz.mydemo.base.BaseActivity;

/**
 * Created by Administrator on 2016/6/27.
 */
public class Animation2_Activity extends BaseActivity {
    private ImageView imageView;
    @Override
    protected int getViewResid() {
        return R.layout.activity_animation_2;
    }

    @Override
    protected void init() {
        super.init();
        imageView = (ImageView) findViewById(R.id.iv_animation_02);
//        imageView.setClipToOutline(true);//开启裁剪功能
//        imageView.setOutlineProvider(new MyViewOutLineProvoder());
    }

    class MyViewOutLineProvoder extends ViewOutlineProvider{
        /**
         * 创建一个轮廓提供者
         * @param view
         * @param outline
         */
        @Override
        public void getOutline(View view, Outline outline) {
            outline.setOval(0,0,view.getWidth(),view.getHeight());
        }
    }
}
