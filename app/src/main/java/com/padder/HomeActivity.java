package com.padder;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HomeActivity extends Activity {

	private ViewGroup content;
	private TextView profileTab;
	private ViewGroup profilePage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		content = (ViewGroup) findViewById(R.id.home_content);
		profileTab = (TextView) findViewById(R.id.home_profile_tab);

		getLayoutInflater().inflate(R.layout.activity_login, content);
		profilePage = (ViewGroup) findViewById(R.id.login_layout);
		profilePage.setVisibility(View.GONE);

		setHomeListener();

	}

	private void setHomeListener() {

		profileTab.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				profilePage.setVisibility(View.VISIBLE);

			}

		});

	}

}
