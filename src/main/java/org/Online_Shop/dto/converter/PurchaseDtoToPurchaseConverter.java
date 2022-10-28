package org.Online_Shop.dto.converter;



import org.Online_Shop.dto.PurchaseDto;
import org.Online_Shop.enteties.Purchase;
import org.Online_Shop.enteties.impl.DefaultPurchase;

import java.util.ArrayList;
import java.util.List;

public class PurchaseDtoToPurchaseConverter {
	
	private ProductDtoToProductConverter productConverter;
	private UserDtoToUserConverter userConverter;
	
	{
		productConverter = new ProductDtoToProductConverter();
		userConverter = new UserDtoToUserConverter();
	}
	
	public Purchase convertPurchaseDtoToPurchase(PurchaseDto purchaseDto) {
		Purchase purchase = new DefaultPurchase();
		purchase.setCreditCardNumber(purchaseDto.getUserDto().getCreditCard());
		purchase.setCustomerId(purchaseDto.getUserDto().getId());
		purchase.setProducts(productConverter.convertProductDtosToProducts(purchaseDto.getProductDtos()));
		
		return purchase;
	}
	
	public PurchaseDto convertPurchaseToPurchaseDto(Purchase purchase) {
		PurchaseDto purchaseDto = new PurchaseDto();
		purchaseDto.setProductDtos(productConverter.convertProductsToProductDtos(purchase.getProducts()));
		purchaseDto.setUserDto(userConverter.convertUserIdToUserDtoWithOnlyId(purchase.getCustomerId()));
		
		return purchaseDto;
	}

	public List<Purchase> convertPurchaseDtosToPurchases(List<PurchaseDto> purchasesDtos) {
		List<Purchase> purchases = new ArrayList<>();
		if (purchasesDtos != null) {
			for (PurchaseDto purchaseDto : purchasesDtos) {
				purchases.add(convertPurchaseDtoToPurchase(purchaseDto));
			}
		}
		return purchases;
	}

}
