package com.example.demo.reflection;

import java.lang.reflect.Field;

class Product {
    // A private, un-editable field
    private String serialNumber = "SN-ORIGINAL-12345";
    private double price = 99.99;

    public double getPrice() {
        return price;
    }
    public String getSerialNumber() {
        return serialNumber;
    }
}

public class ReflectionFieldTest {
    public static void main(String[] args) {
        Product myProduct = new Product();

        System.out.println("--- Before Reflection Attack ---");
        System.out.println("Product Price: $" + myProduct.getPrice());
        System.out.println("Product Serial: " + myProduct.getSerialNumber());

        try {
            // 1. Target the private 'price' field
            Field priceField = Product.class.getDeclaredField("price");

            // 2. BREAK THE LOCK: Force the private field to be accessible
            priceField.setAccessible(true);

            // 3. Hack the value: Change the price from 99.99 to 0.01
            priceField.set(myProduct, 0.01);


            // 4. Target the private FINAL 'serialNumber' field
            Field serialField = Product.class.getDeclaredField("serialNumber");
            serialField.setAccessible(true);

            // Hack the final value
            serialField.set(myProduct, "SN-HACKED-99999");

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\n--- After Reflection Attack ---");
        System.out.println("Product Price: $" + myProduct.getPrice()); // Outputs: $0.01
        System.out.println("Product Serial: " + myProduct.getSerialNumber());
    }
}