package com.example.conclusion.component;

import com.example.conclusion.R;
import com.example.conclusion.Receiver.DynamicReceiver;
import com.example.conclusion.Receiver.ScreenStatusReceiver;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class activity_Component_BroadcastReceiverDemo extends Activity implements OnClickListener {

	Button btn_Component_BroadcastReceiverDemo1, btn_Component_BroadcastReceiverDemo2,
			btn_Component_BroadcastReceiverDemo3, btn_Component_BroadcastReceiverDemo4;

	private DynamicReceiver receiver = null;
	private ScreenStatusReceiver screenSatusReceiver = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_conponent_broadcastreceiver_demo);

		btn_Component_BroadcastReceiverDemo1 = (Button) findViewById(R.id.btn_Component_BroadcastReceiverDemo1);
		btn_Component_BroadcastReceiverDemo2 = (Button) findViewById(R.id.btn_Component_BroadcastReceiverDemo2);
		btn_Component_BroadcastReceiverDemo3 = (Button) findViewById(R.id.btn_Component_BroadcastReceiverDemo3);
		btn_Component_BroadcastReceiverDemo4 = (Button) findViewById(R.id.btn_Component_BroadcastReceiverDemo4);

		btn_Component_BroadcastReceiverDemo1.setOnClickListener(this);
		btn_Component_BroadcastReceiverDemo2.setOnClickListener(this);
		btn_Component_BroadcastReceiverDemo3.setOnClickListener(this);
		btn_Component_BroadcastReceiverDemo4.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_Component_BroadcastReceiverDemo1:
			StaticReceiverDemo();
			break;
		case R.id.btn_Component_BroadcastReceiverDemo2:
			DynamicReceiverDemo();
			break;
		case R.id.btn_Component_BroadcastReceiverDemo3:
			ScreenStatusReceiverDemo();
			break;
		case R.id.btn_Component_BroadcastReceiverDemo4:
			LogOut();
			break;
		}

	}

	// 静态注册广播，（在Mannifest中注册receiver）
	/*
	 * <receiver android:name="com.example.conclusion.Receiver.MyReceiver">---->
	 * 广播处理类 <intent-filter > <action android:name="my_frist_receiver"/>---->
	 * 接受的广播的动作 </intent-filter> </receiver>
	 */
	private void StaticReceiverDemo() {
		// 发送一个静态广播
		Intent intent = new Intent();
		intent.setAction("my_frist_receiver");
		sendBroadcast(intent);
	}

	// 动态注册广播
	private void DynamicReceiverDemo() {
		if (receiver == null) {
			// 创建一个广播处理类
			receiver = new DynamicReceiver();

			// 动态注册广播及action
			registerReceiver(receiver, new IntentFilter("dynamicReceiver"));
		}
		// 发送广播
		Intent intent = new Intent();
		intent.setAction("dynamicReceiver");
		sendBroadcast(intent);

	}

	// 动态注销广播
	private void LogOut() {
		if (receiver == null && screenSatusReceiver == null) {
			Toast.makeText(activity_Component_BroadcastReceiverDemo.this, "未开启服务！", Toast.LENGTH_SHORT).show();
			return;

		}
		if (receiver != null) {
			// 注销广播
			unregisterReceiver(receiver);
			receiver = null;
			Log.i("dynamicReceiver", "-->dynamicReceiver End");
			Toast.makeText(activity_Component_BroadcastReceiverDemo.this, "dynamicReceiver 服务已注销！", Toast.LENGTH_SHORT)
					.show();

		}
		if (screenSatusReceiver != null) {
			// 注销广播
			unregisterReceiver(screenSatusReceiver);
			screenSatusReceiver = null;
			Log.i("dynamicReceiver", "-->screenSatusReceiver End");
			Toast.makeText(activity_Component_BroadcastReceiverDemo.this, "screenSatusReceiver 服务已注销！",
					Toast.LENGTH_SHORT).show();
		}

	}

	// 屏幕状态广播监视
	private void ScreenStatusReceiverDemo() {
		if (screenSatusReceiver == null) {
			screenSatusReceiver = new ScreenStatusReceiver();
			IntentFilter screenStatusIF = new IntentFilter();
			screenStatusIF.addAction(Intent.ACTION_SCREEN_ON);// 屏幕亮屏广播
			screenStatusIF.addAction(Intent.ACTION_SCREEN_OFF);// 屏幕灭屏广播
			screenStatusIF.addAction(Intent.ACTION_USER_PRESENT); // 屏幕解锁广播
			// 当长按电源键弹出“关机”对话或者锁屏时系统会发出这个广播
			// example：有时候会用到系统对话框，权限可能很高，会覆盖在锁屏界面或者“关机”对话框之上，
			// 所以监听这个广播，当收到时就隐藏自己的对话，如点击pad右下角部分弹出的对话框
			screenStatusIF.addAction(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);

			// 动态注册广播
			registerReceiver(screenSatusReceiver, screenStatusIF);

			Toast.makeText(activity_Component_BroadcastReceiverDemo.this, "屏幕状态服务注册成功！", Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(activity_Component_BroadcastReceiverDemo.this, "屏幕状态服务已开启，无需重复注册！", Toast.LENGTH_SHORT)
					.show();
		}
	}

}
