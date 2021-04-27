package com.example.ssvlvotings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {
    EditText un,pass;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("students");


        Button signup = (Button) findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(login.this,signup.class);
                startActivity(intent);
            }
        });

        Button signin = (Button) findViewById(R.id.signin);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                un = findViewById(R.id.emaill);
                pass = findViewById(R.id.pass);

                final ProgressDialog mDialog = new ProgressDialog(login.this);
                mDialog.setMessage("Please Wait....");
                mDialog.show();
                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        // check if user not exit in database
                        if (dataSnapshot.child(un.getText().toString()).exists()) {
                            // get user information

                            mDialog.dismiss();
                            register user = dataSnapshot.child(un.getText().toString()).getValue(register.class);
                            if (user.getPassword().equals(pass.getText().toString())) {
                                Toast.makeText(login.this, " SignIn Successfull !!", Toast.LENGTH_SHORT).show();
                                Intent homeintent = new Intent(login.this,dashboard.class);
                                currentuser.email= user.getEmail();
                                currentuser.firstname = user.getFirstname();
                                currentuser.lastname = user.getLastname();
                                currentuser.rollno = user.rollno;
                                currentuser.password = user.password;
                                startActivity(homeintent);
                                finish();
                            } else {
                                Toast.makeText(login.this, "Wrong Password !!!", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            mDialog.dismiss();
                            Toast.makeText(login.this, "user not exist in database", Toast.LENGTH_SHORT).show();
                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }


                });

            }
        });
    }
}

