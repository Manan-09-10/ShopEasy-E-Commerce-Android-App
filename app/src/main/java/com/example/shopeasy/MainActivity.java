package com.example.shopeasy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnCart, btnCart2, btnCart3, btnSamsung, btnIphone, btnLogout;
    Button btnClothes, btnMobiles, btnShoes;
    TextView txtCartCount;
    ImageView imgHeadphones, imgTshirt, imgShoes, imgSamsung, imgIphone;

    EditText search;

    LinearLayout layoutHeadphones, layoutTshirt, layoutShoes, layoutSamsung, layoutIphone;
    Button btnAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCart = findViewById(R.id.btnCart);
        btnCart2 = findViewById(R.id.btnCart2);
        btnCart3 = findViewById(R.id.btnCart3);

        txtCartCount = findViewById(R.id.txtCartCount);

        imgHeadphones = findViewById(R.id.imgHeadphones);
        imgTshirt = findViewById(R.id.imgTshirt);
        imgShoes = findViewById(R.id.imgShoes);
        imgSamsung = findViewById(R.id.imgSamsung);
        imgIphone = findViewById(R.id.imgIphone);
        btnLogout = findViewById(R.id.btnLogout);

        search = findViewById(R.id.search);

        btnClothes = findViewById(R.id.btnClothes);
        btnMobiles = findViewById(R.id.btnMobiles);
        btnShoes = findViewById(R.id.btnShoes);
        btnSamsung = findViewById(R.id.btnSamsung);
        btnIphone = findViewById(R.id.btnIphone);
        btnAll = findViewById(R.id.btnAll);

        layoutHeadphones = findViewById(R.id.layoutHeadphones);
        layoutTshirt = findViewById(R.id.layoutTshirt);
        layoutShoes = findViewById(R.id.layoutShoes);
        layoutSamsung = findViewById(R.id.layoutSamsung);
        layoutIphone = findViewById(R.id.layoutIphone);

        // Update Cart Count
        txtCartCount.setText("🛒 Cart : " + CartManager.cartItems.size());

        // Headphones Add to Cart
        btnCart.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                CartManager.addItem("Wireless Headphones", 1499);

                txtCartCount.setText("🛒 Cart : " + CartManager.cartItems.size());

                Toast.makeText(MainActivity.this,
                        "Wireless Headphones added to cart!",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // T-Shirt Add to Cart
        btnCart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CartManager.addItem("T-Shirt", 799);

                txtCartCount.setText("🛒 Cart : " + CartManager.cartItems.size());

                Toast.makeText(MainActivity.this,
                        "T-Shirt added to cart!",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Shoes Add to Cart
        btnCart3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CartManager.addItem("Sports Shoes", 2499);

                txtCartCount.setText("🛒 Cart : " + CartManager.cartItems.size());

                Toast.makeText(MainActivity.this,
                        "Sports Shoes added to cart!",
                        Toast.LENGTH_SHORT).show();
            }
        });
        // Samsung Add to Cart
        btnSamsung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CartManager.addItem("Samsung Galaxy S26 Ultra", 129999);

                txtCartCount.setText("🛒 Cart : " + CartManager.cartItems.size());

                Toast.makeText(MainActivity.this,
                        "Samsung Galaxy S26 Ultra added to cart!",
                        Toast.LENGTH_SHORT).show();
            }
        });

