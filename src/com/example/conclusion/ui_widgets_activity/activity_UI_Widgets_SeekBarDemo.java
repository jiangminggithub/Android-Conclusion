package com.example.conclusion.ui_widgets_activity;

import com.example.conclusion.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class activity_UI_Widgets_SeekBarDemo extends Activity {
	SeekBar sb_UI_SeekBarDemo, sb_UI_SeekBarDemo1, sb_UI_SeekBarDemo2;
	TextView tv_UI_SeekBar_Demo, tv_UI_SeekBar_Demo1, tv_UI_SeekBar_Demo2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ui_widgets_seekbar_demo);

		sb_UI_SeekBarDemo = (SeekBar) findViewById(R.id.sb_UI_SeekBarDemo);
		sb_UI_SeekBarDemo1 = (SeekBar) findViewById(R.id.sb_UI_SeekBarDemo1);
		sb_UI_SeekBarDemo2 = (SeekBar) findViewById(R.id.sb_UI_SeekBarDemo2);
		tv_UI_SeekBar_Demo = (TextView) findViewById(R.id.tv_UI_SeekBar_Demo);
		tv_UI_SeekBar_Demo1 = (TextView) findViewById(R.id.tv_UI_SeekBar_Demo1);
		tv_UI_SeekBar_Demo2 = (TextView) findViewById(R.id.tv_UI_SeekBar_Demo2);

		sb_UI_SeekBarDemo
				.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

					@Override
					public void onStopTrackingTouch(SeekBar seekBar) {
						Toast.makeText(activity_UI_Widgets_SeekBarDemo.this,
								"结束滑动", Toast.LENGTH_SHORT).show();

					}

					@Override
					public void onStartTrackingTouch(SeekBar seekBar) {
						Toast.makeText(activity_UI_Widgets_SeekBarDemo.this,
								"开始滑动", Toast.LENGTH_SHORT).show();

					}

					@Override
					public void onProgressChanged(SeekBar seekBar,
							int progress, boolean fromUser) {
						tv_UI_SeekBar_Demo
								.setText("系统默认SeekBar当前值：" + progress);

					}
				});

		sb_UI_SeekBarDemo1
				.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

					@Override
					public void onStopTrackingTouch(SeekBar seekBar) {
						Toast.makeText(activity_UI_Widgets_SeekBarDemo.this,
								"结束滑动", Toast.LENGTH_SHORT).show();
					}

					@Override
					public void onStartTrackingTouch(SeekBar seekBar) {
						Toast.makeText(activity_UI_Widgets_SeekBarDemo.this,
								"开始滑动", Toast.LENGTH_SHORT).show();
					}

					@Override
					public void onProgressChanged(SeekBar seekBar,
							int progress, boolean fromUser) {
						tv_UI_SeekBar_Demo1
								.setText("自定义SeekBar当前值：" + progress);

					}
				});

		sb_UI_SeekBarDemo2
				.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

					@Override
					public void onStopTrackingTouch(SeekBar seekBar) {
						Toast.makeText(activity_UI_Widgets_SeekBarDemo.this,
								"结束滑动", Toast.LENGTH_SHORT).show();
					}

					@Override
					public void onStartTrackingTouch(SeekBar seekBar) {
						Toast.makeText(activity_UI_Widgets_SeekBarDemo.this,
								"开始滑动", Toast.LENGTH_SHORT).show();
					}

					@Override
					public void onProgressChanged(SeekBar seekBar,
							int progress, boolean fromUser) {
						tv_UI_SeekBar_Demo2
								.setText("自定义SeekBar2当前值：" + progress);

					}
				});

	}

}
