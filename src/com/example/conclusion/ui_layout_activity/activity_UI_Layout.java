package com.example.conclusion.ui_layout_activity;

import com.example.conclusion.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class activity_UI_Layout extends Activity implements OnClickListener {
	Button btn_UI_Layout_LinearLayout, btn_UI_Layout_RelativeLayout,
			btn_UI_Layout_FrameLayout, btn_UI_Layout_TableLayout,
			btn_UI_Layout_AbsoluteLayout, btn_UI_Layout_GridLayout,
			btn_UI_Layout_DrawerLayout, btn_UI_Layout_SlidingPaneLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ui_layout);
		initView();
	}

	public void initView() {
		btn_UI_Layout_LinearLayout = (Button) findViewById(R.id.btn_UI_Layout_LinearLayout);
		btn_UI_Layout_RelativeLayout = (Button) findViewById(R.id.btn_UI_Layout_RelativeLayout);
		btn_UI_Layout_TableLayout = (Button) findViewById(R.id.btn_UI_Layout_TableLayout);
		btn_UI_Layout_AbsoluteLayout = (Button) findViewById(R.id.btn_UI_Layout_AbsoluteLayout);
		btn_UI_Layout_GridLayout = (Button) findViewById(R.id.btn_UI_Layout_GridLayout);
		btn_UI_Layout_FrameLayout = (Button) findViewById(R.id.btn_UI_Layout_FrameLayout);
		btn_UI_Layout_DrawerLayout = (Button) findViewById(R.id.btn_UI_Layout_DrawerLayout);
		btn_UI_Layout_SlidingPaneLayout = (Button) findViewById(R.id.btn_UI_Layout_SlidingPaneLayout);

		btn_UI_Layout_LinearLayout.setOnClickListener(this);
		btn_UI_Layout_RelativeLayout.setOnClickListener(this);
		btn_UI_Layout_FrameLayout.setOnClickListener(this);
		btn_UI_Layout_TableLayout.setOnClickListener(this);
		btn_UI_Layout_AbsoluteLayout.setOnClickListener(this);
		btn_UI_Layout_GridLayout.setOnClickListener(this);
		btn_UI_Layout_DrawerLayout.setOnClickListener(this);
		btn_UI_Layout_SlidingPaneLayout.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		Intent intent;
		switch (v.getId()) {
		case R.id.btn_UI_Layout_LinearLayout:
			intent = new Intent(activity_UI_Layout.this,
					activity_UI_Layout_LinearLayoutDemo.class);
			startActivity(intent);
			break;
		case R.id.btn_UI_Layout_RelativeLayout:
			intent = new Intent(activity_UI_Layout.this,
					activity_UI_Layout_RelativeLayoutDemo.class);
			startActivity(intent);
			break;
		case R.id.btn_UI_Layout_FrameLayout:
			intent = new Intent(activity_UI_Layout.this,
					activity_UI_Layout_FrameLayoutDemo.class);
			startActivity(intent);
			break;
		case R.id.btn_UI_Layout_TableLayout:
			intent = new Intent(activity_UI_Layout.this,
					activity_UI_Layout_TableLayoutDemo.class);
			startActivity(intent);
			break;
		case R.id.btn_UI_Layout_AbsoluteLayout:
			intent = new Intent(activity_UI_Layout.this,
					activity_UI_Layout_AbsoluteLayoutDemo.class);
			startActivity(intent);
			break;
		case R.id.btn_UI_Layout_GridLayout:
			intent = new Intent(activity_UI_Layout.this,
					activity_UI_Layout_GridLayoutDemo.class);
			startActivity(intent);
			break;
		case R.id.btn_UI_Layout_DrawerLayout:
			intent = new Intent(activity_UI_Layout.this,
					activity_UI_Layout_DrawerLayoutDemo.class);
			startActivity(intent);
			break;
		case R.id.btn_UI_Layout_SlidingPaneLayout:
			intent = new Intent(activity_UI_Layout.this,
					activity_UI_Layout_SlidingPaneLayoutDemo.class);
			startActivity(intent);
			break;
		default:
			break;
		}

	}

}
