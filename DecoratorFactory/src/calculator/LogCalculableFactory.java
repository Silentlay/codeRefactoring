package calculator;
// Принцип открытости/закрытости (OCP):
// Фабрика LogCalculableFactory позволяет добавлять новые типы Calculable без изменения существующего кода.

public class LogCalculableFactory implements ICalculableFactory {

    private final Loggable logger;

    public LogCalculableFactory(Loggable logger) {
        this.logger = logger;
    }

    @Override
    public Calculable create(double primaryArg) {
        return new LogCalculator(new Calculator(primaryArg), logger);
    }
}
