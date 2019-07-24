
package com.app.architecture.ui.splash;

import android.os.Bundle;

import com.app.architecture.R;
import com.app.architecture.base.BaseActivity;
import com.app.architecture.ui.home.HomeActivity;
import com.app.architecture.ui.login.LoginActivity;

public class SplashActivity extends BaseActivity implements ISplashView {

    ISplashPresenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new SplashPresenter(this);
        mPresenter.navigate();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }


    public void gotoScreen(boolean isLogin) {
        if (isLogin) {
            launchActivity(HomeActivity.class);
        } else {
            launchActivity(LoginActivity.class);
        }
        finish();
    }

    @Override
    public void onBackPressed() {
        mPresenter.onDestroy();
        super.onBackPressed();

    }
}
