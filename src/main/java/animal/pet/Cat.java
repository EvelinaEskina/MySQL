package animal.pet;

import objects.Animal;

public class Cat extends Animal {
    public Cat(String name, int age, String colour, int weight, String type) {
        super(name,type,colour,weight,age);
    }

    @Override
    public void say() {
        System.out.println("Мяу-мяу");

    }
}
