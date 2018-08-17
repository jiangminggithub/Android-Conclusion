package com.example.conclusion.ui_containers_activity;

import com.example.conclusion.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class activity_UI_Containers_RadioGroupDemo extends Activity {

	RadioGroup rg_num1, rg_num2;
	TextView tvSelect;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ui_containers_radiogroup_demo);
		rg_num1 = (RadioGroup) findViewById(R.id.rg_containers_num1);
		rg_num2 = (RadioGroup) findViewById(R.id.rg_containers_num2);
		tvSelect = (TextView) findViewById(R.id.tv_containers_select);

		//RadioGroup 按钮改变监听器
		rg_num1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				RadioButton rbtn = (RadioButton) findViewById(checkedId);
				tvSelect.setText("你选择的性别："+rbtn.getText().toString());
			}
		});

		rg_num2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				RadioButton rbtn = (RadioButton) findViewById(checkedId);
				tvSelect.setText("你选择的课程："+rbtn.getText().toString());
			}
		});
	}
}
