package com.example.piao;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

import com.example.been.InBeen;
import com.example.piao.OutActivity.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class DetailsActivity extends Activity {
	private TextView tv_detail_name, tv_detail_time, tv_detail_option1,
			tv_detail_option2, tv_detail_option3, tv_detail_sum1,
			tv_detail_sum2, tv_detail_sum3, tv_detail_explain,
			tv_datail_content;
	private ProgressBar pb_option1, pb_option2, pb_option3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.details);
		setview();
		Queryout();
	}

	private void setview() {
		tv_datail_content = (TextView) findViewById(R.id.tv_detail_content);
		tv_detail_option1 = (TextView) findViewById(R.id.tv_detail_option1);
		tv_detail_option3 = (TextView) findViewById(R.id.tv_detail_option3);
		tv_detail_option2 = (TextView) findViewById(R.id.tv_detail_option2);
		tv_detail_explain = (TextView) findViewById(R.id.tv_explain);
		tv_detail_sum1 = (TextView) findViewById(R.id.sum);
		tv_detail_sum2 = (TextView) findViewById(R.id.sum2);
		tv_detail_sum3 = (TextView) findViewById(R.id.sum3);
		pb_option1 = (ProgressBar) findViewById(R.id.pb_option1);
		pb_option2 = (ProgressBar) findViewById(R.id.pb_option2);
		pb_option3 = (ProgressBar) findViewById(R.id.pb_option3);
	}

	private void Queryout() {
		BmobQuery<InBeen> query = new BmobQuery<>();
		query.order("-createdAt");
		query.findObjects(getApplicationContext(), new FindListener<InBeen>() {

			@Override
			public void onError(int arg0, String arg1) {

			}

			@Override
			public void onSuccess(List<InBeen> arg0) {
				for (int i = 0; i < arg0.size(); i++) {
					tv_datail_content
							.setText(arg0.get(i).getTitle().toString());
					tv_detail_option1.setText(arg0.get(i).getOption_one()
							.toString());
					tv_detail_option2.setText(arg0.get(i).getOption_two()
							.toString());
					tv_detail_option3.setText(arg0.get(i).getOption_three()
							.toString());
					tv_detail_explain.setText(arg0.get(i).getExplain());
				}
				pb_option1.setMax(100);
				pb_option1.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						pb_option1.setProgress(10);
					}
				});
			}
		});
	}
}
