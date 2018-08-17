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
	ArrayAdapter<CharSequence> adapter;// ���˵�����������

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_ui_layout_drawerlayout_demo);

		lv_leftMenu = (ListView) findViewById(R.id.lv_DrawerLayoutDemo_left);
		// lv_rightMenu = (ListView)findViewById(R.id.lv_DrawerLayoutDemo_Right);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		right_menu = (FrameLayout) findViewById(R.id.right_menu);

		// ʹ�ù��ʻ��ӿ� �ַ������� ��ArrayAdapter��ֵ
		adapter = ArrayAdapter.createFromResource(this,
				R.array.ui_layout_drawerlayoutitems,
				android.R.layout.simple_list_item_1);
		lv_leftMenu.setAdapter(adapter);

		// fragment ������
		manager = getFragmentManager();
		transaction = manager.beginTransaction();
		fragment_DrawerLayoutDemo_right fragment_right = new fragment_DrawerLayoutDemo_right();
		transaction.replace(R.id.right_menu, fragment_right);
		transaction.commit();

		// drawerlayout �����¼�
		drawerLayout.setDrawerListener(new DrawerListener() {

			@Override
			public void onDrawerSlide(View drawerView, float slideOffset) {
				// ���뻬��ʽ�ص��ķ���
				Log.i("tag", "---onDrawerSlide---" + slideOffset);
			}

			@Override
			public void onDrawerOpened(View drawerView) {
				// �����ʱ��ص��ķ���
				Log.i("tag", "---onDrawerOpened---");

				Toast.makeText(activity_UI_Layout_DrawerLayoutDemo.this,
						"����˲˵�", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onDrawerClosed(View drawerView) {
				Log.i("tag", "---onDrawerClosed---");
				Toast.makeText(activity_UI_Layout_DrawerLayoutDemo.this,
						"��ر��˲˵�", Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onDrawerStateChanged(int newState) {
				// �����״̬�ı�ʱ��ص��ķ���
				Log.i("tag", "---onDrawerStateChanged---");
			}
		});

		// ���˵������¼�
		lv_leftMenu.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String item = adapter.getItem(position).toString();
				Toast.makeText(activity_UI_Layout_DrawerLayoutDemo.this,
						"��ѡ���ˣ�" + item, Toast.LENGTH_SHORT).show();
			}

		});
	}

	// ���˵���ť�¼�
	public void showLeftMenu(View view) {
		if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
			drawerLayout.closeDrawer(Gravity.RIGHT);
		}
		if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
			drawerLayout.closeDrawer(Gravity.LEFT);
		} else
			drawerLayout.openDrawer(lv_leftMenu);

	}

	// �Ҳ�˵���ť�¼�
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
