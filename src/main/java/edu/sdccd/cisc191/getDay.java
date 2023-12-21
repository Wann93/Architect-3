package edu.sdccd.cisc191;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class getDay {
    public String getDay()

    {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("EEEE,MMMM dd yyyy");

        return localDate.format(formatDate);
    }

}
