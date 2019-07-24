package com.app.architecture.ui.login;

import com.app.architecture.model.base.Errors;
import com.app.architecture.network.APICallHandler;
import com.app.architecture.network.APICallManager;
import com.app.architecture.network.APIType;

public class LoginPresenter implements ILoginPresenter, APICallHandler {

    private ILoginView mLoginView;


    public LoginPresenter(ILoginView loginView) {
        this.mLoginView = loginView;
    }

    public void onLogin(String email, String password) {
        APICallManager manager = new APICallManager(APIType.EMAIL_LOGIN, this);
        manager.emailLogin(email, password);
    }


    @Override
    public void onSuccess(APIType callType, Object responseBodyOb) {
        switch (callType) {
            case EMAIL_LOGIN:
                mLoginView.onLoginSuccessful();
                break;
        }
    }

    @Override
    public void onFailure(APIType apiType, int code, Errors errors) {
        mLoginView.onLoginFailed(errors.errorMessage);
    }
}
