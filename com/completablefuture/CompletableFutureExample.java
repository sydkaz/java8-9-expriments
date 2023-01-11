package com.completablefuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Payment {
    int invoicenumber;
    double payment;

    public Payment(int invoicenumber, double payment) {
        this.invoicenumber = invoicenumber;
        this.payment = payment;
    }
}

class Order {
    int orderId;
    String orderSKU;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderSKU() {
        return orderSKU;
    }

    public void setOrderSKU(String orderSKU) {
        this.orderSKU = orderSKU;
    }

    public Order(int orderId, String orderSKU) {
        this.orderId = orderId;
        this.orderSKU = orderSKU;
    }

    public Order getOrder(int id){
        System.out.println("getOrder >>>>>>> ");
        return  this;
    }
    public Order getEnrichedOrder(Order o){
        System.out.println("getEnrichedOrder >>>>>>> ");
        return  this;
    }

    public PaymentOrderObj performPayment(Order o){
        System.out.println("performPayment >>>>>>> ");
        return new PaymentOrderObj(o,new Payment(o.orderId,new Random().nextInt(500))) ;
    }

    public PaymentOrderObj disPatchOrder(PaymentOrderObj p){
        System.out.println("disPatchOrder >>>>>>> ");
        System.out.println("going in a sleep  >>>>>>> ");
       try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        p.setDispatched(true);
        p.setTraching(new Random().nextInt(500) + "");
        return  p;
    }

    public PaymentOrderObj sendEmail(PaymentOrderObj p){
        System.out.println("sendEmail >>>>>>> ");
          p.isEmailSent = true;
        return p;
    }
}

class PaymentOrderObj{
public Order oO;
public Payment p;

boolean isDispatched;
    boolean isEmailSent;
String traching;

    public PaymentOrderObj(Order oO, Payment p) {
        this.oO = oO;
        this.p = p;
    }

    public Order getoO() {
        return oO;
    }

    public void setoO(Order oO) {
        this.oO = oO;
    }

    public Payment getP() {
        return p;
    }

    public void setP(Payment p) {
        this.p = p;
    }

    public boolean isDispatched() {
        return isDispatched;
    }

    public void setDispatched(boolean dispatched) {
        isDispatched = dispatched;
    }

    public String getTraching() {
        return traching;
    }

    public void setTraching(String traching) {
        this.traching = traching;
    }
}
public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es1 = Executors.newFixedThreadPool(2);
        ExecutorService es2 = Executors.newCachedThreadPool();
        /*for(var ref = new Object() {
            int i = 0;
        }; ref.i <= 1; ref.i++){*/
            Order o = new Order(1, "1");
            CompletableFuture f = CompletableFuture.supplyAsync(()->o.getOrder(1),es1)
                    .thenApplyAsync(order -> o.getEnrichedOrder(order),es2)
                    .thenApplyAsync(order -> o.performPayment(order))
                    .thenApplyAsync(paymentOrderObj -> o.disPatchOrder(paymentOrderObj))
                    .thenApplyAsync((paymentOrderObj) -> o.sendEmail(paymentOrderObj));

        /*}*/
        System.out.println(f.isDone());
        System.out.println("main thread");


    }


}
