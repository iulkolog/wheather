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
            WhetherDataFragment whetherDataFragment = new WhetherDataFragment();
            whetherDataFragment.setArguments(getIntent().getExtras());
            // Добавим фрагмент на активити
            getFragmentManager().beginTransaction().add(android.R.id.content, whetherDataFragment).commit();
        }
    }


}
