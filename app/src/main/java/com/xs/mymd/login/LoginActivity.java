package com.xs.mymd.login;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.widget.EditText;

import com.xs.mymd.R;
import com.xs.mymd.dialog.LoadingFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-06-04 09:06
 * @email Xs.lin@foxmail.com
 */
public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    @Bind(R.id.et_address)      EditText _addressEt;
    @Bind(R.id.et_password)     EditText _passwordEt;
    @Bind(R.id.bt_login)        AppCompatButton _loginBtn;
    private LoadingFragment _loadingFm;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_layout);
        ButterKnife.bind(this);
        _loadingFm = LoadingFragment.getLoad(null);
    }
    @OnClick(R.id.bt_login )
    public void login(){
        showProgress(_addressEt.getText().toString());
        _loginBtn.setEnabled(false);
        _loginBtn.postDelayed(new Runnable() {
            @Override
            public void run() {
                dismissProgress();
                _loginBtn.setEnabled(true);
            }
        },5000);
    }
    private void showProgress(String message) {
        if (message == null || "".equals(message)) {}
        else {
            _loadingFm.setMessage(message);
            _loadingFm.show(getSupportFragmentManager(),"loading");
        }
    }
    private void dismissProgress() {
        if (_loadingFm != null)
            _loadingFm.dismiss();
    }
    private void progressShow() {
        ProgressDialog progressDialog = ProgressDialog.show(LoginActivity.this,"title","message...");
        progressDialog.setCancelable(true);
        progressDialog.setCanceledOnTouchOutside(false);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        dismissProgress();
        _loginBtn.setEnabled(true);
    }
}
