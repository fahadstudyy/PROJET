package com.example.ssvlvotings;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;

        import android.app.ProgressDialog;
        import android.content.Intent;
        import android.os.Bundle;
        import android.text.TextUtils;
        import android.view.View;
        import android.view.WindowManager;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;

public class signup extends AppCompatActivity{

    private EditText email, fname, lname, rollno, pass;
    private Button btn;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup);

        //initializing views
        email = (EditText) findViewById(R.id.email);
        fname = (EditText) findViewById(R.id.fname);
        lname = (EditText) findViewById(R.id.lname);
        rollno = (EditText) findViewById(R.id.rollno);
        pass = (EditText) findViewById(R.id.pass);
        btn = (Button) findViewById(R.id.button);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("students");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mDialog = new ProgressDialog(signup.this);
                mDialog.setMessage("Please Wait....");
                mDialog.show();

                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // check if already user phone
                        if(dataSnapshot.child(rollno.getText().toString()).exists())
                        {
                            mDialog.dismiss();
                            Toast.makeText(signup.this, "Phone Number Already Registered", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            mDialog.dismiss();
                            register user = new register(email.getText().toString(),fname.getText().toString(),lname.getText().toString(),rollno.getText().toString(),pass.getText().toString());
                            databaseReference.child(rollno.getText().toString()).setValue(user);
                            Toast.makeText(signup.this,"Sign Up Successfully!", Toast.LENGTH_SHORT).show();
                            Intent intent =new Intent(signup.this,dashboard.class);
                            currentuser.email= user.getEmail();
                            currentuser.firstname = user.getFirstname();
                            currentuser.lastname = user.getLastname();
                            currentuser.rollno = user.rollno;
                            currentuser.password = user.password;
                            startActivity(intent);
                        }

                    }

                    @Override
                    public void onCancelled( DatabaseError databaseError) {

                    }
                });

            }
        });

    }
    private void insertstudentdata()
    {
        String mail = email.getText().toString();
        String fn = fname.getText().toString();
        String ln = lname.getText().toString();
        String rn = rollno.getText().toString();
        String ps = pass.getText().toString();

        register reg = new register(mail,fn,ln,rn,ps);

        databaseReference.push().setValue(reg);
        Toast.makeText(signup.this,"Data Entered Succesfully",Toast.LENGTH_SHORT).show();

    }
}
























