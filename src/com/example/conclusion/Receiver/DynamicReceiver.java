package com.example.conclusion.Receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
/**
 * 动态注册Receiver处理
 * @author Ming
 *
 */
public class DynamicReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Log.i("DynamicReceiver", "-->DynamicReceiver Starting");
		Toast.makeText(context, "DynamicReceiver服务已启动！", Toast.LENGTH_SHORT).show();
	}

}
