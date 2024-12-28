// Принцип инверсии зависимостей (DIP):
// Фабрики и логирование зависят от абстракций, а не от конкретных реализаций.
package calculator;

public interface ICalculableFactory {
    Calculable create(double primaryArg);
}




