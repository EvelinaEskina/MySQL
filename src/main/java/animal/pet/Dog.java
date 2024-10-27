package animal.pet;

import objects.Animal;

public class Dog extends Animal {

    public Dog(String name, int age, String colour, int weight, String type) {
        super(name,type,colour,weight,age);
    }

    @Override
    public void say() {
        System.out.println("Гав-Гав");
    }
}

