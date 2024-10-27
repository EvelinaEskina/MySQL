package menu;

public enum AnimalData {
    DOG ("собака"),
    DUCK ("утка"),
    CAT ("кошка");

    private String name;
    AnimalData (String name) { this.name = name;}

    public String getName() {
        return name;
    }
}
