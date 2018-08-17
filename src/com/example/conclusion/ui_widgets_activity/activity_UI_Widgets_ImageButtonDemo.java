package com.example.conclusion.ui_widgets_activity;

import com.example.conclusion.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class activity_UI_Widgets_ImageButtonDemo extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ui_widgets_imagebutton_demo);

	}

	public void imageButtonDemo(View view) {
		Toast.makeText(activity_UI_Widgets_ImageButtonDemo.this, "µÇÂ¼³É¹¦£¡",
				Toast.LENGTH_SHORT).show();
	}

}
