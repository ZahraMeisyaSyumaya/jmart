package zahraJmartRK;
import java.util.regex.*;
import java.util.regex.Pattern;

/**
 * Write a description of class Account here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Account extends Recognizable implements FileParser
{
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9&*_~]+(\\.[a-zA-Z0-9&*_~]+)*@[a-zA-Z0-9][a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    public static final String REGEX_PASSWORD = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?!.* ).{8,}$";
    public String name;
    public String email;
    public String password;

    public Account(int id, String name, String email, String password){
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    @Override
    public boolean read(String content){
        return false;
    }
    
    @Override
    public Object write()
    {
        return null;
    }

    @Override
    public String toString(){
        return(
            "name: " + this.name +"\n" +
            "email: " + this.email + "\n" +
            "password: " + this.password + "\n"
        );
    }
    
    public boolean validate() {
        Pattern passwordPattern = Patern.compile(REGEX_PASSWORD);
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