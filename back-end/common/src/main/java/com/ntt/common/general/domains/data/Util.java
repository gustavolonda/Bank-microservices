package com.ntt.common.general.domains.data;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

@Configuration
public class Util {
    @Autowired
    private MessageSource messageSource;

    private static MessageSource estaticMessageSource;

    public static final String FORMAT_DATE = "dd-MM-yyyy HH:mm a z";

    public static boolean isNullOrEmpty(String string) {
        return string == null || string.trim().isEmpty();
    }

    @Bean
    public void UtilMyWeather() {
        estaticMessageSource = messageSource;
    }

    /*
     *   ^                 # start-of-string
     *   (?=.*[0-9])       # a digit must occur at least once
     *   (?=.*[a-z])       # a lower case letter must occur at least once
     *   (?=.*[A-Z])       # an upper case letter must occur at least once
     *   (?=.*[@#$%^&+=])  # a special character must occur at least once
     *  (?=\S+$)          # no whitespace allowed in the entire string
     *   .{8,}             # anything, at least eight places though
     *   $                 # end-of-string
     */
    public static  String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    public static  String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    public static String phonePattern = "^\\+?[0-9]{1,4}?[-.\\s]?[0-9]{1,12}$";
    public static String letterPattern = "[a-zA-Z ]+";
    /*
    * Length >=3
    * Valid characters: a-z, A-Z, 0-9, points, dashes and underscores.
    */
    public static String usernamePattern = "[a-zA-Z0-9\\._\\-]{3,}";

    public static String getMessage(String property) {
        return estaticMessageSource.getMessage(property, null, Locale.getDefault());
    }

    public static Date dateAddMinutes(Date date, int minutes) {
        // add X minutes
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date.getTime());
        cal.add(Calendar.MINUTE, minutes);
        date = new Date(cal.getTime().getTime());
        return date;
    }

    public static Date toDate(String dateString) {
        SimpleDateFormat d = new SimpleDateFormat(FORMAT_DATE, Locale.US);
        try {
            d.setTimeZone(TimeZone.getTimeZone("UTC"));
            return d.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object jsonToObject(String cad, Class tclass) {
        return new Gson().fromJson(cad, tclass);
    }

    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }
}
