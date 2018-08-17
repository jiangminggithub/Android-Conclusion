package com.example.conclusion.ui_widgets_activity;

import com.example.conclusion.R;
import com.example.conclusion.R.id;
import com.example.conclusion.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;

public class activity_UI_Widgets_CheckBoxDemo extends Activity {
	CheckBox cbCheckBoxDemo1, cbCheckBoxDemo2, cbCheckBoxDemo3,
			cbCheckBoxDemo4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ui_widgets_checkbox_demo);
		initView();
	}

	public void initView() {

		cbCheckBoxDemo1 = (CheckBox) findViewById(R.id.cbCheckBoxDemo1);
		cbCheckBoxDemo2 = (CheckBox) findViewById(R.id.cbCheckBoxDemo2);
		cbCheckBoxDemo3 = (CheckBox) findViewById(R.id.cbCheckBoxDemo3);
		cbCheckBoxDemo4 = (CheckBox) findViewById(R.id.cbCheckBoxDemo4);

		cbCheckBoxDemo1.setOnCheckedChangeListener(checkboxitem);
		cbCheckBoxDemo2.setOnCheckedChangeListener(checkboxitem);
		cbCheckBoxDemo3.setOnCheckedChangeListener(checkboxitem);
		cbCheckBoxDemo4.setOnCheckedChangeListener(checkboxitem);

	}

	private OnCheckedChangeListener checkboxitem = new OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			if (isChecked) {
				Toast.makeText(activity_UI_Widgets_CheckBoxDemo.this,
						"你选中了：" + buttonView.getText(), 0).show();
			}
		}

	};

	public void getCheckBox(View view) {
		String result = "";
		if (cbCheckBoxDemo1.isChecked())
			result += cbCheckBoxDemo1.getText().toString() + ",";
		if (cbCheckBoxDemo2.isChecked())
			result += cbCheckBoxDemo2.getText().toString() + ",";
		if (cbCheckBoxDemo3.isChecked())
			result += cbCheckBoxDemo3.getText().toString() + ",";
		if (cbCheckBoxDemo4.isChecked())
			result += cbCheckBoxDemo4.getText().toString() + ",";
		Toast.makeText(activity_UI_Widgets_CheckBoxDemo.this, "你选中了：" + result, 0)
				.show();

	}

}
