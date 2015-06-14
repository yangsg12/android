package com.example.yang.framelayout;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class FrameLayout extends ActionBarActivity {

    private FrameLayout root;
    private ImageView ivA,ivB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);

        ivA = (ImageView) findViewById(R.id.ivA);
        ivB = (ImageView)findViewById(R.id.ivB);
        showA();

        //root = (FrameLayout)findViewById(R.id.root);
     /*   root.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (ivA.getVisibility() == View.VISIBLE) {
                    showB();
                }  else {
                    showA();
                }
            }
        }) ;*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_frame_layout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void showA() {
        ivA.setVisibility(View.VISIBLE);
        ivB.setVisibility(View.INVISIBLE);
    }

    private void showB() {
        ivA.setVisibility(View.INVISIBLE);
        ivB.setVisibility(View.VISIBLE);
    }
}

