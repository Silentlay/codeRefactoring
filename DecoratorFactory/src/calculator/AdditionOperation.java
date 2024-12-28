package calculator;

/**
 * Класс для операции сложения.
 */
public class AdditionOperation implements Operation{
    @Override
    public double execute(double a, double b) {
        return a + b;
    }
}
