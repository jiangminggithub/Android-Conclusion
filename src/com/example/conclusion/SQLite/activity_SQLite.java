package com.example.conclusion.SQLite;

import com.example.conclusion.R;
import com.example.conclusion.ui.activity_UI_AlertDialogDemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class activity_SQLite extends Activity implements OnClickListener {

	private TextView tv_SQlite_id, tv_SQlite_name, tv_SQlite_age;
	private Button btn_SQLite_add, btn_SQLite_query, btn_SQLite_update, btn_SQLite_delete;
	DBManager DBManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sqlite_demo);

		tv_SQlite_id = (TextView) findViewById(R.id.tv_SQlite_id);
		tv_SQlite_name = (TextView) findViewById(R.id.tv_SQlite_name);
		tv_SQlite_age = (TextView) findViewById(R.id.tv_SQlite_age);

		btn_SQLite_add = (Button) findViewById(R.id.btn_SQLite_add);
		btn_SQLite_query = (Button) findViewById(R.id.btn_SQLite_query);
		btn_SQLite_update = (Button) findViewById(R.id.btn_SQLite_update);
		btn_SQLite_delete = (Button) findViewById(R.id.btn_SQLite_delete);
		DBManager = new DBManager(this);

		btn_SQLite_add.setOnClickListener(this);
		btn_SQLite_query.setOnClickListener(this);
		btn_SQLite_update.setOnClickListener(this);
		btn_SQLite_delete.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_SQLite_add:
			addDemo();
			break;
		case R.id.btn_SQLite_query:
			queryDemo();
			break;
		case R.id.btn_SQLite_update:
			updateDemo();
			break;
		case R.id.btn_SQLite_delete:
			daleteDemo();
			break;
		}

	}

	// 增加数据
	public void addDemo() {
		// 对话框生成器
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("请填写信息：");

		// 加载自定义布局
		View view = getLayoutInflater().inflate(R.layout.sqlite_person_add, null);
		builder.setView(view);

		// 添加确定按钮
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				AlertDialog dialog1 = (AlertDialog) dialog;

				// 获取布局中的控件
				EditText Etid = (EditText) dialog1.findViewById(R.id.et_SQLite_addid);
				EditText Etname = (EditText) dialog1.findViewById(R.id.et_SQLite_addname);
				EditText Etage = (EditText) dialog1.findViewById(R.id.et_SQLite_addage);

				int id = Integer.parseInt(Etid.getText().toString());
				String name = Etname.getText().toString();
				int age = Integer.parseInt(Etage.getText().toString());

				// 判断数据合法性
				if (!"".equals(id) && !"".equals(name) && !"".equals(age)) {
					// 添加数据
					DBManager.add(id, name, age);
				} else
					Toast.makeText(activity_SQLite.this, "内容不能为空！", Toast.LENGTH_SHORT).show();
			}
		});

		// 取消按钮
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});
		// 设置点击返回键及屏幕其他区域不消失
		builder.setCancelable(false);
		// 建立对话框
		builder.create().show();

	}

	// 查询数据
	public void queryDemo() {
		// 对话框生成器
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("请输入查询编号：");

		// 加载自定义布局
		View view = getLayoutInflater().inflate(R.layout.sqlite_person_query, null);
		builder.setView(view);
		// 添加确定按钮
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				AlertDialog dialog1 = (AlertDialog) dialog;

				EditText Etid = (EditText) dialog1.findViewById(R.id.et_SQlite_queryID);

				String id = Etid.getText().toString();

				if (!"".equals(id)) {
					Person person = new Person();
					// 查询数据
					person = DBManager.Query(id);
					if (person != null) {
						tv_SQlite_id.setText("人员编号：" + person.getId());
						tv_SQlite_name.setText("人员姓名：" + person.getName());
						tv_SQlite_age.setText("人员性别：" + person.getAge());
						Toast.makeText(activity_SQLite.this, "查询成功！", Toast.LENGTH_SHORT).show();
					} else {
						tv_SQlite_id.setText("");
						tv_SQlite_name.setText("");
						tv_SQlite_age.setText("");
						Toast.makeText(activity_SQLite.this, "未查询到数据！", Toast.LENGTH_SHORT).show();
					}
				} else
					Toast.makeText(activity_SQLite.this, "内容不能为空！", Toast.LENGTH_SHORT).show();
			}
		});

		// 取消按钮
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});

		// 设置点击返回键及屏幕其他区域不消失
		builder.setCancelable(false);
		// 建立对话框
		builder.create().show();
	}

	// 更新操作
	private void updateDemo() {
		// 对话框生成器
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("请输入信息：");

		// 加载自定义布局
		View view = getLayoutInflater().inflate(R.layout.sqlite_person_update, null);
		builder.setView(view);
		// 添加确定按钮
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				AlertDialog dialog1 = (AlertDialog) dialog;

				EditText EtOldName = (EditText) dialog1.findViewById(R.id.et_SQLite_update_OldName);
				EditText EtName = (EditText) dialog1.findViewById(R.id.et_SQLite_update_Name);

				String oldName = EtOldName.getText().toString();
				String Name = EtName.getText().toString();

				if (!"".equals(oldName) && !"".equals(Name)) {
					// 更新数据
					DBManager.updata(Name, oldName);
				} else
					Toast.makeText(activity_SQLite.this, "内容不能为空！", Toast.LENGTH_SHORT).show();
			}
		});

		// 取消按钮
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});

		// 设置点击返回键及屏幕其他区域不消失
		builder.setCancelable(false);
		// 建立对话框
		builder.create().show();
	}

	// 删除操作
	private void daleteDemo() {
		// 对话框生成器
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("请输入:");

		// 加载自定义布局
		View view = getLayoutInflater().inflate(R.layout.sqlite_person_query, null);
		builder.setView(view);
		// 添加确定按钮
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				AlertDialog dialog1 = (AlertDialog) dialog;

				EditText Etid = (EditText) dialog1.findViewById(R.id.et_SQlite_queryID);

				String id = Etid.getText().toString();

				if (!"".equals(id)) {
					// 删除数据
					DBManager.delete(id);
				} else
					Toast.makeText(activity_SQLite.this, "内容不能为空！", Toast.LENGTH_SHORT).show();
			}
		});

		// 取消按钮
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});

		// 设置点击返回键及屏幕其他区域不消失
		builder.setCancelable(false);
		// 建立对话框
		builder.create().show();
	}

}
