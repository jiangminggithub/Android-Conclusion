package com.example.conclusion.ui_widgets_activity;

import com.example.conclusion.R;
import com.example.conclusion.R.id;
import com.example.conclusion.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.Toast;
public class activity_UI_Widgets_SwitchDemo extends Activity {
	Switch switchDemo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ui_widgets_switch_demo);
		
		switchDemo= (Switch) findViewById(R.id.switchDemo);
		
		switchDemo.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
				
				if (isChecked) {
					Toast.makeText(activity_UI_Widgets_SwitchDemo.this, "已开启", Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(activity_UI_Widgets_SwitchDemo.this, "已关闭", Toast.LENGTH_SHORT).show();
				}

				
			}
		});
		
	}

}
