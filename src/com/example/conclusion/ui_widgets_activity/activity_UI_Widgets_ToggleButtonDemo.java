package com.example.conclusion.ui_widgets_activity;

import com.example.conclusion.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class activity_UI_Widgets_ToggleButtonDemo extends Activity {
	ToggleButton tgb_UI_ToggleButtonDemo, tgb_UI_ToggleButtonDemo1;
	ImageView iv_UI_ToggleButtonDemo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ui_widgets_togglebutton_demo);
		tgb_UI_ToggleButtonDemo = (ToggleButton) findViewById(R.id.tgb_UI_ToggleButtonDemo);
		tgb_UI_ToggleButtonDemo1 = (ToggleButton) findViewById(R.id.tgb_UI_ToggleButtonDemo1);
		iv_UI_ToggleButtonDemo = (ImageView) findViewById(R.id.iv_UI_ToggleButtonDemo);

		tgb_UI_ToggleButtonDemo
				.setOnCheckedChangeListener(ToggleButtonListener);

		tgb_UI_ToggleButtonDemo1
				.setOnCheckedChangeListener(ToggleButtonListener);

	}

	OnCheckedChangeListener ToggleButtonListener = new OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked){
			
			if (isChecked) {
				iv_UI_ToggleButtonDemo.setImageResource(R.drawable.lighton);
			} else
				iv_UI_ToggleButtonDemo.setImageResource(R.drawable.lightoff);
		}
	};
}
