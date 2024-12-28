package jobagency;

import java.util.ArrayList;
import java.util.List;

// Класс JobAgency соблюдает SRP: отвечает только за управление списком наблюдателей и рассылку уведомлений.
// Благодаря DIP взаимодействие с наблюдателями осуществляется через интерфейс Observer.
public class JobAgency implements Publisher {

    private final List<Observer> observers;

    public JobAgency() {
        this.observers = new ArrayList<>(); // SRP: управление списком наблюдателей
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void sendOffer(String nameCompany, int salary) {
        for (Observer observer : observers) {
            observer.receiveOffer(nameCompany, salary); // LSP: гарантированная работа с любым Observer
        }
    }
}