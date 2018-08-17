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

		// 4--> �ڲ�������ʵ��OnClick
		btnButtonDemo8.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(activity_UI_Widgets_ButtonDemo.this, "�ڲ�������-OnClick�¼�",
						Toast.LENGTH_SHORT).show();
			}
		});

	}

	// 1--> xml-Onclick�¼�
	public void xmlOnClick(View view) {
		Toast.makeText(activity_UI_Widgets_ButtonDemo.this, "xml-Onclick�¼�",
				Toast.LENGTH_SHORT).show();
	}

	// 2--> �ڲ���-Onclick�¼�
	class myClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btnButtonDemo6:
				Toast.makeText(activity_UI_Widgets_ButtonDemo.this, "�ڲ���-Onclick�¼�",
						Toast.LENGTH_SHORT).show();
				break;

			default:
				break;
			}

		}

	}

	// 3--> Activity�̳�View.OnClickListener����Activityʵ��OnClick(View
	// view)��������OnClick(View v)��������switch-case�Բ�ͬid�����button������Ӧ�Ĵ���
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnButtonDemo7:
			Toast.makeText(activity_UI_Widgets_ButtonDemo.this, "ctivity-OnClick���¼�",
					Toast.LENGTH_SHORT).show();
			break;

		default:
			break;
		}

	}

}
