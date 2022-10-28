package org.Online_Shop.dao;

import org.Online_Shop.dto.ProductDto;

import java.util.List;

public interface ProductDao {
	
	List<ProductDto> getProducts();

	ProductDto getProductById(int productId);
	
}
