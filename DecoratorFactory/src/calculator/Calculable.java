package calculator;
// Принцип открытости/закрытости (OCP):
// Интерфейс расширен для добавления новых операций (деление, вычитание).
// Это позволяет добавлять новые реализации без изменения существующего кода.
public interface Calculable {
    Calculable sum(double arg);

    Calculable subtraction(double arg);

    Calculable multi(double arg);

    Calculable division(double arg);

    double getResult();
}
