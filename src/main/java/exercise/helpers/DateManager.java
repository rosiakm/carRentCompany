package exercise.helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateManager {

    public static String getCurrentDate(){
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        return currentDate.format(formatter);
    }

}
