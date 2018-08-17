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

	//XMLʵ�ֶ���Ч��
	private void RunFrameAnimationDemo1() {
		iv_FrameAnimation_img.setBackgroundResource(R.anim.animation_frame_demo);
		AnimationDrawable anim = (AnimationDrawable) iv_FrameAnimation_img.getBackground();
		anim.start();
	}

	// ��ȫ����ʵ�ֶ���Ч��
	private void RunFrameAnimationDemo2() {
		AnimationDrawable anim = new AnimationDrawable();
		for (int i = 1; i <= 16; i++) {

			// ������Դ���ƺ�Ŀ¼��ȡR.java�ж�Ӧ����ԴID
			int id = getResources().getIdentifier("frameanimation_" + i, "drawable", getPackageName());
			// ������ԴID��ȡ��Drawable����
			Drawable drawable = getResources().getDrawable(id);
			// ����֡��ӵ�AnimationDrawable��
			anim.addFrame(drawable, 50);

		}
		anim.setOneShot(false);// ����Ϊѭ������
		iv_FrameAnimation_img.setBackgroundDrawable(anim);// ���������ñ���
		anim.start();
	}

	//ֹͣ����
	private void StopFrameAnimationDemo() {
		AnimationDrawable anim = (AnimationDrawable) iv_FrameAnimation_img.getBackground();
		//�ж϶����Ƿ��ڲ���
		if (anim.isRunning()) {
			anim.stop();
		}
	}
}
