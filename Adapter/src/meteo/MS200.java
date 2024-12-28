package meteo;

import java.time.*;
import java.util.Optional;

// Применяю принцип LSP (Liskov Substitution Principle):
// Все реализации интерфейса MeteoSensor могут заменять друг друга без изменения поведения системы
public class MS200 implements MeteoSensor {
    private final int id;

    public MS200(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Float getTemperature() {
        return 20f;
    }

    @Override
    public Optional<Float> getHumidity() {
        return Optional.of(60f);
    }

    @Override
    public Optional<Float> getPressure() {
        return Optional.of(752.4f);
    }

    @Override
    public LocalDateTime getDateTime() {
        return LocalDateTime.now();
    }
}