package edu.gmu.datacorrelation.controller;

import edu.gmu.datacorrelation.DataCorrelation;
import edu.gmu.datacorrelation.athlete.Athlete;
import edu.gmu.datacorrelation.toss.Throw;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
public class AthleteController {

    @RequestMapping(value = "/athlete", method = RequestMethod.GET)
    public List<Athlete> listAthletes() {
        return DataCorrelation.athleteManager.getAllAthletes();
    }

    @RequestMapping(value = "/athlete/{uuid}", method = RequestMethod.GET)
    public Athlete listAthletes(@PathVariable(name = "uuid") String uuid) {
        return DataCorrelation.athleteManager.getAthlete(uuid).orElse(null);
    }

    @RequestMapping(value = "/athlete/{uuid}/throw", method = RequestMethod.GET)
    public List<Throw> listThrows(@PathVariable(name = "uuid") String uuid) {
        Optional<Athlete> optionalAthlete = DataCorrelation.athleteManager.getAthlete(uuid);

        return optionalAthlete.map(DataCorrelation.throwManager::getThrowsBy).orElse(null);
    }

    @RequestMapping(value = "/athlete/{uuid}/throw/top", method = RequestMethod.GET)
    public Throw getBestThrow(@PathVariable(name = "uuid") String uuid) {
        Optional<Athlete> optionalAthlete = DataCorrelation.athleteManager.getAthlete(uuid);

        List<Throw> throwList = optionalAthlete
                .map(DataCorrelation.throwManager::getThrowsBy)
                .orElse(null);

        if (throwList == null) {
            return null;
        }

        return throwList.stream().max(Comparator.comparingDouble(Throw::getDistanceThrown)).orElse(null);
    }

    @RequestMapping(value = "/athlete/{uuid}/throw/average", method = RequestMethod.GET)
    public DistanceResponse getAverageDistance(@PathVariable(name = "uuid") String uuid) {
        Optional<Athlete> optionalAthlete = DataCorrelation.athleteManager.getAthlete(uuid);

        List<Throw> throwList = optionalAthlete
                .map(DataCorrelation.throwManager::getThrowsBy)
                .orElse(null);

        if (throwList == null) {
            return null;
        }

        return new DistanceResponse(throwList.stream().mapToDouble(Throw::getDistanceThrown).average().orElse(Double.NaN));
    }

    @AllArgsConstructor
    @Getter
    @Setter
    private class DistanceResponse {
        private double distance;
    }
}
