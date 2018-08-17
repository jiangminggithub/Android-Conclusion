package com.example.conclusion.ui_widgets_activity;

import com.example.conclusion.R;
import com.example.conclusion.R.id;
import com.example.conclusion.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class activity_UI_Widgets_RadioButtonDemo extends Activity {
	Button btnsex;
	RadioGroup rgroup;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ui_widgets_radiobutton_demo);
		rgroup = (RadioGroup) findViewById(R.id.rgsex);
		btnsex = (Button) findViewById(R.id.btnsex);

		// 按钮发生改变监听器
		rgroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				RadioButton rbtn = (RadioButton) findViewById(checkedId);
				Toast.makeText(activity_UI_Widgets_RadioButtonDemo.this,
						"你选中了：" + rbtn.getText(), 0).show();

			}
		});

		btnsex.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				for (int i = 0; i < rgroup.getChildCount(); i++) {

					RadioButton rbtn = (RadioButton) rgroup.getChildAt(i);
					if (rbtn.isChecked()) {

						Toast.makeText(activity_UI_Widgets_RadioButtonDemo.this,
								"你的性别为：" + rbtn.getText().toString(), 0).show();
						break;
					}
				}

			}
		});

	}

}
