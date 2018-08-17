package com.example.conclusion.ui.animation;

import com.example.conclusion.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class activity_UI_Animation_TweenAnimationDemo extends Activity implements OnClickListener {

	Button btn_Animation_tween_AlphaDemo, btn_Animation_tween_ScaleDemo, btn_Animation_tween_TranslateDemo,
			btn_Animation_tween_RotateDemo, btn_Animation_tween_TotalDemo;
	ImageView iv_Animation_TweenImg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ui_animation_tweenanimation_demo);

		iv_Animation_TweenImg = (ImageView) findViewById(R.id.iv_Animation_TweenImg);
		btn_Animation_tween_AlphaDemo = (Button) findViewById(R.id.btn_Animation_tween_AlphaDemo);
		btn_Animation_tween_ScaleDemo = (Button) findViewById(R.id.btn_Animation_tween_ScaleDemo);
		btn_Animation_tween_TranslateDemo = (Button) findViewById(R.id.btn_Animation_tween_TranslateDemo);
		btn_Animation_tween_RotateDemo = (Button) findViewById(R.id.btn_Animation_tween_RotateDemo);
		btn_Animation_tween_TotalDemo = (Button) findViewById(R.id.btn_Animation_tween_TotalDemo);

		btn_Animation_tween_AlphaDemo.setOnClickListener(this);
		btn_Animation_tween_ScaleDemo.setOnClickListener(this);
		btn_Animation_tween_TranslateDemo.setOnClickListener(this);
		btn_Animation_tween_RotateDemo.setOnClickListener(this);
		btn_Animation_tween_TotalDemo.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_Animation_tween_AlphaDemo:
			AlphaDemo();
			break;
		case R.id.btn_Animation_tween_ScaleDemo:
			ScaleDemo();
			break;
		case R.id.btn_Animation_tween_TranslateDemo:
			TranslateDemo();
			break;
		case R.id.btn_Animation_tween_RotateDemo:
			RotateDmeo();
			break;
		case R.id.btn_Animation_tween_TotalDemo:
			TotalDemo();
			break;
		}

	}

	// 透明度动画
	private void AlphaDemo() {
		Animation animation = AnimationUtils.loadAnimation(activity_UI_Animation_TweenAnimationDemo.this,
				R.anim.animation_tween_alphademo);
		iv_Animation_TweenImg.startAnimation(animation);
	}

	// 缩放动画
	private void ScaleDemo() {
		Animation animation = AnimationUtils.loadAnimation(activity_UI_Animation_TweenAnimationDemo.this,
				R.anim.animation_tween_scaledemo);
		iv_Animation_TweenImg.startAnimation(animation);
	}

	// 平移动画
	private void TranslateDemo() {
		Animation animation = AnimationUtils.loadAnimation(activity_UI_Animation_TweenAnimationDemo.this,
				R.anim.animation_tween_translatedemo);
		iv_Animation_TweenImg.startAnimation(animation);
	}

	// 旋转动画
	private void RotateDmeo() {
		Animation animation = AnimationUtils.loadAnimation(activity_UI_Animation_TweenAnimationDemo.this,
				R.anim.animation_tween_rotatedemo);
		iv_Animation_TweenImg.startAnimation(animation);
	}

	// 混合动画
	private void TotalDemo() {
		Animation animation = AnimationUtils.loadAnimation(activity_UI_Animation_TweenAnimationDemo.this,
				R.anim.animation_tween_totaldemo);
		iv_Animation_TweenImg.startAnimation(animation);
	}
}
