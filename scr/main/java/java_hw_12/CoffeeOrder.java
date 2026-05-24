package java_hw_12;

public class CoffeeOrder extends Order {

    private CoffeeSize size;

    public CoffeeOrder(String orderNumber, CoffeeSize size) {
        super(orderNumber);
        this.size = size;
    }

    public CoffeeSize getSize() {
        return size;
    }

    public void setSize(CoffeeSize size) {
        this.size = size;
    }

    @Override
    public double getPrice() {

        if (size == null) {
            return 0.0;
        }

        switch (size) {

            case SMALL:
                return 3.0;

            case MEDIUM:
                return 4.0;

            case LARGE:
                return 4.5;

            default:
                return 0.0;
        }
    }

    @Override
    public void printOrderInfo() {
        System.out.println(
                "Coffee order #" + getOrderNumber() +
                        ", size: " + size +
                        ", status: " + getStatus() +
                        ", price: $" + getPrice()
        );
    }
}
