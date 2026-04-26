package java_hw_5.TypeOfAnimal;

public class Animal {

    private String animalName;

    public Animal(String animalName) {
        this.animalName = animalName;
    }
    public String getAnimalName() {
        return this.animalName;
    }

    public void setName(String name) {
        this.animalName = animalName;
    }
    public void eat() {
        System.out.println(this.animalName + ": I`m eating.");
    }
    public void sleep() {
        System.out.println(this.animalName + ": I`m sleeping.");
    }
    }


