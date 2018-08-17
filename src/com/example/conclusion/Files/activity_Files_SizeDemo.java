package com.example.conclusion.Files;

import java.io.File;
import java.util.ArrayList;

import com.example.conclusion.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.format.Formatter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class activity_Files_SizeDemo extends Activity {

	Button btn_Files_SizeDemo_DataDirectory, btn_Files_SizeDemo_ExternalStorageDirectory;
	TextView tv_Files_DirectorySize, tv_Files_DirectoryAvailSize;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_files_size_demo);
		btn_Files_SizeDemo_DataDirectory = (Button) findViewById(R.id.btn_Files_SizeDemo_DataDirectory);
		btn_Files_SizeDemo_ExternalStorageDirectory = (Button) findViewById(
				R.id.btn_Files_SizeDemo_ExternalStorageDirectory);
		tv_Files_DirectorySize = (TextView) findViewById(R.id.tv_Files_DirectorySize);
		tv_Files_DirectoryAvailSize = (TextView) findViewById(R.id.tv_Files_DirectoryAvailSize);

		btn_Files_SizeDemo_DataDirectory.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				getDateStorageSize();
			}
		});

		btn_Files_SizeDemo_ExternalStorageDirectory.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				getExternalStorageSize();
			}
		});

	}

	// ��ȡ�ڲ��洢��Ϣ
	private void getDateStorageSize() {
		// ��ȡ�ڲ��洢��Ŀ¼
		File Directorypath = Environment.getDataDirectory();
		// ��ȡ�ļ�ϵͳȫ����Ϣ
		StatFs stat = new StatFs(Directorypath.getPath());
		// ������ݿ��С
		long blockSize = stat.getBlockSize();
		// ��ȡ���ݿ����
		long totalBlocks = stat.getBlockCount();
		// ��ȡ�������ݿ����
		long availableBolcks = stat.getAvailableBlocks();

		// ����������=���ݿ��С*���ݿ����
		long totalSize = blockSize * totalBlocks;
		// �����������=���ݿ��С*�������ݿ����
		long availSize = blockSize * availableBolcks;

		// ��ʽ�����ַ�
		String totalSizeStr = Formatter.formatFileSize(this, totalSize);
		String availSizeStr = Formatter.formatFileSize(this, availSize);

		// ���������
		tv_Files_DirectorySize.setText("�ڲ��洢������С:" + totalSizeStr);
		tv_Files_DirectoryAvailSize.setText("�ڲ��洢��������:" + availSizeStr);
	}

	// ����ⲿ��SD�����洢��Ϣ
	private void getExternalStorageSize() {
		// �ж��ⲿ�豸��SD�����Ƿ����
		if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
			// ��ȡ�ⲿ�洢��Ŀ¼
			File Directorypath = Environment.getExternalStorageDirectory();
			// ��ȡ�ļ�ϵͳȫ����Ϣ
			StatFs stat = new StatFs(Directorypath.getPath());
			// ������ݿ��С
			long blockSize = stat.getBlockSize();
			// ��ȡ���ݿ����
			long totalBlocks = stat.getBlockCount();
			// ��ȡ�������ݿ����
			long availableBolcks = stat.getAvailableBlocks();

			// ����������=���ݿ��С*���ݿ����
			long totalSize = blockSize * totalBlocks;
			// �����������=���ݿ��С*�������ݿ����
			long availSize = blockSize * availableBolcks;

			// ��ʽ�����ַ�
			String totalSizeStr = Formatter.formatFileSize(this, totalSize);
			String availSizeStr = Formatter.formatFileSize(this, availSize);

			// ���������
			tv_Files_DirectorySize.setText("�ⲿ�洢������С:" + totalSizeStr);
			tv_Files_DirectoryAvailSize.setText("�ⲿ�洢��������:" + availSizeStr);
		} else {
			tv_Files_DirectorySize.setText("�ⲿ�豸������");
			tv_Files_DirectoryAvailSize.setText("�ⲿ�豸������");
			Toast.makeText(activity_Files_SizeDemo.this, "�ⲿ�豸�����ڣ��밲װ���豸��", Toast.LENGTH_SHORT).show();
		}
	}

}
