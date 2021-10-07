    package zahraJmartRK; 
import java.util.Date;
import java.text.SimpleDateFormat;

public class Complaint extends Recognizable implements FileParser{
    public Date date;
    public String desc;

    public Complaint(int id, String desc){
        super(id);
        this.date = new Date();
        this.desc = desc;
    }

    @Override
    public boolean read(String content){
        return false;
    }
    
    public String toString()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String formatDate = formatter.format(this.date);
        return ("Complaint{date=" +formatDate+ "desc='" +this.desc+ "'}");
    }
}