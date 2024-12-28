package meteo;
// Применяется принцип OCP (Open-Closed Principle)
// Основной класс системы не изменяется, только добавляется новая функциональность через адаптер
class MeteoStore {
    // сохранение данных в базу
    boolean save(MeteoSensor meteoSensor) {
        System.out.format("Saving data from sensor [%d] at %s%n temperature - %f ; humidity - %f ; pressure - %f \n\r",
                meteoSensor.getId(),
                meteoSensor.getDateTime(),
                meteoSensor.getTemperature(),
                meteoSensor.getHumidity().orElse(null),
                meteoSensor.getPressure().orElse(null));
        return true;
    }
}