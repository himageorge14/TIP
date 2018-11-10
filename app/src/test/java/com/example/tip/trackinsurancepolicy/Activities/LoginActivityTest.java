package com.example.tip.trackinsurancepolicy.Activities;

import android.content.pm.ActivityInfo;
import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.widget.LinearLayout;

import com.example.tip.trackinsurancepolicy.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class LoginActivityTest {
    @Rule

    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<LoginActivity>(LoginActivity.class);

    private LoginActivity pact = null;

    @Before

    public void setUp() throws Exception {

        pact = mActivityTestRule.getActivity();

    }


    @After

    public void tearDown() throws Exception {

        pact = null;

    }
}