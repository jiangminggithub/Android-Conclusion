package com.example.conclusion.ui_widgets_activity;

import com.example.conclusion.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.RatingBar.OnRatingBarChangeListener;

public class activity_UI_Widgets_RatingBarDemo extends Activity {
	RatingBar rb_UI_RatingBarDemo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ui_widgets_ratingbar_demo);
		rb_UI_RatingBarDemo = (RatingBar) findViewById(R.id.rb_UI_RatingBarDemo);
		rb_UI_RatingBarDemo
				.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {

					@Override
					public void onRatingChanged(RatingBar ratingBar,
							float rating, boolean fromUser) {
						Toast.makeText(activity_UI_Widgets_RatingBarDemo.this,
								"ÄãµÄÆÀ·ÖÎª£º" + rating, Toast.LENGTH_SHORT).show();

					}
				});

	}

}
