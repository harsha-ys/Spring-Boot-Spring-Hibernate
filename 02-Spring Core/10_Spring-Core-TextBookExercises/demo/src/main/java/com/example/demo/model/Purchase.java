package com.example.demo.model;

import java.math.BigDecimal;

public class Purchase {

    private int id;
    private String product;
    private BigDecimal price;

    /**
     * Gets the purchase id.
     *
     * @return the purchase id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the purchase id.
     *
     * @param id the purchase id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the product name.
     *
     * @return the product name
     */
    public String getProduct() {
        return product;
    }

    /**
     * Sets the product name.
     *
     * @param product the product name
     */
    public void setProduct(String product) {
        this.product = product;
    }

    /**
     * Gets the purchase price.
     *
     * @return the purchase price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the purchase price.
     *
     * @param price the purchase price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
