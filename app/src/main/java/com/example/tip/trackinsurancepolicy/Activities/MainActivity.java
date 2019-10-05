package com.example.tip.trackinsurancepolicy.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.tip.trackinsurancepolicy.R;
import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {

    private Button signUp;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signUp=(Button)findViewById(R.id.signUpButtonId);
        login=(Button)findViewById(R.id.loginButtonId);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,SignUp.class);
                startActivity(intent);
            }
        });
         /*
            The login button is attached to an event listener
            the listener listens for a CLICK event,
            to provide the action to be performed after the click event, we need to implement(override) the OnClick method of View interface
            
        */
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //this will show up only in terminal of android studio
                System.out.println("Clicked on Login");
                
                Intent intent1 =new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent1);
            }
        });
    }
}
