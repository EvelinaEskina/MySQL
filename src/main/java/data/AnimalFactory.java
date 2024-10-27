package data;

import animal.bird.Duck;
import animal.pet.Cat;
import animal.pet.Dog;
import objects.Animal;

import java.util.Arrays;
import java.util.List;

public class AnimalFactory {
    public static Animal create(String name, int age, int weight, String colour, String type) {
        switch (type) {
            case "Cat":
                return new Cat(name, age, colour,weight,type);
            case "Dog":
                return new Dog(name, age, colour, weight, type);
            case "Duck":
                return new Duck(name, age, colour, weight,type);
            default:
                throw new IllegalArgumentException("Некорректный тип " + type);


        }
    }
    public static final List<String> ANIMAL_TYPES = Arrays.asList("Cat","Dog","Duck");
}



