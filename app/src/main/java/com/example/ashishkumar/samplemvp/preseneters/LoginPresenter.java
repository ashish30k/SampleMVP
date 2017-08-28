package com.example.ashishkumar.samplemvp.preseneters;

/**
 * Created by ashishkumar on 8/27/17.
 */

public interface LoginPresenter {
    interface LoginView extends BaseMVPView {

        String getUserName();

        String getPassword();

        void loginFailed(String errorMessage);

        void loginSuccess();
    }

    void login();

}
