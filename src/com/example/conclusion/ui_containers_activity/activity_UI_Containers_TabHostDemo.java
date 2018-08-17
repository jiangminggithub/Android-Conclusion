package com.example.conclusion.ui_containers_activity;

import com.example.conclusion.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;

public class activity_UI_Containers_TabHostDemo extends Activity {

	TabHost tabhost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ui_containers_tabhost_demo);
		tabhost = (TabHost) findViewById(R.id.th_containers_demo);

		tabhost.setup();

		TabSpec tab1 = tabhost.newTabSpec("tab1");
		tab1.setIndicator(null,getResources().getDrawable(R.drawable.containers_tabhostdemo_imgitem1));
		tab1.setContent(R.id.linl_containers_tab1);
		tabhost.addTab(tab1);

		TabSpec tab2 = tabhost.newTabSpec("tab2");
		tab2.setIndicator(null,getResources().getDrawable(R.drawable.containers_tabhostdemo_imgitem2));
		tab2.setContent(R.id.linl_containers_tab2);
		tabhost.addTab(tab2);

		TabSpec tab3 = tabhost.newTabSpec("tab3");
		tab3.setIndicator(null,getResources().getDrawable(R.drawable.containers_tabhostdemo_imgitem3));
		tab3.setContent(R.id.linl_containers_tab3);
		tabhost.addTab(tab3);

		tabhost.setCurrentTab(0);

		//标签选择变换的监听器
		tabhost.setOnTabChangedListener(new OnTabChangeListener() {

			@Override
			public void onTabChanged(String tabId) {
				
				if (tabId.equals("tab1"))
					Toast.makeText(activity_UI_Containers_TabHostDemo.this, "你选择了第一个标签！", Toast.LENGTH_SHORT).show();
				if (tabId.equals("tab2"))
					Toast.makeText(activity_UI_Containers_TabHostDemo.this, "你选择了第二个标签！", Toast.LENGTH_SHORT).show();
				if (tabId.equals("tab3"))
					Toast.makeText(activity_UI_Containers_TabHostDemo.this, "你选择了第三个标签！", Toast.LENGTH_SHORT).show();

			}
		});

	}
}
