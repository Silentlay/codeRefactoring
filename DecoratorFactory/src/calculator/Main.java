// Главный класс демонстрирует внедрение зависимостей и использование фабрики.
package calculator;

public class Main {
    public static void main(String[] args) {
        Loggable logger = new ConsoleLogger();
        ICalculableFactory factory = new LogCalculableFactory(logger);
        ViewCalculator view = new ViewCalculator(factory);
        view.run();
    }
}