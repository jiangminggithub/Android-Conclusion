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

	// 写入文件到内部存储
	private void WriteDataStorage() {
		// 获取输入内容
		String writeText = et_Files_writeText.getText().toString();
		// 判断输入内容是否为空
		if (!"".equals(writeText)) {
			File file = new File(this.getFilesDir(), "FileDemoinfo.txt");
			try {

				// 建立输出流
				FileOutputStream fos = new FileOutputStream(file);
				// 写入文件
				fos.write(writeText.getBytes());
				Log.i("WriteDataStorage", "-->" + writeText);
				fos.close();
				
				et_Files_writeText.setText("");
				tv_Files_ReadText.setText("");
				Toast.makeText(this, "数据写入成功！", Toast.LENGTH_SHORT).show();

			} catch (Exception e) {
				Toast.makeText(this, "数据写入失败！", Toast.LENGTH_SHORT).show();
				e.printStackTrace();
			}
		} else
			Toast.makeText(this, "请输入写入文件的内容！", Toast.LENGTH_SHORT).show();
	}

	// 写入文件到外部存储设备
	private void WriteExternalStorage() {
		if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
			// 获取输入内容
			String writeText = et_Files_writeText.getText().toString();
			// 判断输入内容是否为空
			if (!"".equals(writeText)) {
				
				//1、外部存储的android->data-当前包下->files->media_router文件夹的目录
				File file = new File(this.getExternalFilesDir(MEDIA_ROUTER_SERVICE), "FileDemoinfo.txt");
				
				//2、当前外部设备的的根目录(4.4以上不允许直接根目录操作)
				//File file = new File(Environment.getExternalStorageDirectory(), "FileDemoinfo.txt");
				
				try {

					// 建立输出流
					FileOutputStream fos = new FileOutputStream(file);
					// 写入文件
					fos.write(writeText.getBytes());
					Log.i("WriteExternalStorage", "-->" + writeText);
					fos.close();
					
					et_Files_writeText.setText("");
					tv_Files_ReadText.setText("");
					Toast.makeText(this, "数据写入成功！", Toast.LENGTH_SHORT).show();

				} catch (Exception e) {
					Toast.makeText(this, "数据写入失败！", Toast.LENGTH_SHORT).show();
					e.printStackTrace();
				}
			} else
				Toast.makeText(this, "请输入写入文件的内容！", Toast.LENGTH_SHORT).show();
		} else
			Toast.makeText(this, "外部设备不存在！", Toast.LENGTH_SHORT).show();
	}

	// 读取内部存储文件
	private void ReadDataStorage() {

		File file = new File(this.getFilesDir(), "FileDemoinfo.txt");
		FileInputStream fis;
		// 读取全部内容
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
			Toast.makeText(this, "文件不存在或损坏！", Toast.LENGTH_SHORT).show();
			e.printStackTrace();
		}

		// 读取一行数据
		// FileInputStream fos = new FileInputStream(file);
		// BufferedReader br = new BufferedReader(new InputStreamReader(fos));
		// String str = br.readLine();

	}

	// 读取外部存储文件
	private void ReadExternalStorage() {

		if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
			
			//1、外部存储的android->data-当前包下->files->media_router文件夹的目录
			File file = new File(this.getExternalFilesDir(MEDIA_ROUTER_SERVICE), "FileDemoinfo.txt");
			
			//2、当前外部设备的的根目录(4.4以上不允许直接根目录操作)
			//File file = new File(Environment.getExternalStorageDirectory(), "FileDemoinfo.txt");
			FileInputStream fis;
			
			// 读取全部内容
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
				Toast.makeText(this, "文件不存在或损坏！", Toast.LENGTH_SHORT).show();
				e.printStackTrace();
			}

		} else
			Toast.makeText(this, "外部设备不存在！", Toast.LENGTH_SHORT).show();
	}

	// 指定写入的模式写入数据到内部存储
	private void WriteDataStorageMode() {
		// 获取输入内容
		String writeText = et_Files_writeText.getText().toString();
		// 判断输入内容是否为空
		if (!"".equals(writeText)) {

			FileOutputStream fos;
			try {

				// MODE_PRIVATE：-rw-rw----私有
				// MODE_APPEND:-rw-rw----追加
				// MODE_WORLD_WRITEABLE:-rw-rw--w-可写
				// MODE_WORLD_READABLE:-rw-rw-r—可读

				fos = this.openFileOutput("FileDemoinfo.txt", MODE_APPEND);
				fos.write((writeText).getBytes());
				Log.i("WriteDataStorageMode", "-->" + writeText);
				fos.close();
				
				et_Files_writeText.setText("");
				tv_Files_ReadText.setText("");
				Toast.makeText(this, "数据写入成功！", Toast.LENGTH_SHORT).show();

			} catch (Exception e) {
				Toast.makeText(this, "数据写入失败！", Toast.LENGTH_SHORT).show();
				e.printStackTrace();
			}

		} else
			Toast.makeText(this, "请输入写入文件的内容！", Toast.LENGTH_SHORT).show();
	}

}
