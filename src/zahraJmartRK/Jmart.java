package zahraJmartRK;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.util.stream.Collectors;

class Jmart {
    public static void main(String[] args) {
        try {
            JsonTable<Payment> table = new JsonTable<>(Payment.class, "C:/Users/Zahra/repo baru/jmart/jmart.json");
            ObjectPoolThread<Payment> paymentPool = new ObjectPoolThread<Payment>("Thread-PP", Jmart::paymentTimekeeper);
            paymentPool.start();
            table.forEach(payment -> paymentPool.add(payment));
            while (paymentPool.size() != 0) ;
            paymentPool.exit();
            while (paymentPool.isAlive()) ;
            System.out.println("Thread exited Successfully");
            Gson gson = new Gson();
            table.forEach(payment -> {
                String history = gson.toJson(payment.history);
                System.out.println(history);
            });
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static boolean paymentTimekeeper(Payment payment) {
        Payment.Record record = payment.history.get(payment.history.size() - 1);
        long elapsed = Math.abs(record.date.getTime() - (new Date()).getTime());

        if(record.status == Invoice.Status.WAITING_CONFIRMATION && elapsed > WAITING_CONF_LIMIT_MS) {
            payment.history.add(new Payment.Record(Invoice.Status.FAILED, "Waiting"));
            return true;
        } else if(record.status == Invoice.Status.ON_PROGRESS && elapsed > ON_PROGRESS_LIMIT_MS) {
            payment.history.add(new Payment.Record(Invoice.Status.FAILED, "Progress"));
            return true;
        } else if(record.status == Invoice.Status.ON_DELIVERY && elapsed > ON_DELIVERY_LIMIT_MS) {
            payment.history.add(new Payment.Record(Invoice.Status.DELIVERED, "Delivery"));
            return false;
        } else if(record.status == Invoice.Status.DELIVERED && elapsed > DELIVERED_LIMIT_MS) {
            payment.history.add(new Payment.Record(Invoice.Status.FINISHED, "Finish"));
            return true;
        }
        return false;
    }

    public static long DELIVERED_LIMIT_MS = 3;
    public static long ON_DELIVERY_LIMIT_MS = 3;
    public static long ON_PROGRESS_LIMIT_MS = 3;
    public static long WAITING_CONF_LIMIT_MS = 3;
}