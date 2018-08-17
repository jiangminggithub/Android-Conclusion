package com.example.conclusion.component;

import com.example.conclusion.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class activity_Cpmponent_ActivityDemo extends Activity {
	
	TextView tvResult;
	String lifecycleResult="【部分周期显示，详细信息见Log】\n";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.i("lifecycle", "-->onCreate");
		lifecycleResult+="-->onCreate\n";
		
		
		setContentView(R.layout.activity_component_activity_demo);
		
		tvResult=(TextView) findViewById(R.id.tv_ComponentDemo_result);
		
		tvResult.setText(lifecycleResult);
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.i("lifecycle", "-->onStart");
		lifecycleResult+="-->onStart\n";
		tvResult.setText(lifecycleResult);
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i("lifecycle", "-->onResume");
		lifecycleResult+="-->onResume\n";
		tvResult.setText(lifecycleResult);
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.i("lifecycle", "-->onPause");
		lifecycleResult+="-->onPause\n";
		tvResult.setText(lifecycleResult);
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.i("lifecycle", "-->onStop");
		lifecycleResult+="-->onStop\n";
		tvResult.setText(lifecycleResult);
	}
	
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.i("lifecycle", "-->onRestart");
		lifecycleResult+="-->onRestart\n";
		tvResult.setText(lifecycleResult);
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i("lifecycle", "-->onDestroy");
		lifecycleResult+="-->onDestroy\n";
		tvResult.setText(lifecycleResult);
	}
}
