package com.example.conclusion;

import com.example.conclusion.AsyncTask.activity_AsyncTaskDemo;
import com.example.conclusion.Files.activity_Files;
import com.example.conclusion.Gesture.activity_GestureDemo;
import com.example.conclusion.Menu.activity_Menu;
import com.example.conclusion.PhoneAndSms.activity_PhoneAndSms;
import com.example.conclusion.SQLite.activity_SQLite;
import com.example.conclusion.component.activity_Component;
import com.example.conclusion.ui.activity_UI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	Button btnUI,btnComponent,btnPhoneAndSMS,btnFiles,btnSQLite,btnAsyncTask,btnMenu,btnGesture;
	long startTime = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnUI = (Button) findViewById(R.id.btnUI);
		btnComponent=(Button) findViewById(R.id.btnComponent);
		btnPhoneAndSMS=(Button) findViewById(R.id.btnPhoneAndSMS);
		btnFiles=(Button) findViewById(R.id.btnFiles);
		btnSQLite=(Button) findViewById(R.id.btnSQLite);
		btnAsyncTask=(Button) findViewById(R.id.btnAsyncTask);
		btnMenu=(Button) findViewById(R.id.btnMenu);
		btnGesture=(Button) findViewById(R.id.btnGesture);
		
		btnUI.setOnClickListener(this);
		btnComponent.setOnClickListener(this);
		btnFiles.setOnClickListener(this);
		btnSQLite.setOnClickListener(this);
		btnPhoneAndSMS.setOnClickListener(this);
		btnAsyncTask.setOnClickListener(this);
		btnMenu.setOnClickListener(this);
		btnGesture.setOnClickListener(this);
	}

	//按back后再2秒内再按Back,退出程序
	@Override
	public void onBackPressed() {
		long currentTime = System.currentTimeMillis();
		if ((currentTime - startTime) > 2000) {
			Toast.makeText(MainActivity.this, "再按一次退出", Toast.LENGTH_SHORT)
					.show();
			startTime=currentTime;
		}
		else{
			setResult(0);
			finish();
			//System.exit(0);
		}
	}

	@Override
	public void onClick(View v) {
		Intent intent;
		switch (v.getId()) {
		case R.id.btnUI:
			intent=new Intent(MainActivity.this, activity_UI.class);
			startActivity(intent);
			break;
		case R.id.btnComponent:
			intent = new Intent(MainActivity.this, activity_Component.class);
			startActivity(intent);
			break;
		case R.id.btnPhoneAndSMS:
			intent = new Intent(MainActivity.this, activity_PhoneAndSms.class);
			startActivity(intent);
			break;
		case R.id.btnFiles:
			intent = new Intent(MainActivity.this, activity_Files.class);
			startActivity(intent);
			break;
		case R.id.btnSQLite:
			intent = new Intent(MainActivity.this, activity_SQLite.class);
			startActivity(intent);
			break;
		case R.id.btnAsyncTask:
			intent = new Intent(MainActivity.this, activity_AsyncTaskDemo.class);
			startActivity(intent);
			break;
		case R.id.btnMenu:
			intent = new Intent(MainActivity.this, activity_Menu.class);
			startActivity(intent);
			break;
		case R.id.btnGesture:
			intent = new Intent(MainActivity.this, activity_GestureDemo.class);
			startActivity(intent);
			break;
		default:
			break;
		}

	}

}
