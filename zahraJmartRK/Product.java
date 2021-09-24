package zahraJmartRK;


/**
 * Write a description of class Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Product
{
     private static int idCounter = 0;
     public int id;
     public String name;
     public int weight;
     public boolean conditionUsed;
     public PriceTag pricetag;
     public ProductCategory category;
     public ProductRating rating;
     
     public Product(String name, int weight, boolean conditionUsed, PriceTag pricetag, ProductCategory category){
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.pricetag = pricetag;
        this.category = category;
        this.rating = new ProductRating();
        id = idCounter;
        idCounter++;
     }
}

