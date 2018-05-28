package yuliya.loginova.ru.wheather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class SettingsActivity extends AppCompatActivity {

    public static final String SETTINGS_DATA_CITY = "city";
    public static final String SETTINGS_DATA_HUMIDITY = "humidity";
    public static final String SETTINGS_DATA_TEMPERATURE = "temperature";
    public static final String SETTINGS_DATA_POWER_OF_WIND = "power of wind";
    public static final String SETTINGS_DATA_PRECIPITATION = "precipitation";

    private EditText editTextCity;
    private CheckBox checkBoxHumidity;
    private CheckBox checkBoxPowerOfWind;
    private CheckBox checkBoxPrecipitation;
    private Button showWhetherButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_layout);

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
        intent.putExtra(SETTINGS_DATA_CITY, editTextCity.getText().toString().trim());
        //intent.putExtra(SETTINGS_DATA_TEMPERATURE, cbTemperature.isChecked());
        intent.putExtra(SETTINGS_DATA_HUMIDITY, checkBoxHumidity.isChecked());
        intent.putExtra(SETTINGS_DATA_POWER_OF_WIND, checkBoxPowerOfWind.isChecked());
        intent.putExtra(SETTINGS_DATA_PRECIPITATION, checkBoxPrecipitation.isChecked());
        return intent;
    }

    private void showWeather() {
        Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
        startActivity(buildIntent(intent));
    }
}
