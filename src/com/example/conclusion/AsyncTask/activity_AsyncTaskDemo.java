package com.example.conclusion.AsyncTask;

import com.example.conclusion.R;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class activity_AsyncTaskDemo extends Activity implements OnClickListener {

	ProgressBar pb_AsyncTask_ProgressBar;
	TextView tv_AsyncTask_Progress;
	Button btn_AsyncTask_Execute, btn_AsyncTask_Cancel;
	MyTask myTask;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_asynctask_demo);

		pb_AsyncTask_ProgressBar = (ProgressBar) findViewById(R.id.pb_AsyncTask_ProgressBar);
		tv_AsyncTask_Progress = (TextView) findViewById(R.id.tv_AsyncTask_Progress);
		btn_AsyncTask_Execute = (Button) findViewById(R.id.btn_AsyncTask_Execute);
		btn_AsyncTask_Cancel = (Button) findViewById(R.id.btn_AsyncTask_Cancel);

		btn_AsyncTask_Execute.setOnClickListener(this);
		btn_AsyncTask_Cancel.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_AsyncTask_Execute:
			Execute();
			break;
		case R.id.btn_AsyncTask_Cancel:
			Cancel();
			break;
		}

	}

	private void Execute() {
		
		// ������ִ��AsyncTask����
		myTask = new MyTask();
		myTask.execute("my AsyncTask");
		
		// �����ظ������������ư�ť�Ŀɲ�����
		btn_AsyncTask_Execute.setEnabled(false);
		btn_AsyncTask_Cancel.setEnabled(true);
	}

	private void Cancel() {
		// ȡ��һ������ִ�е�����,onCancelled�������ᱻ����
		myTask.cancel(true);
	}

	// ����һ��AsyncTask����
	class MyTask extends AsyncTask<String, Integer, String> {

		// ������ִ��֮ǰ��ʼ���ô˷���
		@Override
		protected void onPreExecute() {
			Log.i("AsyncTask", "-->onPreExecute");
			tv_AsyncTask_Progress.setText("Loading����");

		}

		// doInBackground�����ڲ�ִ�к�̨����,�����ڴ˷������޸�UI����ʱ�൱�ڿ�����һ���̣߳�
		@Override
		protected String doInBackground(String... params) {
			Log.i("AsyncTask", "-->doInBackground");
			try {
				for (int i = 0; i <= 100; i++) {
					// ����publishProgress��������,���onProgressUpdate��������ִ��
					publishProgress(i);
					Thread.sleep(50);	
				}
				return "Execute is Ok!";

			} catch (Exception e) {
				return "Execute is Error!";
			}
		}

		// onPostExecute����������ִ�����̨��������UI,��ʾ���
		@Override
		protected void onPostExecute(String result) {
			Log.i("AsyncTask", "-->onPostExecute");
			tv_AsyncTask_Progress.setText(result);
			btn_AsyncTask_Execute.setEnabled(true);
			btn_AsyncTask_Cancel.setEnabled(false);
		}

		// onProgressUpdate���ڸ�����������Ϣ
		@Override
		protected void onProgressUpdate(Integer... values) {
			Log.i("AsyncTask", "-->onProgressUpdate"+values[0]+"%");
			pb_AsyncTask_ProgressBar.setProgress(values[0]);
			tv_AsyncTask_Progress.setText("Loading����" + values[0] + "%");

		}

		// onCancelled����������ȡ��ִ���е�����ʱ����UI
		@Override
		protected void onCancelled() {
			Log.i("AsyncTask", "-->onCancelled");
			tv_AsyncTask_Progress.setText("Canceled!");
			pb_AsyncTask_ProgressBar.setProgress(0);

			btn_AsyncTask_Execute.setEnabled(true);
			btn_AsyncTask_Cancel.setEnabled(false);
		}

	}
}
