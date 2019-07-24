package com.app.architecture.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.app.architecture.R;
import com.app.architecture.base.BaseActivity;
import com.app.architecture.base.BaseFragment;
import com.app.architecture.fragmentfactory.FragmentFactory;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
    }

    private void initUI() {
        BaseFragment profileFragment = FragmentFactory.newInstance().getFragment(FragmentFactory.TYPE.PROFILE);
        replaceFragment(R.id.fl_home_container, profileFragment);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }
}
