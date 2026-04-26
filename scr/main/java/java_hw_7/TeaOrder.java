package java_hw_7;


public class TeaOrder extends Order {
    private String teaType;

    public TeaOrder(String orderNumber, String teaType) {
        super(orderNumber);
        this.teaType = teaType;
    }

    public String getTeaType() {
        return teaType;
    }

    public void setTeaType(String teaType) {
        this.teaType = teaType;
    }

    @Override
    public double getPrice() {
        if (teaType == null) return 0.0;
        switch (teaType.toLowerCase()) {
            case "black":  return 2.0;
            case "green":  return 3.0;
            case "herbal": return 4.0;
            default:       return 0.0;
        }
    }
}
