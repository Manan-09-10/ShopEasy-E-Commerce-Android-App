package com.example.shopeasy;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity {

    Button btnPlaceOrder;
    RadioGroup radioGroupPayment;
    RadioButton rbCOD, rbUPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        radioGroupPayment = findViewById(R.id.radioGroupPayment);
        rbCOD = findViewById(R.id.rbCOD);
        rbUPI = findViewById(R.id.rbUPI);

        btnPlaceOrder = findViewById(R.id.btnPlaceOrder);
        btnPlaceOrder = findViewById(R.id.btnPlaceOrder);

        btnPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!rbCOD.isChecked() && !rbUPI.isChecked()) {
                    Toast.makeText(PaymentActivity.this,
                            "Please select a payment method",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(PaymentActivity.this, OrderSuccessActivity.class);
                startActivity(intent);
            }
        });
            }
        }