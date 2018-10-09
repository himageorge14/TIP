package com.example.tip.trackinsurancepolicy.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.tip.trackinsurancepolicy.R;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }

    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.search_with_add,menu);
        return true;
    }

  /*  public boolean onOptionsItemSelected(MenuItem item){

    }*/



};




