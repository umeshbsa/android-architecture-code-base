package com.app.architecture.ui.splash;

import android.os.Handler;

import com.app.architecture.utils.AppConstant;
import com.app.architecture.utils.PreferenceKeeper;

public class SplashPresenter implements ISplashPresenter {

    private Handler handler;
    private Runnable runnable;

    private ISplashView mSplashView;

    public SplashPresenter(ISplashView mSplashView) {
        this.mSplashView = mSplashView;
    }

    @Override
    public void navigate() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                boolean isLogin = PreferenceKeeper.getInstance().isUserLogin();
                mSplashView.gotoScreen(isLogin);
            }
        };
        handler.postDelayed(runnable, AppConstant.SPLASH_DELAY);
    }

    @Override
    public void onDestroy() {
        if (runnable != null && handler != null) {
            handler.removeCallbacks(runnable);
        }
    }
}
