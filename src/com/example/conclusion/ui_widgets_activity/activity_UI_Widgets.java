package com.example.conclusion.ui_widgets_activity;

import com.example.conclusion.R;
import com.example.conclusion.ui_widgets_activity.activity_UI_Widgets_ButtonDemo;
import com.example.conclusion.ui_widgets_activity.activity_UI_Widgets_CheckBoxDemo;
import com.example.conclusion.ui_widgets_activity.activity_UI_Widgets_ImageButtonDemo;
import com.example.conclusion.ui_widgets_activity.activity_UI_Widgets_ImageViewDemo;
import com.example.conclusion.ui_widgets_activity.activity_UI_Widgets_ProgressBarDemo;
import com.example.conclusion.ui_widgets_activity.activity_UI_Widgets_RadioButtonDemo;
import com.example.conclusion.ui_widgets_activity.activity_UI_Widgets_RatingBarDemo;
import com.example.conclusion.ui_widgets_activity.activity_UI_Widgets_SeekBarDemo;
import com.example.conclusion.ui_widgets_activity.activity_UI_Widgets_SpinnerDemo;
import com.example.conclusion.ui_widgets_activity.activity_UI_Widgets_SwitchDemo;
import com.example.conclusion.ui_widgets_activity.activity_UI_Widgets_TextViewDemo;
import com.example.conclusion.ui_widgets_activity.activity_UI_Widgets_ToggleButtonDemo;
import com.example.conclusion.ui_widgets_activity.activity_UI_Widgets_WebViewDemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class activity_UI_Widgets extends Activity implements OnClickListener {
	Button btnTextViewDemo, btnButtonDemo, btnRadioButton, btnCheckBox, btn_UI_Switch, ToggleButton, btn_UI_ImageView,
			btn_UI_ImageButton, btn_UI_ProgressBar, btn_UI_SeekBar, btn_UI_RatingBar, btn_UI_Spinner, btn_UI_Webview,
			btn_UI_AutoCompleteTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ui_widgets);
		initView();
	}

	public void initView() {
		btnTextViewDemo = (Button) findViewById(R.id.btn_UI_TextView);
		btn_UI_AutoCompleteTextView = (Button) findViewById(R.id.btn_UI_AutoCompleteTextView);
		btnButtonDemo = (Button) findViewById(R.id.btn_UI_Button);
		btnRadioButton = (Button) findViewById(R.id.btn_UI_RadioButton);
		btnCheckBox = (Button) findViewById(R.id.btn_UI_CheckBox);
		btn_UI_Switch = (Button) findViewById(R.id.btn_UI_Switch);
		ToggleButton = (Button) findViewById(R.id.btn_UI_ToggleButton);
		btn_UI_ImageView = (Button) findViewById(R.id.btn_UI_ImageView);
		btn_UI_ImageButton = (Button) findViewById(R.id.btn_UI_ImageButton);
		btn_UI_ProgressBar = (Button) findViewById(R.id.btn_UI_ProgressBar);
		btn_UI_SeekBar = (Button) findViewById(R.id.btn_UI_SeekBar);
		btn_UI_RatingBar = (Button) findViewById(R.id.btn_UI_RatingBar);
		btn_UI_Spinner = (Button) findViewById(R.id.btn_UI_Spinner);
		btn_UI_Webview = (Button) findViewById(R.id.btn_UI_Webview);

		btnTextViewDemo.setOnClickListener(this);
		btn_UI_AutoCompleteTextView.setOnClickListener(this);
		btnButtonDemo.setOnClickListener(this);
		btnRadioButton.setOnClickListener(this);
		btnCheckBox.setOnClickListener(this);
		btn_UI_Switch.setOnClickListener(this);
		ToggleButton.setOnClickListener(this);
		btn_UI_ImageView.setOnClickListener(this);
		btn_UI_ImageButton.setOnClickListener(this);
		btn_UI_ProgressBar.setOnClickListener(this);
		btn_UI_SeekBar.setOnClickListener(this);
		btn_UI_RatingBar.setOnClickListener(this);
		btn_UI_Spinner.setOnClickListener(this);
		btn_UI_Webview.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent = null;
		switch (v.getId()) {
		case R.id.btn_UI_TextView:
			intent = new Intent(activity_UI_Widgets.this, activity_UI_Widgets_TextViewDemo.class);
			startActivity(intent);
			break;
		case R.id.btn_UI_AutoCompleteTextView:
			intent = new Intent(activity_UI_Widgets.this, activity_UI_Widgets_AutoCompleteTextViewDemo.class);
			startActivity(intent);
			break;
		case R.id.btn_UI_Button:
			intent = new Intent(activity_UI_Widgets.this, activity_UI_Widgets_ButtonDemo.class);
			startActivity(intent);
			break;
		case R.id.btn_UI_RadioButton:
			intent = new Intent(activity_UI_Widgets.this, activity_UI_Widgets_RadioButtonDemo.class);
			startActivity(intent);
			break;
		case R.id.btn_UI_CheckBox:
			intent = new Intent(activity_UI_Widgets.this, activity_UI_Widgets_CheckBoxDemo.class);
			startActivity(intent);
			break;
		case R.id.btn_UI_Switch:
			intent = new Intent(activity_UI_Widgets.this, activity_UI_Widgets_SwitchDemo.class);
			startActivity(intent);
			break;
		case R.id.btn_UI_ToggleButton:
			intent = new Intent(activity_UI_Widgets.this, activity_UI_Widgets_ToggleButtonDemo.class);
			startActivity(intent);
			break;
		case R.id.btn_UI_ImageView:
			intent = new Intent(activity_UI_Widgets.this, activity_UI_Widgets_ImageViewDemo.class);
			startActivity(intent);
			break;
		case R.id.btn_UI_ImageButton:
			intent = new Intent(activity_UI_Widgets.this, activity_UI_Widgets_ImageButtonDemo.class);
			startActivity(intent);
			break;
		case R.id.btn_UI_ProgressBar:
			intent = new Intent(activity_UI_Widgets.this, activity_UI_Widgets_ProgressBarDemo.class);
			startActivity(intent);
			break;
		case R.id.btn_UI_SeekBar:
			intent = new Intent(activity_UI_Widgets.this, activity_UI_Widgets_SeekBarDemo.class);
			startActivity(intent);
			break;
		case R.id.btn_UI_RatingBar:
			intent = new Intent(activity_UI_Widgets.this, activity_UI_Widgets_RatingBarDemo.class);
			startActivity(intent);
			break;
		case R.id.btn_UI_Spinner:
			intent = new Intent(activity_UI_Widgets.this, activity_UI_Widgets_SpinnerDemo.class);
			startActivity(intent);
			break;
		case R.id.btn_UI_Webview:
			intent = new Intent(activity_UI_Widgets.this, activity_UI_Widgets_WebViewDemo.class);
			startActivity(intent);
			break;

		}

	}
}
