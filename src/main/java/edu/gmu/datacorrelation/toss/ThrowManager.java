package edu.gmu.datacorrelation.toss;

import edu.gmu.datacorrelation.DataCorrelation;
import edu.gmu.datacorrelation.athlete.Athlete;
import edu.gmu.datacorrelation.weather.WeatherHistory;
import edu.gmu.datacorrelation.weather.WindData;
import edu.gmu.datacorrelation.weather.WindDirection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author junio
 */
public class ThrowManager {
    private static final List<Throw> throwsList = Arrays.asList(
            new Throw("Shot Put", 45, 500, new WeatherHistory(78, 4, new WindData(0, 1, WindDirection.NORTH, 0), false), 35),
            new Throw("Shot Put", 35, 50, new WeatherHistory(78, 4, new WindData(0, 1, WindDirection.NORTH, 0), false), 35),
            new Throw("Discus", 12, 320, new WeatherHistory(56, 4, new WindData(50, 10, WindDirection.WEST, 0), true), 35),
            new Throw("Discus", 52, 470, new WeatherHistory(56, 4, new WindData(50, 10, WindDirection.WEST, 0), true), 25)
    );

    public ThrowManager() {
        throwsList.get(0).setStudent(DataCorrelation.athleteManager.getAllAthletes().get(0));
        throwsList.get(2).setStudent(DataCorrelation.athleteManager.getAllAthletes().get(0));
        throwsList.get(1).setStudent(DataCorrelation.athleteManager.getAllAthletes().get(1));
        throwsList.get(3).setStudent(DataCorrelation.athleteManager.getAllAthletes().get(1));
    }

    public List<Throw> getAllThrows() {
        return throwsList;
    }

    public List<Throw> getThrowsBy(Athlete athlete) {
        return getAllThrows().stream()
                .filter(thr -> athlete.equals(thr.getStudent()))
                .collect(Collectors.toList());
    }
}
