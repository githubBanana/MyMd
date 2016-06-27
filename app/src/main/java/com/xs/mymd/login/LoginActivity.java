package com.xs.mymd.login;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.xs.mymd.R;
import com.xs.mymd.dialog.LoadingFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * @version V1.0 <基于 Material Design 的 Login>
 * @author: Xs
 * @date: 2016-06-04 09:06
 * @email Xs.lin@foxmail.com
 */
public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    @Bind(R.id.et_address)      EditText _addressEt;
    @Bind(R.id.et_password)     EditText _passwordEt;
    @Bind(R.id.bt_login)        AppCompatButton _loginBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_layout);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.bt_login )
    public void login(){
        if (TextUtils.isEmpty(_addressEt.getText()))
            _addressEt.setError("address is not null!");
        showProgress(_addressEt.getText().toString());
        _loginBtn.postDelayed(new Runnable() {
            @Override
            public void run() {
               dismissProgress();
//                Toast.makeText(LoginActivity.this,"jaja",Toast.LENGTH_LONG).show();
            }
        },5000);
    }
    private void showProgress(String message) {
        LoadingFragment.getLoad(message).show(getSupportFragmentManager(),"fragment_dialog");
    }
    private void dismissProgress() {
        Fragment prev = getSupportFragmentManager().findFragmentByTag("fragment_dialog");
        if (prev != null) {
            DialogFragment df = (DialogFragment) prev;
            df.dismiss();
        }
    }
    private void progressShow() {
        ProgressDialog progressDialog = ProgressDialog.show(LoginActivity.this,"title","message...");
        progressDialog.setCancelable(true);
        progressDialog.setCanceledOnTouchOutside(false);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
