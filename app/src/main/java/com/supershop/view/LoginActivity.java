package com.supershop.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.supershop.R;
import com.supershop.service.IUserService;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends Activity {

    @BindView(R.id.username)EditText username;
    @BindView(R.id.password)EditText password;
    @BindView(R.id.loginMessage)TextView loginMessage;

    IUserService userService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    public void checkLogin(View view) {
        String uName = username.getText().toString();
        String pass = password.getText().toString();
        Toast.makeText(this,uName+" and "+pass,Toast.LENGTH_LONG).show();
    }
}
