package com.example.conclusion.Files;

import com.example.conclusion.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class activity_Files extends Activity implements OnClickListener {

	Button btn_Files_SharedPreferences, btn_Files_Size, btn_Files_WriteAndRead;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_files);

		btn_Files_SharedPreferences = (Button) findViewById(R.id.btn_Files_SharedPreferences);
		btn_Files_Size = (Button) findViewById(R.id.btn_Files_Size);
		btn_Files_WriteAndRead = (Button) findViewById(R.id.btn_Files_WriteAndRead);
		
		btn_Files_SharedPreferences.setOnClickListener(this);
		btn_Files_Size.setOnClickListener(this);
		btn_Files_WriteAndRead.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent;
		switch (v.getId()) {
		case R.id.btn_Files_SharedPreferences:
			intent=new Intent(activity_Files.this, activity_Files_SharedPreferencesDemo.class);
			startActivity(intent);
			break;
		case R.id.btn_Files_Size:
			intent=new Intent(activity_Files.this, activity_Files_SizeDemo.class);
			startActivity(intent);
			break;
		case R.id.btn_Files_WriteAndRead:
			intent=new Intent(activity_Files.this, activity_Files_WriteAndReadDemo.class);
			startActivity(intent);
			break;
		}

	}
}
