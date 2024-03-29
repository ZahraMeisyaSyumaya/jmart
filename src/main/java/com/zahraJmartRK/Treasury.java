package com.zahraJmartRK;

public class Treasury {
    public static final double COMMISSION_MULTIPLIER = 0.05;
    public static final double BOTTOM_PRICE = 20000;
    public static final double BOTTOM_FEE = 1000;

    public static double getAdjustedPrice(double price, double discount)
    {
        return getDiscountedPrice(price, discount) + getAdminFee(price, discount);
    }

    public static double getAdminFee(double price, double discount)
    {
        if(getDiscountedPrice(price, discount) < BOTTOM_PRICE){
            return BOTTOM_FEE;
        }else{
            return getDiscountedPrice(price, discount) * COMMISSION_MULTIPLIER;
        }
    }

    private static double getDiscountedPrice(double price, double discount)
    {
        if(discount > 100.0){
            discount = 100.0;
        }
        if(discount == 100.0){
            return 0.0;
        }
        else{ return price * ((100.0 - discount)/100.0); }
    }
}
