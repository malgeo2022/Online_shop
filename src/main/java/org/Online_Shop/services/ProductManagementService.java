package org.Online_Shop.services;

import org.Online_Shop.enteties.Product;

import java.util.List;

public interface ProductManagementService {
    List<Product> getProducts();

    Product getProductById(int productIdToAddToCart);

}
