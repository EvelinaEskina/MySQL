import data.AnimalFactory;
import menu.AnimalData;
import menu.Menu;
import objects.Animal;
import tables.AnimalTable;
import utils.ValidateNumber;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {

        //Загрузим конфигурации для базы данных
        Properties properties = new Properties();
        InputStream input = ClassLoader.getSystemResourceAsStream("SQLSettings.properties");
        properties.load(input);

        //Подключение к базе данных
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
//Создание запроса
        try (Connection conn = DriverManager.getConnection(url, username, password)) {

            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM animals";
//Выполнение
            ResultSet rs = stmt.executeQuery(query);

//Вывод заголовка на экран
            System.out.printf("%-10s %-20s %-10s %-5s %-10s %-5s%n", "Color", "Name", "Weight", "ID", "Type", "Age");
            System.out.println("---------------------------------------------------------------");

//Вывод данных по запросу

            while (rs.next()) {
                System.out.printf("%-10s %-20s %-10s %-5d %-10s %-5d%n",
                        rs.getString("color"),
                        rs.getString("name"),
                        rs.getFloat("weight"),
                        rs.getInt("ID"),
                        rs.getString("type"),
                        rs.getInt("age"));


            }
            //Закроем ресурсы
            rs.close();
            conn.close();
        }

        AnimalTable animalTable= new AnimalTable();

        List<String> columnsAnimalTable= new ArrayList<>();
        columnsAnimalTable.add("id INT AUTO_INCREMENT PRIMARY KEY");
        columnsAnimalTable.add("color VARCHAR(20)");
        columnsAnimalTable.add("name VARCHAR(20)");
        columnsAnimalTable.add("weight INT");
        columnsAnimalTable.add("type VARCHAR(20)");
        columnsAnimalTable.add("age INT");
        animalTable.create(columnsAnimalTable);

        animalTable.write(new Animal(12,"черный","Иван",7,"енот",5));
        animalTable.write(new Animal(13,"белый", "Пес", 8, "собака",  10));
        animalTable.write(new Animal(14,"красный", "Бадди", 5, "собака",  5));
        animalTable.write(new Animal(15,"черный", "Игорь", 5, "енот",  5));
        animalTable.write(new Animal(16,"серый", "Пушок", 3, "выдра",  2));
        animalTable.write(new Animal(17,"серый", "Серый", 3, "кошка",  4));

        ResultSet rs = animalTable.selectAll();
        animalTable.print(rs);

        ArrayList<Animal> an = animalTable.read();
        System.out.println(an);


    Scanner scanner = new Scanner(System.in);
    ValidateNumber validator = new ValidateNumber(scanner);

    List<Animal> animals = new ArrayList<>();

        System.out.println("Привет! Вводи команду ADD/LIST/EXIT");

        while (true) {
        String inputCommand = " ";
        //System.out.println("Привет! Вводи команду ADD/LIST/EXIT");
        String input1 = scanner.next();
        Menu command = Menu.IncorrectCommand(input1);

        if (command == null) {
            System.out.println("Команда не верна, повторите команду: ");
            continue;
        }

        switch (command) {
            case ADD: {
                boolean rightType = false;

                System.out.println(String.format("Введите тип животного: cat/dog/duck"));
                String animalType = scanner.nextLine().toUpperCase().trim();
                boolean isAnimalValid = true;
                for (AnimalData animalData : AnimalData.values()) {
                    if (!animalData.equals(animalType)) {
                        rightType = true;
                    } else {
                        System.out.println("Тип введен не верно");
                    }
                }
                scanner.nextLine().trim();


                System.out.println("Введите имя животного");
                String animalName = scanner.nextLine().trim();

                System.out.println("Введите цвет животного");
                String animalColour = scanner.nextLine().trim();


                System.out.println("Введите возраст животного");
                int animalAge = validator.getValidInput("Введите возраст животного");

                if (animalAge == -1) {
                    System.out.println("Вы потратили все попытки ввода");
                    continue;
                }


                System.out.println("Введите вес животного");
                int animalWeight = validator.getValidInput("Введите вес животного");
                if (animalWeight == -1) {
                    System.out.println("Вы потратили все попытки ввода");
                    continue;
                }


                try {
                    Animal newAnimal = AnimalFactory.create(animalType,animalAge, animalWeight, animalName, animalColour);
                    animals.add(newAnimal);
                    newAnimal.say();
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("Вводи команду ADD/LIST/EXIT");
            break;


            case LIST:
                if (animals.isEmpty()) {
                    System.out.println("Добавьте животное: ADD/EXIT");
                } else {
                    for (Animal animals1 : animals) {
                        System.out.println(animals1.toString());
                    }
                    System.out.println("Вводи команду ADD/LIST/EXIT");
                }
                break;


            case EXIT: {
                System.exit(0);
            }

            default:
                System.out.println("Некорректная команда");
        }
    }


}
}
