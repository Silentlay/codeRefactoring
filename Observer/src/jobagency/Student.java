package jobagency;

// Класс Student соблюдает SRP: отвечает только за логику обработки предложений работы.
// Реализует LSP, так как работает через интерфейс Observer.
public class Student implements Observer {
    private final String name;
    private int currentSalary;

    public Student(String name) {
        this.name = name;
        this.currentSalary = 0; // SRP: текущая зарплата отслеживается только в этом классе
    }

    @Override
    public void receiveOffer(String nameCompany, int salary) {
        if (this.currentSalary < salary) {
            System.out.printf("Student %s: Мне нужна эта работа! Компания: %s, Зарплата: %d\n", name, nameCompany, salary);
            this.currentSalary = salary;
        } else {
            System.out.printf("Student %s: У меня уже есть лучшее предложение! Компания: %s, Зарплата: %d\n", name, nameCompany, salary);
        }
    }
}