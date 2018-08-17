package com.example.conclusion.ui_layout_activity;

import com.example.conclusion.R;
import com.example.conclusion.Fragment.fragment_SlidingPaneLayout_left;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.widget.SlidingPaneLayout;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class activity_UI_Layout_SlidingPaneLayoutDemo extends Activity {
	SlidingPaneLayout splDemo;
	ListView left_menu;
	LinearLayout showContent;
	FragmentManager manager;
	FragmentTransaction transaction;
	ArrayAdapter<CharSequence> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_ui_layout_slidingpanelayout_demo);
		splDemo = (SlidingPaneLayout) findViewById(R.id.spl_SlidingPaneLayoutDemo);
		left_menu = (ListView) findViewById(R.id.lv_SlidingPaneLayout_left);
		showContent = (LinearLayout) findViewById(R.id.linl_SlidingPaneLayoutDemo_Content);

		adapter = ArrayAdapter.createFromResource(this,
				R.array.ui_layout_sildingpanelayout_items,
				android.R.layout.simple_list_item_1);
		left_menu.setAdapter(adapter);

		manager = getFragmentManager();
		transaction = manager.beginTransaction();
		fragment_SlidingPaneLayout_left fragment = new fragment_SlidingPaneLayout_left();
		transaction.replace(R.id.linl_SlidingPaneLayoutDemo_Content, fragment);
		transaction.commit();

		left_menu.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String select = adapter.getItem(position).toString();
				Toast.makeText(activity_UI_Layout_SlidingPaneLayoutDemo.this,
						"ƒ„—°‘Ò¡À£∫" + select, Toast.LENGTH_SHORT).show();

			}
		});

		
	}
}
