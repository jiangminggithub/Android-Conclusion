package com.example.conclusion.ui.animation;

import com.example.conclusion.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class activity_UI_Animation extends Activity implements OnClickListener {

	Button btn_Animation_TweenAnimation, btn_Animation_FrameAnimation, btn_Animation_PropertyAnimation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ui_animation);
		btn_Animation_TweenAnimation = (Button) findViewById(R.id.btn_Animation_TweenAnimation);
		btn_Animation_FrameAnimation = (Button) findViewById(R.id.btn_Animation_FrameAnimation);
		btn_Animation_PropertyAnimation = (Button) findViewById(R.id.btn_Animation_PropertyAnimation);

		btn_Animation_TweenAnimation.setOnClickListener(this);
		btn_Animation_FrameAnimation.setOnClickListener(this);
		btn_Animation_PropertyAnimation.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		Intent intent;
		switch (v.getId()) {
		case R.id.btn_Animation_TweenAnimation:
			intent=new Intent(activity_UI_Animation.this,activity_UI_Animation_TweenAnimationDemo.class);
			startActivity(intent);
			break;
		case R.id.btn_Animation_PropertyAnimation:
			intent=new Intent(activity_UI_Animation.this,activity_UI_Animation_PropertyAnimationDemo.class);
			startActivity(intent);
			break;
		case R.id.btn_Animation_FrameAnimation:
			intent=new Intent(activity_UI_Animation.this,activity_UI_Animation_FrameAnimationDemo.class);
			startActivity(intent);
			break;
		}

	}
	
}
