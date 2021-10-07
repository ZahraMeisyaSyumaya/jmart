package zahraJmartRK;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write a description of class Store here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Store extends Recognizable implements FileParser
{
    public static final String REGEX_PHONE = "^\\d{9, 12}$";
    public static final String REGEX_NAME = "^[A-Z](?!.*(\\s)\\1).{4,20}$";
    public String name;
    public String address;
    public String phoneNumber;
    
    public Store(int accountId, String name, String address, String phoneNumber){
        super(accountId);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    public Store(Account account, String name, String address, String phoneNumber){
        super(account.id);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public boolean read(String content){
        return false;
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