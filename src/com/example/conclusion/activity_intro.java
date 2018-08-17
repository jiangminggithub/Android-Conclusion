package com.example.conclusion;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class activity_intro extends Activity {
	Handler handler;
	TextView tv_Intro_Time;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_intro);
		tv_Intro_Time = (TextView) findViewById(R.id.tv_Intro_Time);

		handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				if (msg.what == 0) {
					Intent intent = new Intent(activity_intro.this, MainActivity.class);

					// 设置标记，跳转后清除前面的栈----->有问题，待解决
					// intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
					// startActivity(intent);

					// 可以根据后面activity返回结果（setResult(int)）判断是否回退到此activity
					startActivityForResult(intent, 1);
					// finish();
				}
				if (msg.what == 1) {
					String time="剩余时间："+msg.arg1+"";
					tv_Intro_Time.setText(time);
				}
			}
		};

		new Thread(new Runnable() {

			@Override
			public void run() {
				int i = 3;
				while (i >= 0) {
					Message msg = new Message();
					msg.what = 1;
					msg.arg1 = i;
					i--;
					handler.sendMessage(msg);

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();

					}
				}

				Message msg = new Message();
				msg.what = 0;
				handler.sendMessage(msg);

			}
		}).start();

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// 判断是否返回0 是则结束activity
		if (resultCode == 0) {

			this.finish();
			// System.exit(0);
		}
	}
}
