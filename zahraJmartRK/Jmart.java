package zahraJmartRK;
    
// Zahra Meisya Syumaya
// 1906300870    

    
public class Jmart
{
    public static void main(String[] args){
        System.out.println(create());
    }
    

    public static Product create(){
        return new Product("kaset", 7, false, new PriceTag(20000L), ProductCategory.ELECTRONIC);
    }
}        
        