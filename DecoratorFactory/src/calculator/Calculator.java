package calculator;
// Принцип единственной ответственности (SRP):
// Класс Calculator отвечает только за вычисления и использует отдельные классы для каждой операции.
public final class Calculator implements Calculable {

    private double primaryArg;

    public Calculator(double primaryArg) {
        this.primaryArg = primaryArg;
    }

    @Override
    public Calculable sum(double arg) {
        // Принцип инверсии зависимостей (DIP):
        // Использую интерфейс Operation для выполнения сложения.
        Operation addition = new AdditionOperation();
        primaryArg = addition.execute(primaryArg, arg);
        return this;
    }

    @Override
    public Calculable subtraction(double arg) {
        // Вычитание через отдельный класс.
        Operation subtraction = new SubtractionOperation();
        primaryArg = subtraction.execute(primaryArg, arg);
        return this;
    }

    @Override
    public Calculable multi(double arg) {
        // Умножение через отдельный класс.
        Operation multiplication = new MultiplicationOperation();
        primaryArg = multiplication.execute(primaryArg, arg);
        return this;
    }

    @Override
    public Calculable division(double arg) {
        // Обработка деления с проверкой на ноль.
        Operation division = new DivisionOperation();
        primaryArg = division.execute(primaryArg, arg);
        return this;
    }

    @Override
    public double getResult() {
        return primaryArg;
    }
}

