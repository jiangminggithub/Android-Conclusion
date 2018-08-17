package com.example.conclusion.ui;

import com.example.conclusion.R;
import com.example.conclusion.R.id;
import com.example.conclusion.R.layout;
import com.example.conclusion.ui.animation.activity_UI_Animation;
import com.example.conclusion.ui_containers_activity.activity_UI_Containers;
import com.example.conclusion.ui_layout_activity.activity_UI_Layout;
import com.example.conclusion.ui_widgets_activity.activity_UI_Widgets;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class activity_UI extends Activity implements OnClickListener {
	Button btn_UI_Widgets, btn_UI_Layout, btn_UI_Containers, btn_UI_Notifications, btn_UI_AlertDialog,
			btn_UI_ProgressDialog, btn_UI_Animation,btn_UI_Toast;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ui);
		btn_UI_Widgets = (Button) findViewById(R.id.btn_UI_Widgets);
		btn_UI_Layout = (Button) findViewById(R.id.btn_UI_Layout);
		btn_UI_Containers = (Button) findViewById(R.id.btn_UI_Containers);
		btn_UI_Notifications = (Button) findViewById(R.id.btn_UI_Notifications);
		btn_UI_AlertDialog = (Button) findViewById(R.id.btn_UI_AlertDialog);
		btn_UI_ProgressDialog = (Button) findViewById(R.id.btn_UI_ProgressDialog);
		btn_UI_Animation = (Button) findViewById(R.id.btn_UI_Animation);
		btn_UI_Toast=(Button) findViewById(R.id.btn_UI_Toast);

		btn_UI_Widgets.setOnClickListener(this);
		btn_UI_Layout.setOnClickListener(this);
		btn_UI_Containers.setOnClickListener(this);
		btn_UI_Notifications.setOnClickListener(this);
		btn_UI_AlertDialog.setOnClickListener(this);
		btn_UI_ProgressDialog.setOnClickListener(this);
		btn_UI_Animation.setOnClickListener(this);
		btn_UI_Toast.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		Intent intent;
		switch (v.getId()) {
		case R.id.btn_UI_Widgets:
			intent = new Intent(activity_UI.this, activity_UI_Widgets.class);
			startActivity(intent);
			break;
		case R.id.btn_UI_Layout:
			intent = new Intent(activity_UI.this, activity_UI_Layout.class);
			startActivity(intent);
			break;
		case R.id.btn_UI_Containers:
			intent = new Intent(activity_UI.this, activity_UI_Containers.class);
			startActivity(intent);
			break;
		case R.id.btn_UI_Notifications:
			intent = new Intent(activity_UI.this, activity_UI_NotificationsDemo.class);
			startActivity(intent);
			break;
		case R.id.btn_UI_AlertDialog:
			intent = new Intent(activity_UI.this, activity_UI_AlertDialogDemo.class);
			startActivity(intent);
			break;
		case R.id.btn_UI_ProgressDialog:
			intent = new Intent(activity_UI.this, activity_UI_ProgressDialogDemo.class);
			startActivity(intent);
			break;
		case R.id.btn_UI_Animation:
			intent = new Intent(activity_UI.this, activity_UI_Animation.class);
			startActivity(intent);
			break;
		case R.id.btn_UI_Toast:
			intent = new Intent(activity_UI.this, activity_UI_Toast_Demo.class);
			startActivity(intent);
			break;
		default:
			break;
		}

	}

}
