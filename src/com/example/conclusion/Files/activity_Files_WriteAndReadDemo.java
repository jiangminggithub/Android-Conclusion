package com.example.conclusion.Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.http.util.EncodingUtils;
import com.example.conclusion.R;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class activity_Files_WriteAndReadDemo extends Activity implements OnClickListener {

	EditText et_Files_writeText;
	TextView tv_Files_ReadText;
	Button btn_Files_WriteDataStorage, btn_Files_WriteExternalStorage, btn_Files_ReadDataStorage,
			btn_Files_ReadExternalStorage, btn_Files_WriteDataStorageMode;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_files_writeandread_demo);
		et_Files_writeText = (EditText) findViewById(R.id.et_Files_writeText);
		tv_Files_ReadText = (TextView) findViewById(R.id.tv_Files_ReadText);

		btn_Files_WriteDataStorage = (Button) findViewById(R.id.btn_Files_WriteDataStorage);
		btn_Files_WriteExternalStorage = (Button) findViewById(R.id.btn_Files_WriteExternalStorage);
		btn_Files_ReadDataStorage = (Button) findViewById(R.id.btn_Files_ReadDataStorage);
		btn_Files_ReadExternalStorage = (Button) findViewById(R.id.btn_Files_ReadExternalStorage);
		btn_Files_WriteDataStorageMode = (Button) findViewById(R.id.btn_Files_WriteDataStorageMode);

		btn_Files_WriteDataStorage.setOnClickListener(this);
		btn_Files_WriteExternalStorage.setOnClickListener(this);
		btn_Files_ReadDataStorage.setOnClickListener(this);
		btn_Files_ReadExternalStorage.setOnClickListener(this);
		btn_Files_WriteDataStorageMode.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_Files_WriteDataStorage:
			WriteDataStorage();
			break;
		case R.id.btn_Files_WriteExternalStorage:
			WriteExternalStorage();
			break;
		case R.id.btn_Files_ReadDataStorage:
			ReadDataStorage();
			break;
		case R.id.btn_Files_ReadExternalStorage:
			ReadExternalStorage();
			break;
		case R.id.btn_Files_WriteDataStorageMode:
			WriteDataStorageMode();
			break;
		}

	}

	// д���ļ����ڲ��洢
	private void WriteDataStorage() {
		// ��ȡ��������
		String writeText = et_Files_writeText.getText().toString();
		// �ж����������Ƿ�Ϊ��
		if (!"".equals(writeText)) {
			File file = new File(this.getFilesDir(), "FileDemoinfo.txt");
			try {

				// ���������
				FileOutputStream fos = new FileOutputStream(file);
				// д���ļ�
				fos.write(writeText.getBytes());
				Log.i("WriteDataStorage", "-->" + writeText);
				fos.close();
				
				et_Files_writeText.setText("");
				tv_Files_ReadText.setText("");
				Toast.makeText(this, "����д��ɹ���", Toast.LENGTH_SHORT).show();

			} catch (Exception e) {
				Toast.makeText(this, "����д��ʧ�ܣ�", Toast.LENGTH_SHORT).show();
				e.printStackTrace();
			}
		} else
			Toast.makeText(this, "������д���ļ������ݣ�", Toast.LENGTH_SHORT).show();
	}

	// д���ļ����ⲿ�洢�豸
	private void WriteExternalStorage() {
		if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
			// ��ȡ��������
			String writeText = et_Files_writeText.getText().toString();
			// �ж����������Ƿ�Ϊ��
			if (!"".equals(writeText)) {
				
				//1���ⲿ�洢��android->data-��ǰ����->files->media_router�ļ��е�Ŀ¼
				File file = new File(this.getExternalFilesDir(MEDIA_ROUTER_SERVICE), "FileDemoinfo.txt");
				
				//2����ǰ�ⲿ�豸�ĵĸ�Ŀ¼(4.4���ϲ�����ֱ�Ӹ�Ŀ¼����)
				//File file = new File(Environment.getExternalStorageDirectory(), "FileDemoinfo.txt");
				
				try {

					// ���������
					FileOutputStream fos = new FileOutputStream(file);
					// д���ļ�
					fos.write(writeText.getBytes());
					Log.i("WriteExternalStorage", "-->" + writeText);
					fos.close();
					
					et_Files_writeText.setText("");
					tv_Files_ReadText.setText("");
					Toast.makeText(this, "����д��ɹ���", Toast.LENGTH_SHORT).show();

				} catch (Exception e) {
					Toast.makeText(this, "����д��ʧ�ܣ�", Toast.LENGTH_SHORT).show();
					e.printStackTrace();
				}
			} else
				Toast.makeText(this, "������д���ļ������ݣ�", Toast.LENGTH_SHORT).show();
		} else
			Toast.makeText(this, "�ⲿ�豸�����ڣ�", Toast.LENGTH_SHORT).show();
	}

	// ��ȡ�ڲ��洢�ļ�
	private void ReadDataStorage() {

		File file = new File(this.getFilesDir(), "FileDemoinfo.txt");
		FileInputStream fis;
		// ��ȡȫ������
		try {

			fis = new FileInputStream(file);
			int length = fis.available();
			byte[] buffer = new byte[length];
			fis.read(buffer);
			String readText = EncodingUtils.getString(buffer, "UTF-8");
			fis.close();
			tv_Files_ReadText.setText(readText);
			Log.i("ReadDataStorage", "-->" + readText);
			

		} catch (Exception e) {
			Toast.makeText(this, "�ļ������ڻ��𻵣�", Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		}

		// ��ȡһ������
		// FileInputStream fos = new FileInputStream(file);
		// BufferedReader br = new BufferedReader(new InputStreamReader(fos));
		// String str = br.readLine();

	}

	// ��ȡ�ⲿ�洢�ļ�
	private void ReadExternalStorage() {

		if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
			
			//1���ⲿ�洢��android->data-��ǰ����->files->media_router�ļ��е�Ŀ¼
			File file = new File(this.getExternalFilesDir(MEDIA_ROUTER_SERVICE), "FileDemoinfo.txt");
			
			//2����ǰ�ⲿ�豸�ĵĸ�Ŀ¼(4.4���ϲ�����ֱ�Ӹ�Ŀ¼����)
			//File file = new File(Environment.getExternalStorageDirectory(), "FileDemoinfo.txt");
			FileInputStream fis;
			
			// ��ȡȫ������
			try {
				fis = new FileInputStream(file);

				int length = fis.available();
				byte[] buffer = new byte[length];

				fis.read(buffer);
				String readText = EncodingUtils.getString(buffer, "UTF-8");
				fis.close();
				tv_Files_ReadText.setText(readText);
				Log.i("ReadExternalStorage", "-->" + readText);
			} catch (Exception e) {
				Toast.makeText(this, "�ļ������ڻ��𻵣�", Toast.LENGTH_SHORT).show();
				e.printStackTrace();
			}

		} else
			Toast.makeText(this, "�ⲿ�豸�����ڣ�", Toast.LENGTH_SHORT).show();
	}

	// ָ��д���ģʽд�����ݵ��ڲ��洢
	private void WriteDataStorageMode() {
		// ��ȡ��������
		String writeText = et_Files_writeText.getText().toString();
		// �ж����������Ƿ�Ϊ��
		if (!"".equals(writeText)) {

			FileOutputStream fos;
			try {

				// MODE_PRIVATE��-rw-rw----˽��
				// MODE_APPEND:-rw-rw----׷��
				// MODE_WORLD_WRITEABLE:-rw-rw--w-��д
				// MODE_WORLD_READABLE:-rw-rw-r���ɶ�

				fos = this.openFileOutput("FileDemoinfo.txt", MODE_APPEND);
				fos.write((writeText).getBytes());
				Log.i("WriteDataStorageMode", "-->" + writeText);
				fos.close();
				
				et_Files_writeText.setText("");
				tv_Files_ReadText.setText("");
				Toast.makeText(this, "����д��ɹ���", Toast.LENGTH_SHORT).show();

			} catch (Exception e) {
				Toast.makeText(this, "����д��ʧ�ܣ�", Toast.LENGTH_SHORT).show();
				e.printStackTrace();
			}

		} else
			Toast.makeText(this, "������д���ļ������ݣ�", Toast.LENGTH_SHORT).show();
	}

}
