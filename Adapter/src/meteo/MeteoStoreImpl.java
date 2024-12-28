package meteo;
// Реализую хранилище для метеоданных
class MeteoStoreImpl implements SensorStore {
    @Override
    public boolean save(MeteoSensor meteoSensor) {
        System.out.format("Saving data from sensor [%d] at %s%n temperature - %f ; humidity - %s ; pressure - %s \n\r",
                meteoSensor.getId(),
                meteoSensor.getDateTime(),
                meteoSensor.getTemperature(),
                meteoSensor.getHumidity().orElse(null),
                meteoSensor.getPressure().orElse(null));
        return true;
    }
}
