package com.example.conclusion.Thread;

import android.os.Handler;
import android.os.Message;

public class timerThread extends Thread {

	Handler handler;
	int Max;
	/**
	 * ProgressBar 中通过线程模拟进度
	 * @param handler
	 * @param Max
	 */
	public timerThread(Handler handler,int Max) {
		this.handler=handler;
		this.Max=Max;
	}
	@Override
	public void run() {
		
		for(int i=0;i<Max+1;i++){
			Message msg=new Message();
			msg.arg1=i;
			handler.sendMessage(msg);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
