package meteo;

public class Main {

    // Есть библиотека сбора данных от датчиков. Все они были куплены в комплекте с этой библиотекой.
    // Поступил новый датчик от другой компании, интерфейс которого отличается от предыдущих.
    // Надо включить этот датчик в систему.
    // Главный метод демонстрирует применение все принципов SOLID
    public static void main(String[] args) {
        SensorStore store = new MeteoStoreImpl();

        // Пример с использованием фабрики для создания сенсоров.
        MeteoSensor ms200 = MeteoSensorFactory.createSensor("MS200", 1);
        MeteoSensor st500 = MeteoSensorFactory.createSensor("ST500", new ST500Info().getData());

        store.save(ms200);
        store.save(st500);
    }
}