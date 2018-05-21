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
    public static final String SETTINGS_DATA_POWER_OF_WIND = "power of wind";
    public static final String SETTINGS_DATA_PRECIPITATION = "precipitation";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_layout);

        final EditText editTextCity = findViewById(R.id.editText_Place);
        final CheckBox checkBoxHumidity = findViewById(R.id.checkBox_humidity);
        final CheckBox checkBoxPowerOfWind = findViewById(R.id.checkBox_power_of_wind);
        final CheckBox checkBoxPrecipitation = findViewById(R.id.checkBox_probability_of_precipitation);

        final Button button = (Button) findViewById(R.id.button_watch_prognose);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                intent.putExtra(SETTINGS_DATA_CITY, editTextCity.getText().toString());
                intent.putExtra(SETTINGS_DATA_HUMIDITY, checkBoxHumidity.isChecked());
                intent.putExtra(SETTINGS_DATA_POWER_OF_WIND, checkBoxPowerOfWind.isChecked());
                intent.putExtra(SETTINGS_DATA_PRECIPITATION, checkBoxPrecipitation.isChecked());
                startActivity(intent);

            }
        });
    }
}
