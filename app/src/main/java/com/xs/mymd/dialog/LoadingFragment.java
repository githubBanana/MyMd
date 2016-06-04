package com.xs.mymd.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xs.mymd.R;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-06-04 14:48
 * @email Xs.lin@foxmail.com
 */
public class LoadingFragment extends DialogFragment {
    private static final String TAG = "LoadingFragment";
    private static final String LABEL = "message";
    public static LoadingFragment getLoad(String message) {
        LoadingFragment lf = new LoadingFragment();
        Bundle bundle = new Bundle();
        bundle.putString(LABEL, message);
        lf.setArguments(bundle);
        return lf;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setCancelable(true);
        setStyle(DialogFragment.STYLE_NORMAL,R.style.AppTheme_Loading);
    }
    private View _view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        _view = inflater.inflate(R.layout.dialog_loading_layout,container,false);
        String message = getArguments().getString(LABEL);
        Log.e(TAG, "onCreateView: "+message );
        if (message == null || "".equals(message)){}
            else{
            final TextView _message = (TextView) _view.findViewById(R.id.tv_progress_message);
            _message.setVisibility(View.VISIBLE);
            _message.setText(message);
        }
        return _view;
    }

    public void setMessage(String message) {
        final TextView _message = (TextView) _view.findViewById(R.id.tv_progress_message);
        _message.setVisibility(View.VISIBLE);
        _message.setText(message);
    }

}
