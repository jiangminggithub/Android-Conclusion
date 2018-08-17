package com.example.conclusion.ui_widgets_activity;

import com.example.conclusion.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class activity_UI_Widgets_AutoCompleteTextViewDemo extends Activity {

	AutoCompleteTextView autoTV_AutoCompleteTextView_demo;
	MultiAutoCompleteTextView multiAutoTV_AutoCompleteTextView_demo;
	private String[] autoText = new String[] { "Android", "Android手机", "Android系统", "Android软件", "C#课程", "C#编程",
			"C#软件开发" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ui_widgets_autocompletetextview_demo);
		autoTV_AutoCompleteTextView_demo = (AutoCompleteTextView) findViewById(R.id.autoTV_AutoCompleteTextView_demo);
		multiAutoTV_AutoCompleteTextView_demo = (MultiAutoCompleteTextView) findViewById(
				R.id.multiAutoTV_AutoCompleteTextView_demo);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity_UI_Widgets_AutoCompleteTextViewDemo.this,
				android.R.layout.simple_list_item_1, autoText);

		autoTV_AutoCompleteTextView_demo.setAdapter(adapter);
		multiAutoTV_AutoCompleteTextView_demo.setAdapter(adapter);
		// 设置多行提示的分隔符，Comma(逗号）
		multiAutoTV_AutoCompleteTextView_demo.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

	}
}
