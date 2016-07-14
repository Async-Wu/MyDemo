package com.hz.mydemo.Adapter;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.hz.mydemo.R;
import com.hz.mydemo.RefreshActivity;

import java.util.List;

/**
 * RecyclerView的适配器
 */
public class MyAdapter extends RecyclerView.Adapter <MyAdapter.MyViewHolder>{
    private Context context;
    private List<String> data;
    private View.OnClickListener onClickListener;
    private View.OnLongClickListener onLongClickListener;

    private MyAdapter(){
    }
    public MyAdapter(Context context,List<String> data){
        this.context = context;
        this.data = data;
    }
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_item,parent,false);
        return new MyViewHolder(view);
    }

    /**
     * 该方法用来进行数据绑定
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {
        holder.textView.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }



    /**
     * 自定义viewholder 必须继承于RecyclerView
     */
    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            if(onClickListener != null){
                itemView.setOnClickListener(onClickListener);
            }
            if(onLongClickListener != null){
                itemView.setOnLongClickListener(onLongClickListener);
            }

            textView = (TextView) itemView.findViewById(R.id.tv_recl);
        }
    }
}
