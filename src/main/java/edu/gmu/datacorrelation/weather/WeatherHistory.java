package edu.gmu.datacorrelation.weather;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherHistory {

    private float degreesFarenheit;
    private float heatIndex;
    private WindData windData;
    private boolean rain;

    public WeatherHistory(float degreesFarenheit, float heatIndex, WindData windData, boolean rain) {
        this.degreesFarenheit = degreesFarenheit;
        this.heatIndex = heatIndex;
        this.windData = windData;
        this.rain = rain;
    }

    public WeatherHistory() {
    }

    public float toCelsius() {
        return (degreesFarenheit - 32) * (5 / 9f);
    }
}
