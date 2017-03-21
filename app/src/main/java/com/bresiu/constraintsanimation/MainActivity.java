package com.bresiu.constraintsanimation;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.constraint.solver.widgets.ConstraintWidget;
import android.support.transition.ChangeBounds;
import android.support.transition.Fade;
import android.support.transition.Transition;
import android.support.transition.TransitionManager;
import android.support.transition.TransitionSet;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

	private static final int ANIMATION_DURATION = 400;
	@BindView(R.id.main) ConstraintLayout constraintLayout;
	@BindView(R.id.edit_text_2) EditText secondEditText;
	@BindView(R.id.divider) View dividerView;
	@BindView(R.id.search_filter_card) CardView searchCard;
	private ConstraintSet applyConstraintSet = new ConstraintSet();
	private ConstraintSet resetConstraintSet = new ConstraintSet();

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
		resetConstraintSet.clone(constraintLayout);
		applyConstraintSet.clone(constraintLayout);
	}

	@SuppressWarnings("unused") @OnClick(R.id.applyButton) public void onApplyClick(View view) {
		Transition transition = new TransitionSet().addTransition(new ChangeBounds())
				.setOrdering(TransitionSet.ORDERING_TOGETHER)
				.addTransition(new Fade(Fade.IN))
				.setInterpolator(new FastOutSlowInInterpolator())
				.setDuration(ANIMATION_DURATION);
		TransitionManager.beginDelayedTransition(constraintLayout, transition);
		//firstSample();
		//secondSample();
		//thirdSample();
		fourthSample();
		applyConstraintSet.applyTo(constraintLayout);
	}

	private void firstSample() {
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
	}

	private void secondSample() {
		applyConstraintSet.setVisibility(R.id.button2, ConstraintSet.GONE);
		applyConstraintSet.setVisibility(R.id.button3, ConstraintSet.GONE);
		applyConstraintSet.clear(R.id.button1);
		applyConstraintSet.connect(R.id.button1, ConstraintSet.LEFT, R.id.main, ConstraintSet.LEFT, 0);
		applyConstraintSet.connect(R.id.button1, ConstraintSet.RIGHT, R.id.main, ConstraintSet.RIGHT, 0);
		applyConstraintSet.connect(R.id.button1, ConstraintSet.TOP, R.id.main, ConstraintSet.TOP, 0);
		applyConstraintSet.connect(R.id.button1, ConstraintSet.BOTTOM, R.id.applyButton, ConstraintSet.TOP, 0);
	}

	private void thirdSample() {
		applyConstraintSet.clear(R.id.button1);
		applyConstraintSet.clear(R.id.button2);
		applyConstraintSet.clear(R.id.button3);

		applyConstraintSet.connect(R.id.button1, ConstraintSet.LEFT, R.id.main, ConstraintSet.LEFT, 0);
		applyConstraintSet.connect(R.id.button3, ConstraintSet.RIGHT, R.id.main, ConstraintSet.RIGHT, 0);

		applyConstraintSet.connect(R.id.button2, ConstraintSet.LEFT, R.id.button1, ConstraintSet.RIGHT, 0);
		applyConstraintSet.connect(R.id.button1, ConstraintSet.RIGHT, R.id.button2, ConstraintSet.LEFT, 0);

		applyConstraintSet.connect(R.id.button2, ConstraintSet.RIGHT, R.id.button3, ConstraintSet.LEFT, 0);
		applyConstraintSet.connect(R.id.button3, ConstraintSet.LEFT, R.id.button2, ConstraintSet.RIGHT, 0);

		applyConstraintSet.createHorizontalChain(R.id.button1, R.id.button3, new int[] { R.id.button1, R.id.button3 }, null,
				ConstraintWidget.CHAIN_PACKED);

		applyConstraintSet.setHorizontalBias(R.id.button1, .1f);

		applyConstraintSet.constrainWidth(R.id.button1, ConstraintSet.WRAP_CONTENT);
		applyConstraintSet.constrainWidth(R.id.button2, ConstraintSet.WRAP_CONTENT);
		applyConstraintSet.constrainWidth(R.id.button3, ConstraintSet.WRAP_CONTENT);

		applyConstraintSet.constrainHeight(R.id.button1, 200);
		applyConstraintSet.constrainHeight(R.id.button2, 200);
		applyConstraintSet.constrainHeight(R.id.button3, 200);
	}

	private void fourthSample() {
		applyConstraintSet.clear(R.id.search_filter_card);
		applyConstraintSet.connect(R.id.search_filter_card, ConstraintSet.TOP, R.id.main, ConstraintSet.TOP, 0);
		applyConstraintSet.connect(R.id.search_filter_card, ConstraintSet.LEFT, R.id.main, ConstraintSet.LEFT, 0);
		applyConstraintSet.connect(R.id.search_filter_card, ConstraintSet.RIGHT, R.id.main, ConstraintSet.RIGHT, 0);
		applyConstraintSet.setVisibility(R.id.edit_text_2, ConstraintSet.VISIBLE);
		applyConstraintSet.setVisibility(R.id.divider, ConstraintSet.VISIBLE);
		applyConstraintSet.constrainHeight(R.id.search_filter_card, ConstraintSet.WRAP_CONTENT);
		secondEditText.setVisibility(View.VISIBLE);
		dividerView.setVisibility(View.VISIBLE);
		secondEditText.setAlpha(1);
		dividerView.setAlpha(1);
		searchCard.setRadius(0);
	}

	@SuppressWarnings("unused") @OnClick(R.id.resetButton) public void onResetClick(View view) {

		Transition transition = new TransitionSet().addTransition(new ChangeBounds())
				.setOrdering(TransitionSet.ORDERING_TOGETHER)
				.addTransition(new Fade(Fade.OUT))
				.setInterpolator(new FastOutSlowInInterpolator())
				.setDuration(ANIMATION_DURATION);
		TransitionManager.beginDelayedTransition(constraintLayout, transition);
		secondEditText.setVisibility(View.GONE);
		dividerView.setVisibility(View.GONE);
		searchCard.setRadius(2 * getResources().getDisplayMetrics().density);
		resetConstraintSet.applyTo(constraintLayout);
	}
}
