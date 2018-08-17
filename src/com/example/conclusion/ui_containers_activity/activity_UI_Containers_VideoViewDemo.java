package com.example.conclusion.ui_containers_activity;

import com.example.conclusion.R;
import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class activity_UI_Containers_VideoViewDemo extends Activity implements OnClickListener {

	Button btn_play, btn_pause, btn_resume, btn_stop;
	VideoView videoview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ui_containers_videoview_demo);

		initView();
		initvideoview();

	}

	//加载view资源
	private void initView() {
		videoview = (VideoView) findViewById(R.id.videoView_containers_VideoViewDemo);
		btn_play = (Button) findViewById(R.id.btn_containers_VideoViewDemo_play);
		btn_pause = (Button) findViewById(R.id.btn_containers_VideoViewDemo_pause);
		btn_resume = (Button) findViewById(R.id.btn_containers_VideoViewDemo_resume);
		btn_stop = (Button) findViewById(R.id.btn_containers_VideoViewDemo_stop);
		btn_play.setOnClickListener(this);
		btn_pause.setOnClickListener(this);
		btn_resume.setOnClickListener(this);
		btn_stop.setOnClickListener(this);
	}

	//加载videoview资源
	private void initvideoview() {
		String localpath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/videoviewdemo.mp4";

		Uri uri = Uri.parse("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");

		MediaController controller = new MediaController(this);
		videoview.setMediaController(controller);
		controller.setMediaPlayer(videoview);

		videoview.setOnCompletionListener(new OnCompletionListener() {

			@Override
			public void onCompletion(MediaPlayer mp) {
				// TODO Auto-generated method stub
				Toast.makeText(activity_UI_Containers_VideoViewDemo.this, "播放完了！", Toast.LENGTH_SHORT).show();
			}
		});

		//本地播放
		//videoview.setVideoPath(localpath);

		//在线播放
		 videoview.setVideoURI(uri);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_containers_VideoViewDemo_play: {
			videoview.start();
			Toast.makeText(activity_UI_Containers_VideoViewDemo.this, "start", 0).show();
		}
			break;
		case R.id.btn_containers_VideoViewDemo_pause:
			if (videoview.isPlaying()) {
				videoview.pause();
				Toast.makeText(activity_UI_Containers_VideoViewDemo.this, "pause", 0).show();
			}
			break;
		case R.id.btn_containers_VideoViewDemo_resume: {
			videoview.resume();
			Toast.makeText(activity_UI_Containers_VideoViewDemo.this, "resume", 0).show();
		}
			break;
		case R.id.btn_containers_VideoViewDemo_stop: {
			videoview.stopPlayback();
			Toast.makeText(activity_UI_Containers_VideoViewDemo.this, "stop", 0).show();
		}
			break;
		}

	}

}
