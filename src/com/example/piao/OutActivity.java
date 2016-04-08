package com.example.piao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.bmob.btp.e.a.in;
import com.example.been.InBeen;
import com.example.been.Register;
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
	int int1, int2, int3;
	int sum, sum2, sum3;
	private static final int REQUESTCODE = 1;

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
				final List<InBeen> lists = arg0;
				out_listView.setAdapter(new adapter(getApplicationContext(),
						lists));
				out_listView.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						Register register = new Register();
						// if
						// (lists.get(arg2).equals(register.getRegister_name()))
						// {
						Intent intent = new Intent(OutActivity.this,
								DetailsActivity.class);
						Bundle bundle = new Bundle();
						bundle.putInt("postion", arg2);
						intent.putExtra("list", (Serializable) lists);
						intent.putExtra("intent", int1);
						intent.putExtra("intent2", int2);
						intent.putExtra("intent3", int3);
						intent.putExtra("sum", sum);
						Log.v("第一个activity的int值", String.valueOf(int1));
						intent.putExtras(bundle);
						startActivityForResult(intent, REQUESTCODE);
						// }
					}
				});
			}

			@Override
			public void onError(int arg0, String arg1) {

			}
		});

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub super.onActivityResult(requestCode,
		// resultCode, data);
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == 2) {
			Log.i("resultcode", String.valueOf(requestCode + resultCode));
			if (requestCode == REQUESTCODE) {
				int1 = data.getIntExtra("back", 0);
				int2 = data.getIntExtra("back2", 0);
				int3 = data.getIntExtra("back3", 0);
				sum = data.getIntExtra("sum", 0);
				Log.i("back", String.valueOf(int1));
			}
		}
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
