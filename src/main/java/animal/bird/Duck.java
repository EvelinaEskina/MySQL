package animal.bird;

import objects.Animal;

public class Duck extends Animal implements Flying {

    public Duck(String name, int age, String colour, int weight, String type) {
        super(name,type,colour,weight,age);
    }

    @Override
    public void say() {
        System.out.println("Кря-Кря");
    }

    @Override
    public void fly() {
        System.out.println("Я лечу");

    }

}
