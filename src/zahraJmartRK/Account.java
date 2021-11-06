package zahraJmartRK;
import java.util.regex.*;
import java.util.regex.Pattern;

public class Account extends Serializable
{
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9&*_~]+(\\.[a-zA-Z0-9&*_~]+)*@[a-zA-Z0-9][a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    public static final String REGEX_PASSWORD = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?!.* ).{8,}$";
    public double balance;
    public String name;
    public String email;
    public String password;
    public Store store;

    public Account(String name, String email, String password, double balance)
    {
        this.balance = balance;
        this.name = name;
        this.email = email;
        this.password = password;
    }


    public boolean validate() {
        Pattern passwordPattern = Pattern.compile(REGEX_PASSWORD);
        Matcher passwordMatcher = passwordPattern.matcher(this.password);
        Pattern emailPattern = Pattern.compile(REGEX_EMAIL);
        Matcher emailMatcher = emailPattern.matcher(this.email);
        boolean passwordMatch = passwordMatcher.find();
        boolean emailMatch = emailMatcher.find();

        if(passwordMatch == true && emailMatch == true){
            return true;
        }
        return false;
    }
}



