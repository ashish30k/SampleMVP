package com.example.ashishkumar.samplemvp.interactors;

import android.text.TextUtils;

/**
 * Created by ashishkumar on 8/27/17.
 */

public class LoginInteractorImpl implements LoginInteractor {
    @Override
    public void login(String userName, String password, LoginListener loginListener) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (loginListener != null) {
            if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(password)) {
                loginListener.onLoginSuccess();
            } else {
                loginListener.onLoginFailed("Login Failed");
            }
        }

    }
}
