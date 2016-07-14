package com.hz.mydemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hz.mydemo.R;

/**
 * Created by Administrator on 2016/6/25.
 */
public class ViewPager_Fragment extends Fragment{
    private TextView textView;
    public static Fragment getInstance(String s){
       ViewPager_Fragment viewPager_fragment = new ViewPager_Fragment();
        Bundle bundle = new Bundle();
        bundle.putString("count", s);
        viewPager_fragment.setArguments(bundle);
        return viewPager_fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.vp_fragment_main,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        textView = (TextView)view.findViewById(R.id.tv_main_tab);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        String str = bundle.getString("count") ;
        textView.setText(str);
    }
}
