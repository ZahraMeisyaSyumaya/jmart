package com.zahraJmartRK;
import com.zahraJmartRK.dbjson.Serializable;

import java.util.regex.*;
import java.util.regex.Pattern;

public class Account extends Serializable
{
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9&*_~]+(\\.[a-zA-Z0-9&*_~]+)*@[a-zA-Z0-9][a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    public static final String REGEX_PASSWORD = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?!.* ).{8,}$";
    public String name;
    public String email;
    public String password;
    public double balance;
    public Store store;

    public Account(String name, String email, String password, double balance){
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
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

    @Override
    public String toString(){
        return ("name: " + name + "\nemail: " + email + "\npassword: " + password);
    }

}

