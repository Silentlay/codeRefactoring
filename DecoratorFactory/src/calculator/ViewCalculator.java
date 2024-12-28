package calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Класс ViewCalculator реализует пользовательский интерфейс для работы с калькулятором.
 * Использует фабрику для создания объектов Calculable, что соответствует принципу DIP (Dependency Inversion Principle).
 */
public class ViewCalculator {

    private final ICalculableFactory calculableFactory;

    /**
     * Конструктор получает фабрику для создания объектов Calculable.
     * Это позволяет отвязать ViewCalculator от конкретной реализации Calculable.
     */
    public ViewCalculator(ICalculableFactory calculableFactory) {
        this.calculableFactory = calculableFactory;
    }

    /**
     * Метод запускает основной цикл взаимодействия с пользователем.
     */
    public void run() {
        DecimalFormat df = new DecimalFormat("#.##"); // Формат до 2х знаков, без лишних нулей
        while (true) {
            // Запрашиваем первый аргумент
            double primaryArg = promptDouble("Введите первый аргумент: ");
            Calculable calculator = calculableFactory.create(primaryArg);

            label:
            while (true) {
                // Запрашиваем команду от пользователя
                String cmd = prompt("Введите команду (*, +, -, /, =) : ");
                switch (cmd) {
                    case "*": {
                        // Умножение
                        double arg = promptDouble("Введите второй аргумент: ");
                        calculator.multi(arg);
                        continue;
                    }
                    case "/": {
                        while (true) {
                            double arg = promptDouble("Введите второй аргумент: ");
                            try {
                                calculator.division(arg);
                                break; // Выходим из внутреннего цикла, если операция успешна
                            } catch (ArithmeticException e) {
                                System.out.println("Ошибка: " + e.getMessage());
                                System.out.println("Попробуйте ввести другой аргумент.");
                            }
                        }
                        System.out.printf("Текущее значение: %s\n", df.format(calculator.getResult()));
                        continue;
                    }
                    case "+": {
                        // Сложение
                        double arg = promptDouble("Введите второй аргумент: ");
                        calculator.sum(arg);
                        continue;
                    }
                    case "-": {
                        // Вычитание
                        double arg = promptDouble("Введите второй аргумент: ");
                        calculator.subtraction(arg);
                        continue;
                    }
                    case "=": {
                        // Вывод результата
                        double result = calculator.getResult();
                        System.out.printf("Результат: %s\n", df.format(result));
                        break label;
                    }
                }
            }

            // Запрос на продолжение или завершение программы
            while (true) {
                String cmd = prompt("Еще посчитать (Y/N)? ");
                if (cmd.equalsIgnoreCase("Y")) {
                    break; // Пользователь хочет продолжить
                } else if (cmd.equalsIgnoreCase("N")) {
                    System.out.println("Выход из программы");
                    return; // Завершаем программу
                } else {
                    // Сообщение о некорректном вводе
                    System.out.println("Ошибка: введите Y для продолжения или N для выхода.");
                }
            }
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private double promptDouble(String message) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print(message);
            String input = in.nextLine().trim();
            if (!input.isEmpty()) {
                try {
                    return Double.parseDouble(input);
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: введите корректное число.");
                }
            } else {
                System.out.println("Ошибка: ввод не должен быть пустым.");
            }
        }
    }
} 