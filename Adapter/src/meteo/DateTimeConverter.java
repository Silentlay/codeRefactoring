package meteo;

import java.time.LocalDateTime;

//Класс для преобразования времени из формата ST500
// Этот класс выделен для преобразования времени и выполняет только одну задачу
public class DateTimeConverter {
    public static LocalDateTime fromST500Format(int year, int day, int second){
        // Преобразую год, день и секунды в LocalDateTime
        LocalDateTime date = LocalDateTime.of(year, 1, 1, 0, 0, 0);
        return date.plusDays(day - 1).plusSeconds(second);
    }
}
