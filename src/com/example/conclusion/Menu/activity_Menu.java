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
			list.add("ѡ��" + i);
		}
		
		adapter = new ArrayAdapter<String>(activity_Menu.this, android.R.layout.simple_list_item_1, list);
		lv_menuDemo.setAdapter(adapter);
		registerForContextMenu(lv_menuDemo);

		iv_popMenu_demo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//�����˵�
				PopupMenuDemo();
			}
		});
	}

	// ����ѡ��˵�
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		/*
		//�Ͱ汾�Ĵ���  
		*//**
		* menu.add(groupId, itemId, order, title);
		* groupId  ����ID
		* itemId   �˵����Id
		* order    ����
		* title    �˵���ʾ������
		*//*
		menu.add(1, 1, 1,"�˵�1").setIcon(R.drawable.ic_launcher);
		menu.add(1, 2, 2,"�˵�2").setIcon(R.drawable.ic_launcher);
		menu.add(2, 3, 3, "�˵�3").setIcon(R.drawable.ic_launcher);
		menu.add(2, 4, 4, "�˵�3").setIcon(R.drawable.ic_launcher);
		*/
		
		// �˵������
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.option_menu_demo, menu);
		
		// ��ʾͼ�꣬4.0���ϰ汾Ĭ�ϲ���ʾͼ�꣬��Ҫ����
		setIconEnable(menu, true);

		// �����Ӳ˵���һ���˵�
		SubMenu subMenu = menu.addSubMenu(menu.NONE, 1, 5, "�Ӳ˵�").setIcon(R.drawable.option_ic6);
		subMenu.add(menu.NONE, 10001, 1, "sub 1-1");
		subMenu.add(menu.NONE, 10002, 2, "sub 1-2");
		subMenu.add(menu.NONE, 10003, 3, "sub 1-3");
		
		super.onCreateOptionsMenu(menu);
		return true;
	}

	// ����ѡ��˵�������
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.optionMenu_item1:
			linear_MenuDemo.setBackgroundColor(Color.RED);
			Toast.makeText(activity_Menu.this, "��ѡ���˺�ɫ������", Toast.LENGTH_SHORT).show();
			break;
		case R.id.optionMenu_item2:
			linear_MenuDemo.setBackgroundColor(Color.GREEN);
			Toast.makeText(activity_Menu.this, "��ѡ������ɫ������", Toast.LENGTH_SHORT).show();
			break;
		case R.id.optionMenu_item3:
			linear_MenuDemo.setBackgroundColor(Color.YELLOW);
			Toast.makeText(activity_Menu.this, "��ѡ���˻�ɫ������", Toast.LENGTH_SHORT).show();
			break;
		case R.id.optionMenu_item4:
			linear_MenuDemo.setBackgroundColor(Color.BLUE);
			Toast.makeText(activity_Menu.this, "��ѡ������ɫ������", Toast.LENGTH_SHORT).show();
			break;
		case R.id.optionMenu_item5:
			Toast.makeText(activity_Menu.this, "��ѡ����ȡ����", Toast.LENGTH_SHORT).show();
			break;
		case 10001:
			Toast.makeText(activity_Menu.this, "��ѡ����:"+item.getTitle().toString(), Toast.LENGTH_SHORT).show();
			break;
		case 10002:
			Toast.makeText(activity_Menu.this, "��ѡ����:"+item.getTitle().toString(), Toast.LENGTH_SHORT).show();
			break;
		case 10003:
			Toast.makeText(activity_Menu.this, "��ѡ����:"+item.getTitle().toString(), Toast.LENGTH_SHORT).show();
			break;
			
		}
		return super.onOptionsItemSelected(item);
		// return true;
	}

	// ���������Ĳ˵�
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		
		super.onCreateContextMenu(menu, v, menuInfo);

		// getMenuInflater().inflate(R.menu.context_menu_demo, menu);

		// �˵������
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.context_menu_demo, menu);
	}

	// �����Ĳ˵��ļ�����
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
			list.remove(info.position);// �Ƴ�����
			adapter.notifyDataSetChanged();// ˢ��������
			Toast.makeText(activity_Menu.this, "���Ƴ����", Toast.LENGTH_SHORT).show();
			break;
		case R.id.ContentMenu_item5:
			break;
		}
		return super.onContextItemSelected(item);
	}

	// �����˵�ʾ��
	private void PopupMenuDemo() {
		// �õ�popup����
		android.widget.PopupMenu popupMenu = new android.widget.PopupMenu(activity_Menu.this, iv_popMenu_demo);
		// ���ز˵�
		getMenuInflater().inflate(R.menu.popup_menu_demo, popupMenu.getMenu());
		// Ϊ popup���ü�����
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

		// ��ʾ
		popupMenu.show();
	}
	
	
	// ��Android4.0ϵͳ�У������˵�Menu��ͨ��setIcon�������˵����ͼ������Ч�ģ�ͼ��û���Գ�����
	//2.3ϵͳ���ǿ�����ʾ�����ġ��������ĸ���ԭ������4.0ϵͳ�У��漰���˵���Դ����
	// MenuBuilder���˸ı䣬����Ĳ���Դ������
	private void setIconEnable(Menu menu, boolean enable) {
		try {
			Class<?> clazz = Class.forName("com.android.internal.view.menu.MenuBuilder");
			Method m = clazz.getDeclaredMethod("setOptionalIconsVisible", boolean.class);
			m.setAccessible(true);

			// MenuBuilderʵ��Menu�ӿڣ������˵�ʱ����������menu��ʵ����MenuBuilder����(java�Ķ�̬����)
			m.invoke(menu, enable);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
