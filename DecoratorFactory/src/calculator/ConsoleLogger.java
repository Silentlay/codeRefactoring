package calculator;
// Логирование вынесено в отдельный класс, что соответствует принципу SRP.
public class ConsoleLogger implements Loggable {
    @Override
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}

