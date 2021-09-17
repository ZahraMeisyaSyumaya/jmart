package zahraJmartRK;
    
// Zahra Meisya Syumaya
// 1906300870    

    public class Jmart
    {
        public static void main(String[] args){
            System.out.println("getPromo(): ");
            System.out.println(getPromo());
            
            System.out.println("getCustomer(): ");
            System.out.println(getCustomer());
            
            System.out.println("getDiscountPercentage(int before, int after): ");
            System.out.println("(1000, 900) = " + getDiscountPercentage(1000,900));
            System.out.println("(1000, 0) = " + getDiscountPercentage(1000, 0));
            System.out.println("(0, 0) = " + getDiscountPercentage(0, 0));
            System.out.println("(0, 1) = " + getDiscountPercentage(0,1));
            
            System.out.println("getDiscountedPrice(): ");
            System.out.println("(1000, 10.0f) = " + getDiscountedPrice(1000, 10.0f));
            System.out.println("(1000, 100.0f) = " + getDiscountedPrice(1000, 100.0f));
            System.out.println("(1000, 120.0f) = " + getDiscountedPrice(1000, 120.0f));
            System.out.println("(0, 0.0f) = " + getDiscountedPrice(0, 0.0f));
            
            System.out.println("getOriginalPrice(int discountedPrice, float discountPercentage): ");
            System.out.println("(900, 10.0f) = " + getOriginalPrice(900, 10.0f));
            System.out.println("(1000, 0.0f) = " + getOriginalPrice(1000, 0.0f));
            System.out.println("(0, 100.0f) = " + getOriginalPrice(0, 100.0f));
            System.out.println("(0, 120.0f) = " + getOriginalPrice(0, 120.0f));
            
            System.out.println("getCommissionMultiplier():");
            System.out.println(getCommissionMultiplier());
            
            System.out.println("getAdjustedPrice(int price):");
            System.out.println("(1000) = " + getAdjustedPrice(1000));
            System.out.println("(500) = " + getAdjustedPrice(500));
            System.out.println("(0) = " + getAdjustedPrice(0));
            
            System.out.println("getAdminFee(int price):");
            System.out.println("(1000) = " + getAdminFee(1000));
            System.out.println("(500) = " + getAdminFee(500));
            System.out.println("(0) = " + getAdminFee(0));
            
        }
        
        
        public static int getPromo(){
            return 0;
        }
        
        public static String getCustomer(){
            return "oop";
        }
        
        public static float getDiscountPercentage(int before, int after){
            float beforeNewVar = before;
            float afterNewVar = after;  
            
            if(beforeNewVar < afterNewVar){
                return 0.0f;
            }
            else{
                float discount = ((beforeNewVar - afterNewVar) / beforeNewVar) * 100;
                return discount;
            }
        } 
        
        public static int getDiscountedPrice(int price, float discountPercentage){
            float result;
            if(discountPercentage>100.0f){
                return 0;
            }
            else {
                return (int) (result = price - (price*(discountPercentage/100)));
            }

        }
        
    
        public static int getOriginalPrice(int discountedPrice, float discountPercentage){
            return (int) (discountedPrice * 100.0f / (100.0f - discountPercentage));
        }
        
        public static float getCommissionMultiplier(){
            return 0.05f;
        }
        
        public static int getAdjustedPrice(int price){
            float adjustedPrice = price + getCommissionMultiplier() * price;
            return (int) adjustedPrice;
        }
        
        public static int getAdminFee(int price){
            return (int) ( (float) price * getCommissionMultiplier());
        }
}