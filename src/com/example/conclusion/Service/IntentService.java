package com.example.conclusion.Service;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class IntentService extends android.app.IntentService {

	public IntentService() {
		super("HelloIntentService");
		Log.i("servicecycle", "--> IntentService");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		Log.i("servicecycle", "--> onHandleIntent");
		long EndTime = System.currentTimeMillis() + 3 * 1000;
		while (System.currentTimeMillis() < EndTime) {
			synchronized (this) {
				try {
					wait(EndTime - System.currentTimeMillis());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i("servicecycle", "--> onDestroy");
		Toast.makeText(IntentService.this, "IntentService-->End", Toast.LENGTH_SHORT).show();
	}
}
