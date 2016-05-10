
package com.dnsoftindia.animationdemo.activities;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.dnsoftindia.animationdemo.R;

public class FrameAnimationActivity extends AppCompatActivity {

    private ImageView ivFrame;
    private AnimationDrawable animFrameDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);
        ActionBar ab = getSupportActionBar();
        if (ab!=null) {
            ab.hide();
        }


    }

    @Override
    protected void onResume() {
        super.onResume();

        ivFrame = (ImageView) findViewById(R.id.ivFrame);
        ivFrame.setBackgroundResource(R.drawable.frame_animation);

        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                animFrameDrawable = (AnimationDrawable) ivFrame.getBackground();
                animFrameDrawable.start();
            }
        }, 700);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (animFrameDrawable!=null) {
            animFrameDrawable.stop();
        }
    }
}
