package com.example.piao;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

import com.example.been.InBeen;
import com.example.been.Login;
import com.example.been.Register;
import com.example.piao.OutActivity.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class LoginActivity extends Activity {
	private EditText login_name, login_psd, register_name, register_psd,
			register_psd2;
	private ImageView iv_login;
	private Button bt_login_top, bt_register_top, bt_login, bt_register;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		setview();
	}

	private void setview() {
		login_name = (EditText) findViewById(R.id.et_login_name);
		login_psd = (EditText) findViewById(R.id.et_login_psd);
		register_name = (EditText) findViewById(R.id.et_register_name);
		register_psd = (EditText) findViewById(R.id.et_register_psd);
		register_psd2 = (EditText) findViewById(R.id.et_register_psd2);
		iv_login = (ImageView) findViewById(R.id.iv_login);
		bt_login = (Button) findViewById(R.id.bt_login);
		bt_login_top = (Button) findViewById(R.id.bt_login_name);
		bt_register_top = (Button) findViewById(R.id.bt_register_name);
		bt_register = (Button) findViewById(R.id.bt_register);
		bt_register_top.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				login_name.setVisibility(View.GONE);
				login_psd.setVisibility(View.GONE);
				bt_login.setVisibility(View.GONE);
				register_name.setVisibility(View.VISIBLE);
				register_psd.setVisibility(View.VISIBLE);
				register_psd2.setVisibility(View.VISIBLE);
				bt_register.setVisibility(View.VISIBLE);

			}
		});
		bt_register.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				String et_register_name = register_name.getText().toString();
				String et_register_psd = register_psd.getText().toString();
				String et_register_psd2 = register_psd2.getText().toString();
				Register register = new Register();
				register.setRegister_name(et_register_name);
				register.setRegister_psd(et_register_psd);
				register.setRegister_psd2(et_register_psd2);
				register.save(getApplicationContext(), new SaveListener() {

					@Override
					public void onSuccess() {
						Toast.makeText(getApplicationContext(), "恭喜你！注册成功！！", 1)
								.show();
					}

					@Override
					public void onFailure(int arg0, String arg1) {
						Toast.makeText(getApplicationContext(), "请检查网络，注册失败！",
								1).show();
					}
				});
			}
		});
		bt_login_top.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				login_name.setVisibility(View.VISIBLE);
				login_psd.setVisibility(View.VISIBLE);
				bt_login.setVisibility(View.VISIBLE);
				register_name.setVisibility(View.GONE);
				register_psd.setVisibility(View.GONE);
				register_psd2.setVisibility(View.GONE);
				bt_register.setVisibility(View.GONE);
			}
		});
		bt_login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				final String et_login_name = login_name.getText().toString();
				final String et_login_psd = login_psd.getText().toString();
				if (et_login_name.equals(" ") && et_login_psd.equals(" ")) {
					Toast.makeText(getApplicationContext(), "用户名和密码不能为空！", 1)
							.show();
				}
				BmobQuery<Register> query = new BmobQuery<Register>();
				query.findObjects(getApplicationContext(),
						new FindListener<Register>() {

							@Override
							public void onError(int arg0, String arg1) {
								Toast.makeText(getApplicationContext(),
										"请检查网络，登录失败！", 1).show();
							}

							@Override
							public void onSuccess(List<Register> arg0) {
								for (int i = 0; i < arg0.size(); i++) {
									String find_name = arg0.get(i)
											.getRegister_name();
									String find_psd = arg0.get(i)
											.getRegister_psd();
									if (et_login_name.equals(find_name)
											&& et_login_psd.equals(find_psd)) {
										Toast.makeText(getApplicationContext(),
												"登录成功", 1).show();
										try {
											Thread.sleep(2000);
											Intent intent = new Intent();
											intent.setClass(
													getApplicationContext(),
													MainActivity.class);
											startActivity(intent);
										} catch (InterruptedException e) {
											e.printStackTrace();
										}

									}
								}
							}
						});
			}
		});

	}
}
