package com.example.ashishkumar.samplemvp.interactors;

/**
 * Created by ashishkumar on 8/27/17.
 */

public interface LoginInteractor {
    void login(String userName, String password, LoginListener loginListener);

    interface LoginListener {
        void onLoginSuccess();

        void onLoginFailed(String errorMessage);
    }
}
