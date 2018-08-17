package com.example.conclusion.ui_widgets_activity;

import com.example.conclusion.R;
import com.example.conclusion.Thread.timerThread;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class activity_UI_Widgets_ProgressBarDemo extends Activity {
	ProgressBar progressbar, progressbar1, progressbar2, progressbar3,
			progressbar4;
	TextView tv_UI_ProgressBarDemo, tv_UI_ProgressBarDemo1;
	Button btn_UI_ProgressBar_Demo;
	int progressMax;
	boolean flg = false;//标记是否为第一次加载
	Handler handler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ui_widgets_progressbar_demo);
		handlerProcessing();

		progressbar = (ProgressBar) findViewById(R.id.pb_ProgressBarDemo);
		progressbar1 = (ProgressBar) findViewById(R.id.pb_ProgressBarDemo1);
		progressbar2 = (ProgressBar) findViewById(R.id.pb_ProgressBarDemo2);
		progressbar3 = (ProgressBar) findViewById(R.id.pb_ProgressBarDemo3);
		progressbar4 = (ProgressBar) findViewById(R.id.pb_ProgressBarDemo4);
		tv_UI_ProgressBarDemo = (TextView) findViewById(R.id.tv_UI_ProgressBarDemo);
		tv_UI_ProgressBarDemo1 = (TextView) findViewById(R.id.tv_UI_ProgressBarDemo1);
		btn_UI_ProgressBar_Demo = (Button) findViewById(R.id.btn_UI_ProgressBar_Demo);

		progressMax = progressbar3.getMax();

	}

	public void handlerProcessing() {
		handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				int result = msg.arg1;
				if (result < progressMax) {
					progressbar3.setProgress(result);
					progressbar4.setProgress(result);
					tv_UI_ProgressBarDemo.setText(result + "%");
					tv_UI_ProgressBarDemo1.setText(result + "%");
				} else {
					progressbar.setVisibility(View.GONE);
					progressbar1.setVisibility(View.GONE);
					progressbar2.setVisibility(View.GONE);
					progressbar3.setVisibility(View.GONE);
					progressbar4.setVisibility(View.GONE);

					flg = true;
					tv_UI_ProgressBarDemo.setText("");
					tv_UI_ProgressBarDemo1.setText("");
					btn_UI_ProgressBar_Demo.setEnabled(true);
					Toast.makeText(activity_UI_Widgets_ProgressBarDemo.this, "加载完成",
							Toast.LENGTH_SHORT).show();

				}
			}
		};
	}

	public void startProgress(View view) {
		if (flg == false) {
			timerThread t1 = new timerThread(handler, progressMax);
			t1.start();
		} else {
			progressbar.setVisibility(View.VISIBLE);
			progressbar1.setVisibility(View.VISIBLE);
			progressbar2.setVisibility(View.VISIBLE);
			progressbar3.setVisibility(View.VISIBLE);
			progressbar4.setVisibility(View.VISIBLE);
			progressbar3.setProgress(0);
			progressbar4.setProgress(0);
			timerThread t1 = new timerThread(handler, progressMax);
			t1.start();
		}
		btn_UI_ProgressBar_Demo.setEnabled(false);

	}

}
