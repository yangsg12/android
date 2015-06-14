package com.example.yang.learnrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Yang on 2015/6/14.
 */
class MyAdapter extends RecyclerView.Adapter {

    class ViewHodler extends RecyclerView.ViewHolder {
        private View root;
        private TextView tvTitle,tvContent;

        public ViewHodler(View root) {


            super(root);
            tvTitle = (TextView)root.findViewById(R.id.tvTitle);
            tvContent = (TextView) root.findViewById(R.id.tvContent);
        }

        public TextView getTvTitle() {
            return tvTitle;
        }

        public TextView getTvContent() {
            return tvContent;
        }


    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHodler(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_cell,null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ViewHodler vh = (ViewHodler) viewHolder;
        //vh.getTv().setText("Item "+i);

        CellData cd = data[i];
        vh.getTvTitle().setText(cd.title);
        vh.getTvContent().setText(cd.content);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }


    private CellData[] data = new CellData[]{new CellData("这个啊", "好吧"), new CellData("十点了", "恩啊")};
    //private String[] data = new String[]{"Hello","haha","item"};
}
