package org.Online_Shop.enteties.Impl;

import org.Online_Shop.enteties.Cart;
import org.Online_Shop.enteties.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefaultCart implements Cart {


    //private static final int DEFAULT_PRODUCT_CAPACITY = 10;
    private List<Product> products;
    //private int lastIndex;

    {
        products = new ArrayList<>();
    }

    @Override
    public boolean isEmpty() {
       return products.isEmpty();
    }


    @Override
    public void addProduct(Product product) {
          if (product == null){
              return;
          }
          products.add(product);
    }

    @Override
    public List<Product> getProducts() {
         return this.products;
    }

    @Override
    public void clear() {
            products.clear();
    }
}
