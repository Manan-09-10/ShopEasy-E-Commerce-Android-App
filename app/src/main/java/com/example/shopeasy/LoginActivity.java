package com.example.shopeasy;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button btnLogin;
    TextView txtRegister;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        btnLogin = findViewById(R.id.btnLogin);
        txtRegister = findViewById(R.id.txtRegister);

        db = new DatabaseHelper(this);

        btnLogin.setOnClickListener(v -> {

            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {

                Toast.makeText(LoginActivity.this,
                        "Please enter email and password",
                        Toast.LENGTH_SHORT).show();

            } else {

                boolean checkUser = db.loginUser(email, password);

                if (checkUser) {

                    Toast.makeText(LoginActivity.this,
                            "Login Successful",
                            Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);

                    finish();

                } else {

                    Toast.makeText(LoginActivity.this,
                            "Invalid Email or Password",
                            Toast.LENGTH_SHORT).show();
                }
            }

        });

        txtRegister.setOnClickListener(v -> {

            Intent intent = new Intent(LoginActivity.this,
                    RegisterActivity.class);

            startActivity(intent);

        });

    }
}