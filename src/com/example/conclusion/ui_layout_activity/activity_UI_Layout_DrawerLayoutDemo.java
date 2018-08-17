package com.example.conclusion.ui_layout_activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.conclusion.R;
import com.example.conclusion.Fragment.fragment_DrawerLayoutDemo_right;

public class activity_UI_Layout_DrawerLayoutDemo extends Activity {
	ListView lv_leftMenu, lv_rightMenu;
	DrawerLayout drawerLayout;
	FrameLayout right_menu;
	FragmentManager manager;
	FragmentTransaction transaction;
	ArrayAdapter<CharSequence> adapter;// 左侧菜单内容适配器

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_ui_layout_drawerlayout_demo);

		lv_leftMenu = (ListView) findViewById(R.id.lv_DrawerLayoutDemo_left);
		// lv_rightMenu = (ListView)findViewById(R.id.lv_DrawerLayoutDemo_Right);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		right_menu = (FrameLayout) findViewById(R.id.right_menu);

		// 使用国际化接口 字符数组来 给ArrayAdapter赋值
		adapter = ArrayAdapter.createFromResource(this,
				R.array.ui_layout_drawerlayoutitems,
				android.R.layout.simple_list_item_1);
		lv_leftMenu.setAdapter(adapter);

		// fragment 事务处理
		manager = getFragmentManager();
		transaction = manager.beginTransaction();
		fragment_DrawerLayoutDemo_right fragment_right = new fragment_DrawerLayoutDemo_right();
		transaction.replace(R.id.right_menu, fragment_right);
		transaction.commit();

		// drawerlayout 监听事件
		drawerLayout.setDrawerListener(new DrawerListener() {

			@Override
			public void onDrawerSlide(View drawerView, float slideOffset) {
				// 抽屉滑动式回调的方法
				Log.i("tag", "---onDrawerSlide---" + slideOffset);
			}

			@Override
			public void onDrawerOpened(View drawerView) {
				// 抽屉打开时会回调的方法
				Log.i("tag", "---onDrawerOpened---");

				Toast.makeText(activity_UI_Layout_DrawerLayoutDemo.this,
						"你打开了菜单", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onDrawerClosed(View drawerView) {
				Log.i("tag", "---onDrawerClosed---");
				Toast.makeText(activity_UI_Layout_DrawerLayoutDemo.this,
						"你关闭了菜单", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onDrawerStateChanged(int newState) {
				// 抽屉的状态改变时会回调的方法
				Log.i("tag", "---onDrawerStateChanged---");
			}
		});

		// 左侧菜单监听事件
		lv_leftMenu.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String item = adapter.getItem(position).toString();
				Toast.makeText(activity_UI_Layout_DrawerLayoutDemo.this,
						"你选择了：" + item, Toast.LENGTH_SHORT).show();
			}

		});
	}

	// 左侧菜单按钮事件
	public void showLeftMenu(View view) {
		if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
			drawerLayout.closeDrawer(Gravity.RIGHT);
		}
		if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
			drawerLayout.closeDrawer(Gravity.LEFT);
		} else
			drawerLayout.openDrawer(lv_leftMenu);

	}

	// 右侧菜单按钮事件
	public void showRightMenu(View view) {
		if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
			drawerLayout.closeDrawer(Gravity.LEFT);
		}
		if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
			drawerLayout.closeDrawer(Gravity.RIGHT);
		} else
			drawerLayout.openDrawer(right_menu);
	}

}
