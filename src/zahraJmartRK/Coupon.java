package zahraJmartRK;

public abstract class Coupon extends Recognizable
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

    public boolean canApply(double price)
    {
        if(Treasury.getAdjustedPrice(price, cut) >= minimum && !used){
            return true;
        }else{
            return false;
        }
    }

    public double apply(Treasury priceTag)
    {
        double finalPrice = 0.00;
        this.used = true;
        if(this.type == Type.DISCOUNT)
        {
            return (priceTag.getAdjustedPrice(1000.0, 5.0) * (100 - this.cut)/100);
        }
        else if(type == Type.REBATE)
        {
            return (priceTag.getAdjustedPrice(1000.0, 5.0) - cut);
        }
        else
        {
            return finalPrice;
        }
    }
   /* public boolean read(String content){
        return false;
    }
    */
}