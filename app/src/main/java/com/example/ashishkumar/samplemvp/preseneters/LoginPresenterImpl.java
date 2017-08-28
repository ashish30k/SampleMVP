package com.example.ashishkumar.samplemvp.preseneters;

import com.example.ashishkumar.samplemvp.interactors.LoginInteractor;

/**
 * Created by ashishkumar on 8/27/17.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.LoginListener {

    private LoginInteractor mInteractor;
    private LoginView mView;

    public LoginPresenterImpl(LoginInteractor mInteractor, LoginView mView) {
        this.mInteractor = mInteractor;
        this.mView = mView;
    }

    @Override
    public void login() {
        mView.showProgress();
        mInteractor.login(mView.getUserName(), mView.getPassword(), this);
    }

    @Override
    public void onLoginSuccess() {
        mView.stopProgress();
        mView.loginSuccess();
    }

    @Override
    public void onLoginFailed(String errorMessage) {
        mView.stopProgress();
        mView.loginFailed(errorMessage);
    }
}
