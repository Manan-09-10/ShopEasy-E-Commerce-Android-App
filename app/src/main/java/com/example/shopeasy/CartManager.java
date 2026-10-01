package com.example.shopeasy;

import java.util.ArrayList;

public class CartManager {

    public static ArrayList<String> cartItems = new ArrayList<>();
    public static int totalPrice = 0;

    public static void addItem(String productName, int price) {
        cartItems.add(productName + " - ₹" + price);
        totalPrice += price;
    }

    public static String getItems() {

        if (cartItems.isEmpty()) {
            return "No items added yet.";
        }

        StringBuilder builder = new StringBuilder();

        for (String item : cartItems) {
            builder.append(item).append("\n");
        }

        return builder.toString();
    }

    public static int getTotalPrice() {
        return totalPrice;
    }
}