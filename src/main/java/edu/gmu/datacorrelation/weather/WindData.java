package edu.gmu.datacorrelation.weather;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WindData {

    private float windChill;
    private float windSpeedMPH;
    private WindDirection windDirection;
    private float humidity; // As a percentage.

    public WindData(float windChill, float windSpeedMPH, WindDirection windDirection, float humidity) {
        this.windChill = windChill;
        this.windSpeedMPH = windSpeedMPH;
        this.windDirection = windDirection;
        this.humidity = humidity;
    }
}
