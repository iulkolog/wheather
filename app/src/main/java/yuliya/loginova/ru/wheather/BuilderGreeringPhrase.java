package yuliya.loginova.ru.wheather;

import java.util.Calendar;

public class BuilderGreeringPhrase {

    private int currentHour;
    private GreetingStrings greetingPhrases;

    public BuilderGreeringPhrase(GreetingStrings greetingPhrases){

        currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        this.greetingPhrases = greetingPhrases;
    }

    public String get(){
        String helloer = greetingPhrases.getHelloer();

        if (5 <= currentHour && currentHour < 12){
            return String.format("%s, %s!", greetingPhrases.getMorning(), helloer);
        }

        else if (12 <= currentHour && currentHour < 18){
            return String.format("%s, %s!",  greetingPhrases.getAfternoon(), helloer);
        }

        else if (18 <= currentHour && currentHour < 21){
            return String.format("%s, %s!",  greetingPhrases.getEvening(), helloer);
        }

        else {
            return String.format("%s, %s!",  greetingPhrases.getNight(), helloer);
        }
    }
}
