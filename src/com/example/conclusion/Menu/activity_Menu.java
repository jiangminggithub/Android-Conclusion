package com.example.conclusion.Menu;

import java.lang.reflect.Method;
import java.util.ArrayList;
import com.example.conclusion.R;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.Toast;

public class activity_Menu extends Activity {
	LinearLayout linear_MenuDemo;
	ListView lv_menuDemo;
	ImageView iv_popMenu_demo;
	private ArrayList<String> list;
	private ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		linear_MenuDemo = (LinearLayout) findViewById(R.id.linear_MenuDemo);
		lv_menuDemo = (ListView) findViewById(R.id.lv_menuDemo);
		iv_popMenu_demo = (ImageView) findViewById(R.id.iv_popMenu_demo);

		list = new ArrayList<String>();
		for (int i = 1; i < 11; i++) {
			list.add("选项" + i);
		}
		
		adapter = new ArrayAdapter<String>(activity_Menu.this, android.R.layout.simple_list_item_1, list);
		lv_menuDemo.setAdapter(adapter);
		registerForContextMenu(lv_menuDemo);

		iv_popMenu_demo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//弹出菜单
				PopupMenuDemo();
			}
		});
	}

	// 创建选项菜单
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		/*
		//低版本的创建  
		*//**
		* menu.add(groupId, itemId, order, title);
		* groupId  分组ID
		* itemId   菜单项的Id
		* order    排序
		* title    菜单显示的文字
		*//*
		menu.add(1, 1, 1,"菜单1").setIcon(R.drawable.ic_launcher);
		menu.add(1, 2, 2,"菜单2").setIcon(R.drawable.ic_launcher);
		menu.add(2, 3, 3, "菜单3").setIcon(R.drawable.ic_launcher);
		menu.add(2, 4, 4, "菜单3").setIcon(R.drawable.ic_launcher);
		*/
		
		// 菜单填充器
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.option_menu_demo, menu);
		
		// 显示图标，4.0以上版本默认不显示图标，需要定义
		setIconEnable(menu, true);

		// 带有子菜单的一级菜单
		SubMenu subMenu = menu.addSubMenu(menu.NONE, 1, 5, "子菜单").setIcon(R.drawable.option_ic6);
		subMenu.add(menu.NONE, 10001, 1, "sub 1-1");
		subMenu.add(menu.NONE, 10002, 2, "sub 1-2");
		subMenu.add(menu.NONE, 10003, 3, "sub 1-3");
		
		super.onCreateOptionsMenu(menu);
		return true;
	}

	// 创建选项菜单监视器
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.optionMenu_item1:
			linear_MenuDemo.setBackgroundColor(Color.RED);
			Toast.makeText(activity_Menu.this, "你选择了红色背景！", Toast.LENGTH_SHORT).show();
			break;
		case R.id.optionMenu_item2:
			linear_MenuDemo.setBackgroundColor(Color.GREEN);
			Toast.makeText(activity_Menu.this, "你选择了绿色背景！", Toast.LENGTH_SHORT).show();
			break;
		case R.id.optionMenu_item3:
			linear_MenuDemo.setBackgroundColor(Color.YELLOW);
			Toast.makeText(activity_Menu.this, "你选择了黄色背景！", Toast.LENGTH_SHORT).show();
			break;
		case R.id.optionMenu_item4:
			linear_MenuDemo.setBackgroundColor(Color.BLUE);
			Toast.makeText(activity_Menu.this, "你选择了蓝色背景！", Toast.LENGTH_SHORT).show();
			break;
		case R.id.optionMenu_item5:
			Toast.makeText(activity_Menu.this, "你选择了取消！", Toast.LENGTH_SHORT).show();
			break;
		case 10001:
			Toast.makeText(activity_Menu.this, "你选择了:"+item.getTitle().toString(), Toast.LENGTH_SHORT).show();
			break;
		case 10002:
			Toast.makeText(activity_Menu.this, "你选择了:"+item.getTitle().toString(), Toast.LENGTH_SHORT).show();
			break;
		case 10003:
			Toast.makeText(activity_Menu.this, "你选择了:"+item.getTitle().toString(), Toast.LENGTH_SHORT).show();
			break;
			
		}
		return super.onOptionsItemSelected(item);
		// return true;
	}

	// 创建上下文菜单
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		
		super.onCreateContextMenu(menu, v, menuInfo);

		// getMenuInflater().inflate(R.menu.context_menu_demo, menu);

		// 菜单填充器
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.context_menu_demo, menu);
	}

	// 上下文菜单的监听器
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
		switch (item.getItemId()) {
		case R.id.ContentMenu_item1:
			info.targetView.setBackgroundColor(Color.RED);
			break;
		case R.id.ContentMenu_item2:
			info.targetView.setBackgroundColor(Color.GREEN);
			break;
		case R.id.ContentMenu_item3:
			info.targetView.setBackgroundColor(Color.BLUE);
			break;
		case R.id.ContentMenu_item4:
			list.remove(info.position);// 移除此项
			adapter.notifyDataSetChanged();// 刷新适配器
			Toast.makeText(activity_Menu.this, "已移除此项！", Toast.LENGTH_SHORT).show();
			break;
		case R.id.ContentMenu_item5:
			break;
		}
		return super.onContextItemSelected(item);
	}

	// 弹出菜单示例
	private void PopupMenuDemo() {
		// 得到popup对象
		android.widget.PopupMenu popupMenu = new android.widget.PopupMenu(activity_Menu.this, iv_popMenu_demo);
		// 加载菜单
		getMenuInflater().inflate(R.menu.popup_menu_demo, popupMenu.getMenu());
		// 为 popup设置监听器
		popupMenu.setOnMenuItemClickListener(new OnMenuItemClickListener() {

			@Override
			public boolean onMenuItemClick(MenuItem item) {
				Animation animation;
				switch (item.getItemId()) {
				case R.id.Popup_Menu_item1:
					animation = AnimationUtils.loadAnimation(activity_Menu.this, R.anim.animation_tween_alphademo);
					iv_popMenu_demo.startAnimation(animation);
					break;
				case R.id.Popup_Menu_item2:
					animation = AnimationUtils.loadAnimation(activity_Menu.this, R.anim.animation_tween_scaledemo);
					iv_popMenu_demo.startAnimation(animation);
					break;
				case R.id.Popup_Menu_item3:
					animation = AnimationUtils.loadAnimation(activity_Menu.this, R.anim.animation_tween_translatedemo);
					iv_popMenu_demo.startAnimation(animation);
					break;
				case R.id.Popup_Menu_item4:
					animation = AnimationUtils.loadAnimation(activity_Menu.this, R.anim.animation_tween_rotatedemo);
					iv_popMenu_demo.startAnimation(animation);
					break;
				case R.id.Popup_Menu_item5:
					animation = AnimationUtils.loadAnimation(activity_Menu.this, R.anim.animation_tween_totaldemo);
					iv_popMenu_demo.startAnimation(animation);
					break;
				}
				return true;
			}
		});

		// 显示
		popupMenu.show();
	}
	
	
	// 在Android4.0系统中，创建菜单Menu，通过setIcon方法给菜单添加图标是无效的，图标没有显出来，
	//2.3系统中是可以显示出来的。这个问题的根本原因在于4.0系统中，涉及到菜单的源码类
	// MenuBuilder做了改变，该类的部分源码如下
	private void setIconEnable(Menu menu, boolean enable) {
		try {
			Class<?> clazz = Class.forName("com.android.internal.view.menu.MenuBuilder");
			Method m = clazz.getDeclaredMethod("setOptionalIconsVisible", boolean.class);
			m.setAccessible(true);

			// MenuBuilder实现Menu接口，创建菜单时，传进来的menu其实就是MenuBuilder对象(java的多态特征)
			m.invoke(menu, enable);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
