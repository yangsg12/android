package com.example.yang.learnrecyclerview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    private RecyclerView rv;
    private TextView tvTitle;
    private TextView tvContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = new RecyclerView(this);
        setContentView(rv);
        //rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setLayoutManager(new GridLayoutManager(this,3));

        rv.setAdapter(new MyAdapter());
    }


}
