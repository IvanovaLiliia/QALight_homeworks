package java_hw_6;

public class DessertOrder extends Order {
    private String DessertName;
    public DessertOrder(String OrderNumber, String DessertName) {
        super(OrderNumber);
        this.DessertName = DessertName;
    }
    public String getDessertName() {
        return DessertName;
    }
    public void setDessertName(String DessertName) {
        this.DessertName = DessertName;
    }

    @Override
    public double getPrice() {
        switch (this.DessertName.toLowerCase()) {
            case "tiramissu": return 5.0;
            case "redvelvet": return 6.0;
            case "sansebastian": return 7.5;
            default: return 0;
        }
    }
}
