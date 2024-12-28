package jobagency;

// Интерфейс Publisher следует ISP: определяет функции для управления наблюдателями и отправки уведомлений.
public interface Publisher {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void sendOffer(String nameCompany, int salary);
}