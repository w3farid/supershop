package com.supershop.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.supershop.R;
import com.supershop.model.User;
import com.supershop.service.IUserService;
import com.supershop.service.UserService;
import com.supershop.utils.SaveSharedPreference;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends Activity {

    @BindView(R.id.username)EditText username;
    @BindView(R.id.password)EditText password;
    @BindView(R.id.loginMessage)TextView loginMessage;
    @BindString(R.string.loginErrorMessage) String loginErrorMessage;

    User user;
    private IUserService userService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        user = new User();
        userService = new UserService();
        if(!SaveSharedPreference.getLoggedStatus(getApplicationContext())) {
            Intent intent = new Intent(getApplicationContext(), Dashboard.class);
            startActivity(intent);
        }
    }

    public void checkLogin(View view) {
        String uName = username.getText().toString();
        String pass = password.getText().toString();
        user.setUsername(uName);
        user.setPassword(pass);
        boolean isLogin = userService.isLogin(user, getApplicationContext());
        if(isLogin){
            Intent intent = new Intent(getApplicationContext(), Dashboard.class);
            startActivity(intent);
        }else
            loginMessage.setText(loginErrorMessage);

    }

    public void createAccount(View view) {
        Intent intent = new Intent(getApplicationContext(), Shop.class);
        startActivity(intent);
    }
}
