package com.example.piao;

import java.io.Serializable;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

import com.example.been.InBeen;
import com.example.been.Progress;
import com.example.been.Register;
import com.example.piao.OutActivity.adapter;

import android.R.integer;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class DetailsActivity extends Activity implements OnClickListener {
	private TextView tv_detail_name, tv_detail_time, tv_detail_option1,
			tv_detail_option2, tv_detail_option3, tv_detail_sum1,
			tv_detail_sum2, tv_detail_sum3, tv_detail_explain,
			tv_datail_content, tv_option1, tv_option2, tv_option3;
	private ProgressBar pb_option1, pb_option2, pb_option3;
	private Button btn_ok;
	private ImageView details_title;
	private int count1 = 0, option1, count2 = 0, option2, count3 = 0, option3;
	List<InBeen> beens;
	int postion;
	private int len;
	private int sum, sum2, sum3, new_sum;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.details);
		setview();
		// Querylist();
	}

	private void Querybtn() {
		Bundle extras = getIntent().getExtras();
		postion = extras.getInt("postion");
		int int1 = getIntent().getIntExtra("intent", 0);
		int int2 = getIntent().getIntExtra("intent2", 0);
		int int3 = getIntent().getIntExtra("intent3", 0);
		new_sum = getIntent().getIntExtra("sum", 0);
		Log.i("intent new _sum", String.valueOf(new_sum));
		// int int1 = extras.getInt("intent");
		Log.i("int值", String.valueOf(int1));
		beens = (List<InBeen>) getIntent().getSerializableExtra("list");
		for (int i = 0; i < beens.size(); i++) {
			Log.i("lists", beens.get(i).getTitle());
			tv_datail_content.setText(beens.get(postion).getTitle().toString());
			tv_detail_option1.setText(beens.get(postion).getOption_one()
					.toString());
			tv_detail_option2.setText(beens.get(postion).getOption_two()
					.toString());
			tv_detail_option3.setText(beens.get(postion).getOption_three()
					.toString());
			tv_detail_explain.setText(beens.get(postion).getExplain());
		}
		pb_option1.setProgress(int1);
		tv_detail_sum1.setText(String.valueOf(new_sum));
		pb_option2.setProgress(int2);
		tv_detail_sum2.setText(String.valueOf(20));
		pb_option3.setProgress(int3);
		tv_detail_sum3.setText(String.valueOf(40));
		pb_option1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				len++;
				if (len == 1) {
					pb_option1.setProgress(pb_option1.getProgress() + 1);
					sum = 1;
					if (new_sum == 0) {
						tv_detail_sum1.setText(sum + "%");
					}
					if (new_sum != 0) {
						int new_String = 5 + new_sum;
						tv_detail_sum1.setText(String.valueOf(new_String) + "%");
					}
					Log.i("len=1", String.valueOf(len));
				}
				if (len == 2) {
					pb_option1.setProgress(pb_option1.getProgress() + 5);
					sum = 5;
					if (new_sum == 0) {
						tv_detail_sum1.setText(sum + "%");
					}
					if (new_sum != 0) {
						int new_String = 5 + new_sum;
						tv_detail_sum1.setText(String.valueOf(new_String) + "%");
					}
					Log.i("progerss1", String.valueOf(pb_option1.getProgress()));
					Log.i("len=2", String.valueOf(len));
				}
				if (len == 3) {
					pb_option1.setProgress(pb_option1.getProgress() + 5);
					sum = 10;
					if (new_sum == 0) {
						tv_detail_sum1.setText(sum + "%");
					}
					if (new_sum != 0) {
						int new_String = 5 + new_sum;
						tv_detail_sum1.setText(String.valueOf(new_String) + "%");
					}
					Log.i("progerss1_3",
							String.valueOf(pb_option1.getProgress()));
					Log.i("len=3", String.valueOf(len));
				}
				if (len == 4) {
					pb_option1.setProgress(pb_option1.getProgress() + 5);
					sum = 15;
					if (new_sum == 0) {
						tv_detail_sum1.setText(sum + "%");
					}
					if (new_sum != 0) {
						int new_String = 5 + new_sum;
						tv_detail_sum1.setText(String.valueOf(new_String) + "%");
					}
				}
				if (len == 5) {
					pb_option1.setProgress(pb_option1.getProgress() + 5);
					sum = 20;
					if (new_sum == 0) {
						tv_detail_sum1.setText(sum + "%");
					}
					if (new_sum != 0) {
						int new_String = 5 + new_sum;
						tv_detail_sum1.setText(String.valueOf(new_String) + "%");
					}
				}
				if (len == 6) {
					pb_option1.setProgress(pb_option1.getProgress() + 5);
					sum = 25;
					if (new_sum == 0) {
						tv_detail_sum1.setText(sum + "%");
					}
					if (new_sum != 0) {
						int new_String = 5 + new_sum;
						tv_detail_sum1.setText(String.valueOf(new_String) + "%");
					}
				}
				if (len == 7) {
					pb_option1.setProgress(pb_option1.getProgress() + 5);
					sum = 30;
					if (new_sum == 0) {
						tv_detail_sum1.setText(sum + "%");
					}
					if (new_sum != 0) {
						int new_String = 5 + new_sum;
						tv_detail_sum1.setText(String.valueOf(new_String) + "%");
					}
				}
				if (len == 8) {
					pb_option1.setProgress(pb_option1.getProgress() + 5);
					sum = 35;
					if (new_sum == 0) {
						tv_detail_sum1.setText(sum + "%");
					}
					if (new_sum != 0) {
						int new_String = 5 + new_sum;
						tv_detail_sum1.setText(String.valueOf(new_String) + "%");
					}
				}
				if (len == 9) {
					pb_option1.setProgress(pb_option1.getProgress() + 5);
					sum = 40;
					if (new_sum == 0) {
						tv_detail_sum1.setText(sum + "%");
					}
					if (new_sum != 0) {
						int new_String = 5 + new_sum;
						tv_detail_sum1.setText(String.valueOf(new_String) + "%");
					}
				}
				if (len == 10) {
					pb_option1.setProgress(pb_option1.getProgress() + 5);
					sum = 45;
					if (new_sum == 0) {
						tv_detail_sum1.setText(sum + "%");
					}
					if (new_sum != 0) {
						int new_String = 5 + new_sum;
						tv_detail_sum1.setText(String.valueOf(new_String) + "%");
					}
				}
				if (len == 11) {
					pb_option1.setProgress(pb_option1.getProgress() + 5);
					sum = 50;
					if (new_sum == 0) {
						tv_detail_sum1.setText(sum + "%");
					}
					if (new_sum != 0) {
						int new_String = 5 + new_sum;
						tv_detail_sum1.setText(String.valueOf(new_String) + "%");
					}
				}
				if (len == 12) {
					sum = 55;
					pb_option1.setProgress(pb_option1.getProgress() + 5);
					if (new_sum == 0) {
						tv_detail_sum1.setText(sum + "%");
					}
					if (new_sum != 0) {
						int new_String = 5 + new_sum;
						tv_detail_sum1.setText(String.valueOf(new_String) + "%");
					}
				}
				if (len == 13) {
					sum = 60;

					pb_option1.setProgress(pb_option1.getProgress() + 5);
					if (new_sum == 0) {
						tv_detail_sum1.setText(sum + "%");
					}
					if (new_sum != 0) {
						int new_String = 5 + new_sum;
						tv_detail_sum1.setText(String.valueOf(new_String) + "%");
					}
				}
				if (len == 14) {
					sum = 65;

					pb_option1.setProgress(pb_option1.getProgress() + 5);
					if (new_sum == 0) {
						tv_detail_sum1.setText(sum + "%");
					}
					if (new_sum != 0) {
						int new_String = 5 + new_sum;
						tv_detail_sum1.setText(String.valueOf(new_String) + "%");
					}
				}
				if (len == 15) {
					sum = 70;

					pb_option1.setProgress(pb_option1.getProgress() + 5);
					if (new_sum == 0) {
						tv_detail_sum1.setText(sum + "%");
					}
					if (new_sum != 0) {
						int new_String = 5 + new_sum;
						tv_detail_sum1.setText(String.valueOf(new_String) + "%");
					}
				}
				if (len == 16) {
					sum = 75;

					pb_option1.setProgress(pb_option1.getProgress() + 5);
					if (new_sum == 0) {
						tv_detail_sum1.setText(sum + "%");
					}
					if (new_sum != 0) {
						int new_String = 5 + new_sum;
						tv_detail_sum1.setText(String.valueOf(new_String) + "%");
					}
				}
				if (len == 17) {
					sum = 80;

					pb_option1.setProgress(pb_option1.getProgress() + 5);
					if (new_sum == 0) {
						tv_detail_sum1.setText(sum + "%");
					}
					if (new_sum != 0) {
						int new_String = 5 + new_sum;
						tv_detail_sum1.setText(String.valueOf(new_String) + "%");
					}
				}
				if (len == 18) {
					sum = 85;

					pb_option1.setProgress(pb_option1.getProgress() + 5);
					if (new_sum == 0) {
						tv_detail_sum1.setText(sum + "%");
					}
					if (new_sum != 0) {
						int new_String = 5 + new_sum;
						tv_detail_sum1.setText(String.valueOf(new_String) + "%");
					}
				}
				if (len == 19) {
					sum = 90;

					pb_option1.setProgress(pb_option1.getProgress() + 5);
					if (new_sum == 0) {
						tv_detail_sum1.setText(sum + "%");
					}
					if (new_sum != 0) {
						int new_String = 5 + new_sum;
						tv_detail_sum1.setText(String.valueOf(new_String) + "%");
					}
				}
				if (len == 20) {
					sum = 95;
					pb_option1.setProgress(pb_option1.getProgress() + 5);
					if (new_sum == 0) {
						tv_detail_sum1.setText(sum + "%");
					}
					if (new_sum != 0) {
						int new_String = 5 + new_sum;
						tv_detail_sum1.setText(String.valueOf(new_String) + "%");
					}
				}
			}
		});
		pb_option2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				count2++;
				if (count2 == 1) {
					pb_option2.setProgress(pb_option2.getProgress() + 1);
					tv_detail_sum1.setText("1%");
				}
				if (count2 == 2) {
					pb_option2.setProgress(pb_option2.getProgress() + 5);
					tv_detail_sum1.setText("6%");

				}
				if (count2 == 3) {
					pb_option2.setProgress(pb_option2.getProgress() + 5);
					tv_detail_sum1.setText("11%");
				}
				if (count2 == 4) {
					pb_option2.setProgress(pb_option2.getProgress() + 5);
					tv_detail_sum1.setText("15%");

				}
				if (count2 == 5) {
					pb_option2.setProgress(pb_option2.getProgress() + 5);
					tv_detail_sum1.setText("20%");

				}
				if (count2 == 6) {
					pb_option2.setProgress(pb_option2.getProgress() + 5);
					tv_detail_sum1.setText("25%");

				}
				if (count2 == 7) {
					pb_option2.setProgress(pb_option2.getProgress() + 5);
					tv_detail_sum1.setText("30%");

				}
				if (count2 == 8) {
					pb_option2.setProgress(pb_option2.getProgress() + 5);
					tv_detail_sum1.setText("35%");

				}
				if (count2 == 9) {
					pb_option2.setProgress(pb_option2.getProgress() + 5);
					tv_detail_sum1.setText("40%");

				}
				if (count2 == 10) {
					pb_option2.setProgress(pb_option2.getProgress() + 5);
					tv_detail_sum1.setText("45%");

				}
				if (count2 == 11) {
					pb_option2.setProgress(pb_option2.getProgress() + 5);
					tv_detail_sum1.setText("50%");

				}
				if (count2 == 12) {
					pb_option2.setProgress(pb_option2.getProgress() + 5);
					tv_detail_sum1.setText("55%");

				}
				if (count2 == 13) {
					pb_option2.setProgress(pb_option2.getProgress() + 5);
					tv_detail_sum1.setText("60%");

				}
				if (count2 == 14) {
					pb_option2.setProgress(pb_option2.getProgress() + 5);
					tv_detail_sum1.setText("65%");

				}
				if (count2 == 15) {
					pb_option2.setProgress(pb_option2.getProgress() + 5);
					tv_detail_sum1.setText("70%");

				}
				if (count2 == 16) {
					pb_option2.setProgress(pb_option2.getProgress() + 5);
					tv_detail_sum1.setText("75%");

				}
				if (count2 == 17) {
					pb_option2.setProgress(pb_option2.getProgress() + 5);
					tv_detail_sum1.setText("80%");

				}
				if (count2 == 18) {
					pb_option2.setProgress(pb_option2.getProgress() + 5);
					tv_detail_sum1.setText("85%");

				}
				if (count2 == 19) {
					pb_option2.setProgress(pb_option2.getProgress() + 5);
					tv_detail_sum1.setText("90%");

				}
				if (count2 == 20) {
					pb_option2.setProgress(pb_option2.getProgress() + 5);
					tv_detail_sum1.setText("95%");

				}
			}
		});
		pb_option3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				count3++;
				if (count3 == 1) {
					pb_option3.setProgress(pb_option3.getProgress() + 1);
					tv_detail_sum1.setText("1%");
				}
				if (count3 == 2) {
					pb_option3.setProgress(pb_option3.getProgress() + 5);
					tv_detail_sum1.setText("6%");

				}
				if (count3 == 3) {
					pb_option3.setProgress(pb_option3.getProgress() + 5);
					tv_detail_sum1.setText("11%");
				}
				if (count3 == 4) {
					pb_option3.setProgress(pb_option3.getProgress() + 5);
					tv_detail_sum1.setText("15%");

				}
				if (count3 == 5) {
					pb_option3.setProgress(pb_option3.getProgress() + 5);
					tv_detail_sum1.setText("20%");

				}
				if (count3 == 6) {
					pb_option3.setProgress(pb_option3.getProgress() + 5);
					tv_detail_sum1.setText("25%");

				}
				if (count3 == 7) {
					pb_option3.setProgress(pb_option3.getProgress() + 5);
					tv_detail_sum1.setText("30%");

				}
				if (count3 == 8) {
					pb_option3.setProgress(pb_option3.getProgress() + 5);
					tv_detail_sum1.setText("35%");

				}
				if (count3 == 9) {
					pb_option3.setProgress(pb_option3.getProgress() + 5);
					tv_detail_sum1.setText("40%");

				}
				if (count3 == 10) {
					pb_option3.setProgress(pb_option3.getProgress() + 5);
					tv_detail_sum1.setText("45%");

				}
				if (count3 == 11) {
					pb_option3.setProgress(pb_option3.getProgress() + 5);
					tv_detail_sum1.setText("50%");

				}
				if (count3 == 12) {
					pb_option3.setProgress(pb_option3.getProgress() + 5);
					tv_detail_sum1.setText("55%");

				}
				if (count3 == 13) {
					pb_option3.setProgress(pb_option3.getProgress() + 5);
					tv_detail_sum1.setText("60%");

				}
				if (count3 == 14) {
					pb_option3.setProgress(pb_option3.getProgress() + 5);
					tv_detail_sum1.setText("65%");

				}
				if (count3 == 15) {
					pb_option3.setProgress(pb_option3.getProgress() + 5);
					tv_detail_sum1.setText("70%");

				}
				if (count3 == 16) {
					pb_option3.setProgress(pb_option3.getProgress() + 5);
					tv_detail_sum1.setText("75%");

				}
				if (count3 == 17) {
					pb_option3.setProgress(pb_option3.getProgress() + 5);
					tv_detail_sum1.setText("80%");

				}
				if (count3 == 18) {
					pb_option3.setProgress(pb_option3.getProgress() + 5);
					tv_detail_sum1.setText("85%");
				}
				if (count3 == 19) {
					pb_option3.setProgress(pb_option3.getProgress() + 5);
					tv_detail_sum1.setText("90%");

				}
				if (count3 == 20) {
					pb_option3.setProgress(pb_option3.getProgress() + 5);
					tv_detail_sum1.setText("95%");
				}
			}
		});
		details_title.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				int progress = pb_option1.getProgress();
				int progress2 = pb_option2.getProgress();
				int progress3 = pb_option3.getProgress();
				Log.i("back方法", String.valueOf(progress));
				Intent intent = getIntent();
				intent.putExtra("back", progress);
				intent.putExtra("back2", progress2);
				intent.putExtra("back3", progress3);
				intent.putExtra("sum", sum);
				setResult(2, intent);
				DetailsActivity.this.finish();
			}
		});
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
		details_title = (ImageView) findViewById(R.id.details_title);
		Querybtn();
	}

	// class tvclicklistener1 implements OnClickListener {
	//
	// @Override
	// public void onClick(View arg0) {
	//
	// count1++;
	// tv_option1.setBackgroundColor(Color.BLUE);
	// }
	//
	// }
	//
	// class tvclicklistener2 implements OnClickListener {
	//
	// @Override
	// public void onClick(View arg0) {
	// count2++;
	// tv_option2.setBackgroundColor(Color.BLUE);
	//
	// }
	//
	// }
	//
	// class tvclicklistener3 implements OnClickListener {
	//
	// @Override
	// public void onClick(View arg0) {
	// count3++;
	// tv_option3.setBackgroundColor(Color.BLUE);
	//
	// }
	//
	// }
	//
	// class btnclicklistener implements OnClickListener {
	//
	// @Override
	// public void onClick(View arg0) {
	// tv_option1.setVisibility(View.GONE);
	// tv_option2.setVisibility(View.GONE);
	// tv_option3.setVisibility(View.GONE);
	// btn_ok.setVisibility(View.GONE);
	// tv_detail_option1.setVisibility(View.VISIBLE);
	// tv_detail_option2.setVisibility(View.VISIBLE);
	// tv_detail_option3.setVisibility(View.VISIBLE);
	// tv_detail_sum1.setVisibility(View.VISIBLE);
	// tv_detail_sum2.setVisibility(View.VISIBLE);
	// tv_detail_sum3.setVisibility(View.VISIBLE);
	// pb_option1.setVisibility(View.VISIBLE);
	// pb_option2.setVisibility(View.VISIBLE);
	// pb_option3.setVisibility(View.VISIBLE);
	// Bundle extras = getIntent().getExtras();
	// postion = extras.getInt("postion");
	// beens = (List<InBeen>) getIntent().getSerializableExtra("list");
	// for (int i = 0; i < beens.size(); i++) {
	// Log.i("lists", beens.get(i).getTitle());
	// tv_detail_option1.setText(beens.get(postion).getOption_one()
	// .toString());
	// tv_detail_option2.setText(beens.get(postion).getOption_two()
	// .toString());
	// tv_detail_option3.setText(beens.get(postion).getOption_three()
	// .toString());
	// }
	// final Progress progress = new Progress();
	// progress.setLen1(count1);
	// progress.setLen2(count2);
	// progress.setLen3(count3);
	// progress.save(getApplicationContext(), new SaveListener() {
	// @Override
	// public void onSuccess() {
	//
	// }
	//
	// @Override
	// public void onFailure(int arg0, String arg1) {
	// }
	// });
	// BmobQuery<Progress> query = new BmobQuery<Progress>();
	// query.findObjects(getApplicationContext(),
	// new FindListener<Progress>() {
	// @Override
	// public void onError(int arg0, String arg1) {
	// }
	//
	// @Override
	// public void onSuccess(List<Progress> arg0) {
	// for (int i = 0; i < arg0.size(); i++) {
	// int len1 = arg0.get(i).getLen1();
	// int len2 = arg0.get(i).getLen2();
	// int len3 = arg0.get(i).getLen2();
	// tv_detail_sum1.setText(String.valueOf(len1));
	// tv_detail_sum2.setText(String.valueOf(len2));
	// tv_detail_sum3.setText(String.valueOf(len3));
	// pb_option1.setProgress(len1);
	// pb_option2.setProgress(len2);
	// pb_option3.setProgress(len3);
	// }
	// }
	// });
	//
	// }
	// }

	// private void Querylist() {
	// Bundle extras = getIntent().getExtras();
	// int postion = extras.getInt("postion");
	// List<InBeen> beens = (List<InBeen>) getIntent().getSerializableExtra(
	// "list");
	// for (int i = 0; i < beens.size(); i++) {
	// Log.i("lists", beens.get(i).getTitle());
	// tv_datail_content.setText(beens.get(postion).getTitle().toString());
	// tv_detail_option1.setText(beens.get(postion).getOption_one()
	// .toString());
	// tv_detail_option2.setText(beens.get(postion).getOption_two()
	// .toString());
	// tv_detail_option3.setText(beens.get(postion).getOption_three()
	// .toString());
	// tv_detail_explain.setText(beens.get(postion).getExplain());
	// }
	// pb_option1.setMax(100);
	// pb_option1.getProgress();
	// pb_option1.setProgress(pb_option1.getProgress());
	// pb_option1.setOnClickListener(new OnClickListener() {
	// @Override
	// public void onClick(View arg0) {
	// Progress progress = new Progress();
	// progress.setLen(1);
	// pb_option1.incrementProgressBy(pb_option1.getProgress()
	// + progress.getLen());
	// int sum = 1;
	// if (sum == 1) {
	// tv_detail_sum1.setText(String.valueOf(sum));
	// } else {
	// tv_detail_sum1.setText(String.valueOf(sum + 1));
	// }
	// pb_option2.setProgress(10);
	// int sum2 = 1;
	// if (sum2 == 1) {
	// tv_detail_sum2.setText(String.valueOf(sum2));
	// } else {
	// tv_detail_sum2.setText(String.valueOf(sum2 + 1));
	// }
	// pb_option3.setProgress(10);
	// int sum3 = 1;
	// if (sum3 == 1) {
	// tv_detail_sum3.setText(String.valueOf(sum3));
	// } else {
	// tv_detail_sum3.setText(String.valueOf(sum3 + 1));
	// }
	//
	// }
	// });
	// }
	//
	// private void Queryout() {
	// BmobQuery<InBeen> query = new BmobQuery<>();
	// query.order("-createdAt");
	// query.findObjects(getApplicationContext(), new FindListener<InBeen>() {
	//
	// @Override
	// public void onError(int arg0, String arg1) {
	//
	// }
	//
	// @Override
	// public void onSuccess(List<InBeen> arg0) {
	// for (int i = 0; i < arg0.size(); i++) {
	// tv_datail_content
	// .setText(arg0.get(i).getTitle().toString());
	// tv_detail_option1.setText(arg0.get(i).getOption_one()
	// .toString());
	// tv_detail_option2.setText(arg0.get(i).getOption_two()
	// .toString());
	// tv_detail_option3.setText(arg0.get(i).getOption_three()
	// .toString());
	// tv_detail_explain.setText(arg0.get(i).getExplain());
	// }
	// pb_option1.setMax(100);
	// pb_option1.setOnClickListener(new OnClickListener() {
	//
	// @Override
	// public void onClick(View arg0) {
	// pb_option1.setProgress(10);
	// int sum = 1;
	// if (sum == 1) {
	// tv_detail_sum1.setText(String.valueOf(sum));
	// } else {
	// tv_detail_sum1.setText(String.valueOf(sum + 1));
	// }
	//
	// }
	// });
	// }
	// });
	// }

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

	}
}
