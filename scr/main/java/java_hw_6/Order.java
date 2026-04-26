package java_hw_6;

public abstract class Order {

    private String OrderNumber;

    public Order (String OrderNumber) {
        this.OrderNumber = OrderNumber;
    }

    public String getOrderNumber() {
        return OrderNumber;
    }
    public void setOrderNumber(String OrderNumber) {
        this.OrderNumber = OrderNumber;
    }
    public abstract double getPrice();
    public void printOrderInfo() {
        System.out.println("Order #" + OrderNumber + ", Type: " + this.getClass().getSimpleName());
    }

}
