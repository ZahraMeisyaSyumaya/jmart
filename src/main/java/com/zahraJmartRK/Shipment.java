package com.zahraJmartRK;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Calendar;

public class Shipment
{
    public String address;
    public int cost;
    public byte plan;
    public String receipt;

    public static final SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("EEE MMMM dd yyyy");
    public static final Plan INSTANT = new Plan((byte)(1<<0));
    public static final Plan SAME_DAY = new Plan((byte)(1<<1));
    public static final Plan NEXT_DAY = new Plan((byte)(1<<2));
    public static final Plan REGULER = new Plan((byte)(1<<3));
    public static final Plan KARGO = new Plan((byte)(1<<4));

    public static class Plan
    {
        public final byte bit;
        private Plan(byte bit)
        {
            this.bit = bit;
        }
    }

    public Shipment(String address, int cost, byte plan, String receipt){
        this.address = address;
        this.cost = cost;
        this.plan = plan;
        this.receipt = receipt;
    }

    public String getEstimatedArrival(Date reference)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(reference);
        if (plan == INSTANT.bit || plan == SAME_DAY.bit)
        {
            calendar.add(Calendar.DATE, 0);
        }
        if(plan == NEXT_DAY.bit)
        {
            calendar.add(Calendar.DATE, 1);
        }
        else if(plan == REGULER.bit)
        {
            calendar.add(Calendar.DATE, 2);
        }
        else if(plan == KARGO.bit)
        {
            calendar.add(Calendar.DATE, 5);
        }
        return (ESTIMATION_FORMAT.format(calendar.getTime()));
    }

    public boolean isDuration(Plan reference)
    {
        if((plan & reference.bit) != 0){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isDuration(byte object, Plan reference)
    {
        if((object & reference.bit) != 0){
            return true;
        }else{
            return false;
        }
    }
}