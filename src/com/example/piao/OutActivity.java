package com.example.piao;

import java.util.ArrayList;
import java.util.List;

import com.example.been.InBeen;
import com.example.piao.R.drawable;
import com.example.piao.R.layout;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class OutActivity extends Activity {
	private ListView out_listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.out);
		setview();
	}

	private void Queryout() {
		BmobQuery<InBeen> query = new BmobQuery<>();
		query.order("-createdAt");
		query.findObjects(this, new FindListener<InBeen>() {

			@Override
			public void onSuccess(List<InBeen> arg0) {
				List<InBeen> lists = arg0;
				out_listView.setAdapter(new adapter(getApplicationContext(),
						lists));
				out_listView.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						Intent intent = new Intent();
						intent.setClass(getApplicationContext(),
								DetailsActivity.class);
						startActivity(intent);

					}
				});
			}

			@Override
			public void onError(int arg0, String arg1) {

			}
		});

	}

	private void setview() {
		out_listView = (ListView) findViewById(R.id.out_listview);
		Queryout();
		// Log.v("66", String.valueOf(lists.size()));
	}

	class adapter extends BaseAdapter {
		LayoutInflater mInflater;
		private List<InBeen> minBeens;

		public adapter(Context context, List<InBeen> beens) {
			this.mInflater = LayoutInflater.from(context);
			this.minBeens = beens;
		}

		@Override
		public int getCount() {
			return minBeens.size();
		}

		@Override
		public Object getItem(int arg0) {
			return minBeens.get(arg0);
		}

		@Override
		public long getItemId(int arg0) {
			return arg0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			Viewholder viewholder;
			if (arg1 == null) {
				viewholder = new Viewholder();
				arg1 = mInflater.inflate(R.layout.out_item, null);
				// viewholder.iv_title = (ImageView) arg1
				// .findViewById(R.id.iv_head);
				viewholder.username = (TextView) arg1
						.findViewById(R.id.tv_vote_title);
				viewholder.password = (TextView) arg1
						.findViewById(R.id.tv_vote_title2);
				viewholder.content = (TextView) arg1
						.findViewById(R.id.tv_vote_content);
				arg1.setTag(viewholder);
			} else {
				viewholder = (Viewholder) arg1.getTag();
			}
			// for (int i = 0; i < lists.size(); i++) {
			// String title = lists.get(i).getTitle();
			// Log.i("lists.gettitle", title);
			// }
			String title = minBeens.get(arg0).getTitle();
			viewholder.content.setText(title);
			// viewholder.iv_title.setBackgroundDrawable(drawable.ic_launcher);
			return arg1;
		}
	}

	private class Viewholder {
		private TextView username;
		private TextView password;
		private TextView content;
		private ImageView iv_title;

	}
}
