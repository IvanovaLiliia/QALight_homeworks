package java_hw_10;

import java_hw_7.Order;
import java_hw_9.CoffeeOrder;
import java_hw_9.DessertOrder;
import java_hw_9.TeaOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        OrderManager test = new OrderManager();

        try {

            test.addOrder(new CoffeeOrder("1", "small"));
            test.addOrder(new CoffeeOrder("2", "large"));
            test.addOrder(new TeaOrder("3", "herbal"));
            test.addOrder(new DessertOrder("4", "redvelvet"));


            test.addOrder(new CoffeeOrder("1", "medium"));

        } catch (DuplicateOrderException e) {

            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("\nAll orders:");

        for (Order order : test.getAllOrders()) {
            order.printOrderInfo();
        }

        try {

            test.setOrderStatus("4", "CANCELED");

            Order canceled = test.findOrderByNumber("4");

            System.out.println("Order canceled:");
            canceled.printOrderInfo();

        } catch (OrderNotFoundException |
                 InvalidOrderStatusException e) {

            System.out.println("ERROR: " + e.getMessage());
        }

        try {

            test.setOrderStatus("3", "INVALID_STATUS");

        } catch (OrderNotFoundException |
                 InvalidOrderStatusException e) {

            System.out.println("ERROR: " + e.getMessage());
        }

        try {

            test.removeOrderByNumber("2");
            System.out.println(" Order 2 removed");

        } catch (OrderNotFoundException e) {

            System.out.println("ERROR: " + e.getMessage());
        }

        try {

            test.removeOrderByNumber("100");

        } catch (OrderNotFoundException e) {

            System.out.println("ERROR: " + e.getMessage());
        }

        try {

            Order found = test.findOrderByNumber("3");

            System.out.println("\nFound order:");
            found.printOrderInfo();

        } catch (OrderNotFoundException e) {

            System.out.println("ERROR: " + e.getMessage());
        }

        try {

            test.findOrderByNumber("999");

        } catch (OrderNotFoundException e) {

            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println(" Orders with status NEW:");

        List<Order> newOrders =
                test.getOrdersByStatus(Order.STATUS_NEW);

        for (Order order : newOrders) {
            order.printOrderInfo();
        }

        try {

            double total = test.calculateTotal(newOrders);

            System.out.println(
                    " Total for NEW orders: $" + total
            );

        } catch (NoOrdersException e) {

            System.out.println("ERROR: " + e.getMessage());
        }

        try {

            List<Order> emptyList = new ArrayList<>();

            test.calculateTotal(emptyList);

        } catch (NoOrdersException e) {

            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println(" Order type counts:");

        Map<String, Integer> counts =
                test.getOrderTypeCounts();

        for (Map.Entry<String, Integer> entry
                : counts.entrySet()) {

            System.out.println(
                    entry.getKey() + ": " + entry.getValue()
            );
        }
    }
}