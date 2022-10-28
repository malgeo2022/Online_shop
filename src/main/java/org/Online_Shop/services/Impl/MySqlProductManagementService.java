package org.Online_Shop.services.Impl;

import org.Online_Shop.dao.ProductDao;
import org.Online_Shop.dao.impl.MySqlJdbcProductDao;
import org.Online_Shop.dto.ProductDto;
import org.Online_Shop.dto.converter.ProductDtoToProductConverter;
import org.Online_Shop.enteties.Product;
import org.Online_Shop.services.ProductManagementService;

import java.util.List;

public class MySqlProductManagementService implements ProductManagementService {

	private ProductDao productDao;
	private ProductDtoToProductConverter productConverter;
	
	{
		productDao = new MySqlJdbcProductDao();
		productConverter = new ProductDtoToProductConverter();
	}
	
	@Override
	public List<Product> getProducts() {
		List<ProductDto> productDtos = productDao.getProducts();
		return productConverter.convertProductDtosToProducts(productDtos);
	}

	@Override
	public Product getProductById(int id) {
		ProductDto productDto = productDao.getProductById(id);
		return productConverter.convertProductDtoToProduct(productDto);
	}

}
