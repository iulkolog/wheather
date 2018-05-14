package yuliya.loginova.ru.wheather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView greeting = (TextView) findViewById(R.id.greeting);

        int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

        if (5 <= currentHour && currentHour < 12){
            greeting.setText("Good morning");
        }

        else if  (12 <= currentHour && currentHour < 6){
            greeting.setText("Good afternon");
        }

        else if ( (6 <= currentHour && currentHour < 9)){
            greeting.setText("Good evening");
        }

        else{
            greeting.setText("Good night");
        }
    }
}
