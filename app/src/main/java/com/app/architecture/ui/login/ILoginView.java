package com.app.architecture.ui.login;

public interface ILoginView {

    void onLoginSuccessful();

    void onLoginFailed(String errorMessage);
}
