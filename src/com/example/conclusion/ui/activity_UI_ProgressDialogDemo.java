package com.example.conclusion.ui;

import com.example.conclusion.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class activity_UI_ProgressDialogDemo extends Activity {

	Button btn_UI_ProgressDialog1, btn_UI_ProgressDialog2;
	ProgressDialog progressdialog;
	Handler handler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ui_progressdialog_demo);
		handler = new Handler() {
			public void handleMessage(Message msg) {
				if (msg.what == 0) {
					progressdialog.dismiss();
					Toast.makeText(activity_UI_ProgressDialogDemo.this, "加载完成！", Toast.LENGTH_SHORT).show();
				}
				if (msg.what == 1) {
					if (msg.arg1 > 100) {
						progressdialog.dismiss();
						Toast.makeText(activity_UI_ProgressDialogDemo.this, "加载完成！", Toast.LENGTH_SHORT).show();
					} else {
						progressdialog.setProgress(msg.arg1);
					}
				}

			};
		};

		btn_UI_ProgressDialog1 = (Button) findViewById(R.id.btn_UI_ProgressDialog1);
		btn_UI_ProgressDialog2 = (Button) findViewById(R.id.btn_UI_ProgressDialog2);

		// 圆形进度框
		btn_UI_ProgressDialog1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				progressdialog = new ProgressDialog(activity_UI_ProgressDialogDemo.this);
				// 设置为圆形样式
				progressdialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
				progressdialog.setTitle("请稍后");
				progressdialog.setMessage("加载数据中……");
				progressdialog.setCancelable(false);
				progressdialog.show();

				// 模拟进度
				new Thread(new Runnable() {

					@Override
					public void run() {
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						Message msg = new Message();
						msg.what = 0;
						handler.sendMessage(msg);
					}
				}).start();

			}
		});

		// 水平条状进度框
		btn_UI_ProgressDialog2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				progressdialog = new ProgressDialog(activity_UI_ProgressDialogDemo.this);
				// 设置为水平样式
				progressdialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
				progressdialog.setTitle("请稍后");
				progressdialog.setMessage("加载数据中……");
				progressdialog.setProgress(0);
				progressdialog.setMax(100);
				progressdialog.setCancelable(false);
				progressdialog.show();

				// 模拟进度
				new Thread(new Runnable() {

					@Override
					public void run() {

						try {
							for (int i = 1; i <= 101; i++) {
								Message msg = new Message();
								msg.what = 1;
								msg.arg1 = i;
								handler.sendMessage(msg);
								Thread.sleep(50);
							}

						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}).start();

			}
		});

	}
}
