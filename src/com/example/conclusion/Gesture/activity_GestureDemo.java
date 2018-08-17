package com.example.conclusion.Gesture;

import java.io.File;
import java.util.ArrayList;
import com.example.conclusion.R;
import android.app.Activity;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;
import android.gesture.Prediction;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

public class activity_GestureDemo extends Activity {

	GestureOverlayView gesture_View;
	private final File mStoreFile = new File(
			Environment.getExternalStorageDirectory(), "gestures");
	private GestureLibrary mGesturelib;
	boolean loadState = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gesture_demo);

		gesture_View = (GestureOverlayView) findViewById(R.id.gesture_View);

		// 文件方式中加载识别库，需要将gestures使用Gestures Builder绘制生成文件后放在指定文件目录下
		// mGesturelib = GestureLibraries.fromFile(mStoreFile);
		// loadState = mGesturelib.load();

		// 在res-->raw文件中获取识别库,gestures文件可以使用Gestures Builder绘制生成文件 
		mGesturelib = GestureLibraries.fromRawResource(
				activity_GestureDemo.this, R.raw.gestures);
		loadState = mGesturelib.load();

		gesture_View
				.setGestureStrokeType(GestureOverlayView.GESTURE_STROKE_TYPE_MULTIPLE);
		gesture_View.setFadeOffset(1000);
		gesture_View.setGestureColor(Color.CYAN);
		gesture_View.setGestureStrokeWidth(15);

		gesture_View
				.addOnGesturePerformedListener(new OnGesturePerformedListener() {

					@Override
					public void onGesturePerformed(GestureOverlayView overlay,
							Gesture gesture) {

						// 匹配识别库资源加载状态
						if (loadState) {

							// 获取画的图形进行匹配，匹配程度就是Prediction中的score
							ArrayList<Prediction> predictions = mGesturelib
									.recognize(gesture);

							if (predictions.size() > 0) {

								if (!predictions.isEmpty()) {

									Prediction prediction = predictions.get(0);
									Log.i("PredictionScore", "-->"
											+ prediction.score);

									// 匹配程度越高，score值越大
									if (prediction.score > 1.0) {

										Toast.makeText(
												activity_GestureDemo.this,
												"\t\t\t\t\t最佳匹配：\n"+
												"手势识别为：-->" + prediction.name
											  + "\n识别值(score)-->:"+ prediction.score,
												Toast.LENGTH_LONG).show();
									} 
									else{
										Toast.makeText(activity_GestureDemo.this,
												"手势匹配失败！", Toast.LENGTH_SHORT).show();
									}
								}

							}

						} else {
							Toast.makeText(activity_GestureDemo.this,
									"匹配库资源加载失败！", Toast.LENGTH_SHORT).show();

						}
					}
				});

	}
}
