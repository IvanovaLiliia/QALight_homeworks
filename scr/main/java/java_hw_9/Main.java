package java_hw_9;

import java_hw_9.CoffeeOrder;
import java_hw_9.DessertOrder;
import java_hw_9.Order;
import java_hw_9.OrderManager;
import java_hw_9.TeaOrder;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        java_hw_9.OrderManager test = new OrderManager();

        test.addOrder(new java_hw_8.CoffeeOrder("1", "small"));
        test.addOrder(new CoffeeOrder("2", "large"));
        test.addOrder(new TeaOrder("3", "herbal"));
        test.addOrder(new DessertOrder("4", "redvelvet"));

        System.out.println("All orders:");
        for (java_hw_7.Order order : test.getAllOrders()) {
            order.printOrderInfo();
        }

        java_hw_7.Order cancelOrder = test.findOrderByNumber("4");
        if (cancelOrder != null) {
            cancelOrder.setStatus(java_hw_8.Order.STATUS_CANCELED);
            System.out.println("Order " + cancelOrder.getOrderNumber() + " canceled");
            cancelOrder.printOrderInfo();
        }

        test.removeOrderByNumber("2");
        System.out.println("Order 2 removed");

        java_hw_7.Order found = test.findOrderByNumber("3");
        if (found != null) {
            System.out.println("Found order:");
            found.printOrderInfo();
        }

        System.out.println("Orders with status NEW:");
        List<java_hw_7.Order> newOrders = test.getOrdersByStatus(Order.STATUS_NEW);
        for (java_hw_7.Order order : newOrders) {
            order.printOrderInfo();
        }

        double total = test.calculateTotal(newOrders);
        System.out.println("Total for NEW orders: $" + total);


        System.out.println("Order type counts:");
        Map<String, Integer> counts = test.getOrderTypeCounts();
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}