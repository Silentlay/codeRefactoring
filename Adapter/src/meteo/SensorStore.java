package meteo;
// Применяю принцип DIP (Dependency Inversion Principle)
//Внедряю интерфейс для хранилища данных, чтобы поддерживать разные реализации данных
public interface SensorStore {
    boolean save(MeteoSensor meteoSensor); // Метод для сохранения сенсора
}
