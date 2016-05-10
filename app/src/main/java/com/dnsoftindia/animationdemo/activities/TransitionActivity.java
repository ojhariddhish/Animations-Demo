package com.dnsoftindia.animationdemo.activities;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import com.dnsoftindia.animationdemo.interfaces.OnRevealAnimationListener;
import com.dnsoftindia.animationdemo.R;
import com.dnsoftindia.animationdemo.utils.UIHelper;

public class TransitionActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout rlTransitionContainer;
    private FloatingActionButton fabTransition;

    private void findViews() {
        rlTransitionContainer = (RelativeLayout)findViewById( R.id.rlTransitionContainer );
        fabTransition = (FloatingActionButton)findViewById( R.id.fabTransition );

        fabTransition.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
        if ( v == fabTransition ) {
            // Handle clicks for fabTransition
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);
        setTitle("Transition");

        findViews();

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setupEnterAnimation();
            setupExitAnimation();
        } else {
            initViews();
        }
    }

    @Override
    public void onBackPressed() {
        UIHelper.animateRevealHide(this, rlTransitionContainer, R.color.colorAccent, fabTransition.getWidth() / 2,
                new OnRevealAnimationListener() {
                    @Override
                    public void onRevealHide() {
                        backPressed();
                    }

                    @Override
                    public void onRevealShow() {

                    }
                });
    }

    private void backPressed() {
        super.onBackPressed();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setupEnterAnimation() {
        Transition transition = TransitionInflater.from(this)
                .inflateTransition(R.transition.arc_motion);
        getWindow().setSharedElementEnterTransition(transition);
        transition.addListener(new Transition.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {

            }

            @Override
            public void onTransitionEnd(Transition transition) {
                transition.removeListener(this);
                animateRevealShow(rlTransitionContainer);
            }

            @Override
            public void onTransitionCancel(Transition transition) {

            }

            @Override
            public void onTransitionPause(Transition transition) {

            }

            @Override
            public void onTransitionResume(Transition transition) {

            }
        });
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setupExitAnimation() {
        Fade fade = new Fade();
        getWindow().setReturnTransition(fade);
        fade.setDuration(300);
    }


    private void animateRevealShow(final View viewRoot) {
        int cx = (viewRoot.getLeft() + viewRoot.getRight()) / 2;
        int cy = (viewRoot.getTop() + viewRoot.getBottom()) / 2;
        UIHelper.animateRevealShow(this, rlTransitionContainer, fabTransition.getWidth() / 2, R.color.colorAccent,
                cx, cy, new OnRevealAnimationListener() {
                    @Override
                    public void onRevealHide() {

                    }

                    @Override
                    public void onRevealShow() {
                        initViews();
                    }
                });
    }

    private void initViews() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Animation animation = AnimationUtils.loadAnimation(TransitionActivity.this, android.R.anim.fade_in);
                animation.setDuration(300);
                rlTransitionContainer.startAnimation(animation);
                rlTransitionContainer.setVisibility(View.VISIBLE);
            }
        });
    }
}
