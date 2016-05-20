package com.xs.mymd;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.xs.mymd.databinding.ModelItemBinding;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-05-20 11:20
 * @email Xs.lin@foxmail.com
 */
public class MyModelAdapter extends BaseAdapter<MyModel> implements View.OnClickListener{
    private static final String TAG = "MyModelAdapter";

    Activity mAct;
    OnClickItemListen onClickItemListen;

    public MyModelAdapter(Activity activity,OnClickItemListen onClickItemListen) {
        this.mAct = activity;
        this.onClickItemListen = onClickItemListen;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mAct.getLayoutInflater().inflate(R.layout.model_item,parent,false);
        return new Holder(mAct,view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Holder h = (Holder) holder;
        h.mItemView.setTag(h);
        h.setData(getItem(position),position);
    }

    @Override
    public void onClick(View v) {

    }

    public static class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Activity mAct;
        View mItemView;
        ModelItemBinding mItemBinding;
        DisplayMetrics mDisplayMetrics;
        public Holder(Activity activity,View itemView) {
            super(itemView);
            mAct = activity;
            mItemView = itemView;
            mItemBinding = DataBindingUtil.bind(mItemView);
            mItemBinding.cdView.setOnClickListener(this);
            mDisplayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(mDisplayMetrics);
        }

        public void setData(MyModel myModel,int position) {
            mItemBinding.setA(myModel.getA());
            mItemBinding.setB(myModel.getB());
            mItemBinding.cdView.setCardBackgroundColor(0xffffffff);
            mItemBinding.cdView.setCardElevation(50f);
            mItemBinding.cdView.setUseCompatPadding(true);
            Log.e(TAG,"setdata myModel:"+myModel.toString());

            mItemBinding.tvA.setTag(myModel);
            mItemBinding.tvB.setTag(myModel);
            mItemBinding.cdView.setTag(myModel);
        }

        @Override
        public void onClick(View v) {
            Log.e(TAG,"getTag:"+v.getTag());

            switch (v.getId()) {
                case R.id.cd_view:
                MyModel myModel = (MyModel) v.getTag();
                Toast.makeText(mAct, myModel.toString(), Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }

    public interface OnClickItemListen<T> {
        void onItemClick(View view, T t, int position);
    }
}
