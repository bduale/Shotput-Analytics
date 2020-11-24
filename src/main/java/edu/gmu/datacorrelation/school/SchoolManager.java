package edu.gmu.datacorrelation.school;

import edu.gmu.datacorrelation.DataCorrelation;
import edu.gmu.datacorrelation.athlete.Athlete;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SchoolManager {

    //TODO import schools from a data source.
    private static final List<School> REGISTERED_SCHOOLS = Arrays.asList(
            new School("GMU"),
            new School("UVA")
    );

    public SchoolManager() {
        REGISTERED_SCHOOLS.get(0).getAthletes().add(DataCorrelation.athleteManager.getAllAthletes().get(0));
        REGISTERED_SCHOOLS.get(1).getAthletes().add(DataCorrelation.athleteManager.getAllAthletes().get(1));
    }

    public List<School> getRegisteredSchools() {
        return REGISTERED_SCHOOLS;
    }

    public Optional<School> getSchool(String name) {
        return getRegisteredSchools().stream()
                .filter(school -> school.getName().equals(name))
                .findFirst();
    }

    public Optional<School> getSchoolOf(Athlete athlete) {
        return getRegisteredSchools().stream()
                .filter(school -> school.getAthletes().contains(athlete))
                .findFirst();
    }
}
