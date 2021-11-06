package zahraJmartRK;
import java.util.Date;
import java.util.ArrayList;


public abstract class Invoice extends Serializable {
    
    enum Status{
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

    public Date date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;
    public Status status;
    public ArrayList<Record> history = new ArrayList<Record>();

    protected Invoice(int buyerId, int productId){
        this.buyerId = buyerId;
        this.productId = productId;
        this.date = new Date();
        this.complaintId = 1;
        this.rating = Rating.NONE;
        this.status = Status.WAITING_CONFIRMATION;
    }

    public abstract double getTotalPay();

   /*
    public boolean read(String content){
        return false;
    }
    */

    class Record{
        public Status status;
        public Date date;
        public String message;
    }
}