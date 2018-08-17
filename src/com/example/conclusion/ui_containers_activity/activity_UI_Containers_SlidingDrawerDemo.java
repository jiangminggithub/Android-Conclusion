package com.example.conclusion.ui_containers_activity;

import com.example.conclusion.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerCloseListener;
import android.widget.SlidingDrawer.OnDrawerOpenListener;
import android.widget.SlidingDrawer.OnDrawerScrollListener;
import android.widget.TextView;
import android.widget.Toast;

public class activity_UI_Containers_SlidingDrawerDemo extends Activity {

	SlidingDrawer slidingdrawer;
	TextView tvContent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ui_containers_slidingdrawer_demo);
		slidingdrawer = (SlidingDrawer) findViewById(R.id.sd_containers_SlidingDrawerdemo);
		tvContent = (TextView) findViewById(R.id.tv_containers_SlidingDrawerDemo);

		//滚动条监听器
		slidingdrawer.setOnDrawerScrollListener(new OnDrawerScrollListener() {

			@Override
			public void onScrollStarted() {
				// TODO Auto-generated method stub
				tvContent.setText("-->开始拖动");
			}

			@Override
			public void onScrollEnded() {
				// TODO Auto-generated method stub
				tvContent.setText("-->结束拖动");
			}
		});

		//抽屉打开监听器
		slidingdrawer.setOnDrawerOpenListener(new OnDrawerOpenListener() {

			@Override
			public void onDrawerOpened() {
				// TODO Auto-generated method stub
				Toast.makeText(activity_UI_Containers_SlidingDrawerDemo.this, "你打开了SlidingDrawer！", Toast.LENGTH_SHORT)
						.show();
			}
		});

		//抽屉关闭监听器
		slidingdrawer.setOnDrawerCloseListener(new OnDrawerCloseListener() {

			@Override
			public void onDrawerClosed() {
				// TODO Auto-generated method stub
				Toast.makeText(activity_UI_Containers_SlidingDrawerDemo.this, "你关闭了SlidingDrawer！", Toast.LENGTH_SHORT)
						.show();
			}
		});
	}
}
