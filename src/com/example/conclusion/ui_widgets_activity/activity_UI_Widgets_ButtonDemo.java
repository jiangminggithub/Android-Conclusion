package com.example.conclusion.ui_widgets_activity;

import com.example.conclusion.R;
import com.example.conclusion.R.id;
import com.example.conclusion.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class activity_UI_Widgets_ButtonDemo extends Activity implements OnClickListener {
	Button btnButtonDemo6, btnButtonDemo7, btnButtonDemo8;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ui_widgets_button_demo);
		btnButtonDemo6 = (Button) findViewById(R.id.btnButtonDemo6);
		btnButtonDemo7 = (Button) findViewById(R.id.btnButtonDemo7);
		btnButtonDemo8 = (Button) findViewById(R.id.btnButtonDemo8);
		btnButtonDemo6.setOnClickListener(new myClickListener());
		btnButtonDemo7.setOnClickListener(this);

		// 4--> 内部匿名类实现OnClick
		btnButtonDemo8.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(activity_UI_Widgets_ButtonDemo.this, "内部匿名类-OnClick事件",
						Toast.LENGTH_SHORT).show();
			}
		});

	}

	// 1--> xml-Onclick事件
	public void xmlOnClick(View view) {
		Toast.makeText(activity_UI_Widgets_ButtonDemo.this, "xml-Onclick事件",
				Toast.LENGTH_SHORT).show();
	}

	// 2--> 内部类-Onclick事件
	class myClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btnButtonDemo6:
				Toast.makeText(activity_UI_Widgets_ButtonDemo.this, "内部类-Onclick事件",
						Toast.LENGTH_SHORT).show();
				break;

			default:
				break;
			}

		}

	}

	// 3--> Activity继承View.OnClickListener，由Activity实现OnClick(View
	// view)方法，在OnClick(View v)方法中用switch-case对不同id代表的button进行相应的处理
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnButtonDemo7:
			Toast.makeText(activity_UI_Widgets_ButtonDemo.this, "ctivity-OnClick是事件",
					Toast.LENGTH_SHORT).show();
			break;

		default:
			break;
		}

	}

}
