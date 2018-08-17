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

	// ��������
	public void addDemo() {
		// �Ի���������
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("����д��Ϣ��");

		// �����Զ��岼��
		View view = getLayoutInflater().inflate(R.layout.sqlite_person_add, null);
		builder.setView(view);

		// ���ȷ����ť
		builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				AlertDialog dialog1 = (AlertDialog) dialog;

				// ��ȡ�����еĿؼ�
				EditText Etid = (EditText) dialog1.findViewById(R.id.et_SQLite_addid);
				EditText Etname = (EditText) dialog1.findViewById(R.id.et_SQLite_addname);
				EditText Etage = (EditText) dialog1.findViewById(R.id.et_SQLite_addage);

				int id = Integer.parseInt(Etid.getText().toString());
				String name = Etname.getText().toString();
				int age = Integer.parseInt(Etage.getText().toString());

				// �ж����ݺϷ���
				if (!"".equals(id) && !"".equals(name) && !"".equals(age)) {
					// �������
					DBManager.add(id, name, age);
				} else
					Toast.makeText(activity_SQLite.this, "���ݲ���Ϊ�գ�", Toast.LENGTH_SHORT).show();
			}
		});

		// ȡ����ť
		builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});
		// ���õ�����ؼ�����Ļ����������ʧ
		builder.setCancelable(false);
		// �����Ի���
		builder.create().show();

	}

	// ��ѯ����
	public void queryDemo() {
		// �Ի���������
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("�������ѯ��ţ�");

		// �����Զ��岼��
		View view = getLayoutInflater().inflate(R.layout.sqlite_person_query, null);
		builder.setView(view);
		// ���ȷ����ť
		builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				AlertDialog dialog1 = (AlertDialog) dialog;

				EditText Etid = (EditText) dialog1.findViewById(R.id.et_SQlite_queryID);

				String id = Etid.getText().toString();

				if (!"".equals(id)) {
					Person person = new Person();
					// ��ѯ����
					person = DBManager.Query(id);
					if (person != null) {
						tv_SQlite_id.setText("��Ա��ţ�" + person.getId());
						tv_SQlite_name.setText("��Ա������" + person.getName());
						tv_SQlite_age.setText("��Ա�Ա�" + person.getAge());
						Toast.makeText(activity_SQLite.this, "��ѯ�ɹ���", Toast.LENGTH_SHORT).show();
					} else {
						tv_SQlite_id.setText("");
						tv_SQlite_name.setText("");
						tv_SQlite_age.setText("");
						Toast.makeText(activity_SQLite.this, "δ��ѯ�����ݣ�", Toast.LENGTH_SHORT).show();
					}
				} else
					Toast.makeText(activity_SQLite.this, "���ݲ���Ϊ�գ�", Toast.LENGTH_SHORT).show();
			}
		});

		// ȡ����ť
		builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});

		// ���õ�����ؼ�����Ļ����������ʧ
		builder.setCancelable(false);
		// �����Ի���
		builder.create().show();
	}

	// ���²���
	private void updateDemo() {
		// �Ի���������
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("��������Ϣ��");

		// �����Զ��岼��
		View view = getLayoutInflater().inflate(R.layout.sqlite_person_update, null);
		builder.setView(view);
		// ���ȷ����ť
		builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				AlertDialog dialog1 = (AlertDialog) dialog;

				EditText EtOldName = (EditText) dialog1.findViewById(R.id.et_SQLite_update_OldName);
				EditText EtName = (EditText) dialog1.findViewById(R.id.et_SQLite_update_Name);

				String oldName = EtOldName.getText().toString();
				String Name = EtName.getText().toString();

				if (!"".equals(oldName) && !"".equals(Name)) {
					// ��������
					DBManager.updata(Name, oldName);
				} else
					Toast.makeText(activity_SQLite.this, "���ݲ���Ϊ�գ�", Toast.LENGTH_SHORT).show();
			}
		});

		// ȡ����ť
		builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});

		// ���õ�����ؼ�����Ļ����������ʧ
		builder.setCancelable(false);
		// �����Ի���
		builder.create().show();
	}

	// ɾ������
	private void daleteDemo() {
		// �Ի���������
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("������:");

		// �����Զ��岼��
		View view = getLayoutInflater().inflate(R.layout.sqlite_person_query, null);
		builder.setView(view);
		// ���ȷ����ť
		builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				AlertDialog dialog1 = (AlertDialog) dialog;

				EditText Etid = (EditText) dialog1.findViewById(R.id.et_SQlite_queryID);

				String id = Etid.getText().toString();

				if (!"".equals(id)) {
					// ɾ������
					DBManager.delete(id);
				} else
					Toast.makeText(activity_SQLite.this, "���ݲ���Ϊ�գ�", Toast.LENGTH_SHORT).show();
			}
		});

		// ȡ����ť
		builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});

		// ���õ�����ؼ�����Ļ����������ʧ
		builder.setCancelable(false);
		// �����Ի���
		builder.create().show();
	}

}
