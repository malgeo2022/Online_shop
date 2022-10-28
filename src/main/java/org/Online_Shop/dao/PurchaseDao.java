package org.Online_Shop.dao;

import org.Online_Shop.dto.PurchaseDto;

import java.util.List;

public interface PurchaseDao {
	
	void savePurchase(PurchaseDto order);

	List<PurchaseDto> getPurchasesByUserId(int userId);
	
	List<PurchaseDto> getPurchases();

}
