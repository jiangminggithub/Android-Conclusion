package com.example.conclusion.ui.animation;

import com.example.conclusion.R;
import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class activity_UI_Animation_PropertyAnimationDemo extends Activity implements OnClickListener {

	ImageView iv_Animation_PropertyImg;
	Button btn_Animation_Property_ObjectAnimation, btn_Animation_Property_ValueAnimation,
			btn_Animation_Property_SetAnimation, btn_Animation_Property_PropertyValuesHolder,
			btn_Animation_Property_ViewPropertyAnimator, btn_Animation_Property_LayoutBackgroudChange;
	View ll_PropertyAnimation_Animation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_ui_animation_propertyanimation_demo);
		iv_Animation_PropertyImg = (ImageView) findViewById(R.id.iv_Animation_PropertyImg);
		btn_Animation_Property_ObjectAnimation = (Button) findViewById(R.id.btn_Animation_Property_ObjectAnimation);
		btn_Animation_Property_ValueAnimation = (Button) findViewById(R.id.btn_Animation_Property_ValueAnimation);
		btn_Animation_Property_SetAnimation = (Button) findViewById(R.id.btn_Animation_Property_SetAnimation);
		btn_Animation_Property_PropertyValuesHolder = (Button) findViewById(
				R.id.btn_Animation_Property_PropertyValuesHolder);
		btn_Animation_Property_ViewPropertyAnimator = (Button) findViewById(
				R.id.btn_Animation_Property_ViewPropertyAnimator);
		btn_Animation_Property_LayoutBackgroudChange = (Button) findViewById(
				R.id.btn_Animation_Property_LayoutBackgroudChange);
		ll_PropertyAnimation_Animation = findViewById(R.id.ll_PropertyAnimation_Animation);

		btn_Animation_Property_ObjectAnimation.setOnClickListener(this);
		btn_Animation_Property_ValueAnimation.setOnClickListener(this);
		btn_Animation_Property_SetAnimation.setOnClickListener(this);
		btn_Animation_Property_PropertyValuesHolder.setOnClickListener(this);
		btn_Animation_Property_ViewPropertyAnimator.setOnClickListener(this);
		btn_Animation_Property_LayoutBackgroudChange.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_Animation_Property_ObjectAnimation:
			ObjectAnimationDemo();
			break;
		case R.id.btn_Animation_Property_ValueAnimation:
			ValueAnimationDemo();
			break;
		case R.id.btn_Animation_Property_SetAnimation:
			SetAnimationDemo();
			break;
		case R.id.btn_Animation_Property_PropertyValuesHolder:
			PropertyValuesHolderDemo();
			break;
		case R.id.btn_Animation_Property_ViewPropertyAnimator:
			ViewPropertyAnimationDemo();
			break;
		case R.id.btn_Animation_Property_LayoutBackgroudChange:
			LayoutBackgroundDemo();
			break;
		}

	}

	// 对象动画实例
	private void ObjectAnimationDemo() {
		ObjectAnimator scaleAnimation = (ObjectAnimator) AnimatorInflater.loadAnimator(
				activity_UI_Animation_PropertyAnimationDemo.this, R.animator.animation_property_objectdemo);
		scaleAnimation.setTarget(iv_Animation_PropertyImg);// 设置动画对象
		scaleAnimation.setDuration(1000);// 时间
		scaleAnimation.setRepeatCount(5);// 重复次数
		scaleAnimation.start();// 开始动画
	}

	// 值动画实例
	private void ValueAnimationDemo() {
		ValueAnimator valueAnimator = (ValueAnimator) AnimatorInflater.loadAnimator(
				activity_UI_Animation_PropertyAnimationDemo.this, R.animator.animation_property_valuedemo);
		valueAnimator.setTarget(iv_Animation_PropertyImg);
		valueAnimator.setEvaluator(new TypeEvaluator<Integer>() {

			@Override
			public Integer evaluate(float fraction, Integer startValue, Integer endValue) {

				Log.i("ValueAnimation", "时间比率(fraction)：" + fraction);
				int resultvalue = (int) (startValue + fraction * (endValue - startValue)) / 10 * 10;
				Log.i("ValueAnimation", "结果值：" + resultvalue);
				return resultvalue;
			}
		});

		// 值更新监听器
		valueAnimator.addUpdateListener(new AnimatorUpdateListener() {

			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				// 在onAnimationUpdate中 该值返回第一个动画的 当前帧的evaluate值
				Log.i("ValueAnimation", "evaluate值：" + animation.getAnimatedValue());
				// 设置控件的相关动画
				iv_Animation_PropertyImg.setAlpha(animation.getAnimatedFraction());
				iv_Animation_PropertyImg.setScaleX(animation.getAnimatedFraction());
				iv_Animation_PropertyImg.setScaleY(animation.getAnimatedFraction());
			}
		});

		// 值动画监听器
		valueAnimator.addListener(new AnimatorListener() {
			// 动画开始时调用
			@Override
			public void onAnimationStart(Animator animation) {
				Log.i("ValueAnimation", "-->Start");
				Toast.makeText(activity_UI_Animation_PropertyAnimationDemo.this, "Start（开始动画）", Toast.LENGTH_SHORT)
						.show();
			}

			// 动画循环播放时调用
			@Override
			public void onAnimationRepeat(Animator animation) {
				Log.i("ValueAnimation", "-->Repeat");
				Toast.makeText(activity_UI_Animation_PropertyAnimationDemo.this, "Repeat（循环动画）", Toast.LENGTH_SHORT)
						.show();
			}

			// 动画结束时调用
			@Override
			public void onAnimationEnd(Animator animation) {
				Log.i("ValueAnimation", "-->End");
				Toast.makeText(activity_UI_Animation_PropertyAnimationDemo.this, "End（结束动画）", Toast.LENGTH_SHORT)
						.show();
			}

			// 动画取消时调用
			@Override
			public void onAnimationCancel(Animator animation) {
				Log.i("ValueAnimation", "-->Cancel");
				Toast.makeText(activity_UI_Animation_PropertyAnimationDemo.this, "Cancel（取消动画）", Toast.LENGTH_SHORT)
						.show();
			}
		});
		// valueAnimator.setInterpolator(new LinearInterpolator());
		// 重复次数
		valueAnimator.setRepeatCount(2);
		valueAnimator.start();
		Toast.makeText(activity_UI_Animation_PropertyAnimationDemo.this, "根据value进行某种动作", Toast.LENGTH_SHORT).show();
	}

	// 混合动画实例
	private void SetAnimationDemo() {
		AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater
				.loadAnimator(activity_UI_Animation_PropertyAnimationDemo.this, R.animator.animation_property_setdemo);
		animatorSet.setTarget(iv_Animation_PropertyImg);
		animatorSet.setDuration(1000);
		animatorSet.setInterpolator(new LinearInterpolator());
		animatorSet.start();
	}

	private void PropertyValuesHolderDemo() {
		// 使用PropertyValuesHolder构造 Animator组合成类似set的效果
		PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("scaleX", 0f, 1.5f);
		PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleY", 0f, 1.5f);
		ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(iv_Animation_PropertyImg, pvhX, pvhY);
		animator.setDuration(2000);
		animator.start();
	}

	private void ViewPropertyAnimationDemo() {
		ViewPropertyAnimator animate = iv_Animation_PropertyImg.animate();
		animate.alpha(0.5f);
		animate.rotation(360);
		animate.translationXBy(100);
		animate.scaleX(1.5f);
		animate.scaleY(1.5f);
		animate.setInterpolator(new BounceInterpolator());// 弹跳差值器
		animate.setDuration(2000);
		animate.start();
	}

	// 属性动画改变背景色
	private void LayoutBackgroundDemo() {

		int RED = 0xffFF8080;
		int BLUE = 0xff8080FF;
		int CYAN = 0xff80ffff;
		int GREEN = 0xff80ff80;

		ObjectAnimator colorAnim = ObjectAnimator.ofInt(activity_UI_Animation_PropertyAnimationDemo.this,
				"backgroundColor", CYAN, BLUE, RED, GREEN);
		colorAnim.setTarget(ll_PropertyAnimation_Animation);
		colorAnim.setEvaluator(new ArgbEvaluator());// RGB值计算器
		colorAnim.setRepeatCount(5);
		colorAnim.setRepeatMode(ValueAnimator.REVERSE);
		colorAnim.setDuration(3000);
		colorAnim.start();
	}

}
