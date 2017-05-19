package com.example.zhangwenfang.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by zhangwenfang on 2017/5/4.
 */

public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.MyViewHolder> {
    private Context context;
    private LayoutInflater layoutInflater;
    private String[] titles;

    public MyRecycleAdapter(Context context) {
        this.context=context;
        layoutInflater=LayoutInflater.from(context);
        titles=context.getResources().getStringArray(R.array.languages);

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(layoutInflater.inflate(R.layout.item_recycleview,parent,false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(titles[position]);

    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    public static class MyViewHolder extends ViewHolder {
        private TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.text);
        }


    }
}
