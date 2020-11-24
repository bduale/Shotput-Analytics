package edu.gmu.datacorrelation.athlete;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class AthleteManager {

    //TODO import from data source
    private static final List<Athlete> registeredAthletes = Arrays.asList(
            new Athlete("Bob", "Smith", PreferredHand.LEFT_HAND, Gender.MALE, LocalDate.of(1999, Month.JULY, 12), 74),
            new Athlete("Alice", "Smith", PreferredHand.RIGHT_HAND, Gender.FEMALE, LocalDate.of(1997, Month.AUGUST, 4), 68)
    );

    public AthleteManager() {
        // empty
    }

    public List<Athlete> getAllAthletes() {
        return registeredAthletes;
    }

    public Optional<Athlete> getAthlete(String uuid) {
        return getAllAthletes().stream()
                .filter(athlete -> uuid.equals(athlete.getUniqueID()))
                .findFirst();
    }
}
