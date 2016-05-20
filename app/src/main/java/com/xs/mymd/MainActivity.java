package com.xs.mymd;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ToolBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final FloatingActionButton mFab = (FloatingActionButton) findViewById(R.id.tab);
        mFab.setOnClickListener((v -> Snackbar.make(v, "ok",Snackbar.LENGTH_LONG).setAction("Action",null).show()));
        initView();

    }

    private void initView() {
        final RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.rv_recycleview_Id);
        MyModelAdapter adapter = new MyModelAdapter(this, new MyModelAdapter.OnClickItemListen() {
            @Override
            public void onItemClick(View view, Object o, int position) {

            }
        });
        adapter.addAll(initAdapterData());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
        mRecyclerView.setAdapter(adapter);
    }

    private List<MyModel> initAdapterData() {
        List<MyModel> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            MyModel myModel = new MyModel();
            myModel.setA("a"+i);
            myModel.setB("b"+i);
            list.add(myModel);
        }
        return list;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onResume() {
        super.onResume();
        setTitle("hello");
    }
}
