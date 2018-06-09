package yuliya.loginova.ru.wheather.fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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
    boolean isExistWhetherDataFragment;  // Можно ли расположить рядом фрагмент с погодными данными
    SettingsParcel currentParcel;
    public static final String TAG = "myLogs";

    private EditText editTextCity;
    private CheckBox checkBoxHumidity;
    private CheckBox checkBoxPowerOfWind;
    private CheckBox checkBoxPrecipitation;
    private Button showWhetherButton;

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(WhetherDataFragment.PARCEL, currentParcel);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.settings_layout_fragment, container, false);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.d(TAG, "onActivityCreated");

        //TODO написать адаптер, чтобы подгружать список городов
        //находим чекбоксы и вешаем листенер на кнопку
        View whetherDataFrame = getActivity().findViewById(R.id.whether_data_container);

        editTextCity = getActivity().findViewById(R.id.editText_Place);
        checkBoxHumidity = getActivity().findViewById(R.id.checkBox_humidity);
        checkBoxPowerOfWind = getActivity().findViewById(R.id.checkBox_power_of_wind);
        checkBoxPrecipitation = getActivity().findViewById(R.id.checkBox_probability_of_precipitation);
        showWhetherButton = (Button)getActivity().findViewById(R.id.button_watch_prognose);

        showWhetherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buildParcel();
                showWeather();
            }
        });
        editTextCity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String city = editable.toString().trim();
                if (showWhetherButton.getVisibility() != View.GONE){
                    showWhetherButton.setEnabled(!city.isEmpty());
                }

            }
        });

        isExistWhetherDataFragment = whetherDataFrame != null && whetherDataFrame.getVisibility() == View.VISIBLE;

        if (savedInstanceState != null) {
            // восстанавливаем состояние
            currentParcel = (SettingsParcel) savedInstanceState.getSerializable(WhetherDataFragment.PARCEL);
        }else {
            //мы не успели поменять значения, а посылка уже сохраняется
            // возможно нужно в другом месте сохранять
            Log.d(TAG,"buildParcel");
            currentParcel = buildParcel();
            }
        setItemsValues(currentParcel);
        if (isExistWhetherDataFragment)
            showWeather();
        }

    private void setItemsValues(SettingsParcel currentParcel){
        editTextCity.setText(currentParcel.getCityName());
        checkBoxHumidity.setChecked(currentParcel.getHumidity());
        checkBoxPowerOfWind.setChecked(currentParcel.getPowerOfWind());
        checkBoxPrecipitation.setChecked(currentParcel.getProbabilityOfPrecipitation());
    }

    private SettingsParcel buildParcel() {
        currentParcel = new SettingsParcel(editTextCity.getText().toString().trim(),
                checkBoxHumidity.isChecked(),
                checkBoxPowerOfWind.isChecked(),
                checkBoxPrecipitation.isChecked());
        return currentParcel;

    }

    private Intent buildIntent(){
        Log.d(TAG, "buildIntent");
        Intent intent = new Intent();
        intent.setClass(getActivity(), WhetherDataActivity.class);
        intent.putExtra(WhetherDataFragment.PARCEL, currentParcel);
        return intent;
    }

    private void showWeather() {
        Log.d(TAG, "showWeather");
        if (isExistWhetherDataFragment) {
            WhetherDataFragment whetherDataFragment = (WhetherDataFragment) getFragmentManager().findFragmentById(R.id.whether_data_container);
            Log.d(TAG, "isExistWhetherDataFragment");
            //замещаем фрагмент
            if ((whetherDataFragment == null)||(!whetherDataFragment.getParcel().equals(currentParcel))) {
                Log.d(TAG, "null or !=");
                whetherDataFragment = WhetherDataFragment.create(currentParcel);

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.whether_data_container, whetherDataFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();

            }
        }
        else {
                //открываем активити, если нельзя рядом вывести фрагмент
                startActivity(buildIntent());
            }
    }

}
