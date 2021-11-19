package com.zahraJmartRK;

public class ProductRating
{
    private long total;
    private long count;
    
    public ProductRating(){
       this.total = 0;
       this.total = 0;
    }
    
    public void insert(int rating){
        total += rating;
        count++;
    }
    
    public double getAverage(){
        if(count < 1)
        {
            return 0.00;
        }
        else
        {
            double averageRating = (this.total) / (this.count);
            return averageRating;
        }
    }
    
    public long getCount(){
        return count;
    }
    
    public long getTotal(){ 
        return total;
    }
}