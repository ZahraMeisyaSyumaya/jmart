package zahraJmartRK;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import zahraJmartRK.Product;
import zahraJmartRK.ProductCategory;
import java.util.stream.Collectors;

class Jmart
{




    public static List<Product> filterByAccountId(List<Product> list, int accountId, int page, int pageSize) {
        Predicate<Product> predicate = acc -> (acc.accountId == accountId);
        return paginate(list, page, pageSize, predicate);
    }

    public static List<Product> filterByCategory(List<Product> list, ProductCategory category){
        List<Product> products = new ArrayList<>();
        for(Product product : list){
            if(product.category.equals(category)){
                products.add(product);
            }
        }
        return products;
    }

    public static List<Product> filterByName(List<Product> list, String search, int page, int pageSize) {
        Predicate<Product> predicate = acc -> (acc.name.toLowerCase().contains(search.toLowerCase()));
        return paginate(list, page, pageSize, predicate);
    }

    public static List<Product> filterByPrice(List<Product> list, double minPrice, double maxPrice){
        List<Product> products = new ArrayList<>();
        for(int cnt = 0; cnt < list.size(); cnt++){
            if(minPrice <= 0.0){
                if(list.get(cnt).price <= maxPrice){
                    products.add(list.get(cnt));
                }
            }else if(maxPrice <= 0.0){
                if(list.get(cnt).price >= minPrice){
                    products.add(list.get(cnt));
                }
            }else{
                if(list.get(cnt).price >= minPrice && list.get(cnt).price <= maxPrice){
                    products.add(list.get(cnt));
                }
            }
        }
        return products;
    }

    public static void main(String[] args)
    {
        try{

            List<Product> list = read("C:/Users/Zahra/repo baru/jmart/randomProductList.json");

            List<Product> nameOutput = filterByName(list, "gtx", 1, 5);
            nameOutput.forEach(product -> System.out.println(product.name));

            List<Product> accountOutput = filterByAccountId(list, 2, 1, 5);
            accountOutput.forEach(product -> System.out.println(product.name));

        }catch (Throwable t)
        {
            t.printStackTrace();
        }
    }

    private static List<Product> paginate(List<Product> list, int page, int pageSize, Predicate<Product> pred) {
        if(page < 0){
            page = 0;
        }
        if(pageSize < 0){
            pageSize = 0;
        }
        return list.stream().filter(acc -> pred.predicate(acc)).skip(page * pageSize).limit(pageSize).collect(Collectors.toList());
    }



    public static List<Product> read(String filepath) throws FileNotFoundException {
        List<Product> products = new ArrayList<>();
        try{
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader(filepath));
            reader.beginArray();
            while(reader.hasNext()){
                products.add(gson.fromJson(reader, Product.class));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }

    

}