package com.example.conclusion.component;

import com.example.conclusion.R;
import com.example.conclusion.Service.CustomService;
import com.example.conclusion.Service.IntentService;
import com.example.conclusion.Service.MyService;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class activity_Component_ServiceDemo extends Activity implements OnClickListener {
	Button btn_component_ServiceDemo1, btn_component_ServiceDemo2, btn_component_ServiceDemo3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_component_service_demo);
		btn_component_ServiceDemo1 = (Button) findViewById(R.id.btn_component_ServiceDemo1);
		btn_component_ServiceDemo2 = (Button) findViewById(R.id.btn_component_ServiceDemo2);
		btn_component_ServiceDemo3 = (Button) findViewById(R.id.btn_component_ServiceDemo3);

		btn_component_ServiceDemo1.setOnClickListener(this);
		btn_component_ServiceDemo2.setOnClickListener(this);
		btn_component_ServiceDemo3.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_component_ServiceDemo1:
			serviceDemo();
			break;
		case R.id.btn_component_ServiceDemo2:
			IntentServiceDmeo();
			break;
		case R.id.btn_component_ServiceDemo3:
			CustomServiceDemo();
			break;
		default:
			break;
		}
	}

	// 官方标准事务处理Service
	private void serviceDemo() {

		Intent service = new Intent(this, MyService.class);
		startService(service);
		Log.i("service", "-->click");
		// stopService(service);
	}

	// IntentService服务
	private void IntentServiceDmeo() {
		Intent service = new Intent(this, IntentService.class);
		startService(service);
		Toast.makeText(activity_Component_ServiceDemo.this, "IntentService-->Starting", Toast.LENGTH_SHORT).show();
	}

	// 自定义Service 继承自：Service
	private void CustomServiceDemo() {
		Intent service = new Intent(this, CustomService.class);
		startService(service);
	}
}
