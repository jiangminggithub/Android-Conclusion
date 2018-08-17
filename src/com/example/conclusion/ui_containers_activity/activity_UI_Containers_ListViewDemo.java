package com.example.conclusion.ui_containers_activity;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.conclusion.R;

public class activity_UI_Containers_ListViewDemo extends Activity {
	ListView lv_num1, lv_num2;
	ArrayAdapter<CharSequence> adapter1;
	SimpleAdapter adapter2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ui_containers_listview_demo);
		lv_num1 = (ListView) findViewById(R.id.lv_containers_ListView1);
		lv_num2 = (ListView) findViewById(R.id.lv_containers_ListView2);

		initListview1();
		initListview2();

	}

	private void initListview1() {
		adapter1 = ArrayAdapter.createFromResource(
				activity_UI_Containers_ListViewDemo.this,
				R.array.ui_layout_drawerlayoutitems,
				android.R.layout.simple_expandable_list_item_1);

		lv_num1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String strSelect = adapter1.getItem(position).toString();
				Toast.makeText(activity_UI_Containers_ListViewDemo.this,
						"你选择了:" + strSelect, Toast.LENGTH_SHORT).show();
			}
		});
	}

	//自定义ListView 
	private void initListview2() {
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("name", "张三");
		hash.put("phone", "18898456332");
		list.add(hash);

		hash = new HashMap<String, Object>();
		hash.put("name", "李四");
		hash.put("phone", "15866889988");
		list.add(hash);

		hash = new HashMap<String, Object>();
		hash.put("name", "王五");
		hash.put("phone", "18898452222");
		list.add(hash);

		String tail = null;
		for (int i = 1; i < 21; i++) {

			if (i < 10) {
				tail = "0" + i;
			}
			else
				tail=i+"";
			hash = new HashMap<String, Object>();
			hash.put("name", "未知");
			hash.put("phone", "152666600" + tail);
			list.add(hash);
		}

		String from[] = { "name", "phone" };
		int[] to = { R.id.tv_containers_listview_name,
				R.id.tv_containers_listview_phonenumber };

		adapter2 = new SimpleAdapter(activity_UI_Containers_ListViewDemo.this,
				list, R.layout.containers_listview_custom_layout, from, to);

		lv_num2.setAdapter(adapter2);

	}

	public void CallPhone(View view) {
		// 得到触发事件的对象本身
		ImageView btnCallPhone = (ImageView) view;
		// 得到父级对象
		RelativeLayout rl = (RelativeLayout) btnCallPhone.getParent();

		// 由父级容器来查找到容器中的某个控件
		TextView tvPhoneNumber = (TextView) rl
				.findViewById(R.id.tv_containers_listview_phonenumber);

		// 得到电话号码
		String phoneNumber = tvPhoneNumber.getText().toString();

		// 真正的打电话
		Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"
				+ phoneNumber));
		startActivity(intent);

		Toast.makeText(activity_UI_Containers_ListViewDemo.this, phoneNumber,
				Toast.LENGTH_SHORT).show();
	}
}
