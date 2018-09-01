package com.supershop.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.supershop.R;
import com.supershop.model.User;
import com.supershop.service.IUserService;
import com.supershop.service.UserService;
import com.supershop.utils.SaveSharedPreference;

public class LoginActivity extends Activity {

    EditText username;
    EditText password;
    TextView loginMessage;
    String loginErrorMessage;

    User user;
    private IUserService userService;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginMessage = findViewById(R.id.loginMessage);

        user = new User();
        userService = new UserService();
        if(SaveSharedPreference.getLoggedStatus(getApplicationContext())) {
            Intent intent = new Intent(getApplicationContext(), Dashboard.class);
            startActivity(intent);
        }

        if (mContext == null)
            mContext = this;
    }

    public void checkLogin(View view) {
        String uName = username.getText().toString();
        String pass = password.getText().toString();
        user.setUsername(uName);
        user.setPassword(pass);
        boolean isLogin = userService.isLogin(user, mContext);
        if(isLogin){
            Intent intent = new Intent(mContext, Dashboard.class);
            startActivity(intent);
        }else
            Toast.makeText(this, "Please check username and password", Toast.LENGTH_SHORT).show();

    }

    public void createAccount(View view) {
        Intent intent = new Intent(getApplicationContext(), AccoutRegistration.class);
        startActivity(intent);
    }
}
