package com.example.conclusion.Receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class ScreenStatusReceiver extends BroadcastReceiver {

	private String ACTION_SCREEN_ON = "android.intent.action.SCREEN_ON";
	private String ACTION_SCREEN_OFF = "android.intent.action.SCREEN_OFF";
	private String ACTION_USER_PRESENT = "android.intent.action.USER_PRESENT";
	private String ACTION_CLOSE_SYSTEM_DIALOGS = "android.intent.action.CLOSE_SYSTEM_DIALOGS";

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		if (ACTION_SCREEN_ON.equals(intent.getAction())) {
			Log.i("ScreenStatusReceiver", "--> ��Ļ�ѿ�����");
			Toast.makeText(context, "��Ļ�ѿ�����", Toast.LENGTH_LONG).show();
		}
		if (ACTION_SCREEN_OFF.equals(intent.getAction())) {
			Log.i("ScreenStatusReceiver", "--> ��Ļ�ѹرգ�");
			Toast.makeText(context, "��Ļ�ѹرգ�", Toast.LENGTH_LONG).show();
		}
		if (ACTION_USER_PRESENT.equals(intent.getAction())) {
			Log.i("ScreenStatusReceiver", "--> ��Ļ�ѽ�����");
			Toast.makeText(context, "��Ļ�ѽ�����", Toast.LENGTH_LONG).show();
		}
		if (ACTION_CLOSE_SYSTEM_DIALOGS.equals(intent.getAction())) {
			Log.i("ScreenStatusReceiver", "--> ��ϵͳ�Ի���DIALOGS��");
			Toast.makeText(context, "ϵͳ�Ի���", Toast.LENGTH_LONG).show();
		}
	}

}
