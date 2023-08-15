package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {
    public static String generateCurrentDateAndTime() {
        return new SimpleDateFormat("ddMMyyyyHHmmssSSS").format(new Date());
    }
}
