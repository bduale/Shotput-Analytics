package edu.gmu.datacorrelation.controller;

import edu.gmu.datacorrelation.DataCorrelation;
import edu.gmu.datacorrelation.athlete.Athlete;
import edu.gmu.datacorrelation.school.School;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
public class SchoolController {

    @RequestMapping(value = "/school", method = RequestMethod.GET)
    public List<School> listSchools() {
        return DataCorrelation.schoolManager.getRegisteredSchools();
    }

    @RequestMapping(value = "/school/{schoolName}", method = RequestMethod.GET)
    public School listSchool(@PathVariable(name = "schoolName") String schoolName) {
        return DataCorrelation.schoolManager.getSchool(schoolName).orElse(null);
    }

    @RequestMapping(value = "/school/{schoolName}/athletes", method = RequestMethod.GET)
    public Set<Athlete> listSchoolAthletes(@PathVariable(name = "schoolName") String schoolName) {
        School school = DataCorrelation.schoolManager.getSchool(schoolName).orElse(null);

        if (school == null) {
            return Collections.emptySet();
        }

        return school.getAthletes();
    }
}
