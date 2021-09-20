package zahraJmartRK;


/**
 * Write a description of class PriceTag here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PriceTag
{
    public static final double COMMISSION_MULTIPLIER = 0.05d;
    public static final double BOTTOM_PRICE = 20000;
    public static final double BOTTOM_FEE = 1000;
    public double price;
    public double discount;
    
    public PriceTag(double price){
        this.price = price;
    }
    
    public PriceTag(double price, double discount){
        this.price = price;
        this.discount  = discount;
    }
    
    private double getDiscountedPrice(){
    if (discount>=100){
        return 0;
    }
    else{
        double totalPrice = price - (price * (discount/100));
        return totalPrice;
    }
    }
    
    public double getAdminFee(){
        double discounted = getDiscountedPrice();
        
        if (discounted<BOTTOM_PRICE){
            return BOTTOM_FEE;    
        }
        
        return discounted - COMMISSION_MULTIPLIER;
    }
    
    public double getAdjustedPrice(){
        return getDiscountedPrice() + getAdminFee();
    }
}

