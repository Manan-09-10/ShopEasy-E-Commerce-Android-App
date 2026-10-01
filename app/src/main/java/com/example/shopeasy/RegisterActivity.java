package com.example.shopeasy;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText etName, etEmail, etPassword, etConfirmPassword;
    Button btnRegister;
    TextView txtLogin;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);

        btnRegister = findViewById(R.id.btnRegister);
        txtLogin = findViewById(R.id.txtLogin);

        db = new DatabaseHelper(this);

        btnRegister.setOnClickListener(v -> {

            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            String confirmPassword = etConfirmPassword.getText().toString().trim();

            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {

                Toast.makeText(RegisterActivity.this,
                        "Please fill all fields",
                        Toast.LENGTH_SHORT).show();

            } else if (!password.equals(confirmPassword)) {

                Toast.makeText(RegisterActivity.this,
                        "Passwords do not match",
                        Toast.LENGTH_SHORT).show();

            } else if (db.checkEmail(email)) {

                Toast.makeText(RegisterActivity.this,
                        "Email already registered",
                        Toast.LENGTH_SHORT).show();

            } else {

                boolean success = db.registerUser(name, email, password);

                if (success) {

                    Toast.makeText(RegisterActivity.this,
                            "Registration Successful",
                            Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(RegisterActivity.this,
                            LoginActivity.class));

                    finish();

                } else {

                    Toast.makeText(RegisterActivity.this,
                            "Registration Failed",
                            Toast.LENGTH_SHORT).show();
                }
            }

        });

        txtLogin.setOnClickListener(v -> {

            startActivity(new Intent(RegisterActivity.this,
                    LoginActivity.class));

            finish();

        });

    }
}