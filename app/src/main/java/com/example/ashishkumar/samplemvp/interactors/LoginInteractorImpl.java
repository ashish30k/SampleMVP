package com.example.ashishkumar.samplemvp.interactors;

import android.os.AsyncTask;
import android.text.TextUtils;

/**
 * Created by ashishkumar on 8/27/17.
 */

public class LoginInteractorImpl implements LoginInteractor {

    private LoginListener loginListener;

    @Override
    public void login(String userName, String password, LoginListener loginListener) {
        this.loginListener = loginListener;

        if (loginListener != null) {
            new LoginAsyncTask().execute(userName, password);
        }

    }

    private class LoginAsyncTask extends AsyncTask<String, Void, Boolean> {
        @Override
        protected Boolean doInBackground(String... strings) {
            String userName = strings[0];
            String password = strings[1];
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return !TextUtils.isEmpty(userName) && !TextUtils.isEmpty(password);
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if (result) {
                loginListener.onLoginSuccess();
            } else {
                loginListener.onLoginFailed("Login Failed");
            }
        }
    }
}
