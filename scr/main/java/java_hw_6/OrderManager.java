package java_hw_6;

public class OrderManager {

        public double calculateTotal(Order[] orders) {
            double total = 0;
            for (Order order : orders) {
                total += order.getPrice();
            }
            return total;
        }
    }

