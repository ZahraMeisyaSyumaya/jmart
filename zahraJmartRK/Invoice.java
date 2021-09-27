package zahraJmartRK;


/**
 * Write a description of class Invoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Invoice extends Recognizable implements FileParser{
    public enum Status{
        WAITING_CONFIRMATION,
        CANCELLED,
        ON_PROGRESS,
        ON_DELIVERY,
        COMPLAINT,
        FINISHED,
        FAILED
    }

    public enum Rating{
        NONE,
        BAD,
        NEUTRAL,
        GOOD
    }
    
    public String date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;
    public Status status;
    
    protected Invoice(int id, int buyerId, int productId){
        super(id);
        this.buyerId = buyerId;
        this.productId = productId;
        this.date = "Time";
        this.rating = Rating.NONE;
        this.status = status.WAITING_CONFIRMATION;
    }

    abstract double getTotalPay();
    
    @Override
    public boolean read(String content){
        return false;
    }
}