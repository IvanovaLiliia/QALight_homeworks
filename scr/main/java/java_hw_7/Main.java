package java_hw_7;

public class Main {
    public static void main(String[] args) {

        Order[] orders = new Order[] {
                new CoffeeOrder("1", "small"),
                new CoffeeOrder("2", "large"),
                new TeaOrder("3", "herbal"),
                new DessertOrder("4", "redvelvet")
        };

        System.out.println("All orders");
        for (Order order : orders) {
            order.printOrderInfo();
        }

        orders[3].setStatus(Order.STATUS_CANCELED);
        System.out.println("Order " + orders[3].getOrderNumber() + " Cancelled ");

        OrderManager manager = new OrderManager();
        double total = manager.calculateTotal(orders);

        System.out.println("Updated Statuses ");
        for (Order order : orders) {
            order.printOrderInfo();
        }

        System.out.println("Total: $" + total);
    }
}
