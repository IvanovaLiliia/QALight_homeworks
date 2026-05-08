package java_hw_9;

import java_hw_7.Order;

public class CoffeeOrder extends Order {
    private String size;

    public CoffeeOrder(String orderNumber, String size) {
        super(orderNumber);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public double getPrice() {
        if (size == null) return 0.0;
        switch (size.toLowerCase()) {
            case "small":  return 3.0;
            case "medium": return 4.0;
            case "large":  return 4.5;
            default:       return 0.0;
        }
    }
}

