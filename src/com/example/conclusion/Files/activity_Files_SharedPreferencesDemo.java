package com.example.conclusion.Files;

import com.example.conclusion.R;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class activity_Files_SharedPreferencesDemo extends Activity {
	RadioButton rb_SharedPreferences_rememberPassword, rb_SharedPreferences_rememberUser;
	EditText et_Files_SharedPreferences_user, et_Files_SharedPreferences_password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_files_sharedpreferences_demo);

		rb_SharedPreferences_rememberPassword = (RadioButton) findViewById(R.id.rb_SharedPreferences_rememberPassword);
		rb_SharedPreferences_rememberUser = (RadioButton) findViewById(R.id.rb_SharedPreferences_rememberUser);
		et_Files_SharedPreferences_user = (EditText) findViewById(R.id.et_Files_SharedPreferences_user);
		et_Files_SharedPreferences_password = (EditText) findViewById(R.id.et_Files_SharedPreferences_password);

		// 获取SharedPreferences信息
		SharedPreferences sp = getSharedPreferences("filesSharedconfig", MODE_PRIVATE);
		String user = sp.getString("user", "");
		String password = sp.getString("password", "");
		et_Files_SharedPreferences_user.setText(user);
		et_Files_SharedPreferences_password.setText(password);
		
	}

	public void sharedLogin(View view) {

		String user = et_Files_SharedPreferences_user.getText().toString();
		String password = et_Files_SharedPreferences_password.getText().toString();

		// 判断输入是否为空
		if ("".equals(user) || "".equals(password)) {
			Toast.makeText(activity_Files_SharedPreferencesDemo.this, "请输入账号或密码！", Toast.LENGTH_SHORT).show();
			return;
		}
		// 判断是否选择保存（账户和密码）模式
		if (rb_SharedPreferences_rememberPassword.isChecked()) {
			
			SharedPreferences sharedPreferences = getSharedPreferences("filesSharedconfig", MODE_PRIVATE);

			Editor editor = sharedPreferences.edit();
			editor.putString("user", user);
			editor.putString("password", password);
			editor.commit();
			Toast.makeText(activity_Files_SharedPreferencesDemo.this, "登录成功，[已记住账户和密码]！", Toast.LENGTH_SHORT).show();

		}
		// 判断是否选择仅保存（账户）模式
		if (rb_SharedPreferences_rememberUser.isChecked()) {
			
			SharedPreferences sharedPreferences = getSharedPreferences("filesSharedconfig", MODE_PRIVATE);

			Editor editor = sharedPreferences.edit();
			editor.putString("user", user);
			editor.putString("password", null);
			editor.commit();
			Toast.makeText(activity_Files_SharedPreferencesDemo.this, "登录成功，[已记住账户]！", Toast.LENGTH_SHORT).show();
		}
	}

}
