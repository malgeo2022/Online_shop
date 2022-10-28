package org.Online_Shop.services.Impl;

import org.Online_Shop.dao.PurchaseDao;
import org.Online_Shop.dao.impl.MySqlJdbcPurchaseDao;
import org.Online_Shop.dto.PurchaseDto;
import org.Online_Shop.dto.converter.PurchaseDtoToPurchaseConverter;
import org.Online_Shop.enteties.Purchase;

import java.util.List;

public class MySqlPurchaseManagementService implements PurchaseManagementService {
	
	private PurchaseDao purchaseDao;
	private PurchaseDtoToPurchaseConverter purchaseConverter;
	
	{
		purchaseDao = new MySqlJdbcPurchaseDao();
		purchaseConverter = new PurchaseDtoToPurchaseConverter();
	}

	@Override
	public void addPurchase(Purchase purchase) {
		purchaseDao.savePurchase(purchaseConverter.convertPurchaseToPurchaseDto(purchase));
	}

	@Override
	public List<Purchase> getPurchasesByUserId(int userId) {
		List<PurchaseDto> purchasesDtos = purchaseDao.getPurchasesByUserId(userId);
		return purchaseConverter.convertPurchaseDtosToPurchases(purchasesDtos);
	}

	@Override
	public List<Purchase> getPurchases() {
		List<PurchaseDto> purchasesDtos = purchaseDao.getPurchases();
		return purchaseConverter.convertPurchaseDtosToPurchases(purchasesDtos);
	}

}
