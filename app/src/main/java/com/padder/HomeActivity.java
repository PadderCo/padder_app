package com.padder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class HomeActivity extends Activity {

	private LayoutInflater layoutInflater;

	private ViewGroup coreLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		coreLayout = (ViewGroup) findViewById(R.id.home_layout);
		layoutInflater = getLayoutInflater();

		setHomeListener();

	}

	private void setHomeListener() {

		final TextView profileButton = (TextView) findViewById(R.id.home_profile_button);

		profileButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				ViewGroup content = (ViewGroup) findViewById(R.id.home_content);
				layoutInflater.inflate(R.layout.activity_login, content);

			}

		});

	}

}
