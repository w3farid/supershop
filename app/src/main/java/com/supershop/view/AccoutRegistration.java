package com.supershop.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.supershop.R;
import com.supershop.model.User;
import com.supershop.service.IUserService;
import com.supershop.service.UserService;

import java.util.List;

public class AccoutRegistration extends AppCompatActivity implements View.OnClickListener {
    EditText et_name;
    EditText et_email;
    RadioButton radio_male;
    RadioButton radio_female;
    EditText et_username;
    EditText et_password;
    EditText et_contact_no;
    Button btn_submit;
    User user;
    IUserService userService;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accout_registration);
        et_name = findViewById(R.id.et_rg_name);
        et_email = findViewById(R.id.et_rg_email);
        radio_male = findViewById(R.id.radio_rg_male);
        radio_female = findViewById(R.id.radio_rg_female);
        et_username = findViewById(R.id.et_rg_username);
        et_password = findViewById(R.id.et_rg_password);
        et_contact_no = findViewById(R.id.et_rg_contact_no);
        btn_submit = findViewById(R.id.btn_rg_submit);

        userService = new UserService();
        btn_submit.setOnClickListener(this);

        if (mContext == null)
            mContext = this;
    }

    @Override
    public void onClick(View view) {
        User user1 = new User();
        user1.setName(et_name.getText().toString());
        user1.setEmail(et_email.getText().toString());
        user1.setMale(radio_male.getText().toString());
        user1.setFemale(radio_female.getText().toString());
        user1.setUsername(et_username.getText().toString());
        user1.setPassword(et_password.getText().toString());
        user1.setContact(et_contact_no.getText().toString());
        userService.insertData(mContext, user1);
        List<User> userList = userService.getAll(mContext);
        if (!userList.isEmpty()) {
            Toast.makeText(this, "You Account Successfully Created", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(mContext, LoginActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "You can't created account. please chek all field.", Toast.LENGTH_SHORT).show();

        }
        }
}
