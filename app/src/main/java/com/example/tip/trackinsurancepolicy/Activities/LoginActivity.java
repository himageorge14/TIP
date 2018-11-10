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

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText usernme;
    EditText passwd;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        mAuth = FirebaseAuth.getInstance();
        usernme=(EditText)findViewById(R.id.usernameId);
        passwd=(EditText)findViewById(R.id.passwordId);
        loginButton=(Button)findViewById(R.id.loginPageButtonId);



        loginButton.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View view) {
               String email1=usernme.getText().toString();
               String pssword1=passwd.getText().toString();
                mAuth.signInWithEmailAndPassword(email1, pssword1)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("Status", "signInWithEmail:success");
                                    Toast.makeText(LoginActivity.this, "Login Successful!!", Toast.LENGTH_SHORT).show();
                                    FirebaseUser user1 = mAuth.getCurrentUser();
                                    startActivity(new Intent(LoginActivity.this,HomePage.class));

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("Status", "signInWithEmail:failure", task.getException());
                                    Toast.makeText(LoginActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }

                                // ...
                            }
                        });
            }
        });

    }


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }
}
