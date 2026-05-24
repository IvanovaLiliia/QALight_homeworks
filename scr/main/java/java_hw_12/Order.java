package java_hw_12;

public abstract class Order implements Pricable, Printable {

    private String orderNumber;
    private OrderStatus status;

    public Order(String orderNumber) {
        this.orderNumber = orderNumber;
        this.status = OrderStatus.NEW;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
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
