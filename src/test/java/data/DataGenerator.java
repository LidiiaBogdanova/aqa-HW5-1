package data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {

        public static String generateCity(String locale) {
            Faker faker = new Faker(new Locale(locale));
            String city=faker.address().city();
           return city;
        }
    public static  String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String fullName=faker.name().fullName();
        return fullName;
    }
    public static  String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String number=faker.phoneNumber().phoneNumber();
        return number;
    }
    public static String chooseFirstDate(){
        LocalDate today = LocalDate.now();
        LocalDate meetingDay=today.plusDays(4);
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String textFirstDate= meetingDay.format(formatter);
        return textFirstDate;

    }
    public static String chooseSecondDate(){
        LocalDate today = LocalDate.now();
        LocalDate meetingDay=today.plusDays(6);
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String textSecondDate= meetingDay.format(formatter);
        return textSecondDate;

    }

}
