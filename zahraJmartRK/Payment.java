package zahraJmartRK;


/**
 * Write a description of class Payment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Payment extends Invoice implements Transactor
{
    public Shipment shipment;
    public int productCount;

    public Payment(int id, int buyerId, int productId, int productCount, Shipment shipment){
        super(id, buyerId, productId);
        this.productCount = productCount;
        this.shipment = shipment;
    }

    @Override
    public double getTotalPay() {
        return 0.0;
    }
    
    public boolean validate() {
        return false;
    }

    public Invoice perform() {
        return null;
    }
    
    @Override
    public boolean read(String content){
        return false;
    }
}