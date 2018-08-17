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

					// ���ñ�ǣ���ת�����ǰ���ջ----->�����⣬�����
					// intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
					// startActivity(intent);

					// ���Ը��ݺ���activity���ؽ����setResult(int)���ж��Ƿ���˵���activity
					startActivityForResult(intent, 1);
					// finish();
				}
				if (msg.what == 1) {
					String time="ʣ��ʱ�䣺"+msg.arg1+"";
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
		// �ж��Ƿ񷵻�0 �������activity
		if (resultCode == 0) {

			this.finish();
			// System.exit(0);
		}
	}
}
