package yuliya.loginova.ru.wheather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements GreetingStrings{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TextView greeting = (TextView) findViewById(R.id.greeting);

        //BuilderGreeringPhrase builderGreeringPhrase = new BuilderGreeringPhrase(this);
        //greeting.setText(builderGreeringPhrase.get());

    }


    @Override
    public String getHelloer() {
        return getResources().getString(R.string.helloer);
    }

    @Override
    public String getMorning() {
        return getResources().getString(R.string.morning);
    }

    @Override
    public String getAfternoon() {
        return getResources().getString(R.string.afternoon);
    }

    @Override
    public String getEvening() {
        return getResources().getString(R.string.evening);
    }

    @Override
    public String getNight() {
        return getResources().getString(R.string.night);
    }
}
//TODO