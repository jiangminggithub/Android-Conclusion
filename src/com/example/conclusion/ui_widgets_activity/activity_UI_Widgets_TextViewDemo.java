package com.example.conclusion.ui_widgets_activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.conclusion.R;

public class activity_UI_Widgets_TextViewDemo extends Activity {

	TextView tvTextViewDemo4,tvTextViewDemo7, tvTextViewDemo8;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ui_widgets_textview_demo);
		tvTextViewDemo4 = (TextView) findViewById(R.id.tvTextViewDemo4);
		tvTextViewDemo7 = (TextView) findViewById(R.id.tvTextViewDemo7);
		tvTextViewDemo8 = (TextView) findViewById(R.id.tvTextViewDemo8);
	
		tvTextViewDemo7.setSelected(true);
//		tvTextViewDemo4.setEllipsize(TruncateAt.MIDDLE);

	}
}
