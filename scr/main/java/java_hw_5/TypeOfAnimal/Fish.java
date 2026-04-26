package java_hw_5.TypeOfAnimal;

public class Fish extends Animal{

    public Fish(String name) {
        super(name);
    }
    public void swim() {
        System.out.println(this.getAnimalName() + ": I`m swimming");
    }
}
