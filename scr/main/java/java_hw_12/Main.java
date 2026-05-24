package java_hw_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java_hw_12.OrderStatus.NEW;

public class Main {

    public static void main(String[] args) {

        OrderManager test = new OrderManager();

        try {

            // создание заказов с enum-ами
            test.addOrder(new CoffeeOrder("1", CoffeeSize.SMALL));
            test.addOrder(new CoffeeOrder("2", CoffeeSize.LARGE));
            test.addOrder(new TeaOrder("3", TeaType.HERBAL));
            test.addOrder(new DessertOrder("4", "redvelvet"));

            test.addOrder(new CoffeeOrder("1", CoffeeSize.MEDIUM));

        } catch (DuplicateOrderException e) {

            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("\nAll orders:");

        for (Order order : test.getAllOrders()) {
            order.printOrderInfo();
        }

        try {

            // изменение статуса через enum
            test.setOrderStatus("4", OrderStatus.CANCELED);

            Order canceled = test.findOrderByNumber("4");

            System.out.println("\nOrder canceled:");
            canceled.printOrderInfo();

        } catch (OrderNotFoundException |
                 InvalidOrderStatusException e) {

            System.out.println("ERROR: " + e.getMessage());
        }

        try {

            test.setOrderStatus("3", NEW);

        } catch (OrderNotFoundException |
                 InvalidOrderStatusException e) {

            System.out.println("ERROR: " + e.getMessage());
        }

        try {

            test.removeOrderByNumber("2");
            System.out.println("\nOrder 2 removed");

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

        System.out.println("\nOrders with status NEW:");

        List<Order> newOrders =
                test.getOrdersByStatus(NEW);

        for (Order order : newOrders) {
            order.printOrderInfo();
        }

        try {

            double total = test.calculateTotal(newOrders);

            System.out.println(
                    "\nTotal for NEW orders: $" + total
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

        System.out.println("\nOrder type counts:");

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
