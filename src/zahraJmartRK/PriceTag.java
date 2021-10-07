package zahraJmartRK;


/**
 * Write a description of class PriceTag here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PriceTag
{
    public static final double COMMISSION_MULTIPLIER = 0.05;
    public static final double BOTTOM_PRICE = 20000;
    public static final double BOTTOM_FEE = 1000;
    public double price;
    public double discount;
    
    public PriceTag(double price){
        this.price = price;
        this.discount = 0.0;
    }
    
    public PriceTag(double price, double discount){
        this.price = price;
        this.discount  = discount;
    }
    
    private double getDiscountedPrice(){
         if (discount > 100.0){
            discount = 100.0;
        }
        if (discount == 100.0){
            return 0.0;
        }
        else{
            return price * ((100.0 - discount)/100.0);
        }
    }
    
    public double getAdminFee(){
        double discounted = getDiscountedPrice();
        
        if (discounted<BOTTOM_PRICE){
            return BOTTOM_FEE;    
        }
        
        return discounted * COMMISSION_MULTIPLIER;
    }
    
    public double getAdjustedPrice(){
        return getDiscountedPrice() + getAdminFee();
    }
}


