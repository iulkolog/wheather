package yuliya.loginova.ru.wheather.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import yuliya.loginova.ru.wheather.R;
import yuliya.loginova.ru.wheather.SettingsParcel;
import yuliya.loginova.ru.wheather.activity.WhetherDataActivity;

public class SettingsFragment extends Fragment{
    boolean isExistWhetherData;  // Можно ли расположить рядом фрагмент с погодными данными
    SettingsParcel currentParcel;

    private final String FRAGMENT_KEY = "FRAGMENT_SETTINGS";

    private EditText editTextCity;
    private CheckBox checkBoxHumidity;
    private CheckBox checkBoxPowerOfWind;
    private CheckBox checkBoxPrecipitation;
    private Button showWhetherButton;

    @Override
    public void onStart() {
        super.onStart();
        setItemsValues(currentParcel);

    }

    private void setItemsValues(SettingsParcel currentParcel){
        editTextCity.setText(currentParcel.getCityName());
        checkBoxHumidity.setChecked(currentParcel.getHumidity());
        checkBoxPowerOfWind.setChecked(currentParcel.getPowerOfWind());
        checkBoxPrecipitation.setChecked(currentParcel.getProbabilityOfPrecipitation());
    }

    private SettingsParcel buildParcel() {
        //TODO применить здесь паттерн фабрика

        return new SettingsParcel(editTextCity.getText().toString().trim(),
                                    checkBoxHumidity.isChecked(),
                                    checkBoxPowerOfWind.isChecked(),
                                    checkBoxPrecipitation.isChecked());

    }

    private Intent buildIntent(Intent intent){
        intent.setClass(getActivity(), WhetherDataFragment.class);
        intent.putExtra(FRAGMENT_KEY, currentParcel);
        return intent;
    }

    private void showWeather() {
        Intent intent = new Intent(getActivity(), WhetherDataActivity.class);
        startActivity(buildIntent(intent));
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.settings_layout_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        editTextCity = getActivity().findViewById(R.id.editText_Place);
        checkBoxHumidity = getActivity().findViewById(R.id.checkBox_humidity);
        checkBoxPowerOfWind = getActivity().findViewById(R.id.checkBox_power_of_wind);
        checkBoxPrecipitation = getActivity().findViewById(R.id.checkBox_probability_of_precipitation);
        showWhetherButton = (Button) getActivity().findViewById(R.id.button_watch_prognose);

        showWhetherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showWeather();
            }
        });

        if (savedInstanceState != null) {
            // Restore last state for checked position.
            currentParcel = (SettingsParcel) savedInstanceState.getSerializable(FRAGMENT_KEY);
        }else {
            //мы не успели поменять значения, а посылка уже сохраняется
            // возможно нужно в другом месте сохранять
            currentParcel = buildParcel();
            }


        }


}
