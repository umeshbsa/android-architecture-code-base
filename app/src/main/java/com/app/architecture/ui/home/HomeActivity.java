package com.app.architecture.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.app.architecture.R;
import com.app.architecture.ui.BaseActivity;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
}
