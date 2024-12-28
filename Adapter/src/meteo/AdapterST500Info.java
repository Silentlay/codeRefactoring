package meteo;

import java.time.LocalDateTime;
import java.util.Optional;

// Применяю принцип SRP (Single Responsibility Principle)
// Разделяю обязанности. AdapterST500Info отвечает теперь только за адаптацию данных
public class AdapterST500Info implements MeteoSensor{

    private final SensorTemperature adaptee;

    public AdapterST500Info(SensorTemperature adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public int getId() {
        // Преобразование индентификатора датчика
        return adaptee.identifier();
    }

    @Override
    public Float getTemperature() {
        // Преобразование температуры
        return (float)adaptee.temperature();
    }

    @Override
    // В данных ST500 нет информации о влажности, возвращаю Optional.empty()
    public Optional<Float> getHumidity() {
        return Optional.empty();
    }

    @Override
    // В данных ST500 нет информации о давлении, возвращаю Optional.empty()
    public Optional<Float> getPressure() {
        return Optional.empty();
    }

    @Override
    public LocalDateTime getDateTime() {
        // Использую класс DateTimeConverter для преобразования времени
        return DateTimeConverter.fromST500Format(adaptee.year(), adaptee.day(), adaptee.second());
    }
}
