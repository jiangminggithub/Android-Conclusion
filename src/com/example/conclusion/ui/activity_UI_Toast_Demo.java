package com.example.conclusion.ui;

import com.example.conclusion.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class activity_UI_Toast_Demo extends Activity {

	Button btn_ui_ToastDemo_demo1, btn_ui_ToastDemo_demo2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ui_toast_demo);

		btn_ui_ToastDemo_demo1 = (Button) findViewById(R.id.btn_ui_ToastDemo_demo1);
		btn_ui_ToastDemo_demo2 = (Button) findViewById(R.id.btn_ui_ToastDemo_demo2);

		btn_ui_ToastDemo_demo1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 1.(context)�����Ķ��� 2.(text)��ʾ������ 3.(duration)��ʾ��ʱ��
				Toast.makeText(activity_UI_Toast_Demo.this, "ͨ��makeText()����������Ϣ��ʾ��", Toast.LENGTH_SHORT).show();
			}
		});

		btn_ui_ToastDemo_demo2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// ������ͼƬ�����ֵ���Ϣ��ʾ��Toast��
				Toast toast = new Toast(activity_UI_Toast_Demo.this);
				toast.setDuration(Toast.LENGTH_LONG);// ���ó���ʱ��
				toast.setGravity(Gravity.CENTER, 0, 200);// ���ö��뷽ʽ

				// //��̬��Ӳ�����ͼ
				// LinearLayout ll=new
				// LinearLayout(activity_UI_Toast_Demo.this);
				// ll.setOrientation(LinearLayout.HORIZONTAL);
				// // ���ͼƬ
				// ImageView iv = new ImageView(activity_UI_Toast_Demo.this);
				// iv.setImageResource(R.drawable.containers_tabhostdemo_imgitem1);
				// iv.setPadding(0, 0, 5, 0);
				// ll.addView(iv);
				//
				// // ����ı�
				// TextView tv = new TextView(activity_UI_Toast_Demo.this);
				// tv.setText("����ͨ�����췽����������Ϣ��ʾ��");
				// tv.setTextSize(20);
				// tv.setTextColor(Color.GREEN);
				// ll.addView(tv);
				// //��layout�ļ�����Ӳ�����ͼ

				View ll = LayoutInflater.from(activity_UI_Toast_Demo.this).inflate(R.layout.ui_toast_layoutdemo, null);
				toast.setView(ll);// ������ʵ����ͼ
				toast.show();// ��ʾ��Ϣ��

			}
		});
	}
}
