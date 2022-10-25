package org.Online_Shop.services;

import org.Online_Shop.enteties.Product;

public interface ProductManagementService {
    Product[] getProducts();

    Product getProductById(int productIdToAddToCart);

}
