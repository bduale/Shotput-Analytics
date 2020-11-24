package edu.gmu.datacorrelation;

import edu.gmu.datacorrelation.athlete.AthleteManager;
import edu.gmu.datacorrelation.event.EventManager;
import edu.gmu.datacorrelation.school.SchoolManager;
import edu.gmu.datacorrelation.toss.ThrowManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataCorrelation {

    public static final AthleteManager athleteManager;
    public static final SchoolManager schoolManager;
    public static final EventManager eventManager;
    public static final ThrowManager throwManager;

    static {
        athleteManager = new AthleteManager();
        schoolManager = new SchoolManager();
        throwManager = new ThrowManager();
        eventManager = new EventManager();
    }

    public static void main(String[] args) {
        SpringApplication.run(DataCorrelation.class, args);
    }
}
