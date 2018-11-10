package com.example.tip.trackinsurancepolicy.Activities;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tip.trackinsurancepolicy.Data.PolicyList;
import com.example.tip.trackinsurancepolicy.Model.Policy;
import com.example.tip.trackinsurancepolicy.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomePage extends AppCompatActivity {

    ListView listView;
    List<Policy> policyList;
    DatabaseReference databasePolicy;
    TextView policykey;
    public HashMap<String,String> hashPolicies; //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        listView = findViewById(R.id.listviewPolicy);
        databasePolicy = FirebaseDatabase.getInstance().getReference("policy");
        policyList = new ArrayList<>();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent2 = new Intent(HomePage.this,PolicyDetails.class);
                policykey=(TextView)findViewById(R.id.textView14);
                String keyP=policykey.getText().toString();
                Log.d("keyId",keyP);
                intent2.putExtra("keyID",keyP);
                startActivity(intent2);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        databasePolicy.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                policyList.clear();
                for (DataSnapshot policySnapshot : dataSnapshot.getChildren()){
                    Policy policy = policySnapshot.getValue(Policy.class);
                    policyList.add(policy);
                   // hashPolicies.put(policy.policyID,policy.policyNo);  //

                }
                PolicyList adapter = new PolicyList(HomePage.this,policyList);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.search_with_add,menu);
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.addPolicyIconId:
                Intent intent = new Intent(HomePage.this,AddPolicy.class);
                startActivity(intent);
                return true;
            case R.id.searchIconId:

                return true;
            case R.id.signOutIconId:
                FirebaseAuth mAuth = FirebaseAuth.getInstance();
                try {
                    mAuth.signOut();
                    Toast.makeText(this, "User Sign out!", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(HomePage.this,MainActivity.class);
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
