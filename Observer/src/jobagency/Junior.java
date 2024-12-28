package jobagency;

import java.util.Random;

// Класс Junior соблюдает LSP и SRP: он является отдельным типом наблюдателя с уникальной логикой выбора предложений.
public class Junior implements Observer {

    private final String name;
    private final Random random;

    public Junior(String name) {
        this.name = name;
        this.random = new Random(); // SRP: инкапсуляция генерации случайных решений
    }

    @Override
    public void receiveOffer(String nameCompany, int salary) {
        if (random.nextBoolean()) {
            System.out.printf("Junior %s принял предложение! Компания: %s, Зарплата: %d\n", name, nameCompany, salary);
        } else {
            System.out.printf("Junior %s отклонил предложение! Компания: %s, Зарплата: %d\n", name, nameCompany, salary);
        }
    }
}