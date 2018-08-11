package com.supershop.view;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.supershop.R;

public class Shop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
    }

    public void createShopAccount(View view) {
        Fragment fragment;
        fragment = new CreateShopFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ftx = fm.beginTransaction();
        ftx.add(R.id.setupAccountFragment, fragment);
        ftx.addToBackStack(null);
        ftx.commit();
        Toast.makeText(this, "he", Toast.LENGTH_SHORT).show();

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_pirates:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.radio_ninjas:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }
}
