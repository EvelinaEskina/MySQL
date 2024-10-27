package objects;

public class Animal  implements  IObjectDB {
    private int id;
    private String color,name,type;
    private int weight,age;

    public Animal(int id, String color, String name, int weight, String type, int age) {
    }


    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight='" + weight + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
    public Animal(String type, String name, String color, int weight, int age) {
        this.color = color;
        this.weight = weight;
        this.name = name;
        this.type = type;
        this.age = age;
    }

    public Animal(int id, String type, String name, String color, int weight, int age) {
        this.id = id;
        this.color = color;
        this.weight = weight;
        this.name = name;
        this.type = type;
        this.age = age;
    }


    public void say() {
        System.out.println("Я говорю");
    }

    public void drink() {
        System.out.println("Я пью");
    }

    public void eat() {
        System.out.println("Я ем");
    }

    public void go() {
        System.out.println("Я иду");
    }

    private String agetoString() {
        int ostatok = age % 10;
        int celoeAge = age / 10;

        if (celoeAge == 1 || ostatok == 0) {
            return "год";
        }
        if (ostatok >= 2 && ostatok <= 4) {
            return "года";
        }

        return "лет";
    }


}
