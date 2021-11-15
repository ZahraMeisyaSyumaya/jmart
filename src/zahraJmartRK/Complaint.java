package zahraJmartRK;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Complaint extends Serializable
    {
        public Date date;
        public String desc;

        public Complaint(String desc){
            this.desc = desc;
            this.date = new Date();
            System.out.println(date);
        }

        @Override
        public String toString(){
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            return ("Complaint{date=" + df.format(date) + ", desc='" + desc + "'}");
        }


    }