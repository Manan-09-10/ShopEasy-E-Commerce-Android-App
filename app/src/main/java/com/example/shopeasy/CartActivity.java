package com.example.shopeasy;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CartActivity extends AppCompatActivity {

    TextView txtCartItems, txtTotalPrice;
    Button btnCheckout, btnClearCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        txtCartItems = findViewById(R.id.txtCartItems);
        txtTotalPrice = findViewById(R.id.txtTotalPrice);

        btnCheckout = findViewById(R.id.btnCheckout);
        btnClearCart = findViewById(R.id.btnClearCart);

        // Show Cart Items
        txtCartItems.setText(CartManager.getItems());

        // Show Total Price
        txtTotalPrice.setText("Total : ₹" + CartManager.getTotalPrice());

        // Checkout Button
        btnCheckout.setOnClickListener(v -> {

            if (CartManager.cartItems.isEmpty()) {

                Toast.makeText(
                        CartActivity.this,
                        "Your cart is empty!",
                        Toast.LENGTH_SHORT
                ).show();

            } else {

                Intent intent = new Intent(CartActivity.this, AddressActivity.class);
                startActivity(intent);

            }

        });

        // Clear Cart Button
        btnClearCart.setOnClickListener(v -> {

            CartManager.cartItems.clear();
            CartManager.totalPrice = 0;

            txtCartItems.setText("No items added yet.");
            txtTotalPrice.setText("Total : ₹0");

            Toast.makeText(
                    CartActivity.this,
                    "Cart Cleared Successfully!",
                    Toast.LENGTH_SHORT
            ).show();

        });
    }
}