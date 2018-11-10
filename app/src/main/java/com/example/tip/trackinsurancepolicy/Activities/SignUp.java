package com.example.tip.trackinsurancepolicy.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tip.trackinsurancepolicy.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.app.PendingIntent.getActivity;

public class SignUp extends AppCompatActivity {

    EditText fname,lname,emailID,phone,pswd;
    Button signUpButton;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();

        fname=(EditText)findViewById(R.id.signNameId);
        lname=(EditText)findViewById(R.id.signLastNameId);
        emailID=(EditText)findViewById(R.id.signEmailId);
        phone=(EditText)findViewById(R.id.signPhoneId);
        pswd=(EditText)findViewById(R.id.signPasswordId);
        signUpButton=(Button)findViewById(R.id.signButtonId);


        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email= emailID.getText().toString();
                String password=pswd.getText().toString();
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("msg", "createUserWithEmail:success");
                                    //FirebaseUser user = mAuth.getCurrentUser();
                                    Toast.makeText(SignUp.this,"Authentication success",Toast.LENGTH_LONG).show();
                                    Intent intent=new Intent(SignUp.this,HomePage.class);
                                    startActivity(intent);

                                }
                                else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("msg", "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(SignUp.this,"Authentication failed",Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });


    }
}
