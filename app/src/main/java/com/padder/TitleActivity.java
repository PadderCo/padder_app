package com.padder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

public class TitleActivity extends Activity {

	private Animation blink;
	private TextView blinkMessage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_title);

		blink = new AlphaAnimation(0.0f, 1.0f);
		blink.setDuration(600);
		blink.setRepeatMode(Animation.REVERSE);
		blink.setRepeatCount(4);
		blink.setAnimationListener(new Animation.AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {
				//do nothing
			}

			@Override
			public void onAnimationEnd(Animation animation) {

				Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
				startActivity(intent);

			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				//do nothing
			}

		});

		blinkMessage = (TextView) findViewById(R.id.title_message);
		blinkMessage.startAnimation(blink);

	}

}
