package yuliya.loginova.ru.wheather.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import yuliya.loginova.ru.wheather.fragments.WhetherDataFragment;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;

public class WhetherDataActivity extends AppCompatActivity{

    private TextView textViewCityName;
    private TextView textViewTemperatureData;
    private TextView textViewHumidityData;
    private TextView textViewWindData;
    private TextView textViewPrecipitationData;
    private ImageView imageViewPrecipitationIcon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == ORIENTATION_LANDSCAPE) {
            // Если устройство перевернули в альбомную ориентацию, то надо это активити закрыть
            finish();
            return;
        }

        if (savedInstanceState == null) {
            // Если это активити запускается первый раз (с каждым новым гербом первый раз)
            // то перенаправим параметр фрагменту
            WhetherDataFragment details = new WhetherDataFragment();
            details.setArguments(getIntent().getExtras());
            // Добавим фрагмент на активити
            getFragmentManager().beginTransaction().add(android.R.id.content, details).commit();
        }
    }

   /* protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.whether_data_fragment);

        textViewCityName = findViewById(R.id.textview_cityname);
        textViewTemperatureData = findViewById(R.id.textview__temperature_data);
        textViewHumidityData = findViewById(R.id.textview__humidity_data);
        textViewWindData = findViewById(R.id.textview__wind_data);
        textViewPrecipitationData = findViewById(R.id.textview__probability_of_precipitation_data);
        imageViewPrecipitationIcon = findViewById(R.id.imageview_p_o_p_icon);


        String city = getIntent().getExtras().getString(SettingsDataEnum.SETTINGS_DATA_CITY.name());
        textViewCityName.setText(city);

        Boolean humidity = getIntent().getExtras().getBoolean(SettingsDataEnum.SETTINGS_DATA_HUMIDITY.name());
        Boolean wind = getIntent().getExtras().getBoolean(SettingsDataEnum.SETTINGS_DATA_POWER_OF_WIND.name());
        Boolean precipitation = getIntent().getExtras().getBoolean(SettingsDataEnum.SETTINGS_DATA_PRECIPITATION.name());

        setTextViewTemperatureData();

        if (humidity)
            setHumidityData();

        if (wind)
            setWindData();

        if (precipitation)
            setPrecipitationData();


    }

    private void setPrecipitationData() {
        textViewPrecipitationData.setText(R.string.precipitation_data);
        imageViewPrecipitationIcon.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.if_sunny_3233850));
    }

    private void setWindData() {
        textViewWindData.setText(R.string.wind_data);
    }

    private void setHumidityData() {
        textViewHumidityData.setText(R.string.humidity_data);
    }

    private void setTextViewTemperatureData() {
        textViewTemperatureData.setText(R.string.temperature_data);
    }*/


}
