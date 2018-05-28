package yuliya.loginova.ru.wheather;

import java.io.Serializable;

public class Parcel implements Serializable {
    private int whetherImage;
    private String cityName;
    private int humidity;
    private int powerOfWind;
    private int probabilityOfPrecipitation;

    public int getWhetherImage() {
        return whetherImage;
    }

    public String getCityName() {
        return cityName;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getPowerOfWind() {
        return powerOfWind;
    }

    public int getProbabilityOfPrecipitation() {
        return probabilityOfPrecipitation;
    }

    public Parcel(int whetherImage, String cityName, int humidity, int powerOfWind, int probabilityOfPrecipitation) {
        this.whetherImage = whetherImage;
        this.cityName = cityName;
        this.humidity = humidity;
        this.powerOfWind = powerOfWind;
        this.probabilityOfPrecipitation = probabilityOfPrecipitation;
    }



}