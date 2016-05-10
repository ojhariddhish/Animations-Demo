package com.dnsoftindia.animationdemo.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dnsoftindia.animationdemo.R;

public class SequentialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        overridePendingTransition(R.anim.enter_from_right, R.anim.exit_from_left);
        setContentView(R.layout.activity_sequential);
        setTitle("Sequential Animation");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.enter_from_left, R.anim.exit_from_right);
    }
}
