package com.xs.mymd;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-05-20 11:04
 * @email Xs.lin@foxmail.com
 */
public abstract class BaseAdapter<T> extends RecyclerView.Adapter {
    private static final String TAG = "BaseAdapter";

    private List<T> mList;
    private Object mLock = new Object();

    public BaseAdapter() {
        mList = new ArrayList<>();
        Log.e(TAG,"new BaseAdapter");
    }

    public List<T> getmList() {
        return mList;
    }
    public boolean addAll(Collection<T> items) {
        synchronized (mLock) {
            int size = getmList().size();
            if (getmList().addAll(items)) {
                notifyItemRangeInserted(size,items.size());
                return true;
            }
            return false;
        }

    }

    public boolean addAll(T... items) {
        synchronized (mLock) {
            int size = getmList().size();
            if (Collections.addAll(getmList(),items)) {
                notifyItemRangeInserted(size,items.length);
                return true;
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public T getItem(int position) {
        return getmList().get(position);
    }
}
