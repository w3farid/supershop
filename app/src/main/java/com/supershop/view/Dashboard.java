package com.supershop.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.supershop.R;
import com.supershop.utils.SaveSharedPreference;

public class Dashboard extends AppCompatActivity {
    private Context mContext;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        imageView = findViewById(R.id.ds_add_product);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddProduct.class);
                startActivity(intent);
            }
        });
        if (mContext == null)
            mContext = this;
    }


    public void logout(View view) {
        SaveSharedPreference.setLoggedIn(mContext, false);
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Successfully Logout", Toast.LENGTH_SHORT).show();

    }

    public void goProductList(View view) {
        Intent intent = new Intent(getApplicationContext(), ProductList.class);
        startActivity(intent);
    }
}
