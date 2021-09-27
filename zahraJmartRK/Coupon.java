package zahraJmartRK;

public class Coupon
{    
   private boolean used;
   public final String name;
   public final int code;
   public final Type type;
   public final double cut;
   public final double minimum;
    
    public enum Type{
       DISCOUNT,
       REBATE
   }
   
    public Coupon(String name, int code, Type type, double cut, double minimum){
        this.name = name;
        this.code = code;
        this.type = type;
        this.cut = cut;
        this.minimum = minimum;
        this.used = false;
   }
    
    public boolean isUsed(){
       return used;
   }
    
   public boolean canApply(PriceTag priceTag){
       if ((priceTag.getAdjustedPrice() >= minimum) && (used == false)){
           return true;
       }    
       else{
           return false;
       }
    }
        
    public double apply (PriceTag priceTag){
       used = true;
       
       if (type == Type.DISCOUNT){
           return (100 - cut) / 100 * priceTag.getAdjustedPrice();
       }
       else if (type == Type.REBATE){
           return priceTag.getAdjustedPrice() - priceTag.price;
       }
       else{
           return 0.0;
       }
   }
}