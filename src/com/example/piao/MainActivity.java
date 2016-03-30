package com.example.piao;

import cn.bmob.v3.Bmob;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Build;

public class MainActivity extends Activity {
	Button bt_in, bt_out;
	public static final String APP_ID = "98b20fe235f525721eb0f46a14c64f03";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Bmob.initialize(this, APP_ID);

		setView();
	}

	private void setView() {
		bt_in = (Button) findViewById(R.id.bt_In);
		bt_in.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this, InActivity.class);
				startActivity(intent);
			}
		});
		bt_out = (Button) findViewById(R.id.bt_out);
	}

}
