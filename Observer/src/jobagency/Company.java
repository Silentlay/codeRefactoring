package jobagency;

import java.util.Random;

// Класс Company теперь соблюдает SRP: он отвечает только за генерацию вакансий
// и передачу их агентству. Логика работы с Random изолирована.
public class Company {
    private final Publisher jobAgency; // DIP: зависимость через интерфейс
    private final String nameCompany;
    private final Random rnd;
    private final int maxSalary;

    public Company(Publisher jobAgency, String nameCompany, int maxSalary) {
        this.jobAgency = jobAgency; // DIP: не зависит от конкретной реализации
        this.nameCompany = nameCompany;
        this.rnd = new Random(); // SRP: инкапсуляция логики генерации случайных чисел
        this.maxSalary = maxSalary;
    }

    // Метод отвечает только за создание и отправку предложения о работе
    public void needEmployee() {
        int salary = rnd.nextInt(maxSalary);
        jobAgency.sendOffer(nameCompany, salary);
    }
}