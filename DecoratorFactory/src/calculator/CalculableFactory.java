package calculator;
// Принцип открытости/закрытости (OCP):
// Использование фабрики позволяет добавлять новые виды Calculable без изменения существующего кода.
public class CalculableFactory implements ICalculableFactory {

    @Override
    public Calculable create(double primaryArg) {
        return new Calculator(primaryArg);
    }
}
