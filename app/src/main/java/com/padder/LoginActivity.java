package com.padder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends Activity {

	private EditText usernameEditText;
	private EditText passwordEditText;
	private Button signupButton;
	private Button loginButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		usernameEditText = (EditText) findViewById(R.id.login_username);
		passwordEditText = (EditText) findViewById(R.id.login_password);
		signupButton = (Button) findViewById(R.id.login_signup_button);
		loginButton = (Button) findViewById(R.id.login_login_button);

		setSignUpListener();
		setLoginListener();

		//Parse.initialize(getApplicationContext(), );

	}

	private void setSignUpListener() {

		signupButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {


			}

		});

	}

	private void setLoginListener() {

		loginButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				final String username = usernameEditText.getText().toString().trim();
				final String password = passwordEditText.getText().toString().trim();

				ParseUser.logInInBackground(username, password, new LogInCallback() {

					@Override
					public void done(ParseUser parseUser, ParseException e) {

						if (parseUser != null) {

							Bundle b = new Bundle();
							b.putString("username", username);
							b.putString("password", password);

							Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
							intent.putExtras(b);
							startActivity(intent);

						} else {

							final String message = "Sorry, that username/password combination was incorrect.";
							int length = Toast.LENGTH_SHORT;
							Toast.makeText(getApplicationContext(), message, length).show();

						}

					}

				});

			}

		});

	}

}
