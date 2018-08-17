package com.example.conclusion.ui.animation;

import com.example.conclusion.R;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class activity_UI_Animation_FrameAnimationDemo extends Activity implements OnClickListener {

	ImageView iv_FrameAnimation_img;
	Button btn_FrameAnimation_RunFrameAnimation1, btn_FrameAnimation_RunFrameAnimation2,
			btn_FrameAnimation_StopFrameAnimation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ui_animation_frameanimation_demo);
		
		iv_FrameAnimation_img = (ImageView) findViewById(R.id.iv_FrameAnimation_img);
		btn_FrameAnimation_RunFrameAnimation1 = (Button) findViewById(R.id.btn_FrameAnimation_RunFrameAnimation1);
		btn_FrameAnimation_RunFrameAnimation2 = (Button) findViewById(R.id.btn_FrameAnimation_RunFrameAnimation2);
		btn_FrameAnimation_StopFrameAnimation = (Button) findViewById(R.id.btn_FrameAnimation_StopFrameAnimation);

		btn_FrameAnimation_RunFrameAnimation1.setOnClickListener(this);
		btn_FrameAnimation_RunFrameAnimation2.setOnClickListener(this);
		btn_FrameAnimation_StopFrameAnimation.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_FrameAnimation_RunFrameAnimation1:
			RunFrameAnimationDemo1();
			break;
		case R.id.btn_FrameAnimation_RunFrameAnimation2:
			RunFrameAnimationDemo2();
			break;
		case R.id.btn_FrameAnimation_StopFrameAnimation:
			StopFrameAnimationDemo();
			break;
		}

	}

	//XML实现动画效果
	private void RunFrameAnimationDemo1() {
		iv_FrameAnimation_img.setBackgroundResource(R.anim.animation_frame_demo);
		AnimationDrawable anim = (AnimationDrawable) iv_FrameAnimation_img.getBackground();
		anim.start();
	}

	// 完全编码实现动画效果
	private void RunFrameAnimationDemo2() {
		AnimationDrawable anim = new AnimationDrawable();
		for (int i = 1; i <= 16; i++) {

			// 根据资源名称和目录获取R.java中对应的资源ID
			int id = getResources().getIdentifier("frameanimation_" + i, "drawable", getPackageName());
			// 根据资源ID获取到Drawable对象
			Drawable drawable = getResources().getDrawable(id);
			// 将此帧添加到AnimationDrawable中
			anim.addFrame(drawable, 50);

		}
		anim.setOneShot(false);// 设置为循环播放
		iv_FrameAnimation_img.setBackgroundDrawable(anim);// 将动画设置背景
		anim.start();
	}

	//停止动画
	private void StopFrameAnimationDemo() {
		AnimationDrawable anim = (AnimationDrawable) iv_FrameAnimation_img.getBackground();
		//判断动画是否在播放
		if (anim.isRunning()) {
			anim.stop();
		}
	}
}
