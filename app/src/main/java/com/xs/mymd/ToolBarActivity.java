package com.xs.mymd;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-05-20 10:26
 * @email Xs.lin@foxmail.com
 */
public abstract class ToolBarActivity extends AppCompatActivity {
    private static final String TAG = "ToolBarActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutInflater().inflate(getContentViewId(),null));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_Id);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        setHomeAsUpEnable(true);
    }

    private void setHomeAsUpEnable(boolean enable) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(enable);
        getSupportActionBar().setHomeAsUpIndicator(android.R.drawable.arrow_up_float);
    }


    @Override
    public void setTitle(CharSequence title) {
        getSupportActionBar().setTitle(title);
    }

    protected abstract int getContentViewId();


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
