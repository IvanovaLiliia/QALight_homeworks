package java_hw_5.Passangers;

public class Car extends Vehicle {

    private int passengerCapacity;

    public Car(String name, int speed, int passengerCapacity) {
        super(name, speed);
        this.passengerCapacity = passengerCapacity;
    }

    public int getPassengerCapacity() {
        return this.passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public void move() {
        System.out.println("The vehicle " + this.getName() +
                " is moving " + this.getSpeed() +
                " km/h with " + this.passengerCapacity + " passengers");
    }
}

