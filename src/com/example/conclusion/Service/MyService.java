package com.example.conclusion.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
	private Looper mServiceLooper;
	private ServiceHandler mServiceHandler;

	// ���߳̽�����Ϣ�Ĵ������
	private final class ServiceHandler extends Handler {
		public ServiceHandler(Looper looper) {
			super(looper);
		}

		@Override
		public void handleMessage(Message msg) {
			// ͨ�����ǻ���������һЩ��������������һ���ļ����������ǵ�����������ֻ˯5�롣
			long endTime = System.currentTimeMillis() + 3 * 1000;
			while (System.currentTimeMillis() < endTime) {
				synchronized (this) {
					try {
						wait(endTime - System.currentTimeMillis());
					} catch (Exception e) {
					}
				}
			}
			// ʹ��startidֹͣ�����������ǲ�ͣ���ڴ�����һ�������еķ���
			stopSelf(msg.arg1);
		}
	}

	@Override
	public void onCreate() {
		Log.i("service", "-->onCreate");
		// �����߳����з�����ע�⣬���Ǵ���һ���������̣߳���Ϊ������process'smain�߳���������������£����ǲ�����ֹ��
		//����Ҳʹ���ı������ȣ�����CPU�ܼ��Ĺ��������ƻ����ǵ��û����档
		HandlerThread thread = new HandlerThread("ServiceStartArguments", Process.THREAD_PRIORITY_BACKGROUND);
		thread.start();
		//�õ�handlerthread��looper��ʹ����Ϊ���ǵ�Handler
		mServiceLooper = thread.getLooper();
		mServiceHandler = new ServiceHandler(mServiceLooper);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i("service", "-->onStartCommand");
		Toast.makeText(this, "service-->starting", Toast.LENGTH_SHORT).show();
		//ÿһ���������󣬷���һ����Ϣ������һ������������������ID���Ա�����֪������ֹͣʱ��������ɵ�������
		Message msg = mServiceHandler.obtainMessage();
		msg.arg1 = startId;
		mServiceHandler.sendMessage(msg);
		// ������Ǳ�ɱ������������������¿�ʼ

		return START_STICKY;
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onDestroy() {
		Log.i("service", "-->onDestroy");
		Toast.makeText(this, "service-->End", Toast.LENGTH_SHORT).show();
	}
}
