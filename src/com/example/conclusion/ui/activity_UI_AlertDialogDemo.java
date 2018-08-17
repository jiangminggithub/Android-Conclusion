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

	// ��ѡ��ѡ��
	private final String[] Singleitems = { "��", "Ů", "����" };
	// ��ѡ��ѡ��
	private final String[] MultiItems = { "����", "˯��", "��Ϸ", "K��" };
	// �б��ѡ��
	private final String[] ListItems = { "android", "HTML", "JavaScript", "ASP.NET" };
	// ��ѡ���ʼѡ����
	private int singleCheckedItem = 0;
	// ��ѡ���ʼѡ����
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

	// Ĭ����Ϣ��
	private void DialogMessageDemo() {
		AlertDialog.Builder builder = new AlertDialog.Builder(activity_UI_AlertDialogDemo.this);
		// ���ñ���
		builder.setTitle("��ʾ");
		// ������ʾ��Ϣ
		builder.setMessage("�㿪�Ŀ�����");

		// ȷ����ť
		builder.setPositiveButton("��", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(activity_UI_AlertDialogDemo.this, "Ҫ����������Ŀ���Ŷ��", Toast.LENGTH_SHORT).show();
			}
		});

		// �񶨰�ť
		builder.setNegativeButton("��", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(activity_UI_AlertDialogDemo.this, "Ҫ����ȥѰ�������ȤŶ��", Toast.LENGTH_SHORT).show();
			}
		});

		// ������ť
		builder.setNeutralButton("��֪��", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(activity_UI_AlertDialogDemo.this, "��Ҫ���淴˼һ���Լ�������̬��Ŷ��", Toast.LENGTH_SHORT).show();
			}
		});

		// ���õ����Ļ����������߷��ؼ��Ƿ�ȡ����ʾ
		builder.setCancelable(false);
		// �Ի��򴴽���չʾ
		builder.create().show();

	}

	// ��ѡ��
	private void SingleDialogDemo() {

		AlertDialog.Builder builder = new AlertDialog.Builder(activity_UI_AlertDialogDemo.this);
		builder.setTitle("����Ա�");

		// ���õ�ѡ��ѡ������ü�����
		builder.setSingleChoiceItems(Singleitems, singleCheckedItem, new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				singleCheckedItem = which;
			}
		});

		builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(activity_UI_AlertDialogDemo.this, "��ѡ���ˣ�" + Singleitems[singleCheckedItem],
						Toast.LENGTH_SHORT).show();
			}
		});

		builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(activity_UI_AlertDialogDemo.this, "��ȡ����ѡ��", Toast.LENGTH_SHORT).show();
			}
		});

		builder.setCancelable(false);
		builder.create().show();
	}

	// ��ѡ��
	private void MuiltiDialogDemo() {

		AlertDialog.Builder builder = new AlertDialog.Builder(activity_UI_AlertDialogDemo.this);
		builder.setTitle("����");

		// ���ø�ѡ���ѡ�������
		builder.setMultiChoiceItems(MultiItems, multiCheckedItems, new DialogInterface.OnMultiChoiceClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which, boolean isChecked) {
				// TODO Auto-generated method stub
				multiCheckedItems[which] = isChecked;
			}
		});

		builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {

				String result = "";
				for (int i = 0; i < multiCheckedItems.length; i++) {
					if (multiCheckedItems[i]) {
						result += MultiItems[i] + ",";
					}
				}

				// ��result��Ϊ��ʱ����ʾ���
				if (!"".equals(result)) {
					// ȥ�������" , "����
					result = result.substring(0, result.length() - 1);
					Toast.makeText(activity_UI_AlertDialogDemo.this, "��İ���Ϊ��" + result, Toast.LENGTH_SHORT).show();
				}
			}
		});

		builder.setNegativeButton("ȡ��", null);

		builder.setCancelable(false);
		builder.create().show();

	}

	// �б��
	private void ListDialogDemo() {
		AlertDialog.Builder builder = new AlertDialog.Builder(activity_UI_AlertDialogDemo.this);
		builder.setTitle("ѡ��γ�");
		// �����б���ѡ�������
		builder.setItems(ListItems, new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(activity_UI_AlertDialogDemo.this, "��ѡ���ˣ�" + ListItems[which], Toast.LENGTH_SHORT).show();
			}
		});
		builder.setCancelable(true);
		builder.create().show();
	}

	// ��ת���ȿ�
	private void ProgressSpinnerDialogDemo() {
		final ProgressDialog progressDialog = new ProgressDialog(activity_UI_AlertDialogDemo.this);
		// ���ý���Ϊ��ת��ʽ
		progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		progressDialog.setTitle("���Ժ�");
		progressDialog.setMessage("���ڼ������ݡ���");
		progressDialog.setCancelable(false);
		progressDialog.show();

		// �߳�ģ�����
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

	// ˮƽ���ȿ�
	private void ProgressHorizontalDialog() {
		final ProgressDialog progressDialog = new ProgressDialog(activity_UI_AlertDialogDemo.this);
		// ���ý���Ϊˮƽ����ʽ
		progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		progressDialog.setTitle("��������");
		// ���ý��ȵ����ֵ
		progressDialog.setMax(100);
		// ���ý��ȵ�ֵ
		progressDialog.setProgress(0);
		progressDialog.show();

		// �߳�ģ�����
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

	//�Զ��岼�ֶԻ���
	private void CustomDialog() {

		AlertDialog.Builder builder = new AlertDialog.Builder(activity_UI_AlertDialogDemo.this);
		builder.setTitle("��¼");

		// �����Զ��岼�ֵ���ͼ
		View view = getLayoutInflater().inflate(R.layout.ui_alertdialogdemo_customdialog, null);
		builder.setView(view);

		// ȷ����ť���¼�����
		builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {

				// ��ʽ�ṹ
				// EditText user=(EditText) ((AlertDialog)
				// dialog).findViewById(R.id.et_AlertDialogDemo_user);

				AlertDialog dialog1 = (AlertDialog) dialog;

				// ����Զ��岼���еĿؼ�
				EditText user = (EditText) dialog1.findViewById(R.id.et_AlertDialogDemo_user);
				EditText pass = (EditText) dialog1.findViewById(R.id.et_AlertDialogDemo_password);

				// ��ȡ�����е�����
				String username = user.getText().toString();
				String password = pass.getText().toString();

				// �ж��Ƿ�Ϊ��
				if (!"".equals(username) && !"".equals(password)) {
					Toast.makeText(activity_UI_AlertDialogDemo.this, "��ӭ�㣬" + username, Toast.LENGTH_SHORT).show();
				} else
					Toast.makeText(activity_UI_AlertDialogDemo.this, "�����������������룡", Toast.LENGTH_SHORT).show();
			}
		});

		// ȡ���������رնԻ���
		builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});

		//������Ļ�հ�������back���ɹرնԻ���
		builder.setCancelable(false);
		// �����Ի���
		builder.create().show();
	}

}
