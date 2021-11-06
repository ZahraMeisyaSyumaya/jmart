    package zahraJmartRK; 
import java.util.Date;
import java.text.SimpleDateFormat;

public class Complaint extends Serializable {
    public Date date;
    public String desc;

    public Complaint(String desc){
        this.desc = desc;
        this.date = new Date();
    }

    /*
    @Override
    public boolean read(String content){
        return false;
    }
     */

    
    public String toString()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String formatDate = formatter.format(this.date);
        return ("Complaint{date=" +formatDate+ "desc='" +this.desc+ "'}");
    }
}