package com.app.architecture.base;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;

import com.app.architecture.R;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {


    private ProgressDialog progressDialog;

    /**
     * Launch activity using class concept
     *
     * @param classType launching class
     */
    public void launchActivity(Class<? extends BaseActivity> classType) {
        startActivity(new Intent(this, classType));
    }

    /**
     * Launch activity using class concept and pass data using bundle
     *
     * @param classType launching class
     */
    public void launchActivity(Class<? extends BaseActivity> classType, Bundle bundle) {
        Intent intent = new Intent(this, classType);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * Launch activity with clear all stack
     *
     * @param classType launching class
     */
    public void launchActivityMain(Class<? extends BaseActivity> classType) {
        Intent intent = new Intent(this, classType);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }


    public void showProgressBar(String msg, boolean isCancel) {
        hideProgressBar();
        if (!BaseActivity.this.isFinishing()) {
            progressDialog = ProgressDialog.show(BaseActivity.this, "", msg, false);
            if (progressDialog != null) {
                progressDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
                    @Override
                    public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                        hideProgressBar();
                        return false;
                    }
                });
                progressDialog.setCanceledOnTouchOutside(isCancel);
                progressDialog.setContentView(R.layout.progress_layout);
                progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            }
        }
    }

    /**
     * Show progress bar with single ocurrent object
     */
    public void showProgressBar() {
        hideProgressBar();
        if (!BaseActivity.this.isFinishing()) {
            progressDialog = ProgressDialog.show(BaseActivity.this, "", "", true);
            if (progressDialog != null) {
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.setContentView(R.layout.progress_layout);
                progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            }
        }
    }

    public void hideProgressBar() {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    public void hideSoftKeyBoard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        if (getCurrentFocus() != null) {
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                    InputMethodManager.RESULT_UNCHANGED_SHOWN);
        }
    }

    /**
     * show snack bar with no callback detection
     *
     * @param id msg
     */
    public void showSnackbar(final int id) {
        Snackbar.make(findViewById(android.R.id.content),
                getString(id),
                Snackbar.LENGTH_LONG)
                .show();
    }

    public void showSnackbar(String msg) {
        if (!TextUtils.isEmpty(msg)) {
            Snackbar.make(findViewById(android.R.id.content),
                    msg,
                    Snackbar.LENGTH_SHORT)
                    .show();
        }
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
    }


    public void replaceFragment(int containerId, boolean isStackAllow, BaseFragment baseFragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(containerId, baseFragment);
        if (isStackAllow) {
            transaction.addToBackStack(baseFragment.getClass().getSimpleName());
        }
        transaction.commit();
    }

    public void replaceFragment(int containerId, BaseFragment baseFragment) {
        replaceFragment(containerId, false, baseFragment);
    }

    public abstract int getLayoutId();
}
