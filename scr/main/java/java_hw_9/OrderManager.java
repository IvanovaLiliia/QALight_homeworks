package java_hw_9;

import java_hw_7.Order;
import java_hw_9.CoffeeOrder;
import java_hw_9.DessertOrder;
import java_hw_9.TeaOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    public List<Order> getAllOrders() {
        return new ArrayList<>(orders);
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

    public double calculateTotal(List<Order> orderList) {
        double total = 0;
        for (Order order : orderList) {
            total += order.getPrice();
        }
        return total;
    }

    public Map<String, Integer> getOrderTypeCounts() {
        Map<String, Integer> counts = new HashMap<>();

        for (Order order : orders) {
            if (order instanceof CoffeeOrder) {
                counts.put("Coffee", counts.getOrDefault("Coffee", 0) + 1);
            } else if (order instanceof TeaOrder) {
                counts.put("Tea", counts.getOrDefault("Tea", 0) + 1);
            } else if (order instanceof DessertOrder) {
                counts.put("Dessert", counts.getOrDefault("Dessert", 0) + 1);
            }
        }

        return counts;
    }
}