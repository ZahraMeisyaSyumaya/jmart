package zahraJmartRK;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Store extends Recognizable
{
    public static final String REGEX_PHONE = "^\\d{9, 12}$";
    public static final String REGEX_NAME = "^[A-Z](?!.*(\\s)\\1).{4,20}$";
    public String name;
    public String address;
    public double balance;
    public String phoneNumber;

    public Store(int id, String name, String address, String phoneNumber, double balance)
    {
        super(id);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    @Override
    public String toString(){
        return(
            "name: " + this.name +"\n" +
            "address: " + this.address + "\n" +
            "phoneNumber: " + this.phoneNumber + "\n"
        );
    }
    
    public boolean validate() {
        Pattern namePattern = Pattern.compile(REGEX_NAME);
        Matcher nameMatcher = namePattern.matcher(this.name);
        Pattern telpPattern = Pattern.compile(REGEX_PHONE);
        Matcher telpMatcher = telpPattern.matcher(this.phoneNumber);
        boolean nameMatch = nameMatcher.find();
        boolean telpMatch = telpMatcher.find();
        
        if(nameMatch == true && telpMatch == true){
            return true;
        }
        return false;
    }

}