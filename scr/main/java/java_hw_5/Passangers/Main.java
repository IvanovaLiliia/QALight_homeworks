package java_hw_5.Passangers;

public class Main {
    public static void main(String[] args) {
        // Створення об'єктів
        Car car = new Car("BMW", 100, 5);
        Truck truck = new Truck("Mercedes", 80, 8.5);

        // Демонстрація роботи
        car.move();
        car.stop();

        System.out.println();

        truck.move();
        truck.stop();
    }
}
