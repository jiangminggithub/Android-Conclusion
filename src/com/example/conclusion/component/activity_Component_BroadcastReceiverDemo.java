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

	// ��̬ע��㲥������Mannifest��ע��receiver��
	/*
	 * <receiver android:name="com.example.conclusion.Receiver.MyReceiver">---->
	 * �㲥������ <intent-filter > <action android:name="my_frist_receiver"/>---->
	 * ���ܵĹ㲥�Ķ��� </intent-filter> </receiver>
	 */
	private void StaticReceiverDemo() {
		// ����һ����̬�㲥
		Intent intent = new Intent();
		intent.setAction("my_frist_receiver");
		sendBroadcast(intent);
	}

	// ��̬ע��㲥
	private void DynamicReceiverDemo() {
		if (receiver == null) {
			// ����һ���㲥������
			receiver = new DynamicReceiver();

			// ��̬ע��㲥��action
			registerReceiver(receiver, new IntentFilter("dynamicReceiver"));
		}
		// ���͹㲥
		Intent intent = new Intent();
		intent.setAction("dynamicReceiver");
		sendBroadcast(intent);

	}

	// ��̬ע���㲥
	private void LogOut() {
		if (receiver == null && screenSatusReceiver == null) {
			Toast.makeText(activity_Component_BroadcastReceiverDemo.this, "δ��������", Toast.LENGTH_SHORT).show();
			return;

		}
		if (receiver != null) {
			// ע���㲥
			unregisterReceiver(receiver);
			receiver = null;
			Log.i("dynamicReceiver", "-->dynamicReceiver End");
			Toast.makeText(activity_Component_BroadcastReceiverDemo.this, "dynamicReceiver ������ע����", Toast.LENGTH_SHORT)
					.show();

		}
		if (screenSatusReceiver != null) {
			// ע���㲥
			unregisterReceiver(screenSatusReceiver);
			screenSatusReceiver = null;
			Log.i("dynamicReceiver", "-->screenSatusReceiver End");
			Toast.makeText(activity_Component_BroadcastReceiverDemo.this, "screenSatusReceiver ������ע����",
					Toast.LENGTH_SHORT).show();
		}

	}

	// ��Ļ״̬�㲥����
	private void ScreenStatusReceiverDemo() {
		if (screenSatusReceiver == null) {
			screenSatusReceiver = new ScreenStatusReceiver();
			IntentFilter screenStatusIF = new IntentFilter();
			screenStatusIF.addAction(Intent.ACTION_SCREEN_ON);// ��Ļ�����㲥
			screenStatusIF.addAction(Intent.ACTION_SCREEN_OFF);// ��Ļ�����㲥
			screenStatusIF.addAction(Intent.ACTION_USER_PRESENT); // ��Ļ�����㲥
			// ��������Դ���������ػ����Ի���������ʱϵͳ�ᷢ������㲥
			// example����ʱ����õ�ϵͳ�Ի���Ȩ�޿��ܸܺߣ��Ḳ��������������ߡ��ػ����Ի���֮�ϣ�
			// ���Լ�������㲥�����յ�ʱ�������Լ��ĶԻ�������pad���½ǲ��ֵ����ĶԻ���
			screenStatusIF.addAction(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);

			// ��̬ע��㲥
			registerReceiver(screenSatusReceiver, screenStatusIF);

			Toast.makeText(activity_Component_BroadcastReceiverDemo.this, "��Ļ״̬����ע��ɹ���", Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(activity_Component_BroadcastReceiverDemo.this, "��Ļ״̬�����ѿ����������ظ�ע�ᣡ", Toast.LENGTH_SHORT)
					.show();
		}
	}

}
