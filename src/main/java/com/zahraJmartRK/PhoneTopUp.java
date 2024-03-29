package com.zahraJmartRK;

public class PhoneTopUp extends Invoice{
    public String phoneNumber;
    public Status status;
    public PhoneTopUp(int buyerId, int productId, String phoneNumber){
        super(buyerId, productId);
        this.phoneNumber = phoneNumber;
    }
    @Override
    public double getTotalPay(Product product){
        return Treasury.getAdjustedPrice(product.price, product.discount);
    }
}
