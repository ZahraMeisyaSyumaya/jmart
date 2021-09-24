package zahraJmartRK;
    
// Zahra Meisya Syumaya
// 1906300870    

    
public class Jmart
{
    public void main(String[] args)
    {

    }

    
    public static Product createProduct(){
        PriceTag priceTag = new PriceTag(20000);
        Product product = new Product("BUMPER",2,false,priceTag,
        ProductCategory.AUTOMOTIVE);
        return product;
    }
    
    public static Coupon createCoupon()
    {
       Coupon coupon = new Coupon("SummerSale 2K21",1, Coupon.Type.DISCOUNT, 20, 50000);
       return coupon;
    }

    public static ShipmentDuration createshipmentDuration (String args[])
    {
        return new ShipmentDuration(ShipmentDuration.REGULER, ShipmentDuration.INSTANT);
    }
    
    public static ShipmentDuration createShipmentDuration()
    {
        return null;
    }
}  
        