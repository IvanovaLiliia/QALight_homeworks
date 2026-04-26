package java_hw_5.TypeOfAnimal;

public class Bird extends Animal {

    public Bird(String name) {
        super(name);
    }

    public void fly() {
        System.out.println(this.getAnimalName() + ": I`m flying");
    }

}

