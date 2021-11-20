package com.zahraJmartRK;

import com.google.gson.*;

import com.zahraJmartRK.dbjson.JsonDBEngine;
import com.zahraJmartRK.dbjson.JsonTable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Jmart {

    /*public static long DELIVERED_LIMIT_MS = 3;
    public static long ON_DELIVERY_LIMIT_MS = 3;
    public static long ON_PROGRESS_LIMIT_MS = 3;
    public static long WAITING_CONF_LIMIT_MS = 3;
    */
    public static void main(String[] args) {
        JsonDBEngine.Run(Jmart.class);
        SpringApplication.run(Jmart.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));

        /*
        try {
            JsonTable<Payment> table = new JsonTable<>(Payment.class, "C:/Users/Zahra/repo baru/jmart/json/randomPaymentList.json");
            ObjectPoolThread<Payment> paymentPool = new ObjectPoolThread<Payment>("Thread", Jmart::paymentTimekeeper);
            paymentPool.start();
            table.forEach(payment -> paymentPool.add(payment));
            while (paymentPool.size() != 0) ;
            paymentPool.exit();
            while (paymentPool.isAlive()) ;
            System.out.println("Thread succeed");
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
        if (payment.history.size() == 0) {
            return true;
        } else {
            Payment.Record record = payment.history.get(payment.history.size() - 1);
            long elapsed = System.currentTimeMillis() - record.date.getTime();

            if (record.status == Invoice.Status.WAITING_CONFIRMATION && elapsed > WAITING_CONF_LIMIT_MS) {
                payment.history.add(new Payment.Record(Invoice.Status.FAILED, "WAITING"));
                return true;
            } else if (record.status == Invoice.Status.ON_PROGRESS && elapsed > ON_PROGRESS_LIMIT_MS) {
                payment.history.add(new Payment.Record(Invoice.Status.FAILED, "ON PROGRESS"));
                return true;
            } else if (record.status == Invoice.Status.ON_DELIVERY && elapsed > ON_DELIVERY_LIMIT_MS) {
                payment.history.add(new Payment.Record(Invoice.Status.DELIVERED, "ON DELIVERY"));
                return true;
            } else if (record.status == Invoice.Status.DELIVERED && elapsed > DELIVERED_LIMIT_MS) {
                payment.history.add(new Payment.Record(Invoice.Status.FINISHED, "DELIVERED"));
                return true;
            } else {
                return false;
            }
        }

         */
    }

}



