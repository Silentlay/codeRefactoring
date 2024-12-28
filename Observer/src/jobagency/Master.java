package jobagency;

// Класс Master соблюдает LSP: реализует интерфейс Observer и гарантирует корректное поведение.
public class Master implements Observer {
    private final String name;

    public Master(String name) {
        this.name = name;
    }

    @Override
    public void receiveOffer(String nameCompany, int salary) {
        if (salary < 80) {
            System.out.printf("Master %s: Жду лучшего предложения! Компания: %s, Зарплата: %d\n", name, nameCompany, salary);
        } else {
            System.out.printf("Master %s: Принимаю работу! Компания: %s, Зарплата: %d\n", name, nameCompany, salary);
        }
    }
}