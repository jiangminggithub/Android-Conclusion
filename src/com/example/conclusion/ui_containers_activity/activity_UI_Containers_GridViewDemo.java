package com.example.conclusion.ui_containers_activity;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.conclusion.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleAdapter;

public class activity_UI_Containers_GridViewDemo extends Activity {
	GridView gv_num;
	ArrayList<HashMap<String, Object>> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ui_containers_gridview_demo);
		gv_num = (GridView) findViewById(R.id.gv_containers_GriviewDemo_num1);

		list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("imageItem", R.drawable.containers_gridview_imgdemo1);
		hashmap.put("imageText", "Í¼Æ¬ËØ²Ä:" + 1);
		list.add(hashmap);
		hashmap = new HashMap<String, Object>();
		hashmap.put("imageItem", R.drawable.containers_gridview_imgdemo2);
		hashmap.put("imageText", "Í¼Æ¬ËØ²Ä:" + 2);
		list.add(hashmap);
		hashmap = new HashMap<String, Object>();
		hashmap.put("imageItem", R.drawable.containers_gridview_imgdemo3);
		hashmap.put("imageText", "Í¼Æ¬ËØ²Ä:" + 3);
		list.add(hashmap);
		hashmap = new HashMap<String, Object>();
		hashmap.put("imageItem", R.drawable.containers_gridview_imgdemo4);
		hashmap.put("imageText", "Í¼Æ¬ËØ²Ä:" + 4);
		list.add(hashmap);
		hashmap = new HashMap<String, Object>();
		hashmap.put("imageItem", R.drawable.containers_gridview_imgdemo5);
		hashmap.put("imageText", "Í¼Æ¬ËØ²Ä:" + 5);
		list.add(hashmap);
		hashmap = new HashMap<String, Object>();
		hashmap.put("imageItem", R.drawable.containers_gridview_imgdemo6);
		hashmap.put("imageText", "Í¼Æ¬ËØ²Ä:" + 6);
		list.add(hashmap);
		hashmap = new HashMap<String, Object>();
		hashmap.put("imageItem", R.drawable.containers_gridview_imgdemo7);
		hashmap.put("imageText", "Í¼Æ¬ËØ²Ä:" + 7);
		list.add(hashmap);
		hashmap = new HashMap<String, Object>();
		hashmap.put("imageItem", R.drawable.containers_gridview_imgdemo8);
		hashmap.put("imageText", "Í¼Æ¬ËØ²Ä:" + 8);
		list.add(hashmap);
		hashmap = new HashMap<String, Object>();
		hashmap.put("imageItem", R.drawable.containers_gridview_imgdemo9);
		hashmap.put("imageText", "Í¼Æ¬ËØ²Ä:" + 9);
		list.add(hashmap);
		
		
		
		
		/*for (int i = 4; i < 13; i++) {
			hashmap = new HashMap<String, Object>();
			hashmap.put("imageItem", R.drawable.containers_listview_img);
			hashmap.put("imageText", "Í¼Æ¬ËØ²Ä:" + i);
			list.add(hashmap);
		}*/

		String[] from = { "imageItem", "imageText" };
		int[] to = { R.id.iv_containers_gridview_img,
				R.id.iv_containers_gridview_imgname };
		SimpleAdapter adapter = new SimpleAdapter(
				activity_UI_Containers_GridViewDemo.this, list,
				R.layout.containers_gridview_items_layout, from, to);
		gv_num.setAdapter(adapter);

	}

}
