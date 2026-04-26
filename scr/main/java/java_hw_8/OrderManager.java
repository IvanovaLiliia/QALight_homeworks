package java_hw_8;

import java_hw_7.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {

    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        if (order != null) {
            orders.add(order);
        }
    }

    public void removeOrderByNumber(String orderNumber) {
        orders.removeIf(order -> order.getOrderNumber().equals(orderNumber));
    }

    public Order findOrderByNumber(String orderNumber) {
        for (Order order : orders) {
            if (order.getOrderNumber().equals(orderNumber)) {
                return order;
            }
        }
        return null;
    }

    public List<Order> getOrdersByStatus(String status) {
        List<Order> result = new ArrayList<>();

        for (Order order : orders) {
            if (order.getStatus().equals(status)) {
                result.add(order);
            }
        }

        return result;
    }

    public double calculateTotal(List<Order> orders) {
        double total = 0.0;

        if (orders == null) return total;

        for (Order order : orders) {
            if (order != null && order.getStatus().equals(Order.STATUS_NEW)) {
                total += order.getPrice();
            }
        }

        return total;
    }

    public List<Order> getAllOrders() {
        return orders;
    }
}