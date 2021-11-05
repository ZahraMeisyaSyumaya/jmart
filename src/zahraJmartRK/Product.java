package zahraJmartRK;

public class Product extends Recognizable
{
    public int accountId;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public ProductCategory category;
    public double price;
    public double discount;
    public byte shipmentPlans;

    public Product(int id, int accountId, String name, int weight, boolean conditionUsed, double price, double discount, ProductCategory category, byte shipmentPlans)
    {
        super(id);
        this.accountId = accountId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.price = price;
        this.discount = discount;
        this.category = category;
        this.shipmentPlans = shipmentPlans;
    }

    /*@Override
    public boolean read(String content){
        return false;
    }
    */
    @Override
    public String toString(){
        return("Name: " + name + "\nWeight: " + weight + "\nconditionUsed: " + conditionUsed +
                "\nprice: " + price + "\ncategory: " + category + "\ndiscount: " + discount + "\naccountId: " + accountId);
    }


}