// iPhone Add to Cart
        btnIphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CartManager.addItem("iPhone 17 Pro Max", 149999);

                txtCartCount.setText("🛒 Cart : " + CartManager.cartItems.size());

                Toast.makeText(MainActivity.this,
                        "iPhone 17 Pro Max added to cart!",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Open Cart Screen
        txtCartCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, CartActivity.class);
                startActivity(intent);

            }
        });

        // Headphones Details
        imgHeadphones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ProductDetailsActivity.class);
                intent.putExtra("name", "Wireless Headphones");
                intent.putExtra("price", "₹1499");
                intent.putExtra("image", R.drawable.headphones);
                intent.putExtra("description",
                        "Experience premium sound quality with deep bass, Bluetooth connectivity and long battery life.");

                startActivity(intent);
            }
        });

        // T-Shirt Details
        imgTshirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ProductDetailsActivity.class);
                intent.putExtra("name", "T-Shirt");
                intent.putExtra("price", "₹799");
                intent.putExtra("image", R.drawable.tshirts);
                intent.putExtra("description",
                        "Premium cotton T-Shirt with soft fabric, comfortable fitting and stylish design.");

                startActivity(intent);
            }
        });

        // Shoes Details
        imgShoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ProductDetailsActivity.class);
                intent.putExtra("name", "Sports Shoes");
                intent.putExtra("price", "₹2499");
                intent.putExtra("image", R.drawable.shoes);
                intent.putExtra("description",
                        "Lightweight sports shoes designed for running, walking and everyday comfort.");

                startActivity(intent);
            }
        });
        // Samsung Details
        imgSamsung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ProductDetailsActivity.class);

                intent.putExtra("name", "Samsung Galaxy S26 Ultra");
                intent.putExtra("price", "₹129999");
                intent.putExtra("image", R.drawable.s26ultra);
                intent.putExtra("description",
                        "Samsung Galaxy S26 Ultra with Snapdragon processor, 200MP camera, AI features, 120Hz AMOLED display and 5000mAh battery.");

                startActivity(intent);
            }
        });
        // iPhone Details
        imgIphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ProductDetailsActivity.class);

                intent.putExtra("name", "iPhone 17 Pro Max");
                intent.putExtra("price", "₹149999");
                intent.putExtra("image", R.drawable.iphone17promax);
                intent.putExtra("description",
                        "Apple iPhone 17 Pro Max with A19 Pro chip, ProMotion display, advanced camera system and all-day battery life.");

                startActivity(intent);
            }
        });
        btnClothes.setOnClickListener(v -> {

            layoutHeadphones.setVisibility(View.GONE);
            layoutTshirt.setVisibility(View.VISIBLE);
            layoutShoes.setVisibility(View.GONE);

            layoutSamsung.setVisibility(View.GONE);
            layoutIphone.setVisibility(View.GONE);

        });

        btnShoes.setOnClickListener(v -> {

            layoutHeadphones.setVisibility(View.GONE);
            layoutTshirt.setVisibility(View.GONE);
            layoutShoes.setVisibility(View.VISIBLE);

            layoutSamsung.setVisibility(View.GONE);
            layoutIphone.setVisibility(View.GONE);

        });

        btnMobiles.setOnClickListener(v -> {

            layoutHeadphones.setVisibility(View.GONE);
            layoutTshirt.setVisibility(View.GONE);
            layoutShoes.setVisibility(View.GONE);

            layoutSamsung.setVisibility(View.VISIBLE);
            layoutIphone.setVisibility(View.VISIBLE);

        });
        btnAll.setOnClickListener(v -> {

            layoutHeadphones.setVisibility(View.VISIBLE);
            layoutTshirt.setVisibility(View.VISIBLE);
            layoutShoes.setVisibility(View.VISIBLE);

            layoutSamsung.setVisibility(View.VISIBLE);
            layoutIphone.setVisibility(View.VISIBLE);

        });
        search.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String text = s.toString().toLowerCase();

                layoutHeadphones.setVisibility(
                        text.contains("head") || text.isEmpty()
                                ? View.VISIBLE : View.GONE);

                layoutTshirt.setVisibility(
                        text.contains("shirt") || text.contains("cloth") || text.isEmpty()
                                ? View.VISIBLE : View.GONE);

                layoutShoes.setVisibility(
                        text.contains("shoe") || text.isEmpty()
                                ? View.VISIBLE : View.GONE);

                layoutSamsung.setVisibility(
                        text.contains("samsung") || text.contains("mobile") || text.isEmpty()
                                ? View.VISIBLE : View.GONE);

                layoutIphone.setVisibility(
                        text.contains("iphone") || text.contains("mobile") || text.isEmpty()
                                ? View.VISIBLE : View.GONE);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        btnLogout.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, LoginActivity.class);

            startActivity(intent);

            finish();

        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (txtCartCount != null) {
            txtCartCount.setText("🛒 Cart : " + CartManager.cartItems.size());
        }
    }
}