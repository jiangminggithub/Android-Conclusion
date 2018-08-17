package com.example.conclusion.ui_containers_activity;

import com.example.conclusion.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class activity_UI_Containers extends Activity implements OnClickListener {
	Button btn_UI_Containers_RadioGroup, btn_UI_Containers_ListView,
			btn_UI_Containers_GridView, btn_UI_Containers_ExpandableListView,
			btn_UI_Containers_ScrollView, btn_UI_Containers_TabHost,
			btn_UI_Containers_SlidingDrawer, btn_UI_Containers_Gallery,
			btn_UI_Containers_VideoView, btn_UI_Containers_DialerFilter,
			btn_UI_Containers_RecyclerView, btn_UI_Containers_CardView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ui_containers);
		initView();
		
		
	}
	
	private void initView(){
		btn_UI_Containers_RadioGroup = (Button) findViewById(R.id.btn_UI_Containers_RadioGroup);
		btn_UI_Containers_ListView = (Button) findViewById(R.id.btn_UI_Containers_ListView);
		btn_UI_Containers_GridView = (Button) findViewById(R.id.btn_UI_Containers_GridView);
		btn_UI_Containers_ExpandableListView = (Button) findViewById(R.id.btn_UI_Containers_ExpandableListView);
		btn_UI_Containers_ScrollView = (Button) findViewById(R.id.btn_UI_Containers_ScrollView);
		btn_UI_Containers_TabHost = (Button) findViewById(R.id.btn_UI_Containers_TabHost);
		btn_UI_Containers_SlidingDrawer = (Button) findViewById(R.id.btn_UI_Containers_SlidingDrawer);
		btn_UI_Containers_Gallery = (Button) findViewById(R.id.btn_UI_Containers_Gallery);
		btn_UI_Containers_VideoView = (Button) findViewById(R.id.btn_UI_Containers_VideoView);
		btn_UI_Containers_DialerFilter = (Button) findViewById(R.id.btn_UI_Containers_DialerFilter);
		btn_UI_Containers_RecyclerView = (Button) findViewById(R.id.btn_UI_Containers_RecyclerView);
		btn_UI_Containers_CardView = (Button) findViewById(R.id.btn_UI_Containers_CardView);
		
		btn_UI_Containers_RadioGroup.setOnClickListener(this);
		btn_UI_Containers_ListView.setOnClickListener(this);
		btn_UI_Containers_GridView.setOnClickListener(this);
		btn_UI_Containers_ExpandableListView.setOnClickListener(this);
		btn_UI_Containers_ScrollView.setOnClickListener(this);
		btn_UI_Containers_TabHost.setOnClickListener(this);
		btn_UI_Containers_SlidingDrawer.setOnClickListener(this);
		btn_UI_Containers_Gallery.setOnClickListener(this);
		btn_UI_Containers_VideoView.setOnClickListener(this);
		btn_UI_Containers_DialerFilter.setOnClickListener(this);
		btn_UI_Containers_RecyclerView.setOnClickListener(this);
		btn_UI_Containers_CardView.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent;
		switch (v.getId()) {
		case R.id.btn_UI_Containers_RadioGroup:
			intent = new Intent(activity_UI_Containers.this,
					activity_UI_Containers_RadioGroupDemo.class);
			startActivity(intent);
			break;
		case R.id.btn_UI_Containers_ListView:
			intent = new Intent(activity_UI_Containers.this,
					activity_UI_Containers_ListViewDemo.class);
			startActivity(intent);
			break;
		case R.id.btn_UI_Containers_GridView:
			intent = new Intent(activity_UI_Containers.this,
					activity_UI_Containers_GridViewDemo.class);
			startActivity(intent);
			break;
			
		case R.id.btn_UI_Containers_ScrollView:
			intent = new Intent(activity_UI_Containers.this,
					activity_UI_Containers_ScrollViewDemo.class);
			startActivity(intent);
			break;
		case R.id.btn_UI_Containers_TabHost:
			intent = new Intent(activity_UI_Containers.this,
					activity_UI_Containers_TabHostDemo.class);
			startActivity(intent);
			break;
		case R.id.btn_UI_Containers_SlidingDrawer:
			intent = new Intent(activity_UI_Containers.this,
					activity_UI_Containers_SlidingDrawerDemo.class);
			startActivity(intent);
			break;
		case R.id.btn_UI_Containers_Gallery:
			intent = new Intent(activity_UI_Containers.this,
					activity_UI_Containers_GalleryDemo.class);
			startActivity(intent);
			break;
		case R.id.btn_UI_Containers_VideoView:
			intent = new Intent(activity_UI_Containers.this,
					activity_UI_Containers_VideoViewDemo.class);
			startActivity(intent);
			break;
		case R.id.btn_UI_Containers_ExpandableListView:
			intent = new Intent(activity_UI_Containers.this,
					activity_UI_Containers_ExpandableListViewDemo.class);
			startActivity(intent);
			break;
		default:
			break;
		}

	}
}
