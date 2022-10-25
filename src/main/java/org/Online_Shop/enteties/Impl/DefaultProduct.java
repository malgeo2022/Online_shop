package org.Online_Shop.enteties.Impl;

import org.Online_Shop.enteties.Product;

import java.math.BigDecimal;

public class DefaultProduct implements Product {

   private int id;
   private String productName;
   private String categoryName;
   private BigDecimal price;

    public DefaultProduct() {
    }

    public DefaultProduct(int id, String productName, String categoryName, BigDecimal price) {
        this.id = id;
        this.productName = productName;
        this.categoryName = categoryName;
        this.price = price;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public String toString() {
        return "DefaultProduct{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", price=" + price +
                '}';
    }
}
