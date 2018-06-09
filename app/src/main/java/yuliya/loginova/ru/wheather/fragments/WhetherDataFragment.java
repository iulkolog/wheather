package yuliya.loginova.ru.wheather.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import yuliya.loginova.ru.wheather.R;
import yuliya.loginova.ru.wheather.SettingsParcel;

public class WhetherDataFragment extends Fragment {

    public static final String PARCEL = "WhetherDataFragmentParcel";
    private TextView textViewCityName;
    private TextView textViewTemperatureData;
    private TextView textViewHumidityData;
    private TextView textViewWindData;
    private TextView textViewPrecipitationData;
    private ImageView imageViewPrecipitationIcon;

    private View currentLayout;


    public static WhetherDataFragment create(SettingsParcel parcel) {
        WhetherDataFragment f = new WhetherDataFragment();

        // передача параметра
        Bundle args = new Bundle();
        args.putSerializable(PARCEL, parcel);
        f.setArguments(args);
        return f;
    }

    public SettingsParcel getParcel() {
        SettingsParcel parcel = (SettingsParcel) getArguments().getSerializable(PARCEL);
        return parcel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.whether_data_fragment, container, false);
        currentLayout = layout;

        Log.d(SettingsFragment.TAG, "onCreateView");
        textViewCityName = layout.findViewById(R.id.textview_cityname);
        textViewTemperatureData = layout.findViewById(R.id.textview__temperature_data);
        textViewHumidityData = layout. findViewById(R.id.textview__humidity_data);
        textViewWindData = layout.findViewById(R.id.textview__wind_data);
        textViewPrecipitationData = layout.findViewById(R.id.textview__probability_of_precipitation_data);
        imageViewPrecipitationIcon = layout.findViewById(R.id.imageview_p_o_p_icon);

        // определить какую инфу показывать и показать её
        SettingsParcel parcel = getParcel();

        if (parcel != null) {
            Log.d(SettingsFragment.TAG, "parcel != null");
            String city = parcel.getCityName();
            textViewCityName.setText(city);

            Boolean humidity = parcel.getHumidity();
            Boolean wind = parcel.getPowerOfWind();
            Boolean precipitation = parcel.getProbabilityOfPrecipitation();

            setTextViewTemperatureData();

            if (humidity)
                setHumidityData();

            if (wind)
                setWindData();

            if (precipitation)
                setPrecipitationData(layout);
        }

        return layout;
    }

    private void setPrecipitationData(View layout) {
        Log.d(SettingsFragment.TAG, "precip");
        View layoutItem = currentLayout.findViewById(R.id.ll_probability_of_precipitation);
        layoutItem.setVisibility(View.VISIBLE);
        textViewPrecipitationData.setText(R.string.precipitation_data);
        imageViewPrecipitationIcon.setImageDrawable(ContextCompat.getDrawable(layout.getContext(), R.drawable.if_sunny_3233850));
    }

    private void setWindData() {
        Log.d(SettingsFragment.TAG, "winddata");
        View layoutItem = currentLayout.findViewById(R.id.ll_wind);
        layoutItem.setVisibility(View.VISIBLE);
        textViewWindData.setText(R.string.wind_data);
    }

    private void setHumidityData() {
        Log.d(SettingsFragment.TAG, "humidity");
        View layoutItem = currentLayout.findViewById(R.id.ll_humidity);
        layoutItem.setVisibility(View.VISIBLE);
        textViewHumidityData.setText(R.string.humidity_data);
    }

    private void setTextViewTemperatureData() {
        Log.d(SettingsFragment.TAG, "temper");
        textViewTemperatureData.setText(R.string.temperature_data);
    }
}
