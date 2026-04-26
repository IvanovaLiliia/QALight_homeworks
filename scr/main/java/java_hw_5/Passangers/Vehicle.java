package java_hw_5.Passangers;

public class Vehicle {

        private String name;
        private int speed;

        public Vehicle(String name, int speed) {
            this.name = name;
            this.speed = speed;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSpeed() {
            return this.speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        // Методи
        public void move() {
            System.out.println("The vehicle is moving " + this.speed + " km/h");
        }

        public void stop() {
            System.out.println("The vehicle " + this.name + " has stopped");
        }
    }

