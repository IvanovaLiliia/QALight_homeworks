package java_hw_10;

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

    public void addOrder(Order order) throws DuplicateOrderException {

        if (order == null) {
            return;
        }

        for (Order existingOrder : orders) {
            if (existingOrder.getOrderNumber()
                    .equals(order.getOrderNumber())) {

                throw new DuplicateOrderException(
                        "Order with number "
                                + order.getOrderNumber()
                                + " already exists."
                );
            }
        }

        orders.add(order);
    }

    public void removeOrderByNumber(String orderNumber)
            throws OrderNotFoundException {

        Order orderToRemove = findOrderByNumber(orderNumber);

        orders.remove(orderToRemove);
    }

    public Order findOrderByNumber(String orderNumber)
            throws OrderNotFoundException {

        for (Order order : orders) {
            if (order.getOrderNumber().equals(orderNumber)) {
                return order;
            }
        }

        throw new OrderNotFoundException(
                "Order with number "
                        + orderNumber
                        + " not found."
        );
    }

    public void setOrderStatus(String orderNumber, String status)
            throws OrderNotFoundException,
            InvalidOrderStatusException {

        if (!status.equals("NEW")
                && !status.equals("CANCELED")
                && !status.equals("COMPLETED")) {

            throw new InvalidOrderStatusException(
                    "Invalid status: " + status
            );
        }

        Order order = findOrderByNumber(orderNumber);

        order.setStatus(status);
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

    public double calculateTotal(List<Order> orderList)
            throws NoOrdersException {

        if (orderList == null || orderList.isEmpty()) {
            throw new NoOrdersException(
                    "Order list is empty."
            );
        }

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
                counts.put(
                        "Coffee",
                        counts.getOrDefault("Coffee", 0) + 1
                );

            } else if (order instanceof TeaOrder) {

                counts.put(
                        "Tea",
                        counts.getOrDefault("Tea", 0) + 1
                );

            } else if (order instanceof DessertOrder) {

                counts.put(
                        "Dessert",
                        counts.getOrDefault("Dessert", 0) + 1
                );
            }
        }

        return counts;
    }
}