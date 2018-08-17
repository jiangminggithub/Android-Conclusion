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

	// 获取内部存储信息
	private void getDateStorageSize() {
		// 获取内部存储的目录
		File Directorypath = Environment.getDataDirectory();
		// 获取文件系统全部信息
		StatFs stat = new StatFs(Directorypath.getPath());
		// 获得数据块大小
		long blockSize = stat.getBlockSize();
		// 获取数据块个数
		long totalBlocks = stat.getBlockCount();
		// 获取可用数据块个数
		long availableBolcks = stat.getAvailableBlocks();

		// 计算总容量=数据块大小*数据块个数
		long totalSize = blockSize * totalBlocks;
		// 计算可用容量=数据块大小*可用数据块个数
		long availSize = blockSize * availableBolcks;

		// 格式化成字符
		String totalSizeStr = Formatter.formatFileSize(this, totalSize);
		String availSizeStr = Formatter.formatFileSize(this, availSize);

		// 输出到界面
		tv_Files_DirectorySize.setText("内部存储容量大小:" + totalSizeStr);
		tv_Files_DirectoryAvailSize.setText("内部存储可用容量:" + availSizeStr);
	}

	// 获得外部（SD卡）存储信息
	private void getExternalStorageSize() {
		// 判断外部设备（SD卡）是否存在
		if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
			// 获取外部存储的目录
			File Directorypath = Environment.getExternalStorageDirectory();
			// 获取文件系统全部信息
			StatFs stat = new StatFs(Directorypath.getPath());
			// 获得数据块大小
			long blockSize = stat.getBlockSize();
			// 获取数据块个数
			long totalBlocks = stat.getBlockCount();
			// 获取可用数据块个数
			long availableBolcks = stat.getAvailableBlocks();

			// 计算总容量=数据块大小*数据块个数
			long totalSize = blockSize * totalBlocks;
			// 计算可用容量=数据块大小*可用数据块个数
			long availSize = blockSize * availableBolcks;

			// 格式化成字符
			String totalSizeStr = Formatter.formatFileSize(this, totalSize);
			String availSizeStr = Formatter.formatFileSize(this, availSize);

			// 输出到界面
			tv_Files_DirectorySize.setText("外部存储容量大小:" + totalSizeStr);
			tv_Files_DirectoryAvailSize.setText("外部存储可用容量:" + availSizeStr);
		} else {
			tv_Files_DirectorySize.setText("外部设备不存在");
			tv_Files_DirectoryAvailSize.setText("外部设备不存在");
			Toast.makeText(activity_Files_SizeDemo.this, "外部设备不存在，请安装此设备！", Toast.LENGTH_SHORT).show();
		}
	}

}
