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
	ArrayAdapter<CharSequence> adapterDemo1;//���ʻ�������
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
		list[n++] = "�������C#";
		list[n++] = "WEB ASP.Net";
	}

	//
	public void SpinnerDemo() {
		// ���������б���������������
		adapterDemo = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
		// �����б��������ʽ
		adapterDemo
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		// ��������
		spn_UI_SpinnerDemo.setAdapter(adapterDemo);

		// �����б��¼�������
		spn_UI_SpinnerDemo
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> parent,
							View view, int position, long id) {
						// TODO Auto-generated method stub
						Toast.makeText(activity_UI_Widgets_SpinnerDemo.this,
								"��ѡ���ˣ�" + adapterDemo.getItem(position),
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
				Toast.makeText(activity_UI_Widgets_SpinnerDemo.this, "Touch �¼�������",
						Toast.LENGTH_SHORT).show();
				return false;
			}
		});

	}

	public void SpinnerDemo1() {
		// ���������б���������������
		adapterDemo1 = ArrayAdapter.createFromResource(this,
				R.array.ui_spinnerdemo, android.R.layout.simple_spinner_item);
		// �����б��������ʽ
		adapterDemo1
				.setDropDownViewResource(android.R.layout.simple_spinner_item);
		// ��������
		spn_UI_SpinnerDemo1.setAdapter(adapterDemo1);

		// �����б��¼�������
		spn_UI_SpinnerDemo1
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> parent,
							View view, int position, long id) {
						// TODO Auto-generated method stub
						Toast.makeText(activity_UI_Widgets_SpinnerDemo.this,
								"��ѡ���ˣ�" + adapterDemo1.getItem(position),
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
