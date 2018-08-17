package com.example.conclusion.ui_widgets_activity;

import com.example.conclusion.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class activity_UI_Widgets_WebViewDemo extends Activity {
	WebView wv_UI_WebViewDemo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ui_widgets_webview_demo);
		
		wv_UI_WebViewDemo=(WebView) findViewById(R.id.wv_UI_WebViewDemo);
		
		wv_UI_WebViewDemo.getSettings().setJavaScriptEnabled(true);
		
		wv_UI_WebViewDemo.setWebViewClient(new WebViewClient(){
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}
		});
		wv_UI_WebViewDemo.loadUrl("http://www.baidu.com");
		
		
	}
	//返回键
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK) && wv_UI_WebViewDemo.canGoBack()) {

            wv_UI_WebViewDemo.goBack(); // goBack()表示返回WebView的上一页面
            return true;
        }
		return super.onKeyDown(keyCode, event);
	}

}
