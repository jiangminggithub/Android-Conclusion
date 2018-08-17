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

	// 从线程接收消息的处理程序
	private final class ServiceHandler extends Handler {
		public ServiceHandler(Looper looper) {
			super(looper);
		}

		@Override
		public void handleMessage(Message msg) {
			// 通常我们会在这里做一些工作，比如下载一个文件。对于我们的样本，我们只睡5秒。
			long endTime = System.currentTimeMillis() + 3 * 1000;
			while (System.currentTimeMillis() < endTime) {
				synchronized (this) {
					try {
						wait(endTime - System.currentTimeMillis());
					} catch (Exception e) {
					}
				}
			}
			// 使用startid停止服务，所以我们不停的在处理另一个工作中的服务
			stopSelf(msg.arg1);
		}
	}

	@Override
	public void onCreate() {
		Log.i("service", "-->onCreate");
		// 启动线程运行服务。请注意，我们创建一个单独的线程，因为服务在process'smain线程运行正常的情况下，我们不想阻止。
		//我们也使它的背景优先，所以CPU密集的工作不会破坏我们的用户界面。
		HandlerThread thread = new HandlerThread("ServiceStartArguments", Process.THREAD_PRIORITY_BACKGROUND);
		thread.start();
		//得到handlerthread的looper和使用它为我们的Handler
		mServiceLooper = thread.getLooper();
		mServiceHandler = new ServiceHandler(mServiceLooper);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i("service", "-->onStartCommand");
		Toast.makeText(this, "service-->starting", Toast.LENGTH_SHORT).show();
		//每一个启动请求，发送一个消息来启动一个工作，并交付启动ID，以便我们知道我们停止时，我们完成的请求工作
		Message msg = mServiceHandler.obtainMessage();
		msg.arg1 = startId;
		mServiceHandler.sendMessage(msg);
		// 如果我们被杀死，从这里回来后，重新开始

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
