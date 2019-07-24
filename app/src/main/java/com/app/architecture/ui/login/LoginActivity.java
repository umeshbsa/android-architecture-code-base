package com.app.architecture.ui.login;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.view.View;

import com.app.architecture.R;
import com.app.architecture.ui.BaseActivity;
import com.app.architecture.ui.home.HomeActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements ILoginView {


    @BindView(R.id.et_email)
    protected TextInputEditText etEmail;

    @BindView(R.id.et_password)
    protected TextInputEditText etPassword;

    private ILoginPresenter mLoginPresenter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLoginPresenter = new LoginPresenter(this);
    }

    @OnClick(R.id.btn_login)
    public void onLoginClick(View view) {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        mLoginPresenter.onLogin(email, password);
    }


    @Override
    public void onLoginSuccessful() {
        launchActivityMain(HomeActivity.class);
        finish();
    }

    @Override
    public void onLoginFailed(String errorMessage) {
        showSnackbar(errorMessage);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }
}

