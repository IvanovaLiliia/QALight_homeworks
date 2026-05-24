package java_hw_12;

public class TeaOrder extends Order {

    private TeaType teaType;

    public TeaOrder(String orderNumber, TeaType teaType) {
        super(orderNumber);
        this.teaType = teaType;
    }

    public TeaType getTeaType() {
        return teaType;
    }

    public void setTeaType(TeaType teaType) {
        this.teaType = teaType;
    }

    @Override
    public double getPrice() {
        if (teaType == null) return 0.0;

        switch (teaType) {
            case BLACK:
                return 2.0;

            case GREEN:
                return 3.0;

            case HERBAL:
                return 4.0;

            default:
                return 0.0;
        }
    }
}
