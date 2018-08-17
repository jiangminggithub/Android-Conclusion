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
				// 1.(context)上下文对象 2.(text)显示的文字 3.(duration)显示的时间
				Toast.makeText(activity_UI_Toast_Demo.this, "通过makeText()方法创建消息提示框！", Toast.LENGTH_SHORT).show();
			}
		});

		btn_ui_ToastDemo_demo2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// 创建带图片和文字的消息提示框（Toast）
				Toast toast = new Toast(activity_UI_Toast_Demo.this);
				toast.setDuration(Toast.LENGTH_LONG);// 设置持续时间
				toast.setGravity(Gravity.CENTER, 0, 200);// 设置对齐方式

				// //动态添加布局视图
				// LinearLayout ll=new
				// LinearLayout(activity_UI_Toast_Demo.this);
				// ll.setOrientation(LinearLayout.HORIZONTAL);
				// // 添加图片
				// ImageView iv = new ImageView(activity_UI_Toast_Demo.this);
				// iv.setImageResource(R.drawable.containers_tabhostdemo_imgitem1);
				// iv.setPadding(0, 0, 5, 0);
				// ll.addView(iv);
				//
				// // 添加文本
				// TextView tv = new TextView(activity_UI_Toast_Demo.this);
				// tv.setText("我是通过构造方法创建的消息提示框！");
				// tv.setTextSize(20);
				// tv.setTextColor(Color.GREEN);
				// ll.addView(tv);
				// //在layout文件中添加布局视图

				View ll = LayoutInflater.from(activity_UI_Toast_Demo.this).inflate(R.layout.ui_toast_layoutdemo, null);
				toast.setView(ll);// 设置现实的视图
				toast.show();// 显示消息框

			}
		});
	}
}
