package com.hz.mydemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ImageView;


/**
 * Created by Administrator on 2016/6/27.
 */
public class AminationActivity extends AppCompatActivity {
    private ImageView iv_amination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);//开启trasitions过场动画
//        getWindow().setEnterTransition(new Explode().setDuration(6000));//设置进场的过度动画
//        getWindow().setExitTransition(new Explode().setDuration(6000));//设置退场的过度动画

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amination);
        iv_amination = (ImageView) findViewById(R.id.iv_amination);
    }


    public void btnclick(final View view){
        switch (view.getId()){
            case R.id.bt_amination_01:
                Animator circularReveal = ViewAnimationUtils.createCircularReveal(iv_amination, 0, 0, 0,
                        (float) Math.sqrt(iv_amination.getHeight()*iv_amination.getHeight() +  iv_amination.getWidth()*iv_amination.getWidth()));
               circularReveal.addListener(new AnimatorListenerAdapter() {
                   @Override
                   public void onAnimationStart(Animator animation) {
                       iv_amination.setVisibility(View.VISIBLE);
                   }
               });
                circularReveal.setDuration(2000);
                circularReveal.start();
                break;
            case R.id.bt_amination_02:
                Animator circularReveal2 = ViewAnimationUtils.createCircularReveal(iv_amination,
                        iv_amination.getWidth()/2,
                        iv_amination.getHeight()/2,
                        iv_amination.getHeight()/2,
                        0);
                circularReveal2.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        iv_amination.setVisibility(View.GONE);
                    }
                });
                circularReveal2.setDuration(2000);
                circularReveal2.start();
                break;
            case R.id.bt_amination_03:
                Intent intent = new Intent(this,Animation2_Activity.class);
                Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(this).toBundle();
                startActivity(intent,bundle);
                break;
            case R.id.bt_amination_04:
                Intent intent2 = new Intent(this,Animation2_Activity.class);
                Bundle bundle2 = ActivityOptions.makeSceneTransitionAnimation(this,iv_amination,"share").toBundle();
                startActivity(intent2,bundle2);
                break;
            default:
                break;
        }
    }
}
