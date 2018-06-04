package yuliya.loginova.ru.wheather;

import java.io.Serializable;

public class SettingsParcel implements Serializable {

    private String cityName;
    private boolean humidity;
    private boolean powerOfWind;
    private boolean probabilityOfPrecipitation;
    //Map settingsData;

    public String getCityName() {
        return cityName;
    }

    public boolean getHumidity() {
        return humidity;
    }

    public boolean getPowerOfWind() {
        return powerOfWind;
    }

    public boolean getProbabilityOfPrecipitation() {
        return probabilityOfPrecipitation;
    }

    public SettingsParcel(String cityName, boolean humidity, boolean powerOfWind, boolean probabilityOfPrecipitation) {

        this.cityName = cityName;
        this.humidity = humidity;
        this.powerOfWind = powerOfWind;
        this.probabilityOfPrecipitation = probabilityOfPrecipitation;

        //settingsData = new HashMap();
    }



}