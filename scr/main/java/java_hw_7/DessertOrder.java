package java_hw_7;


public class DessertOrder extends Order {
    private String dessertName;

    public DessertOrder(String orderNumber, String dessertName) {
        super(orderNumber);
        this.dessertName = dessertName;
    }

    public String getDessertName() {
        return dessertName;
    }

    public void setDessertName(String dessertName) {
        this.dessertName = dessertName;
    }

    @Override
    public double getPrice() {
        if (dessertName == null) return 0.0;
        switch (dessertName.toLowerCase()) {
            case "tiramisu":     return 5.0;
            case "redvelvet":    return 6.0;
            case "sansebastian": return 7.5;
            default:             return 0.0;
        }
    }
}
