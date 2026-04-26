package java_hw_8;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        OrderManager Test = new OrderManager();

        Test.addOrder(new CoffeeOrder("1", "small"));
        Test.addOrder(new CoffeeOrder("2", "large"));
        Test.addOrder(new TeaOrder("3", "herbal"));
        Test.addOrder(new DessertOrder("4", "redvelvet"));


        System.out.println("All orders:");
        for (java_hw_7.Order order : Test.getAllOrders()) {
            order.printOrderInfo();
        }

        java_hw_7.Order CancelOrder = Test.findOrderByNumber("4");
        if (CancelOrder != null) {
            CancelOrder.setStatus(Order.STATUS_CANCELED);
            System.out.println("Order " + CancelOrder.getOrderNumber() + " canceled");
            CancelOrder.printOrderInfo();
        }

        Test.removeOrderByNumber("2");
        System.out.println("Order 2 removed");



        java_hw_7.Order found = Test.findOrderByNumber("3");
        if (found != null) {
            System.out.println("Found order:");
            found.printOrderInfo();
        }

        System.out.println("Orders with status NEW:");
        List<java_hw_7.Order> newOrders = Test.getOrdersByStatus(Order.STATUS_NEW);
        for (java_hw_7.Order order : newOrders) {
            order.printOrderInfo();
        }

        double total = Test.calculateTotal(newOrders);
        System.out.println("Total for NEW orders: $" + total);
    }
}