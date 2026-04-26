package java_hw_7;

public class OrderManager {


    public double calculateTotal(Order[] orders) {
        double total = 0.0;
        if (orders == null) return total;

        for (Order order : orders) {
            if (order != null && order.getStatus() == Order.STATUS_NEW) {
                total += order.getPrice();
            }
        }
        return total;
    }
}
