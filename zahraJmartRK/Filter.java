package zahraJmartRK; 
import java.util.ArrayList;

/**
 * Write a description of class filter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Filter
{
    // instance variables - replace the example below with your own
    private Filter(){    }

    public static ArrayList<PriceTag> filterPriceTag(PriceTag[] list, double value, boolean less){
        ArrayList<PriceTag> priceTags = new ArrayList<>();
        for (PriceTag a : list){
            if (less && a.getAdjustedPrice() < value || !less && a.getAdjustedPrice() >= value){
                priceTags.add(a);
            }
        }
        return priceTags;
    }
    
    public static void filterProductRating(ArrayList<ProductRating> list, double value, boolean less){
        for (int i=0; i<list.size(); ++i){
            final ProductRating a = list.get(i);
            if (less && a.getAverage()<value || !less&&a.getAverage()>= value){
                list.remove(i);
            }
        }
    }
}
