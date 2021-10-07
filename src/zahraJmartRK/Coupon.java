package zahraJmartRK;

public abstract class Coupon extends Recognizable implements FileParser
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
   
    public Coupon(int id, String name, int code, Type type, double cut, double minimum){
        super(id);
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
   @Override
    public boolean read(String content){
        return false;
    }
}