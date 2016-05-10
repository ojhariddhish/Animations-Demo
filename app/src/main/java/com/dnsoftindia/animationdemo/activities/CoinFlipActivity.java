package com.dnsoftindia.animationdemo.activities;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.dnsoftindia.animationdemo.R;

public class CoinFlipActivity extends AppCompatActivity {

    private AnimatorSet leftIn, rightOut;
    private boolean isBackVisible = false;
    private View coinFront, coinBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_flip);
        setTitle("Coin Flip");

        leftIn = (AnimatorSet) AnimatorInflater.loadAnimator(CoinFlipActivity.this, R.animator.flip_in);
        rightOut = (AnimatorSet) AnimatorInflater.loadAnimator(CoinFlipActivity.this, R.animator.flip_out);

        coinFront = findViewById(R.id.coin_front);
        coinBack = findViewById(R.id.coin_back);

        int distance = 2000;
        float scale = getResources().getDisplayMetrics().density * distance;
        coinFront.setCameraDistance(scale);
        coinBack.setCameraDistance(scale);

        Toast.makeText(CoinFlipActivity.this, "Tap the coin to flip it.", Toast.LENGTH_SHORT).show();
    }

    public void flipCoin(View view) {
        if (!isBackVisible) {
            rightOut.setTarget(coinFront);
            leftIn.setTarget(coinBack);
            rightOut.start();
            leftIn.start();
            isBackVisible = true;
        } else {
            rightOut.setTarget(coinBack);
            leftIn.setTarget(coinFront);
            rightOut.start();
            leftIn.start();
            isBackVisible = false;
        }
    }
}
