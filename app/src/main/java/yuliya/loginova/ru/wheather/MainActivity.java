package yuliya.loginova.ru.wheather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textViewCityName = findViewById(R.id.textview_cityname);
        TextView textViewData = findViewById(R.id.textview_whether_data);

        String city = getIntent().getExtras().getString(SettingsActivity.SETTINGS_DATA_CITY);
        textViewCityName.setText(city);

        Boolean humidity = getIntent().getExtras().getBoolean(SettingsActivity.SETTINGS_DATA_HUMIDITY);
        Boolean wind = getIntent().getExtras().getBoolean(SettingsActivity.SETTINGS_DATA_POWER_OF_WIND);
        Boolean precipitation = getIntent().getExtras().getBoolean(SettingsActivity.SETTINGS_DATA_PRECIPITATION);

        if (humidity)
            textViewData.append(getString(R.string.humidity_data) + "\n");

        if (wind)
            textViewData.append(getString(R.string.wind_data)+ "\n");

        if (precipitation)
            textViewData.append(getString(R.string.precipitation_data)+ "\n");

    }


}
