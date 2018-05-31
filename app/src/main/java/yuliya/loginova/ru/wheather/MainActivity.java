package yuliya.loginova.ru.wheather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    private TextView textViewCityName;
    private TextView textViewTemperatureData;
    private TextView textViewHumidityData;
    private TextView textViewWindData;
    private TextView textViewPrecipitationData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCityName = findViewById(R.id.textview_cityname);
        textViewTemperatureData = findViewById(R.id.textview__temperature_data);
        textViewHumidityData = findViewById(R.id.textview__humidity_data);
        textViewWindData = findViewById(R.id.textview__wind_data);
        textViewPrecipitationData = findViewById(R.id.textview__probability_of_precipitation_data);

        String city = getIntent().getExtras().getString(SettingsActivity.SETTINGS_DATA_CITY);
        textViewCityName.setText(city);

        Boolean humidity = getIntent().getExtras().getBoolean(SettingsActivity.SETTINGS_DATA_HUMIDITY);
        Boolean wind = getIntent().getExtras().getBoolean(SettingsActivity.SETTINGS_DATA_POWER_OF_WIND);
        Boolean precipitation = getIntent().getExtras().getBoolean(SettingsActivity.SETTINGS_DATA_PRECIPITATION);

        setHumidityData();

        if (humidity)
            setHumidityData();

        if (wind)
            setWindData();

        if (precipitation)
            setPrecipitationData();


    }

    private void setPrecipitationData() {
        textViewPrecipitationData.setText(R.string.precipitation_data);
    }

    private void setWindData() {
        textViewWindData.setText(R.string.power_of_wind);
    }

    private void setHumidityData() {
        textViewHumidityData.setText(R.string.humidity_data);
    }

    private void setTextViewTemperatureData() {
        textViewTemperatureData.setText(R.string.temperature_data);
    }


}
