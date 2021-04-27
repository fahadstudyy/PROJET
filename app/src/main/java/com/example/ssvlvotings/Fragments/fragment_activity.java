package com.example.ssvlvotings.Fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.ssvlvotings.R;
import com.example.ssvlvotings.currentuser;

public class fragment_activity extends AppCompatActivity {
    TextView yourname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_activity);

        yourname = (TextView) findViewById(R.id.name);
        yourname.setText(currentuser.firstname);


    }
}