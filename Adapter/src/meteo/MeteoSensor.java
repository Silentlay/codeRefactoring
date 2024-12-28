package meteo;

import java.time.*;
import java.util.Optional;
//Изменила интерфейс MeteoSensor с учетом поддержки отсутствующих данных
public interface MeteoSensor {
    int getId(); // идентификатор датчика

    Float getTemperature(); // температура датчика

    Optional<Float> getHumidity(); // влажность

    Optional<Float> getPressure(); // давление

    LocalDateTime getDateTime(); // время чтения данных датчика
}