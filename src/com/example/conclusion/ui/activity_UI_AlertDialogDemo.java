package com.example.conclusion.ui;

import com.example.conclusion.R;
import com.example.conclusion.R.id;
import com.example.conclusion.R.layout;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity_UI_AlertDialogDemo extends Activity implements OnClickListener {

	Button btn_dialogdemo1, btn_dialogdemo2, btn_dialogdemo3, btn_dialogdemo4, btn_dialogdemo5, btn_dialogdemo6,
			btn_dialogdemo7;

	// 单选框选项
	private final String[] Singleitems = { "男", "女", "保密" };
	// 复选框选项
	private final String[] MultiItems = { "篮球", "睡觉", "游戏", "K歌" };
	// 列表框选项
	private final String[] ListItems = { "android", "HTML", "JavaScript", "ASP.NET" };
	// 单选框初始选择项
	private int singleCheckedItem = 0;
	// 复选框初始选择项
	private boolean[] multiCheckedItems = { true, false, false, false };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ui_alertdialog_demo);

		btn_dialogdemo1 = (Button) findViewById(R.id.btn_UI_Dialogdemo1);
		btn_dialogdemo2 = (Button) findViewById(R.id.btn_UI_Dialogdemo2);
		btn_dialogdemo3 = (Button) findViewById(R.id.btn_UI_Dialogdemo3);
		btn_dialogdemo4 = (Button) findViewById(R.id.btn_UI_Dialogdemo4);
		btn_dialogdemo5 = (Button) findViewById(R.id.btn_UI_Dialogdemo5);
		btn_dialogdemo6 = (Button) findViewById(R.id.btn_UI_Dialogdemo6);
		btn_dialogdemo7 = (Button) findViewById(R.id.btn_UI_Dialogdemo7);

		btn_dialogdemo1.setOnClickListener(this);
		btn_dialogdemo2.setOnClickListener(this);
		btn_dialogdemo3.setOnClickListener(this);
		btn_dialogdemo4.setOnClickListener(this);
		btn_dialogdemo5.setOnClickListener(this);
		btn_dialogdemo6.setOnClickListener(this);
		btn_dialogdemo7.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_UI_Dialogdemo1:
			DialogMessageDemo();
			break;
		case R.id.btn_UI_Dialogdemo2:
			SingleDialogDemo();
			break;
		case R.id.btn_UI_Dialogdemo3:
			MuiltiDialogDemo();
			break;
		case R.id.btn_UI_Dialogdemo4:
			ListDialogDemo();
			break;
		case R.id.btn_UI_Dialogdemo5:
			ProgressSpinnerDialogDemo();
			break;
		case R.id.btn_UI_Dialogdemo6:
			ProgressHorizontalDialog();
			break;
		case R.id.btn_UI_Dialogdemo7:
			CustomDialog();
			break;
		}

	}

	// 默认消息框
	private void DialogMessageDemo() {
		AlertDialog.Builder builder = new AlertDialog.Builder(activity_UI_AlertDialogDemo.this);
		// 设置标题
		builder.setTitle("提示");
		// 设置提示信息
		builder.setMessage("你开心快乐吗？");

		// 确定按钮
		builder.setPositiveButton("是", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(activity_UI_AlertDialogDemo.this, "要继续保持你的快乐哦！", Toast.LENGTH_SHORT).show();
			}
		});

		// 否定按钮
		builder.setNegativeButton("否", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(activity_UI_AlertDialogDemo.this, "要积极去寻找你的乐趣哦！", Toast.LENGTH_SHORT).show();
			}
		});

		// 中立按钮
		builder.setNeutralButton("不知道", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(activity_UI_AlertDialogDemo.this, "需要认真反思一下自己的生活态度哦！", Toast.LENGTH_SHORT).show();
			}
		});

		// 设置点击屏幕后面区域或者返回键是否取消显示
		builder.setCancelable(false);
		// 对话框创建并展示
		builder.create().show();

	}

	// 单选框
	private void SingleDialogDemo() {

		AlertDialog.Builder builder = new AlertDialog.Builder(activity_UI_AlertDialogDemo.this);
		builder.setTitle("你的性别：");

		// 设置单选框选项，并设置监听器
		builder.setSingleChoiceItems(Singleitems, singleCheckedItem, new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				singleCheckedItem = which;
			}
		});

		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(activity_UI_AlertDialogDemo.this, "你选择了：" + Singleitems[singleCheckedItem],
						Toast.LENGTH_SHORT).show();
			}
		});

		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(activity_UI_AlertDialogDemo.this, "你取消了选择！", Toast.LENGTH_SHORT).show();
			}
		});

		builder.setCancelable(false);
		builder.create().show();
	}

	// 复选框
	private void MuiltiDialogDemo() {

		AlertDialog.Builder builder = new AlertDialog.Builder(activity_UI_AlertDialogDemo.this);
		builder.setTitle("爱好");

		// 设置复选框的选项及监听器
		builder.setMultiChoiceItems(MultiItems, multiCheckedItems, new DialogInterface.OnMultiChoiceClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which, boolean isChecked) {
				// TODO Auto-generated method stub
				multiCheckedItems[which] = isChecked;
			}
		});

		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {

				String result = "";
				for (int i = 0; i < multiCheckedItems.length; i++) {
					if (multiCheckedItems[i]) {
						result += MultiItems[i] + ",";
					}
				}

				// 档result不为空时，提示结果
				if (!"".equals(result)) {
					// 去掉后面的" , "符号
					result = result.substring(0, result.length() - 1);
					Toast.makeText(activity_UI_AlertDialogDemo.this, "你的爱好为：" + result, Toast.LENGTH_SHORT).show();
				}
			}
		});

		builder.setNegativeButton("取消", null);

		builder.setCancelable(false);
		builder.create().show();

	}

	// 列表框
	private void ListDialogDemo() {
		AlertDialog.Builder builder = new AlertDialog.Builder(activity_UI_AlertDialogDemo.this);
		builder.setTitle("选择课程");
		// 设置列表框的选项及监听器
		builder.setItems(ListItems, new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(activity_UI_AlertDialogDemo.this, "你选择了：" + ListItems[which], Toast.LENGTH_SHORT).show();
			}
		});
		builder.setCancelable(true);
		builder.create().show();
	}

	// 旋转进度框
	private void ProgressSpinnerDialogDemo() {
		final ProgressDialog progressDialog = new ProgressDialog(activity_UI_AlertDialogDemo.this);
		// 设置进度为旋转样式
		progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		progressDialog.setTitle("请稍后");
		progressDialog.setMessage("正在加载数据……");
		progressDialog.setCancelable(false);
		progressDialog.show();

		// 线程模拟进程
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				progressDialog.dismiss();
			}
		}).start();
		;

	}

	// 水平进度框
	private void ProgressHorizontalDialog() {
		final ProgressDialog progressDialog = new ProgressDialog(activity_UI_AlertDialogDemo.this);
		// 设置进度为水平条样式
		progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		progressDialog.setTitle("加载数据");
		// 设置进度的最大值
		progressDialog.setMax(100);
		// 设置进度的值
		progressDialog.setProgress(0);
		progressDialog.show();

		// 线程模拟进程
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < progressDialog.getMax(); i++) {
					progressDialog.setProgress(i);
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				progressDialog.dismiss();
			}
		}).start();

	}

	//自定义布局对话框
	private void CustomDialog() {

		AlertDialog.Builder builder = new AlertDialog.Builder(activity_UI_AlertDialogDemo.this);
		builder.setTitle("登录");

		// 加载自定义布局的视图
		View view = getLayoutInflater().inflate(R.layout.ui_alertdialogdemo_customdialog, null);
		builder.setView(view);

		// 确定按钮及事件处理
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {

				// 链式结构
				// EditText user=(EditText) ((AlertDialog)
				// dialog).findViewById(R.id.et_AlertDialogDemo_user);

				AlertDialog dialog1 = (AlertDialog) dialog;

				// 获得自定义布局中的控件
				EditText user = (EditText) dialog1.findViewById(R.id.et_AlertDialogDemo_user);
				EditText pass = (EditText) dialog1.findViewById(R.id.et_AlertDialogDemo_password);

				// 获取布局中的内容
				String username = user.getText().toString();
				String password = pass.getText().toString();

				// 判断是否为空
				if (!"".equals(username) && !"".equals(password)) {
					Toast.makeText(activity_UI_AlertDialogDemo.this, "欢迎你，" + username, Toast.LENGTH_SHORT).show();
				} else
					Toast.makeText(activity_UI_AlertDialogDemo.this, "输入有误，请重新输入！", Toast.LENGTH_SHORT).show();
			}
		});

		// 取消操作，关闭对话框
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});

		//设置屏幕空白区域与back不可关闭对话框
		builder.setCancelable(false);
		// 创建对话框
		builder.create().show();
	}

}
