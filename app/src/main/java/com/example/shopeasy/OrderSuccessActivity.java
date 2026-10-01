package com.example.shopeasy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

public class OrderSuccessActivity extends AppCompatActivity {

    Button btnHome;
    TextView txtOrderId, txtDateTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_success);

        btnHome = findViewById(R.id.btnHome);
        txtOrderId = findViewById(R.id.txtOrderId);
        txtDateTime = findViewById(R.id.txtDateTime);

// Random Order ID
        Random random = new Random();
        int orderNumber = 1000 + random.nextInt(9000);
        txtOrderId.setText("Order ID : ORD" + orderNumber);

// Current Date & Time
        String currentDateTime = new SimpleDateFormat(
                "dd MMM yyyy | hh:mm a",
                Locale.getDefault()
        ).format(new Date());

        txtDateTime.setText(currentDateTime);

// Cart Clear
        CartManager.cartItems.clear();
        CartManager.totalPrice = 0;

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderSuccessActivity.this, MainActivity.class);
                startActivity(intent);
                finishAffinity();
            }
        });
    }
}