package com.mihainour.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.util.Log;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private EditText editTextEmail, editTextPassword;
    private TextView textViewDisplayAccount;
    private Button buttonDisplayAboutAndroid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        setupViews();
        displayAboutAndroidOnClick();
    }

    private void displayAboutAndroidOnClick() {
        buttonDisplayAboutAndroid.setOnClickListener(view -> {
            Intent moveFromMainToAboutAndroidActivity = new Intent(MainActivity.this, AboutAndroid.class);
            startActivity(moveFromMainToAboutAndroidActivity);
        });
    }

    private void setupViews() {
        editTextEmail = findViewById(R.id.editTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextPassword);
        textViewDisplayAccount = findViewById(R.id.textViewDisplayAccount);
        buttonDisplayAboutAndroid = findViewById(R.id.buttonAboutAndroid);
    }

    public void loginOnClick(View view) {
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();
        if (isValidForm(email, password)) {
            if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                textViewDisplayAccount.setText(new StringBuilder().append(email).append(", ").append(password).toString());
            } else {
                // editTextEmail.setError("Please add a valid email address");
                Toast.makeText(MainActivity.this, R.string.email_not_valid, Toast.LENGTH_LONG).show();
            }
        } else {
            //TODO add validation per field
            editTextEmail.setError(getString(R.string.add_email));
            editTextPassword.setError(getString(R.string.add_password));
            Log.e(TAG, "email and password empty");
        }
    }

    private boolean isValidForm(String email, String password) {
        return email.length() > 0 && password.length() > 0;
    }
}