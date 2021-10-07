package zahraJmartRK;
import java.text.SimpleDateFormat;
import java.util.Date;

// Zahra Meisya Syumaya
// 1906300870    

    
public class Jmart
{
    public static void main (String[] args)
    {
        System.out.println(Shipment.Duration.INSTANT.getEstimatedArrival(new Date())); 
     
        Account account = new Account(80,"hiu keren","zahra@gmail.com","aqhiu");
        account.validate();
        System.out.print(account);
        
        Complaint complaint = new Complaint (22, "mau komplen nih");
        System.out.print(complaint);
    }
}
        