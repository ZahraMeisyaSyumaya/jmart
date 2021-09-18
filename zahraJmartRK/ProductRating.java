package zahraJmartRK;


/**
 * Write a description of class ProductRating here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProductRating
{
    private long total;
    private long count;
    
    public ProductRating(){
        long total;
        count = 0;
    }
    
    public void insert(int rating){
        long totalInsert = rating + total;
        count++;
    }
    
    public double getAverage(){
        return ((double) total/count);
    }
    
    public long getCount(){
        return count;
    }
    
    public long getTotal(){ 
        return total;
    }
}