package jobagency;

// Главный класс демонстрирует применение OCP: новые наблюдатели могут быть добавлены без изменения существующего кода.
public class Main {
    public static void main(String[] args) {
        Publisher jobAgency = new JobAgency(); // DIP: использование интерфейса

        Company google = new Company(jobAgency, "Google", 50);
        Company geekBrains = new Company(jobAgency, "GeekBrains", 100);

        Observer petrov = new Student("Petrov");
        Observer ivanov = new Master("Ivanov");
        Observer gerasimov = new Junior("Junior Gerasimov");

        jobAgency.registerObserver(petrov);
        jobAgency.registerObserver(ivanov);
        jobAgency.registerObserver(gerasimov);

        for (int i = 0; i < 10; i++) {
            google.needEmployee();
            geekBrains.needEmployee();
        }
    }
}