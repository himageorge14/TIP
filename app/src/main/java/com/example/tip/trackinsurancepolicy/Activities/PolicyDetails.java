package com.example.tip.trackinsurancepolicy.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tip.trackinsurancepolicy.Model.Policy;
import com.example.tip.trackinsurancepolicy.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class PolicyDetails extends AppCompatActivity {

    TextView name;
    TextView company,issueDate,lastDate,premiumAmt,paymentPeriod,age,premiumDue,sumAssured,nominee,claim;
    Button updateb,deleteb;
    List<Policy> policyList1;
    DatabaseReference databaseReference;
    String key;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_policy_details);

        name=(TextView)findViewById(R.id.displayNameId);
        company=(TextView)findViewById(R.id.displayCompanyId);
        issueDate=(TextView)findViewById(R.id.displayDateId);
        lastDate=(TextView)findViewById(R.id.displayLastDateId);
        premiumAmt=(TextView)findViewById(R.id.displayAmtId);
        paymentPeriod=(TextView)findViewById(R.id.displayPaymentId);
        age=(TextView)findViewById(R.id.displayAgeId);
        premiumDue=(TextView)findViewById(R.id.displayDueDateId);
        sumAssured=(TextView)findViewById(R.id.displaySumAssuredId);
        nominee=(TextView)findViewById(R.id.displayNomineeId);
        claim=(TextView)findViewById(R.id.displayClaimId);
        updateb=(Button)findViewById(R.id.policyUpdateButtonId);
        deleteb=(Button)findViewById(R.id.policyDeleteButtonId);


        policyList1 = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference("policy");
        Intent intentPdetails=getIntent();

        key=intentPdetails.getStringExtra("keyID");
        Log.d("checkKey",key);


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){

                    Policy policy1 = dataSnapshot1.getValue(Policy.class);
                    if(policy1.policyNo.equals(key)) {
                        name.setText(policy1.policyName);
                        Log.d("CHECK", policy1.policyName);
                        company.setText(policy1.pCompany);
                        issueDate.setText(policy1.pIssueDate);
                        lastDate.setText(policy1.pLastDate);
                        premiumAmt.setText(policy1.pPremAmt);
                        paymentPeriod.setText(policy1.pPayPeriod);
                        age.setText(policy1.pAge);
                        premiumDue.setText(policy1.pPremDueDate);
                        sumAssured.setText(policy1.pSumAssured);
                        nominee.setText(policy1.pNomineeName);
                        claim.setText(policy1.pClaim);
                    }
                }}

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        updateb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("transition","we are going");
                Intent intentu = new Intent(PolicyDetails.this,UpdatePolicy.class);
                startActivity(intentu);
            }
        });
        deleteb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                databaseReference.removeValue();

                Intent intentdel = new Intent(PolicyDetails.this,HomePage.class);
                startActivity(intentdel);
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.search_with_add,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.addPolicyIconId:
                Intent intent = new Intent(PolicyDetails.this,AddPolicy.class);
                startActivity(intent);
                return true;
            case R.id.searchIconId:

                return true;
            case R.id.signOutIconId:
                FirebaseAuth mAuth = FirebaseAuth.getInstance();
                try {
                    mAuth.signOut();
                    Toast.makeText(this, "User Sign out!", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(PolicyDetails.this,MainActivity.class);
                    startActivity(i);
                }catch (Exception e) {
                    Log.e("signOut", "onClick: Exception "+e.getMessage(),e );
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
