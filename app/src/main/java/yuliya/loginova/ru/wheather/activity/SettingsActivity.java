package yuliya.loginova.ru.wheather.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import yuliya.loginova.ru.wheather.R;
import yuliya.loginova.ru.wheather.SettingsDataEnum;

public class SettingsActivity extends AppCompatActivity {


    private EditText editTextCity;
    private CheckBox checkBoxHumidity;
    private CheckBox checkBoxPowerOfWind;
    private CheckBox checkBoxPrecipitation;
    private Button showWhetherButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_layout_fragment);

        editTextCity = findViewById(R.id.editText_Place);
        checkBoxHumidity = findViewById(R.id.checkBox_humidity);
        checkBoxPowerOfWind = findViewById(R.id.checkBox_power_of_wind);
        checkBoxPrecipitation = findViewById(R.id.checkBox_probability_of_precipitation);
        showWhetherButton = (Button) findViewById(R.id.button_watch_prognose);

        showWhetherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showWeather();
            }
        });
    }

    private Intent buildIntent(Intent intent) {
        intent.putExtra(SettingsDataEnum.SETTINGS_DATA_CITY.name(), editTextCity.getText().toString().trim());
        //intent.putExtra(SETTINGS_DATA_TEMPERATURE, cbTemperature.isChecked());
        intent.putExtra(SettingsDataEnum.SETTINGS_DATA_HUMIDITY.name(), checkBoxHumidity.isChecked());
        intent.putExtra(SettingsDataEnum.SETTINGS_DATA_POWER_OF_WIND.name(), checkBoxPowerOfWind.isChecked());
        intent.putExtra(SettingsDataEnum.SETTINGS_DATA_PRECIPITATION.name(), checkBoxPrecipitation.isChecked());
        return intent;
    }

    private void showWeather() {
        Intent intent = new Intent(SettingsActivity.this, WhetherDataActivity.class);
        startActivity(buildIntent(intent));
    }
}
