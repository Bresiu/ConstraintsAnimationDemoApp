package com.bresiu.constraintsanimation;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main)
    ConstraintLayout constraintLayout;
    private ConstraintSet applyConstraintSet = new ConstraintSet();
    private ConstraintSet resetConstraintSet = new ConstraintSet();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        resetConstraintSet.clone(constraintLayout);
        applyConstraintSet.clone(constraintLayout);
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.applyButton)
    public void onApplyClick(View view) {
        TransitionManager.beginDelayedTransition(constraintLayout);

        /*
        applyConstraintSet.setMargin(R.id.button1, ConstraintSet.START, 0);
        applyConstraintSet.setMargin(R.id.button1, ConstraintSet.END, 0);
        applyConstraintSet.setMargin(R.id.button2, ConstraintSet.START, 0);
        applyConstraintSet.setMargin(R.id.button2, ConstraintSet.END, 0);
        applyConstraintSet.setMargin(R.id.button2, ConstraintSet.TOP, 0);
        applyConstraintSet.setMargin(R.id.button3, ConstraintSet.START, 0);
        applyConstraintSet.setMargin(R.id.button3, ConstraintSet.END, 0);
        applyConstraintSet.setMargin(R.id.button3, ConstraintSet.TOP, 0);

        applyConstraintSet.centerHorizontally(R.id.button1, R.id.main);
        applyConstraintSet.centerHorizontally(R.id.button2, R.id.main);
        applyConstraintSet.centerHorizontally(R.id.button3, R.id.main);

        applyConstraintSet.constrainWidth(R.id.button1, 600);
        applyConstraintSet.constrainWidth(R.id.button2, 600);
        applyConstraintSet.constrainWidth(R.id.button3, 600);

        applyConstraintSet.constrainHeight(R.id.button1, 200);
        applyConstraintSet.constrainHeight(R.id.button2, 200);
        applyConstraintSet.constrainHeight(R.id.button3, 200);
        */

        applyConstraintSet.setVisibility(R.id.button2, ConstraintSet.GONE);
        applyConstraintSet.setVisibility(R.id.button3, ConstraintSet.GONE);
        applyConstraintSet.clear(R.id.button1);
        applyConstraintSet.connect(R.id.button1, ConstraintSet.LEFT, R.id.main, ConstraintSet.LEFT, 0);
        applyConstraintSet.connect(R.id.button1, ConstraintSet.RIGHT, R.id.main, ConstraintSet.RIGHT, 0);
        applyConstraintSet.connect(R.id.button1, ConstraintSet.TOP, R.id.main, ConstraintSet.TOP, 0);
        applyConstraintSet.connect(R.id.button1, ConstraintSet.BOTTOM, R.id.applyButton, ConstraintSet.TOP, 0);

        applyConstraintSet.applyTo(constraintLayout);
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.resetButton)
    public void onResetClick(View view) {
        TransitionManager.beginDelayedTransition(constraintLayout);
        resetConstraintSet.applyTo(constraintLayout);
    }
}
