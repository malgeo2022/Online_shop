package org.Online_Shop.enteties.Impl;

import org.Online_Shop.enteties.Order;
import org.Online_Shop.enteties.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefaultOrder implements Order {

    private static final int AMOUNT_OF_DIGITS_IN_CREDIT_NUMBER = 16;

    private String creditCardNumber;
    private List<Product> products;
    private int customerId;

    @Override
    public boolean isCreditCardNumberValid(String creditCardNumber) {
            return creditCardNumber.toCharArray().length == AMOUNT_OF_DIGITS_IN_CREDIT_NUMBER
                    && !creditCardNumber.contains(" ") && Long.parseLong(creditCardNumber) > 0;

    }

    @Override
    public void setCreditCardNumber(String userInput) {
        if (creditCardNumber == null){
            return;
        }
        this.creditCardNumber = creditCardNumber;
    }

    @Override
    public void setProducts(List<Product> products) {
              this.products = new ArrayList<>(products);
    }

    @Override
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public int getCustomerId() {
        return this.customerId;
    }

    @Override
    public String toString() {
        return "DefaultOrder{" +
                "creditCardNumber='" + creditCardNumber + '\'' +
                ", products=" + this.products +
                ", customerId=" + customerId +
                '}';
    }
}
