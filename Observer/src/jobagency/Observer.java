package jobagency;

// Интерфейс Observer следует ISP: определяет только одну функцию для получения предложений.
public interface Observer {
    void receiveOffer(String nameCompany, int salary);
}