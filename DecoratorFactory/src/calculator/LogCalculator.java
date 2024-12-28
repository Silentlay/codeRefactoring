// Принцип подстановки Барбары Лисков (LSP):
// Класс LogCalculator расширяет функциональность Calculator, не нарушая его поведения.
package calculator;

public class LogCalculator implements Calculable {

    private Calculable decorated;
    private final Loggable logger;

    public LogCalculator(Calculable decorated, Loggable logger) {
        this.decorated = decorated;
        this.logger = logger;
    }

    @Override
    public Calculable sum(double arg) {
        // Логирование вызова метода sum
        double firstArg = decorated.getResult();
        logger.log("Первое значение калькулятора: " + firstArg + ". Начало вызова метода sum с параметром " + arg);
        Calculable result = decorated.sum(arg);
        logger.log("Вызов метода sum произошел успешно.");
        return result;
    }


    @Override
    public Calculable subtraction(double arg) {
        // Логирование вызова метода subtraction
        double firstArg = decorated.getResult();
        logger.log("Первое значение калькулятора: " + firstArg + ". Начало вызова метода Subtraction с параметром " + arg);
        Calculable result = decorated.subtraction(arg);
        logger.log("Вызов метода subtraction произошел успешно.");
        return result;
    }

    @Override
    public Calculable multi(double arg) {
        // Логирование вызова метода multi
        double firstArg = decorated.getResult();
        logger.log("Первое значение калькулятора: " + firstArg + ". Начало вызова метода multi с параметром " + arg);
        Calculable result = decorated.multi(arg);
        logger.log("Вызов метода multi произошел успешно.");
        return result;
    }

    @Override
    public Calculable division(double arg) {
        // Логирование вызова метода division
        try {
            double firstArg = decorated.getResult();
            logger.log("Первое значение калькулятора: " + firstArg + ". Начало вызова метода Division с параметром " + arg);
            decorated = decorated.division(arg); // Обновляем состояние только при успешном делении
            logger.log("Вызов метода Division произошел успешно.");
        } catch (ArithmeticException e) {
            logger.log("Ошибка при вызове Division: " + e.getMessage());
            throw e; // Пробрасываем исключение выше, чтобы оно обрабатывалось в вызывающем коде
        }
        return this;
    }



    @Override
    public double getResult() {
        double result = decorated.getResult();
        logger.log("Получение результата: " + result);
        return result;
    }
}
