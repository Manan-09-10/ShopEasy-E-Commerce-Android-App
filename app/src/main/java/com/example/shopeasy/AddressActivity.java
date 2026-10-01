package com.example.shopeasy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddressActivity extends AppCompatActivity {

    Button btnContinue;
    EditText etName, etPhone, etAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etAddress = findViewById(R.id.etAddress);

        btnContinue = findViewById(R.id.btnContinue);

        btnContinue = findViewById(R.id.btnContinue);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etName.getText().toString().trim();
                String phone = etPhone.getText().toString().trim();
                String address = etAddress.getText().toString().trim();

                if (name.isEmpty()) {
                    etName.setError("Enter your name");
                    etName.requestFocus();
                    return;
                }

                if (phone.isEmpty()) {
                    etPhone.setError("Enter mobile number");
                    etPhone.requestFocus();
                    return;
                }

                if (phone.length() != 10) {
                    etPhone.setError("Mobile number must be 10 digits");
                    etPhone.requestFocus();
                    return;
                }

                if (address.isEmpty()) {
                    etAddress.setError("Enter your address");
                    etAddress.requestFocus();
                    return;
                }

                Intent intent = new Intent(AddressActivity.this, PaymentActivity.class);
                startActivity(intent);
            }
        });
            }
        }