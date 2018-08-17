package com.example.conclusion.component;

import com.example.conclusion.R;
import com.example.conclusion.R.id;
import com.example.conclusion.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class activity_Component extends Activity implements OnClickListener {

	Button btn_Component_ActivityDemo, btn_Component_ServiceDemo, btn_Component_BroadcastReceiverDemo,
			btn_Component_ContentProviderDemo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_component);

		btn_Component_ActivityDemo = (Button) findViewById(R.id.btn_Component_ActivityDemo);
		btn_Component_ServiceDemo = (Button) findViewById(R.id.btn_Component_ServiceDemo);
		btn_Component_BroadcastReceiverDemo = (Button) findViewById(R.id.btn_Component_BroadcastReceiverDemo);
		btn_Component_ContentProviderDemo = (Button) findViewById(R.id.btn_Component_ContentProviderDemo);

		btn_Component_ActivityDemo.setOnClickListener(this);
		btn_Component_ServiceDemo.setOnClickListener(this);
		btn_Component_BroadcastReceiverDemo.setOnClickListener(this);
		btn_Component_ContentProviderDemo.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		Intent intent;
		switch (v.getId()) {
		case R.id.btn_Component_ActivityDemo:
			intent = new Intent(activity_Component.this, activity_Cpmponent_ActivityDemo.class);
			startActivity(intent);
			break;
		case R.id.btn_Component_ServiceDemo:
			intent = new Intent(activity_Component.this, activity_Component_ServiceDemo.class);
			startActivity(intent);
			break;
		case R.id.btn_Component_BroadcastReceiverDemo:
			intent = new Intent(activity_Component.this, activity_Component_BroadcastReceiverDemo.class);
			startActivity(intent);
			break;
		case R.id.btn_Component_ContentProviderDemo:
			intent = new Intent(activity_Component.this, activity_Component_ContentProviderDemo.class);
			startActivity(intent);
			break;
		}
	}
}
