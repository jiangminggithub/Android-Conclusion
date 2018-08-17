package com.example.conclusion.ui;

import com.example.conclusion.R;
import com.example.conclusion.R.drawable;
import com.example.conclusion.R.id;
import com.example.conclusion.R.layout;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Builder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class activity_UI_NotificationsDemo extends Activity {

	Button notifications1, notifications2, notifications3, notifications4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		final NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		setContentView(R.layout.activity_ui_notifications_demo);
		notifications1 = (Button) findViewById(R.id.btn_UI_NotificationsDemo1);
		notifications2 = (Button) findViewById(R.id.btn_UI_NotificationsDemo2);
		notifications3 = (Button) findViewById(R.id.btn_UI_NotificationsDemo3);
		notifications4 = (Button) findViewById(R.id.btn_UI_NotificationsDemo4);

		//默认实现方式
		notifications1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Notification notification = new Notification();
				// 通知图标
				notification.icon = R.drawable.containers_tabhostdemo_imgitem1;
				// 通知任务栏提示信息
				notification.tickerText = "你有一个新消息";
				// 什么时间显示
				notification.when = System.currentTimeMillis();
				notification.defaults = Notification.DEFAULT_SOUND;// 默认系统声音
				notification.defaults |= Notification.DEFAULT_VIBRATE;// 振动
				// notification.defaults=Notification.DEFAULT_ALL;//默认的声音，振动，闪光灯
				notification.setLatestEventInfo(activity_UI_NotificationsDemo.this, "通知1", "快乐每一天！", null);
				
				//点击通知后调整的页面
				Intent intent = new Intent(activity_UI_NotificationsDemo.this, activity_UI_NotificationsDemo.class);
				PendingIntent pendingIntent=PendingIntent.getActivity(activity_UI_NotificationsDemo.this, 0, intent, 0);
				notification.contentIntent=pendingIntent;
				
				// 显示通知
				notificationManager.notify(1, notification);

			}
		});

		//通过NotificationCompat.Builder实现（新版本支持4.1及以上）
		notifications2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				NotificationCompat.Builder builder = new Builder(activity_UI_NotificationsDemo.this);
				builder.setSmallIcon(R.drawable.containers_tabhostdemo_imgitem2);
				builder.setTicker("你有一个新消息");
				builder.setContentTitle("通知2");
				builder.setContentText("NotificationCompat.Builder");
				builder.setDefaults(Notification.DEFAULT_SOUND);
				notificationManager.notify(2, builder.build());
			}
		});

		//builder生成通知
		notifications3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Builder builder = new Builder(activity_UI_NotificationsDemo.this);
				// 系统收到通知时，通知栏上面显示的文字。
				builder.setTicker("你有一个新消息");
				// 显示在通知栏的小图标
				builder.setSmallIcon(R.drawable.containers_gridview_imgdemo1);
				// 通知标题
				builder.setContentTitle("天气预报");
				// 通知内容
				builder.setContentText("芜湖，晴，2～15度，微风");
				// 内容右侧显示的消息
				builder.setContentInfo("良好");
				// 显示的时刻
				builder.setWhen(System.currentTimeMillis());
				// 显示在小图标左侧的数字
				builder.setNumber(6);
				// 设置为不可清除模式
				builder.setOngoing(false);
				// 显示通知
				notificationManager.notify(3, builder.build());

			}
		});

		//带有进度条的通知
		notifications4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				final Builder builder = new Builder(activity_UI_NotificationsDemo.this);
				// 链式结构
				/*
				 * builder.setTicker("你有一个新消息")
				 * .setSmallIcon(R.drawable.containers_tabhostdemo_imgitem1)
				 * .setContentTitle("通知4") .setContentText("正在加载……");
				 */

				builder.setTicker("你有一个新消息");
				builder.setSmallIcon(R.drawable.containers_tabhostdemo_imgitem1);
				builder.setContentTitle("进度条通知");
				builder.setContentText("正在加载……");
				//builder.setWhen(System.currentTimeMillis());

				//模拟进度条
				new Thread(new Runnable() {

					@Override
					public void run() {
						for (int i = 0; i <= 100; i++) {

//							使用setProgress(0, 0, true)来表示进度不明确的进度条
							builder.setProgress(100, i, false);
							builder.setContentText(i + "%");
							notificationManager.notify(4, builder.build());
							try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}
						
						builder.setContentText("加载完成！");
						builder.setProgress(0, 0, false);
						notificationManager.notify(4, builder.build());
					}
				}).start();

			}
		});

	}

}
