package com.example.piao;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.listener.SaveListener;

import com.bmob.btp.e.a.in;
import com.example.been.InBeen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InActivity extends Activity {
	private EditText et_title, optionone, optiontwo, optionthree, et_content;
	private Button bt_commit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.in);
		setView();

	}

	private void setView() {
		et_title = (EditText) findViewById(R.id.et_title);
		optionone = (EditText) findViewById(R.id.optionone);
		optiontwo = (EditText) findViewById(R.id.optiontwo);
		optionthree = (EditText) findViewById(R.id.optionthree);
		et_content = (EditText) findViewById(R.id.et_content);
		bt_commit = (Button) findViewById(R.id.commit);
		bt_commit.setOnClickListener(new btnonclicklistener());
	}

	class btnonclicklistener implements OnClickListener {

		@Override
		public void onClick(View arg0) {
			final InBeen inBeen = new InBeen();
			String Intitle = et_title.getText().toString().trim();
			String Inoptionone = optionone.getText().toString().trim();
			String Inoptiontwo = optiontwo.getText().toString().trim();
			String Inoptionthree = optionthree.getText().toString().trim();
			String Inexplain = et_content.getText().toString().trim();
			inBeen.setTitle(Intitle);
			inBeen.setOption_one(Inoptionone);
			inBeen.setOption_two(Inoptiontwo);
			inBeen.setOption_three(Inoptionthree);
			inBeen.setExplain(Inexplain);
			inBeen.save(InActivity.this, new SaveListener() {

				@Override
				public void onSuccess() {
					Toast.makeText(getApplicationContext(),
							"添加数据成功，返回的object为：" + inBeen.getObjectId(), 1)
							.show();
					Intent intent = new Intent();
					intent.setClass(InActivity.this, OutActivity.class);
					startActivity(intent);
				}

				@Override
				public void onFailure(int arg0, String arg1) {
					Toast.makeText(getApplicationContext(), "创建数据失败:" + arg1, 1)
							.show();
				}
			});
		}
	}
}
