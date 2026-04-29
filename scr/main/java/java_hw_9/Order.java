package java_hw_9;

import java_hw_9.Pricable;
import java_hw_9.Printable;

public abstract class Order implements Pricable, Printable {
    public static final String STATUS_NEW = "NEW";
    public static final String STATUS_CANCELED = "CANCELED";
    public static final String STATUS_COMPLETED = "COMPLETED";

    private String orderNumber;
    private String status;

    public Order(String orderNumber) {
        this.orderNumber = orderNumber;
        this.status = STATUS_NEW;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public void printOrderInfo() {
        System.out.println(
                "Order #" + orderNumber +
                        ", Type: " + this.getClass().getSimpleName() +
                        ", Status: " + status +
                        ", Price: $" + getPrice()
        );
    }
}
