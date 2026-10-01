package com.example.shopeasy;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class ProductDetailsActivity extends AppCompatActivity {

    Button btnBuyNow, btnAddToCart;
    ImageView imgProduct;
    TextView txtProductName, txtPrice, txtDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        imgProduct = findViewById(R.id.imgProduct);
        txtProductName = findViewById(R.id.txtProductName);
        txtPrice = findViewById(R.id.txtPrice);
        txtDescription = findViewById(R.id.txtDescription);
        btnAddToCart = findViewById(R.id.btnAddToCart);
        btnBuyNow = findViewById(R.id.btnBuyNow);
         
        String name = getIntent().getStringExtra("name");
        String price = getIntent().getStringExtra("price");
        int image = getIntent().getIntExtra("image", R.drawable.headphones);
        String description = getIntent().getStringExtra("description");

        txtProductName.setText(name);
        txtPrice.setText(price);
        imgProduct.setImageResource(image);
        txtDescription.setText(description);
        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CartManager.addItem(
                        name,
                        Integer.parseInt(price.replace("₹", ""))
                );

                Toast.makeText(ProductDetailsActivity.this,
                        name + " added to cart!",
                        Toast.LENGTH_SHORT).show();
            }
        });
        btnBuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductDetailsActivity.this, AddressActivity.class);
                startActivity(intent);
            }
        });

    }
}