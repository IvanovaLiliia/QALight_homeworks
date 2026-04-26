package java_hw_5.TypeOfAnimal;

public class Main {
    public static void main(String[] args) {
        Bird bird = new Bird("Bird");
        Fish fish = new Fish("Fish");
        Dog dog = new Dog("Dog");

        bird.eat();
        bird.sleep();
        bird.fly();

        System.out.println();

        fish.eat();
        fish.sleep();
        fish.swim();

        System.out.println();

        dog.eat();
        dog.sleep();
        dog.bark();
    }
}
