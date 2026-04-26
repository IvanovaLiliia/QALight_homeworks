package java_hw_5.TypeOfAnimal;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }
    public void bark() {
        System.out.println(this.getAnimalName() + ": I`m barking");
    }
}
