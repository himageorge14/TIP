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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.jar.Attributes;

public class AddPolicy extends AppCompatActivity {

    EditText NomineeId;
    EditText SumAssuredId;
    EditText AgeId;
    EditText PaymentPeriodId;
    EditText PaymentAmtId;
    EditText LastDateId;
    EditText IssueId;
    EditText ClaimId;
    EditText PolicyNoId;
    Button PolicyButtonId;
    Button ClickPictureId;
    EditText NameId;
    EditText CompanyId;
    EditText PremiumDue;


    DatabaseReference databasePolicy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_policy);
        CompanyId=(EditText)findViewById(R.id.addCompanyId);
        NomineeId=(EditText)findViewById(R.id.addNomineeId);
        SumAssuredId=(EditText)findViewById(R.id.addSumAssuredId);
        AgeId=(EditText)findViewById(R.id.addAgeId);
        PaymentPeriodId=(EditText)findViewById(R.id.addPaymentPeriodId);
        PaymentAmtId=(EditText)findViewById(R.id.addPremiumAmtId);
        LastDateId=(EditText)findViewById(R.id.addLastDateId);
        IssueId=(EditText)findViewById(R.id.addissueId);
        ClaimId=(EditText)findViewById(R.id.addClaimId);
        PolicyNoId=(EditText)findViewById(R.id.addPolicyNoId);
        ClickPictureId=(Button)findViewById(R.id.addClickPictureId);
        NameId=(EditText)findViewById(R.id.addNameId);
        PolicyButtonId=(Button)findViewById(R.id.addPolicyButtonId);
        PremiumDue=(EditText)findViewById(R.id.addPremiumDue);
        databasePolicy = FirebaseDatabase.getInstance().getReference("policy");

        PolicyButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPolicy();
                Intent intent1 = new Intent(AddPolicy.this,HomePage.class);
                startActivity(intent1);
            }
        });
    }

    private void addPolicy(){
        String no=PolicyNoId.getText().toString().trim();
        String name = NameId.getText().toString().trim();
        String company = CompanyId.getText().toString();
        String issuedate = IssueId.getText().toString();
        String lastdate = LastDateId.getText().toString();
        String premiumamt = PaymentAmtId.getText().toString();
        String paymentper = PaymentPeriodId.getText().toString();
        String cage = AgeId.getText().toString();
        String premidue = PremiumDue.getText().toString();
        String sumassured = SumAssuredId.getText().toString();
        String claim=ClaimId.getText().toString().trim();
        String nomineename = NomineeId.getText().toString();

        String id = databasePolicy.push().getKey();
        Policy policy = new Policy(id,no,name,company,issuedate,lastdate,premiumamt,paymentper,cage,premidue,sumassured,claim,nomineename);
        databasePolicy.child(id).setValue(policy);
        Toast.makeText(this, "Policy Added!!", Toast.LENGTH_SHORT).show();
    }
}
