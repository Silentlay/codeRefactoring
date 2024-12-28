package meteo;

// Фабрика для создания объектов сенсоров (принцип OCP).

public class MeteoSensorFactory {
    public static MeteoSensor createSensor(String type, Object sensorData) {
        switch (type) {
            case "MS200":
                return new MS200((int) sensorData);
            case "ST500":
                return new AdapterST500Info((SensorTemperature) sensorData);
            default:
                throw new IllegalArgumentException("Unknown sensor type");
        }
    }
}