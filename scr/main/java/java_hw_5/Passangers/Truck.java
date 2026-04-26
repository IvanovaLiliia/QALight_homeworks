package java_hw_5.Passangers;

public class Truck extends Vehicle {
    private double loadCapacity;

    public Truck(String name, int speed, double loadCapacity) {
        super(name, speed);
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity() {
        return this.loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void move() {
        System.out.println("The vehicle " + this.getName() +
                " load capacity " + this.loadCapacity +
                " and moving " + this.getSpeed() + " km/h");
    }
}

