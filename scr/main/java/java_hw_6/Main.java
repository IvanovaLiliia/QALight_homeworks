package java_hw_6;

public class Main {
    public static void main(String[] args) {
        Order[] orders = new Order[]{
                new CoffeeOrder("1", "small"),
                new CoffeeOrder("2", "large"),
                new TeaOrder("3", "herbal"),
                new DessertOrder("4", "redvelvet" +
                        ""),
        };
        for (Order order : orders) {
            order.printOrderInfo();
        }
        OrderManager manager = new OrderManager();
        double total = manager.calculateTotal(orders);

        System.out.println("Total price: " + total);
    }
    }