package org.Online_Shop.storage;

import org.Online_Shop.enteties.Product;

import java.util.List;

public interface ProductStoringService {

        List<Product> loadProducts();
}
