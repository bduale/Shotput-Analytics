package edu.gmu.datacorrelation.school;

import edu.gmu.datacorrelation.athlete.Athlete;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class School {

    private final String name;
    private Set<Athlete> athletes;

    public School(String name) {
        this.name = name;
        this.athletes = new HashSet<>();
    }
}
