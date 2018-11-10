package com.example.tip.trackinsurancepolicy.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tip.trackinsurancepolicy.Model.Policy;
import com.example.tip.trackinsurancepolicy.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdatePolicy extends AppCompatActivity {

    EditText name,policyNo,issueDate,lastDate,premiumAmt,paymentPeriod,age,claim,sumAssured,nominee,company,premiumDue;
    Button update,click;
    String cmp;
    private DatabaseReference databaseReference1;
    DataSnapshot dataSnapshot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_policy);

        name=(EditText)findViewById(R.id.updateNameId);
        company=(EditText)findViewById(R.id.updateCompanyId);
        policyNo=(EditText)findViewById(R.id.updatePolicyNoId);
        issueDate=(EditText)findViewById(R.id.updateIssuedDateId);
        lastDate=(EditText)findViewById(R.id.updateLastDateId);
        premiumAmt=(EditText)findViewById(R.id.updatePremiumAmtId);
        paymentPeriod=(EditText)findViewById(R.id.updatePaymentPeriodId);
        age=(EditText)findViewById(R.id.updateAgeId);
        claim=(EditText)findViewById(R.id.updateClaimId);
        sumAssured=(EditText)findViewById(R.id.updateSumId);
        nominee=(EditText)findViewById(R.id.updateNomineeId);
        update=(Button)findViewById(R.id.updateButtonId);
        click=(Button)findViewById(R.id.clickUpdate);
        premiumDue=(EditText)findViewById(R.id.updatePremiumDue);
        databaseReference1 = FirebaseDatabase.getInstance().getReference("policy");


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1 = name.getText().toString().trim();
                String company1 = company.getText().toString();
                String issuedate1 = issueDate.getText().toString();
                String lastdate1= lastDate.getText().toString();
                String premiumamt1 = premiumAmt.getText().toString();
                String paymentper1 = paymentPeriod.getText().toString();
                String cage1 = age.getText().toString();
                String premidue1 = premiumDue.getText().toString();
                String sumassured1 = sumAssured.getText().toString();
                String claim1=claim.getText().toString();
                String nomineename1 = nominee.getText().toString();
                String id = databaseReference1.push().getKey();
                String policyno1=policyNo.getText().toString();
                Policy policy = new Policy(id,policyno1,name1,company1,issuedate1,lastdate1,premiumamt1,paymentper1,cage1,premidue1,sumassured1,claim1,nomineename1);
                databaseReference1.child(id).setValue(policy);
                Toast.makeText(UpdatePolicy.this, "Policy Details Updated!!", Toast.LENGTH_SHORT).show();
            }
        });
        Intent intent3=new Intent(UpdatePolicy.this,HomePage.class);
        startActivity(intent3);
    }
}
