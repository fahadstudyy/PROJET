package com.example.ssvlvotings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ssvlvotings.Fragments.ProfileFragment;

public class viewinfo extends AppCompatActivity {
    TextView mail,fname,lname,rollno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_viewinfo);
        Bundle bundle = getIntent().getExtras();


        mail = (TextView) findViewById(R.id.email);
        mail.setText(currentuser.email);
        fname = (TextView) findViewById(R.id.Fname);
        fname.setText(currentuser.firstname);
        lname = (TextView) findViewById(R.id.Lname);
        lname.setText(currentuser.lastname);
        rollno = (TextView) findViewById(R.id.rollno);
        rollno.setText(currentuser.rollno);


    }
}