package java_hw_6;

public class CoffeeOrder extends Order {

    private String size;

    public CoffeeOrder(String OrderNumber, String Size) {
        super(OrderNumber);
        this.size = Size;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public double getPrice() {
        switch (this.size.toLowerCase()) {
            case "small": return 3.0;
            case "medium": return 4.0;
            case "large": return 4.5;
            default: return 0;
        }
}
}
