package com.dnsoftindia.animationdemo.activities;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.dnsoftindia.animationdemo.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;
    private Button btnSequential;
    private Button btnFade;
    private Button btnRotate;
    private Button btnZoom;
    private Button btnBlink;
    private Button btnScale;
    private Button btnAlpha;
    private Button btnSlide;
    private Button btnSlideAbove;
    private Button btnSlideRight;
    private Button btnSlideLeft;
    private Button btnCoinFlip;
    private Button btnFrameAnimation;
    private FloatingActionButton fab;

    private void findViews() {
        textView = (TextView)findViewById( R.id.textView );
        btnSequential = (Button)findViewById( R.id.btnSequential );
        btnFade = (Button)findViewById( R.id.btnFade );
        btnRotate = (Button)findViewById( R.id.btnRotate );
        btnZoom = (Button)findViewById( R.id.btnZoom );
        btnBlink = (Button)findViewById( R.id.btnBlink );
        btnScale = (Button)findViewById( R.id.btnScale );
        btnAlpha = (Button)findViewById( R.id.btnAlpha );
        btnSlide = (Button)findViewById( R.id.btnSlide );
        btnSlideAbove = (Button)findViewById( R.id.btnSlideAbove );
        btnSlideRight = (Button)findViewById( R.id.btnSlideRight );
        btnSlideLeft = (Button)findViewById( R.id.btnSlideLeft );
        btnCoinFlip = (Button)findViewById( R.id.btnCoinFlip );
        btnFrameAnimation = (Button) findViewById(R.id.btnFrameAnimation);
        fab = (FloatingActionButton)findViewById( R.id.fab );

        btnSequential.setOnClickListener( this );
        btnFade.setOnClickListener( this );
        btnRotate.setOnClickListener( this );
        btnZoom.setOnClickListener( this );
        btnBlink.setOnClickListener( this );
        btnScale.setOnClickListener( this );
        btnAlpha.setOnClickListener( this );
        btnSlide.setOnClickListener( this );
        btnSlideAbove.setOnClickListener( this );
        btnSlideRight.setOnClickListener( this );
        btnSlideLeft.setOnClickListener( this );
        btnCoinFlip.setOnClickListener( this );
        btnFrameAnimation.setOnClickListener(this);
        fab.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
        if (v == btnSequential) {
            // Handle clicks for btnSequential
            Intent i = new Intent(MainActivity.this, SequentialActivity.class);
            startActivity(i);

        } else if (v == btnFade) {
            // Handle clicks for btnFade
            final Animation animFadeIn = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in);
            final Animation animFadeOut = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_out);
            btnFade.startAnimation(animFadeOut);
            animFadeOut.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    btnFade.startAnimation(animFadeIn);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

        } else if (v == btnRotate) {
            // Handle clicks for btnRotate
            Animation animRotate = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate);
            btnRotate.startAnimation(animRotate);

        } else if (v == btnZoom) {
            // Handle clicks for btnZoomIn
            final Animation animZoomIn = AnimationUtils.loadAnimation(MainActivity.this, R.anim.zoom_in);
            final Animation animZoomOut = AnimationUtils.loadAnimation(MainActivity.this, R.anim.zoom_out);
            btnZoom.startAnimation(animZoomIn);
            animZoomIn.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    btnZoom.startAnimation(animZoomOut);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        } else if (v == btnBlink) {
            // Handle clicks for btnBlink
            Animation animBlink = AnimationUtils.loadAnimation(MainActivity.this, R.anim.blink);
            btnBlink.startAnimation(animBlink);
        } else if ( v == btnScale ) {
            // Handle clicks for btnScale
            Animation animScale = AnimationUtils.loadAnimation(MainActivity.this, R.anim.scale);
            btnScale.startAnimation(animScale);
        } else if ( v == btnAlpha ) {
            // Handle clicks for btnAlpha
            Animation animAlpha = AnimationUtils.loadAnimation(MainActivity.this, R.anim.alpha);
            btnAlpha.startAnimation(animAlpha);
        } else if (v == btnSlide) {
            // Handle clicks for btnSlideUp
            Animation animSlideDown = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_down);
            final Animation animSlideUp = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_up);

            btnSlide.startAnimation(animSlideDown);
            animSlideDown.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    btnSlide.startAnimation(animSlideUp);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        }
        else if ( v == btnSlideAbove ) {
            final Animation animSlideAboveDown = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_above_down);
            final Animation animSlideAboveUp = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_above_up);

            btnSlideAbove.startAnimation(animSlideAboveDown);
            animSlideAboveDown.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    btnSlideAbove.startAnimation(animSlideAboveUp);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        }
        else if ( v == btnSlideRight ) {
            final Animation animRightSlideIn = AnimationUtils.loadAnimation(MainActivity.this, R.anim.right_slide_in);
            Animation animRightSlideOut = AnimationUtils.loadAnimation(MainActivity.this, R.anim.right_slide_out);
            btnSlideRight.startAnimation(animRightSlideOut);
            animRightSlideOut.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    btnSlideRight.startAnimation(animRightSlideIn);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        }
        else if ( v ==  btnSlideLeft ) {
            final Animation animLeftSlideIn = AnimationUtils.loadAnimation(MainActivity.this, R.anim.left_slide_in);
            final Animation animLeftSlideOut = AnimationUtils.loadAnimation(MainActivity.this, R.anim.left_slide_out);
            btnSlideLeft.startAnimation(animLeftSlideOut);
            animLeftSlideOut.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    btnSlideLeft.startAnimation(animLeftSlideIn);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        }
        else if ( v == btnCoinFlip ) {
            Intent i = new Intent(MainActivity.this, CoinFlipActivity.class);
            startActivity(i);
        }
        else if ( v == btnFrameAnimation ) {
            Intent i = new Intent(MainActivity.this, FrameAnimationActivity.class);
            startActivity(i);
        }
        else if ( v == fab ) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptions options =
                        ActivityOptions.makeSceneTransitionAnimation(this, fab, fab.getTransitionName());
                startActivity(new Intent(this, TransitionActivity.class), options.toBundle());
            } else {
                startActivity(new Intent(this, TransitionActivity.class));
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Animations Demo");

        findViews();
    }


}
