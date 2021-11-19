package com.zahraJmartRK;

public class Product extends Serializable
{
    public int accountId;
    public boolean conditionUsed;
    public double discount;
    public ProductCategory category;
    public String name;
    public double price;
    public byte shipmentPlans;
    public int weight;

    public Product(int accountId, String name, int weight, boolean conditionUsed, double price, double discount, ProductCategory category, byte shipmentPlans)
    {
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.category = category;
        this.accountId = accountId;
        this.price = price;
        this.discount = discount;
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


