package java_hw_6;

public class TeaOrder extends Order {

    private String teaType;
    public TeaOrder(String OrderNumber, String teaType ) {
        super(OrderNumber);
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
        switch (this.teaType.toLowerCase()) {
            case "black": return 2.0;
            case "green": return 3.0;
            case "herbal": return 4.0;
            default: return 0;
        }
    }
}
