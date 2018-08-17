package com.example.conclusion.ui_containers_activity;

import com.example.conclusion.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

public class activity_UI_Containers_GalleryDemo extends Activity {

	Gallery gallery;
	int[] imageitems = new int[] { R.drawable.containers_gridview_imgdemo1, R.drawable.containers_gridview_imgdemo4,
			R.drawable.containers_gridview_imgdemo5, R.drawable.containers_gridview_imgdemo7,
			R.drawable.containers_gridview_imgdemo8, R.drawable.containers_gridview_imgdemo9 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ui_containers_gallery);
		gallery = (Gallery) findViewById(R.id.gallery_containers_GalleryDemo);

		gallery.setAdapter(new imgAdapter());

		gallery.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				int resultposition = position + 1;
				Toast.makeText(activity_UI_Containers_GalleryDemo.this, "你选择了第：" + resultposition + "张图片！",
						Toast.LENGTH_SHORT).show();
			}
		});

	}

	class imgAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return imageitems.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return imageitems[position];
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return imageitems[position];
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ImageView img = new ImageView(activity_UI_Containers_GalleryDemo.this);
			img.setImageResource(imageitems[position]);
			return img;
		}

	}
}
