package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidateNumber {
    private Scanner scanner;
    public ValidateNumber (Scanner scanner) {
        this.scanner = scanner;
    }
    public  int getValidInput (String massage) {
        int value = 0;
        int min = 1;
        int max = 20;
        boolean isValid = false;
        try {
            if (value >= 1 && value <= 20) {
                isValid = true;
                System.out.println("Значение корректно");
            } else {
                System.out.println("Введите значение от " + min + " до " + max);
            }
        } catch (InputMismatchException e) {
            System.out.println("Вводите цифры");
            scanner.nextLine();
        }
        if (!isValid) {
            scanner.nextLine();
        }
        return value;



    }

}

