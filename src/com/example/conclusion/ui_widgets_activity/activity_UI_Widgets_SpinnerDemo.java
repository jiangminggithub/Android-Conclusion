package com.example.conclusion.ui_widgets_activity;

import com.example.conclusion.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class activity_UI_Widgets_SpinnerDemo extends Activity {

	Spinner spn_UI_SpinnerDemo, spn_UI_SpinnerDemo1;
	ArrayAdapter<String> adapterDemo;
	ArrayAdapter<CharSequence> adapterDemo1;//国际化适配器
	String[] list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ui_widgets_spinner_demo);
		spn_UI_SpinnerDemo = (Spinner) findViewById(R.id.spn_UI_SpinnerDemo);
		spn_UI_SpinnerDemo1 = (Spinner) findViewById(R.id.spn_UI_SpinnerDemo1);
		
		initView();
		SpinnerDemo();
		SpinnerDemo1();

	}

	public void initView() {
		list = new String[5];
		int n = 0;
		list[n++] = "android";
		list[n++] = "java";
		list[n++] = "html+css";
		list[n++] = "面向对象C#";
		list[n++] = "WEB ASP.Net";
	}

	//
	public void SpinnerDemo() {
		// 定义下拉列表适配器关联数据
		adapterDemo = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
		// 下拉列表的下拉样式
		adapterDemo
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		// 绑定适配器
		spn_UI_SpinnerDemo.setAdapter(adapterDemo);

		// 下拉列表事件监听器
		spn_UI_SpinnerDemo
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> parent,
							View view, int position, long id) {
						// TODO Auto-generated method stub
						Toast.makeText(activity_UI_Widgets_SpinnerDemo.this,
								"你选中了：" + adapterDemo.getItem(position),
								Toast.LENGTH_SHORT).show();
					}

					@Override
					public void onNothingSelected(AdapterView<?> parent) {
						// TODO Auto-generated method stub
						// parent.setVisibility(View.VISIBLE);
					}
				});

		spn_UI_SpinnerDemo.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				Toast.makeText(activity_UI_Widgets_SpinnerDemo.this, "Touch 事件触发！",
						Toast.LENGTH_SHORT).show();
				return false;
			}
		});

	}

	public void SpinnerDemo1() {
		// 定义下拉列表适配器关联数据
		adapterDemo1 = ArrayAdapter.createFromResource(this,
				R.array.ui_spinnerdemo, android.R.layout.simple_spinner_item);
		// 下拉列表的下拉样式
		adapterDemo1
				.setDropDownViewResource(android.R.layout.simple_spinner_item);
		// 绑定适配器
		spn_UI_SpinnerDemo1.setAdapter(adapterDemo1);

		// 下拉列表事件监听器
		spn_UI_SpinnerDemo1
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> parent,
							View view, int position, long id) {
						// TODO Auto-generated method stub
						Toast.makeText(activity_UI_Widgets_SpinnerDemo.this,
								"你选中了：" + adapterDemo1.getItem(position),
								Toast.LENGTH_SHORT).show();
					}

					@Override
					public void onNothingSelected(AdapterView<?> parent) {
						// TODO Auto-generated method stub
						// parent.setVisibility(View.VISIBLE);
					}
				});
	}
}
