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
					Toast.makeText(activity_UI_ProgressDialogDemo.this, "������ɣ�", Toast.LENGTH_SHORT).show();
				}
				if (msg.what == 1) {
					if (msg.arg1 > 100) {
						progressdialog.dismiss();
						Toast.makeText(activity_UI_ProgressDialogDemo.this, "������ɣ�", Toast.LENGTH_SHORT).show();
					} else {
						progressdialog.setProgress(msg.arg1);
					}
				}

			};
		};

		btn_UI_ProgressDialog1 = (Button) findViewById(R.id.btn_UI_ProgressDialog1);
		btn_UI_ProgressDialog2 = (Button) findViewById(R.id.btn_UI_ProgressDialog2);

		// Բ�ν��ȿ�
		btn_UI_ProgressDialog1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				progressdialog = new ProgressDialog(activity_UI_ProgressDialogDemo.this);
				// ����ΪԲ����ʽ
				progressdialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
				progressdialog.setTitle("���Ժ�");
				progressdialog.setMessage("���������С���");
				progressdialog.setCancelable(false);
				progressdialog.show();

				// ģ�����
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

		// ˮƽ��״���ȿ�
		btn_UI_ProgressDialog2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				progressdialog = new ProgressDialog(activity_UI_ProgressDialogDemo.this);
				// ����Ϊˮƽ��ʽ
				progressdialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
				progressdialog.setTitle("���Ժ�");
				progressdialog.setMessage("���������С���");
				progressdialog.setProgress(0);
				progressdialog.setMax(100);
				progressdialog.setCancelable(false);
				progressdialog.show();

				// ģ�����
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
