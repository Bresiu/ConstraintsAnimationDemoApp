package com.bresiu.constraintsanimation;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
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
        applyConstraintSet.setMargin(R.id.button1, ConstraintSet.START, 8);
        applyConstraintSet.applyTo(constraintLayout);
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.resetButton)
    public void onResetClick(View view) {
        resetConstraintSet.applyTo(constraintLayout);
    }
}
