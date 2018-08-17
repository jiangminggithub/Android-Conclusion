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

		//Ĭ��ʵ�ַ�ʽ
		notifications1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Notification notification = new Notification();
				// ֪ͨͼ��
				notification.icon = R.drawable.containers_tabhostdemo_imgitem1;
				// ֪ͨ��������ʾ��Ϣ
				notification.tickerText = "����һ������Ϣ";
				// ʲôʱ����ʾ
				notification.when = System.currentTimeMillis();
				notification.defaults = Notification.DEFAULT_SOUND;// Ĭ��ϵͳ����
				notification.defaults |= Notification.DEFAULT_VIBRATE;// ��
				// notification.defaults=Notification.DEFAULT_ALL;//Ĭ�ϵ��������񶯣������
				notification.setLatestEventInfo(activity_UI_NotificationsDemo.this, "֪ͨ1", "����ÿһ�죡", null);
				
				//���֪ͨ�������ҳ��
				Intent intent = new Intent(activity_UI_NotificationsDemo.this, activity_UI_NotificationsDemo.class);
				PendingIntent pendingIntent=PendingIntent.getActivity(activity_UI_NotificationsDemo.this, 0, intent, 0);
				notification.contentIntent=pendingIntent;
				
				// ��ʾ֪ͨ
				notificationManager.notify(1, notification);

			}
		});

		//ͨ��NotificationCompat.Builderʵ�֣��°汾֧��4.1�����ϣ�
		notifications2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				NotificationCompat.Builder builder = new Builder(activity_UI_NotificationsDemo.this);
				builder.setSmallIcon(R.drawable.containers_tabhostdemo_imgitem2);
				builder.setTicker("����һ������Ϣ");
				builder.setContentTitle("֪ͨ2");
				builder.setContentText("NotificationCompat.Builder");
				builder.setDefaults(Notification.DEFAULT_SOUND);
				notificationManager.notify(2, builder.build());
			}
		});

		//builder����֪ͨ
		notifications3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Builder builder = new Builder(activity_UI_NotificationsDemo.this);
				// ϵͳ�յ�֪ͨʱ��֪ͨ��������ʾ�����֡�
				builder.setTicker("����һ������Ϣ");
				// ��ʾ��֪ͨ����Сͼ��
				builder.setSmallIcon(R.drawable.containers_gridview_imgdemo1);
				// ֪ͨ����
				builder.setContentTitle("����Ԥ��");
				// ֪ͨ����
				builder.setContentText("�ߺ����磬2��15�ȣ�΢��");
				// �����Ҳ���ʾ����Ϣ
				builder.setContentInfo("����");
				// ��ʾ��ʱ��
				builder.setWhen(System.currentTimeMillis());
				// ��ʾ��Сͼ����������
				builder.setNumber(6);
				// ����Ϊ�������ģʽ
				builder.setOngoing(false);
				// ��ʾ֪ͨ
				notificationManager.notify(3, builder.build());

			}
		});

		//���н�������֪ͨ
		notifications4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				final Builder builder = new Builder(activity_UI_NotificationsDemo.this);
				// ��ʽ�ṹ
				/*
				 * builder.setTicker("����һ������Ϣ")
				 * .setSmallIcon(R.drawable.containers_tabhostdemo_imgitem1)
				 * .setContentTitle("֪ͨ4") .setContentText("���ڼ��ء���");
				 */

				builder.setTicker("����һ������Ϣ");
				builder.setSmallIcon(R.drawable.containers_tabhostdemo_imgitem1);
				builder.setContentTitle("������֪ͨ");
				builder.setContentText("���ڼ��ء���");
				//builder.setWhen(System.currentTimeMillis());

				//ģ�������
				new Thread(new Runnable() {

					@Override
					public void run() {
						for (int i = 0; i <= 100; i++) {

//							ʹ��setProgress(0, 0, true)����ʾ���Ȳ���ȷ�Ľ�����
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
						
						builder.setContentText("������ɣ�");
						builder.setProgress(0, 0, false);
						notificationManager.notify(4, builder.build());
					}
				}).start();

			}
		});

	}

}
