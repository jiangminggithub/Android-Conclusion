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

		// �ļ���ʽ�м���ʶ��⣬��Ҫ��gesturesʹ��Gestures Builder���������ļ������ָ���ļ�Ŀ¼��
		// mGesturelib = GestureLibraries.fromFile(mStoreFile);
		// loadState = mGesturelib.load();

		// ��res-->raw�ļ��л�ȡʶ���,gestures�ļ�����ʹ��Gestures Builder���������ļ� 
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

						// ƥ��ʶ�����Դ����״̬
						if (loadState) {

							// ��ȡ����ͼ�ν���ƥ�䣬ƥ��̶Ⱦ���Prediction�е�score
							ArrayList<Prediction> predictions = mGesturelib
									.recognize(gesture);

							if (predictions.size() > 0) {

								if (!predictions.isEmpty()) {

									Prediction prediction = predictions.get(0);
									Log.i("PredictionScore", "-->"
											+ prediction.score);

									// ƥ��̶�Խ�ߣ�scoreֵԽ��
									if (prediction.score > 1.0) {

										Toast.makeText(
												activity_GestureDemo.this,
												"\t\t\t\t\t���ƥ�䣺\n"+
												"����ʶ��Ϊ��-->" + prediction.name
											  + "\nʶ��ֵ(score)-->:"+ prediction.score,
												Toast.LENGTH_LONG).show();
									} 
									else{
										Toast.makeText(activity_GestureDemo.this,
												"����ƥ��ʧ�ܣ�", Toast.LENGTH_SHORT).show();
									}
								}

							}

						} else {
							Toast.makeText(activity_GestureDemo.this,
									"ƥ�����Դ����ʧ�ܣ�", Toast.LENGTH_SHORT).show();

						}
					}
				});

	}
}
