package com.example.ashishkumar.samplemvp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ashishkumar.samplemvp.interactors.LoginInteractorImpl;
import com.example.ashishkumar.samplemvp.preseneters.LoginPresenter;
import com.example.ashishkumar.samplemvp.preseneters.LoginPresenterImpl;

public class LoginActivity extends AppCompatActivity implements LoginPresenter.LoginView, View.OnClickListener {

    private ProgressDialog mProgressDialog;

    private EditText mUserNameEditText;
    private EditText mPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mUserNameEditText = (EditText) findViewById(R.id.user_et);
        mPasswordEditText = (EditText) findViewById(R.id.password_et);
        Button mLoginButton = (Button) findViewById(R.id.login_button);
        mLoginButton.setOnClickListener(this);
    }

    @Override
    public void showProgress() {
        if (mProgressDialog == null || !mProgressDialog.isShowing()) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mProgressDialog.setCancelable(false);
            mProgressDialog.setIndeterminate(true);
            mProgressDialog.setMessage("Loading");
            mProgressDialog.show();
        }
    }

    @Override
    public void stopProgress() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }

    @Override
    public String getUserName() {
        return mUserNameEditText.getText().toString();
    }

    @Override
    public String getPassword() {
        return mPasswordEditText.getText().toString();
    }

    @Override
    public void loginFailed(String errorMessage) {
        Toast.makeText(getBaseContext(), errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginSuccess() {
        startActivity(new Intent(this, HomeActivity.class));
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.login_button) {
            LoginPresenter mLoginPresenter = new LoginPresenterImpl(new LoginInteractorImpl(), this);
            mLoginPresenter.login();
        }
    }


}
