package edu.gmu.datacorrelation.toss;

import edu.gmu.datacorrelation.athlete.Athlete;
import edu.gmu.datacorrelation.weather.WeatherHistory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Throw {

    private String name;
    private double releaseAngle;
    private double distanceThrown;
    private WeatherHistory weatherCondition;
    private double releaseVelocity; // MPH
    private Athlete student;

    /**
     * Creates an Event.
     *
     * @param name             the name for the event
     * @param releaseAngle     the angle of release of the throw
     * @param distanceThrown   the distance the throw attained
     * @param weatherCondition the weather condition for the throw
     * @param releaseVelocity  the velocity of the throw at the time of release
     */
    public Throw(String name, double releaseAngle, double distanceThrown, WeatherHistory weatherCondition, double releaseVelocity) {
        this.name = name;
        this.releaseAngle = releaseAngle;
        this.distanceThrown = distanceThrown;
        this.weatherCondition = weatherCondition;
        this.releaseVelocity = releaseVelocity;
    }

    /**
     * Creates an event with null attributes (only with event name)
     */
    public Throw(String name) {
        this.name = name;
    }
}
